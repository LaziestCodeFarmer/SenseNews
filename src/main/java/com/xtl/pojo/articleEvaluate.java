package com.xtl.pojo;

public class articleEvaluate {

    private int uId;
    private int aId;
    private String evaluate;
    private String dateTime;
    private int collected;
    private int like;
    private int dislike;

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public int getCollected() {
        return collected;
    }

    public void setCollected(int collected) {
        this.collected = collected;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getDislike() {
        return dislike;
    }

    public void setDislike(int dislike) {
        this.dislike = dislike;
    }

    @Override
    public String toString() {
        return "articleEvaluate{" +
                "uId=" + uId +
                ", aId=" + aId +
                ", evaluate='" + evaluate + '\'' +
                ", dateTime='" + dateTime + '\'' +
                ", collected=" + collected +
                ", like=" + like +
                ", dislike=" + dislike +
                '}';
    }
}
