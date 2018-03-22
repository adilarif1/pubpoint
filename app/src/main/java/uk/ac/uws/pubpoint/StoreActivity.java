package uk.ac.uws.pubpoint;

/**
 * StoreActivity, PubPoint.
 * Built by - B00147369, B00221290, B00257014
 * Nov/Dec 2016
 */

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class StoreActivity extends AppCompatActivity {

    static ArrayList<String> pubs = new ArrayList<>();
    static ArrayList<LatLng> locations = new ArrayList<>();
    static ArrayAdapter<String> arrayAdapter;

    // set operations and classes on creation of the page
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        // building the list
        ListView listView = (ListView) findViewById(R.id.listView);

        if (pubs.isEmpty()) {

            pubs.add("Find a new pub to store! Click here.");
            locations.add(new LatLng(0, 0));
            arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, pubs) {

                // zebra styling for the pub list
                @Override
                public View getView(int position, View convertView, ViewGroup parent) {

                    View view = super.getView(position, convertView, parent);

                    TextView ListItemText = (TextView) view.findViewById(android.R.id.text1);

                    if (position % 2 == 1) {
                        view.setBackgroundResource(R.color.options_menu_background);
                        ListItemText.setTextColor(ContextCompat.getColor(getContext(), R.color.options_menu_text));
                    } else {
                        view.setBackgroundColor(Color.TRANSPARENT);
                    }

                    return view;
                }
            };
        }

        // for movement to MapsActivity
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
                intent.putExtra("storePubIdentity", i);

                startActivity(intent);
            }

        });


    }

    // app menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);

        return super.onCreateOptionsMenu(menu);

    }

    // app menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        switch (item.getItemId()) {
            case R.id.activity_store:
                Intent intentStore = new Intent(getApplicationContext(), StoreActivity.class);
                startActivity(intentStore);
                Log.i("Menu item clicked", "Pub List");
                return true;
            case R.id.map:
                Intent intentMap = new Intent(getApplicationContext(), MapsActivity.class);
                startActivity(intentMap);
                Log.i("Menu item clicked", "Pub Map");
                return true;
            case R.id.activity_music:
                Intent intentMusic = new Intent(getApplicationContext(), MusicActivity.class);
                startActivity(intentMusic);
                Log.i("Menu item clicked", "Play Music");
                return true;
            default:
                return false;

        }

    }

}