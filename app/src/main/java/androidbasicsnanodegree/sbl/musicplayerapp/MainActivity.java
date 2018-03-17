package androidbasicsnanodegree.sbl.musicplayerapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Drawable note = getDrawable(R.drawable.note) ;
        Drawable dollar = getDrawable(R.drawable.dollar) ;
        Drawable glass = getDrawable(R.drawable.glass) ;

        // Following code is changing the color of the icons, and make the change of colors easy
        // instead of directly changing the drawable color
        note.setColorFilter(getColor(R.color.colorAccent), PorterDuff.Mode.SRC_IN);
        dollar.setColorFilter(getColor(R.color.colorAccent), PorterDuff.Mode.SRC_IN);
        glass.setColorFilter(getColor(R.color.colorAccent), PorterDuff.Mode.SRC_IN);

        View musicButton = findViewById(R.id.musicButton) ;
        View storeButton = findViewById(R.id.storeButton) ;
        View searchButton = findViewById(R.id.searchButton) ;

        //An OnClickListener is set for each button of the main screen
        musicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MusicListActivity.class) ;
                startActivity(intent);
            }
        });

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SearchActivity.class) ;
                startActivity(intent);
            }
        });

       storeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, StoreActivity.class) ;
                startActivity(intent);
            }
        });
    }
}
