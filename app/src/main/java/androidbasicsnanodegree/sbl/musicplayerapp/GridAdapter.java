package androidbasicsnanodegree.sbl.musicplayerapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Android on 17/03/2018.
 */

public class GridAdapter extends ArrayAdapter<Song> {

    //Following method is the constructor

    public GridAdapter(Activity context, ArrayList<Song> song) {
        super(context, 0, song);
    }

    // Overriding the getView method in order for the adapter to fit our GridView

    /**
     * Code found on GitHub : https://github.com/udacity/ud839_CustomAdapter_Example/
     *
     * @author : Udacity
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.grid_songs, parent, false);
        }
        // Get the {@link AndroidFlavor} object located at this position in the list
        Song currentSong = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.songGridName);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        nameTextView.setText(currentSong.getSongName());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView numberTextView = (TextView) listItemView.findViewById(R.id.songGridArtist);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        numberTextView.setText(currentSong.getArtist());

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.songGridImage);
        // Get the image resource ID from the current AndroidFlavor object and
        // set the image to iconView
        iconView.setImageResource(currentSong.getImage());

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the GridView
        return listItemView;
    }
}