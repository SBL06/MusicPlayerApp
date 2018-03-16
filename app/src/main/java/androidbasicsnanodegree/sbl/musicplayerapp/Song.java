package androidbasicsnanodegree.sbl.musicplayerapp;

import android.graphics.drawable.Drawable;
import android.media.Image;

/**
 * Created by Android on 15/03/2018.
 */

public class Song {
    private String mName ;
    private String mArtist ;
    private int mImage ;

    public Song (String name, String artist, int drawable) {
        mName = name ;
        mArtist = artist ;
        mImage = drawable ;
    }

    public String getSongName() {
        return mName ;
    }

    public String getArtist() {
        return mArtist ;
    }

    public int getImage() {
        return mImage ;
    }

}
