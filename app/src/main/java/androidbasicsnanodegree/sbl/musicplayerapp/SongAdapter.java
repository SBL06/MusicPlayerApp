package androidbasicsnanodegree.sbl.musicplayerapp;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SongAdapter extends ArrayAdapter<Song>  {

    // Following variables are declared as global ones because we are going to use them
    // in the custom filter
    private ArrayList<Song> objects;
    private Context context;
    private Filter filter;

    //Following method is the constructor

    public SongAdapter(Activity context, ArrayList<Song> song) {
        super(context, 0, song);
        this.context = context ;
        this.objects = song ;
    }

    // The two following methods are overriden in order for our custom filter to work
    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public Song getItem(int position) {
        return objects.get(position);
    }

    // Overriding the getView method in order for the adapter to fit our ListView
    /**Code found on GitHub : https://github.com/udacity/ud839_CustomAdapter_Example/
    *@author : Udacity
     *
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_songs, parent, false);
        }
        // Get the {@link AndroidFlavor} object located at this position in the list
        Song currentSong = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.songName);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        nameTextView.setText(currentSong.getSongName());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView numberTextView = (TextView) listItemView.findViewById(R.id.songArtist);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        numberTextView.setText(currentSong.getArtist());

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.songImage);
        // Get the image resource ID from the current AndroidFlavor object and
        // set the image to iconView
        iconView.setImageResource(currentSong.getImage());

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }

    //Overriding the getFilter method in order to return our custom filter
    @Override
    public Filter getFilter() {
        if (filter == null)
            filter = new AppFilter<Song>(objects);
        return filter;
    }

    /**
     * Class for filtering in Arraylist listview. Objects need a valid
     * 'toString()' method.
     *
     * @author Tobias Schürg inspired by Alxandr
     *         (http://stackoverflow.com/a/2726348/570168)
     *
     */

    private class AppFilter<T> extends Filter {

        private ArrayList<T> sourceObjects;

        public AppFilter(List<T> objects) {
            sourceObjects = new ArrayList<T>();
            synchronized (this) {
                sourceObjects.addAll(objects);
            }
        }

        @Override
        protected FilterResults performFiltering(CharSequence chars) {
            String filterSeq = chars.toString().toLowerCase();
            FilterResults result = new FilterResults();
            if (filterSeq != null && filterSeq.length() > 0) {
                ArrayList<T> filter = new ArrayList<T>();

                for (T object : sourceObjects) {
                    // the filtering itself:
                    if (object.toString().toLowerCase().contains(filterSeq))
                        filter.add(object);
                }
                result.count = filter.size();
                result.values = filter;
            } else {
                // add all objects
                synchronized (this) {
                    result.values = sourceObjects;
                    result.count = sourceObjects.size();
                }
            }
            return result;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint,
                                      FilterResults results) {
            // NOTE: this function is *always* called from the UI thread.
            ArrayList<T> filtered = (ArrayList<T>) results.values;
            notifyDataSetChanged();
            clear();
            for (int i = 0, l = filtered.size(); i < l; i++)
                add((Song) filtered.get(i));
            notifyDataSetInvalidated();
        }
    }
}



