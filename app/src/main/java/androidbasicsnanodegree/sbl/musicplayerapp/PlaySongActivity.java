package androidbasicsnanodegree.sbl.musicplayerapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class PlaySongActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_song);

        ImageView image = findViewById(R.id.songPlayImage) ;
        TextView name = findViewById(R.id.songPlayName) ;
        TextView artist = findViewById(R.id.songPlayArtist) ;

        //Infos about the song currently playing are sent by the MusicList or SearchList Activity
        // and retrieved here
        int imageId = getIntent().getIntExtra("songImage" , 0) ;
        String nameSong = getIntent().getStringExtra("songName") ;
        String artistSong = getIntent().getStringExtra("songArtist") ;

        image.setImageResource(imageId);
        name.setText(nameSong);
        artist.setText(artistSong);
    }
}
