package cn.licoy.service;

import cn.licoy.bean.Project;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author licoy.cn
 * @version 1.0 /
 */
public class GitOsChina {
    /**
     * 目标URL
     */
    private String url = "https://git.oschina.net/explore/recommend?page={pageNumber}";
    /**
     * 地址HOST
     */
    private String host = "https://git.oschina.net";
    /**
     * 线程池
     */
    private ThreadPoolExecutor executor;
    /**
     * 日志
     */
    private Logger logger = LoggerFactory.getLogger(GitOsChina.class);
    /**
     * 开始页
     */
    private int startPageNumber;
    /**
     * 结束页
     */
    private int endPageNumber;
    /**
     * 缓存数据
     */
    private List<Project> projects;


    /**
     * 构造函数
     * @param index 开始页
     * @param end 结束页
     */
    GitOsChina(int index,int end) {
        startPageNumber = index;
        endPageNumber = end;
    }

    /**
     * 运行
     */
    void run(){
        executor = new ThreadPoolExecutor(100, 200, 3, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10000), new ThreadPoolExecutor.DiscardOldestPolicy());
        projects = new ArrayList<>();
        for (Integer i = startPageNumber; i <= endPageNumber; i++) {
            String url = this.url.replace("{pageNumber}",i.toString());
            executor.execute(new Run(url));
        }
        executor.shutdown();
        while (true){
            if(executor.isTerminated()){
                logger.info("->线程池任务已执行完成");
                break;
            }
        }
        for (Project p:projects) {
            System.out.println(p);
        }
    }


    private class Run implements Runnable{

        private String urls;

        Run(String url) {
            this.urls = url;
        }

        @Override
        public void run() {
            logger.info("->当前执行 : "+urls);
            Document document = null;
            try {
                document = Jsoup.connect(this.urls).get();
            } catch (IOException e) {
                logger.error("->文档获取失败 : "+this.urls);
                e.printStackTrace();
            }
            if(document!=null){
                //logger.info("->文档获取成功 : "+this.urls);
                Element list = document.getElementById("git-discover-list");
                Elements elements = list.getElementsByClass("item");
                Iterator<Element> elementIterator = elements.iterator();
                while (elementIterator.hasNext()){
                    Project project = new Project();
                    Element el = elementIterator.next();
                    //获取内容区域
                    Element title = el.select("div.project-title a").first();
                    project.setUrl(host+title.attr("href"));
                    String[] infos = title.text().split("/");
                    project.setAuthor(infos[0]);
                    project.setName(infos[1]);
                    try {
                        Element lang = el.select("div.project-title .lang-label").first();
                        project.setLang(lang.text());
                    } catch (Exception e) {
                        new Exception("->编程语言获取失败 : "+project.getName()).printStackTrace();
                    }
                    try {
                        Element desc = el.select(".project-desc").first();
                        project.setDesc(desc.text());
                    } catch (Exception e) {
                        new Exception("->项目描述获取失败 : "+project.getName()).printStackTrace();
                    }
                    try {
                        Elements pulls = el.select(".pull-right a");
                        for (int i = 0; i < pulls.size(); i++) {
                            Element e = pulls.get(i);
                            if(i==0){
                                project.setWatch(e.select("span").first().text());
                            }
                            if(i==1){
                                project.setStar(e.select("span").first().text());
                            }
                            if(i==2){
                                project.setFork(e.select("span").first().text());
                            }
                        }
                    } catch (Exception e) {
                        new Exception("->收藏/关注/Fork数量获取失败 : "+project.getName()).printStackTrace();
                    }
                    projects.add(project);
                }
            }else{
                logger.error("->文档获取失败 : "+this.urls);
            }
        }
    }
}
