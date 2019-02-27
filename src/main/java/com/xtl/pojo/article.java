package com.xtl.pojo;

public class article {

    //主体数据
    private int aId;
    private String author;
    private String authorUrl;
    private String dataTime;
    private String title;
    private String context;
    private String type;
    private int click;

    //index数据处理保存的数据
    private String imgUrl;
    private String indexTimeShow;

    public String getIndexTimeShow() {
        return indexTimeShow;
    }

    public void setIndexTimeShow(String indexTimeShow) {
        this.indexTimeShow = indexTimeShow;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthorUrl() {
        return authorUrl;
    }

    public void setAuthorUrl(String authorUrl) {
        this.authorUrl = authorUrl;
    }

    public String getDataTime() {
        return dataTime;
    }

    public void setDataTime(String dataTime) {
        this.dataTime = dataTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getClick() {
        return click;
    }

    public void setClick(int click) {
        this.click = click;
    }

    @Override
    public String toString() {
        return "article{" +
                "aId=" + aId +
                ", author='" + author + '\'' +
                ", authorUrl='" + authorUrl + '\'' +
                ", dataTime='" + dataTime + '\'' +
                ", title='" + title + '\'' +
                ", context='" + context + '\'' +
                ", type='" + type + '\'' +
                ", click=" + click +
                '}';
    }
}
