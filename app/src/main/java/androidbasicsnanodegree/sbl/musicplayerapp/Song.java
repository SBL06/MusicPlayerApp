package androidbasicsnanodegree.sbl.musicplayerapp;

import android.graphics.drawable.Drawable;
import android.media.Image;


// Custom objects storing informations about a specific song, including an image

public class Song {
    private String mName ;
    private String mArtist ;
    private int mImage ;

    public Song (String mName, String mArtist, int mDrawable) {
        this.mName = mName ;
        this.mArtist = mArtist ;
        this.mImage = mDrawable ;
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

    // Overriding the toString method in order to display only texts infos about the song
    //That method is used for the custom filter.
    @Override
    public String toString() {
        return "Song{" +
                "mName='" + mName + '\'' +
                ", mArtist='" + mArtist + '\'' +
                '}';
    }
}
