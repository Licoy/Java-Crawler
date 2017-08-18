# JAVA爬虫 - Java-Crawler
使用java爬虫框架(jsoup)爬取数据
# 例：爬开源中国最新项目
## 调用
```
public class GitOsChinaTest {
    @Test
    public void run() throws Exception {
        new GitOsChina(1,2).run();
    }
}
```
## 结果：
```
16:35:31.063 [pool-1-thread-1] INFO cn.licoy.thread.GitOsChina - ->当前执行 : https://git.oschina.net/explore/recommend?page=1
16:35:31.070 [pool-1-thread-2] INFO cn.licoy.thread.GitOsChina - ->当前执行 : https://git.oschina.net/explore/recommend?page=2
16:35:32.771 [main] INFO cn.licoy.thread.GitOsChina - ->线程池任务已执行完成
Project{name='smart-web2', author='狂晕', lang='Java', watch='139', star='288', fork='125', url='https://git.oschina.net/bcworld/smart-web2'}
Project{name='UPMS', author='lyg945', lang='Java', watch='38', star='56', fork='20', url='https://git.oschina.net/lyg945/UPMS'}
Project{name='kind', author='郑州java', lang='Java', watch='75', star='136', fork='52', url='https://git.oschina.net/zhengzhoujava/kind'}
Project{name='xtp通用权限管理系统', author='贤二智能', lang='Java', watch='34', star='56', fork='32', url='https://git.oschina.net/shenghaijiang/xtp'}
Project{name='SVN资源权限管理系统', author='微笑风采', lang='Java', watch='85', star='159', fork='87', url='https://git.oschina.net/hpboys/svnadmin'}
Project{name='React-VR', author='紫苏吃个蕉', lang='JavaScript', watch='8', star='27', fork='6', url='https://git.oschina.net/zisuzz/react-vr'}
Project{name='xxpay', author='jmdhappy', lang='Java', watch='194', star='468', fork='168', url='https://git.oschina.net/jmdhappy/xxpay-master'}
Project{name='easy-jdbc', author='yydf', lang='Java', watch='10', star='27', fork='7', url='https://git.oschina.net/yydf/easy-jdbc'}
Project{name='Pigeon', author='monsterLin', lang='Android', watch='18', star='34', fork='5', url='https://git.oschina.net/monsterLin/Pigeon'}
Project{name='asyncio', author='james', lang='C++', watch='2', star='3', fork='2', url='https://git.oschina.net/zhanglix/asyncio'}
Project{name='OpenTracker', author='小樱', lang='C', watch='4', star='5', fork='0', url='https://git.oschina.net/cc12655/OpenTracker'}
Project{name='JApiDocs', author='叶大侠', lang='Java', watch='52', star='118', fork='25', url='https://git.oschina.net/yeguozhong/JApiDocs'}
Project{name='Hero', author='点融科技', lang='JavaScript', watch='47', star='57', fork='16', url='https://git.oschina.net/dianrong/Hero'}
Project{name='vnpy', author='若水', lang='C++', watch='18', star='42', fork='9', url='https://git.oschina.net/wruoshuiy/vnpy'}
Project{name='YurunEvent', author='宇润', lang='PHP', watch='6', star='11', fork='0', url='https://git.oschina.net/yurunsoft/yurunevent'}
Project{name='jTool', author='拭目以待', lang='JavaScript', watch='4', star='5', fork='3', url='https://git.oschina.net/baukh/jTool'}
Project{name='SpringBootUnity', author='小莫', lang='Java', watch='108', star='214', fork='70', url='https://git.oschina.net/hupeng/SpringBootUnity'}
Project{name='ad_tools', author='jiangzeyin', lang='Java', watch='15', star='24', fork='12', url='https://git.oschina.net/jiangzeyin/ad_tools'}
Project{name='dbtracer', author='ghsea', lang='Java', watch='18', star='37', fork='10', url='https://git.oschina.net/ghsea/dbtracer'}
Project{name='sc', author='Vincent', lang='Java', watch='33', star='78', fork='28', url='https://git.oschina.net/wangxinforme/sc'}
Project{name='mylinks-m0m1-open-sdk', author='浙江劢领智能科技有限公司', lang='C', watch='6', star='9', fork='5', url='https://git.oschina.net/mqlinks/mylinks-m0m1-open-sdk'}
Project{name='phpboot', author='cayman', lang='PHP', watch='11', star='25', fork='3', url='https://git.oschina.net/caoyangmin/phpboot'}
Project{name='SmartSql', author='Ahoo', lang='C#', watch='8', star='13', fork='4', url='https://git.oschina.net/AhooWang/SmartSql'}
Project{name='壹凯巴cmsV2.0', author='yihank', lang='PHP', watch='7', star='13', fork='7', url='https://git.oschina.net/yihank/YiKaiBacmsV2.0'}
Project{name='JFBlog-maven', author='Realfighter', lang='Java', watch='8', star='20', fork='15', url='https://git.oschina.net/realfighter/JFBlog-maven'}
Project{name='arthur', author='ArthurFamily', lang='Java', watch='10', star='14', fork='6', url='https://git.oschina.net/ArthurFamily/arthur'}
Project{name='Rexjs', author='china-liji', lang='JavaScript', watch='3', star='1', fork='0', url='https://git.oschina.net/jQun/Rexjs'}
Project{name='TensorFlow-Bitcoin-Robot', author='feiwang', lang='Python', watch='6', star='9', fork='2', url='https://git.oschina.net/fendouai/TensorFlow-Bitcoin-Robot'}
Project{name='Brouhaha', author='惊奇漫画', lang='Objective-C', watch='3', star='4', fork='0', url='https://git.oschina.net/JingQiManHua/Brouhaha'}
Project{name='tangyuan2', author='xson_org', lang='Java', watch='23', star='19', fork='12', url='https://git.oschina.net/xsonorg/tangyuan2'}
Project{name='weixin-dubbo-springboot', author='blueriver', lang='Java', watch='34', star='62', fork='27', url='https://git.oschina.net/blueriver/weixin-dubbo-springboot'}
Project{name='网页宠物插件', author='lt1726', lang='JavaScript', watch='10', star='16', fork='5', url='https://git.oschina.net/lutao1726/WeiChunCaiChaJian'}
Project{name='flyray-base', author='boleixiongdi', lang='Java', watch='117', star='210', fork='102', url='https://git.oschina.net/boleixiongdi/flyray'}
Project{name='NextMQTT', author='陈永佳', lang='Java', watch='9', star='16', fork='3', url='https://git.oschina.net/yoojia/NextMQTT'}
Project{name='live-chat在线聊天室', author='furioussoul', lang='NodeJS', watch='12', star='18', fork='3', url='https://git.oschina.net/65465498/live-chat'}
Project{name='BMS', author='haibing871802', lang='Java', watch='72', star='149', fork='59', url='https://git.oschina.net/imsroot/BMS'}
Project{name='NextInput-Android', author='陈永佳', lang='Android', watch='4', star='22', fork='2', url='https://git.oschina.net/yoojia/NextInput-Android'}
Project{name='mqttclient', author='JesusSlim', lang='PHP', watch='2', star='3', fork='1', url='https://git.oschina.net/JesusSlim/mqttclient'}
Project{name='jquery-webos-win10', author='菩提树下杨过', lang='JavaScript', watch='13', star='28', fork='9', url='https://git.oschina.net/bodhiyg/jquery-webos-win10'}
Project{name='dp-LTE', author='小林攻城狮', lang='Java', watch='90', star='197', fork='57', url='https://git.oschina.net/zhocuhenglin/dp-security'}
Project{name='2048_cli', author='(._.)码农BTS', lang='C', watch='7', star='14', fork='2', url='https://git.oschina.net/coder-bts/2048_cli'}
Project{name='OPEN_CTP_X', author='量化交易', lang='Android', watch='9', star='4', fork='1', url='https://git.oschina.net/openctp/open_ctp_x'}
Project{name='typeofit', author='前端巨浪', lang='JavaScript', watch='6', star='6', fork='1', url='https://git.oschina.net/yaohaixiao/typeofit'}
Project{name='goreporter', author='wgliang', lang='Go', watch='5', star='5', fork='6', url='https://git.oschina.net/wgliang/goreporter'}
Project{name='athena-support', author='这里的名字只能十个字', lang='Java', watch='27', star='34', fork='11', url='https://git.oschina.net/opdar/athena-support'}
Project{name='eweapp', author='tumobi', lang='JavaScript', watch='16', star='36', fork='8', url='https://git.oschina.net/tumobi/eweapp'}
Project{name='swoole-worker', author='花花世界欢乐多', lang='PHP', watch='10', star='13', fork='1', url='https://git.oschina.net/FEIGE/swoole-worker'}
Project{name='wakew-news', author='憧憬Licoy', lang='Java', watch='16', star='43', fork='12', url='https://git.oschina.net/licoy/wakew-news'}
Project{name='ILog CMS', author='duzhi', lang='Java', watch='29', star='57', fork='37', url='https://git.oschina.net/duzhime/DUZHI_BLOG'}
Project{name='EasyReport', author='hacken', lang='Java', watch='47', star='100', fork='31', url='https://git.oschina.net/yunzhi/EasyReport'}
```
