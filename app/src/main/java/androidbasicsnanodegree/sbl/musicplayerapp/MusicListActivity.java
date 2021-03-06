package androidbasicsnanodegree.sbl.musicplayerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MusicListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_list);

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
        SongAdapter adapter = new SongAdapter(this, songs) ;

        ListView songList = findViewById(R.id.songList);

        songList.setAdapter(adapter);

        // The following code is set in order to, when a Song is clicked, send the song infos to the PlaySong Activity
       songList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               Song song = (Song) adapterView.getItemAtPosition(i) ;
               Intent intent = new Intent(MusicListActivity.this, PlaySongActivity.class) ;
               intent.putExtra("songImage", song.getImage()) ;
               intent.putExtra("songName", song.getSongName()) ;
               intent.putExtra("songArtist", song.getArtist()) ;
               startActivity(intent);

           }
       });

    }
}
