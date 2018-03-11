
package com.example.raja.meme;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Message {

    @SerializedName("meme")
    @Expose
    private List<Meme> meme = null;

    public List<Meme> getMeme() {
        return meme;
    }

    public void setMeme(List<Meme> meme) {
        this.meme = meme;
    }

}
