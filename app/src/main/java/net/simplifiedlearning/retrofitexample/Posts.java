package net.simplifiedlearning.retrofitexample;

import com.google.gson.annotations.SerializedName;

/**
 * Created by DELL on 21-10-2017.
 */

public class Posts {
    private String id;
    private String authorid;
    @SerializedName("heading")
    private String heading;
    private String catagory;
    private String language;
    private String views;
    private String likes;
    private String dislikes;
    private String comments;
    private String image;
    private String content;
    private String time;
    private String status;

    public Posts(String id, String authorid, String heading, String catagory, String language, String views, String likes, String dislikes, String comments, String image, String content, String time, String status) {
        this.id = id;
        this.authorid = authorid;
        this.heading = heading;
        this.catagory = catagory;
        this.language = language;
        this.views = views;
        this.likes = likes;
        this.dislikes = dislikes;
        this.comments = comments;
        this.image = image;
        this.content = content;
        this.time = time;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getAuthorid() {
        return authorid;
    }

    public String getHeading() {
        return heading;
    }

    public String getCatagory() {
        return catagory;
    }

    public String getLanguage() {
        return language;
    }

    public String getViews() {
        return views;
    }

    public String getLikes() {
        return likes;
    }

    public String getDislikes() {
        return dislikes;
    }

    public String getComments() {
        return comments;
    }

    public String getImage() {
        return image;
    }

    public String getContent() {
        return content;
    }

    public String getTime() {
        return time;
    }

    public String getStatus() {
        return status;
    }
}
