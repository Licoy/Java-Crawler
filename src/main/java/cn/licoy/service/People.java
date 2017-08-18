package cn.licoy.service;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author licoy.cn
 * @version 1.0 /
 */
public class People {
    /**
     * 线程池
     */
    private ThreadPoolExecutor poolExecutor;
    /**
     * 数据缓存
     */
    private ConcurrentHashMap<String,String> propers;
    /**
     * 文件读入路径
     */
    private String readPath;
    /**
     * 文件写出路径
     */
    private String writePath;
    /**
     * 日志
     */
    private Logger logger = LoggerFactory.getLogger(People.class);

    /**
     * 构造方法
     */
    People(String r, String w) {
        readPath = r;
        writePath = w;
        poolExecutor = new ThreadPoolExecutor(200, 500, 3, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10000), new ThreadPoolExecutor.DiscardOldestPolicy());
        propers = new ConcurrentHashMap<>();
    }

    void run() throws Exception {
        long startTime = new Date().getTime();
        BufferedReader buff = new BufferedReader(new FileReader(readPath));
        //已操作记录，防止重复
        List<String> list = new ArrayList<>();
        while (buff.ready()){
            String name = buff.readLine().trim();
            if(!list.contains(name)){
                list.add(name);
            }
            if("".equals(name)){
                continue;
            }
            getBaiKeLink(name);
        }
        buff.close();
        //不再继续往线程池放入任务
        poolExecutor.shutdown();
        //等待任务执行完成
        while (true){
            if(poolExecutor.isTerminated()){
                logger.info("->总记录数 : "+propers.size());
                //将数据写出
                poi();
                logger.info("->总耗时 : "+(new Date().getTime()-startTime)+"ms");
                break;
            }
        }
        logger.info("->程序执行完毕");
    }

    private void getBaiKeLink(String name) {
        //将抓取放入线程中
        poolExecutor.execute(new BaiKeRunnable(name));
    }


    /**
     * 爬虫线程程序
     */
    class BaiKeRunnable implements Runnable{

        private String name;

        public BaiKeRunnable() {
        }

        BaiKeRunnable(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            logger.debug("当前执行者 -> "+name);
            String link = null;
            Document doc = null;
            //获取文档
            try {
                doc = Jsoup.connect("https://www.baidu.com/s?ie=UTF-8&wd="+name).get();
            } catch (IOException e) {
                e.printStackTrace();
                logger.error("DEBUG REQUEST ERROR : NOW NAME IS { "+name+" }");
            }
            //查找所需数据
            for (Integer i = 1; i < 11; i++) {
                Element el = null;
                if (doc != null) {
                    el = doc.getElementById(i.toString());
                    if(el==null){
                        //没有找到对应的ID元素
                        logger.error("DEBUG REQUEST IS NULL ERROR : NOW NAME IS { "+name+" }");
                        continue;
                    }
                    String tpl = el.attr("tpl");
                    if("bk_polysemy".equals(tpl)){
                        link = el.attr("mu");
                        addProp(name,link);
                        break;//已经找到对应的数据，无须继续执行
                    }
                    if(i==10){
                        //没有找到对应的数据
                        logger.error("NOT FOUND 404 : NOW NAME IS { "+name+" }");
                    }
                }else{
                    //无效的请求
                    logger.error("REQUEST BAD : NOW NAME IS { "+name+" }");
                    break;
                }
            }
        }
    }

    /**
     * 将数据添加至缓存
     * @param name 姓名
     * @param link 链接
     */
    private void addProp(String name,String link){
        propers.put(name,link);
    }

    /**
     * 将缓存数据写入Excel
     */
    private void poi() throws Exception{
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("data");
        Iterator<ConcurrentHashMap.Entry<String,String>> iterator = propers.entrySet().iterator();
        int in = 0;
        while (iterator.hasNext()){
            Row row = sheet.createRow(in);
            ConcurrentHashMap.Entry<String,String> e = iterator.next();
            for(int i = 0; i < 2; i++) {
                if (i == 0) {
                    row.createCell(i).setCellValue(e.getKey());
                } else {
                    row.createCell(i).setCellValue(e.getValue());
                }
            }
            in++;
        }
        File xlsFile = new File(writePath);
        FileOutputStream xlsStream = new FileOutputStream(xlsFile);
        //写出
        workbook.write(xlsStream);
        xlsStream.flush();
        xlsStream.close();
        logger.info("->POI操作完成");
    }
}


