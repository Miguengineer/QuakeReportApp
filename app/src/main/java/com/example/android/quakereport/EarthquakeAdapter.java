package com.example.android.quakereport;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> earthquakes){
        super(context, 0, earthquakes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate
                    (R.layout.earthquake_list_item, parent, false);
        }
        // Data formatter for dates
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM DD, yyyy");
        // Get the user object located at this position in the list
        Earthquake currentEarthquake = getItem(position);
        TextView magnitudeTextView = (TextView) listItemView.findViewById(R.id.magnitude_textview);
        magnitudeTextView.setText(listItemView.getResources().getString(R.string.magnitude_textview,
                currentEarthquake.getMagnitude()));
        TextView locationTextView = (TextView) listItemView.findViewById(R.id.location_textview);
        locationTextView.setText(currentEarthquake.getLocation());
        TextView dateTextview = (TextView) listItemView.findViewById(R.id.date_textview);
        dateTextview.setText(listItemView.getResources().getString(R.string.date_textview,
                formatDate(currentEarthquake.getDate())));
        TextView timeTextView = (TextView) listItemView.findViewById(R.id.time_textview);
        timeTextView.setText(listItemView.getResources().getString(R.string.time_textview, formatTime(currentEarthquake.getDate())));



        return listItemView;
    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

}
