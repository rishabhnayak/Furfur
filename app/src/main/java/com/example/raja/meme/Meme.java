
package com.example.raja.meme;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Meme {

    @SerializedName("link")
    @Expose
    private String link;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

}
