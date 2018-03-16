package androidbasicsnanodegree.sbl.musicplayerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    ArrayList<Song> songs ;
    SongAdapter adapter ;
    ListView songList ;
    EditText searchField ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        songs = new ArrayList<>();

        String[] songNames = getResources().getStringArray(R.array.songNames);
        String[] songArtists = getResources().getStringArray(R.array.songArtist);
        int[] imagePath = {R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four,
                R.drawable.five, R.drawable.six, R.drawable.seven, R.drawable.eight, R.drawable.nine,
                R.drawable.ten, R.drawable.one, R.drawable.two, R.drawable.three,
                R.drawable.four, R.drawable.five, R.drawable.six, R.drawable.seven,
                R.drawable.eight, R.drawable.nine, R.drawable.ten};


        for (int i = 0; i < songNames.length; i++) {
            songs.add(new Song(songNames[i], songArtists[i], imagePath[i])) ;
        }

        adapter = new SongAdapter(this, songs) ;

        songList = findViewById(R.id.searchList);

        songList.setAdapter(adapter);

        songList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Song song = (Song) adapterView.getItemAtPosition(i) ;
                Intent intent = new Intent(SearchActivity.this, PlaySongActivity.class) ;
                intent.putExtra("songImage", song.getImage()) ;
                intent.putExtra("songName", song.getSongName()) ;
                intent.putExtra("songArtist", song.getArtist()) ;
                startActivity(intent);

            }
        });

        searchField = findViewById(R.id.searchEditText) ;

        searchField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d("MESSAGE", "*** Search value changed: " + charSequence.toString());
                adapter.getFilter().filter(charSequence);


            }

            @Override
            public void afterTextChanged(Editable editable) {


            }
        });

    }
}
