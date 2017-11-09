package net.simplifiedlearning.retrofitexample;

import com.google.gson.annotations.SerializedName;

/**
 * Created by DELL on 21-10-2017.
 */

public class EachPost {
    @SerializedName("heading")
    private String heading;
    private String image;
    private String content;


    public EachPost(String heading, String image, String content) {
        this.heading = heading;
        this.image = image;
        this.content = content;
    }


    public String getHeading() {
        return heading;
    }

    public String getImage() {
        return image;
    }

    public String getContent() {
        return content;
    }
}
