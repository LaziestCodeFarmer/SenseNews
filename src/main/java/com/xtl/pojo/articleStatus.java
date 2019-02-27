package com.xtl.pojo;

public class articleStatus {

    private int aId;
    private int like;
    private int dislike;
    private int collected;

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
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

    public int getCollected() {
        return collected;
    }

    public void setCollected(int collected) {
        this.collected = collected;
    }

    @Override
    public String toString() {
        return "articleStatus{" +
                "aId=" + aId +
                ", like=" + like +
                ", dislike=" + dislike +
                ", collected=" + collected +
                '}';
    }
}
