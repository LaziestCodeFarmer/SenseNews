package com.xtl.pojo;

public class userMessage {

    private String userName;
    private String company;
    private String occupation;
    private String mailbox;
    private String microBlog;
    private String weChat;
    private int  uId;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getMailbox() {
        return mailbox;
    }

    public void setMailbox(String mailbox) {
        this.mailbox = mailbox;
    }

    public String getMicroBlog() {
        return microBlog;
    }

    public void setMicroBlog(String microBlog) {
        this.microBlog = microBlog;
    }

    public String getWeChat() {
        return weChat;
    }

    public void setWeChat(String weChat) {
        this.weChat = weChat;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    @Override
    public String toString() {
        return "userMessage{" +
                "userName='" + userName + '\'' +
                ", company='" + company + '\'' +
                ", occupation='" + occupation + '\'' +
                ", mailbox='" + mailbox + '\'' +
                ", microBlog='" + microBlog + '\'' +
                ", weChat='" + weChat + '\'' +
                ", uId=" + uId +
                '}';
    }
}
