package inducesmile.com.androidtabwithswipe;

import android.graphics.Bitmap;

public class ItemObject {

    //private Bitmap screenShot;
    private int screenShot;
    private String musicName;
    private String musicAuthor;

    public ItemObject(int screenShot, String musicName, String musicAuthor) {
        this.screenShot = screenShot;
        this.musicName = musicName;
        this.musicAuthor = musicAuthor;
    }

    public int getScreenShot() {
        return screenShot;
    }

    public String getMusicName() {
        return musicName;
    }

    public String getMusicAuthor() {
        return musicAuthor;
    }
}
