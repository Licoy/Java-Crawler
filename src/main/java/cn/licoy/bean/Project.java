package cn.licoy.bean;

/**
 * 码云中国项目
 * @author licoy.cn
 * @version 1.0 /
 */
public class Project {
    //项目名称
    private String name;
    //项目作者
    private String author;
    //项目描述
    private String desc;
    //编程语言
    private String lang;
    //关注数
    private String watch;
    //收藏数
    private String star;
    //fork数
    private String fork;
    //项目地址
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getWatch() {
        return watch;
    }

    public void setWatch(String watch) {
        this.watch = watch;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getFork() {
        return fork;
    }

    public void setFork(String fork) {
        this.fork = fork;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", lang='" + lang + '\'' +
                ", watch='" + watch + '\'' +
                ", star='" + star + '\'' +
                ", fork='" + fork + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
