package androidbasicsnanodegree.sbl.musicplayerapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

public class StoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        // Song names and artists are stored in string-arrays in a resource file so we need
        // to retrieve them first
        String[] songNames = getResources().getStringArray(R.array.songNames);
        String[] songArtists = getResources().getStringArray(R.array.songArtist);

        // We retrieve the images id and store them in an int array
        int[] imagePath = {R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four,
                R.drawable.five, R.drawable.six, R.drawable.seven, R.drawable.eight, R.drawable.nine,
                R.drawable.ten, R.drawable.one, R.drawable.two, R.drawable.three,
                R.drawable.four, R.drawable.five, R.drawable.six, R.drawable.seven,
                R.drawable.eight, R.drawable.nine, R.drawable.ten};

        ArrayList<Song> songs = new ArrayList<>();

        // Our song ArrayList is populated with Song objects
        for (int i = 0; i < songNames.length; i++) {
            songs.add(new Song(songNames[i], songArtists[i], imagePath[i])) ;
        }

        // The ArrayList is used for a new custom adapter
        GridAdapter adapter = new GridAdapter(this, songs) ;

        GridView songList = findViewById(R.id.gridList);

        songList.setAdapter(adapter);
    }
}
