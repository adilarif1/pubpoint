package uk.ac.uws.pubpoint;

/**
 * MapsActivity, PubPoint.
 * Built by - B00147369, B00221290, B00257014
 * Nov/Dec 2016
 */

import android.*;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.Manifest;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMapLongClickListener {

    private GoogleMap mMap;

    LocationManager locationManager;
    LocationListener locationListener;

    // initial request of permission to use GPS, passing through last location and general title to the next method
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 1) {

            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

                    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);

                    Location lastKnownLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

                    centerMapOnLocation(lastKnownLocation, "Hey! See any good pubs? Long press to store them.");

                }

            }
        }

    }

    // taking location, finding address, displaying marker on map
    public void centerMapOnLocation(Location location, String title) {

        LatLng userLocation = new LatLng(location.getLatitude(), location.getLongitude());

        String address = "";

        if (userLocation.latitude != 0 && userLocation.longitude != 0) {
            Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());
            try {
                List<Address> listAddresses = geocoder.getFromLocation(userLocation.latitude, userLocation.longitude, 1);

                if (listAddresses != null && listAddresses.size() > 0) {

                    if (listAddresses.get(0).getSubThoroughfare() != null) {

                        address += listAddresses.get(0).getSubThoroughfare() + " ";

                    }

                    if (listAddresses.get(0).getThoroughfare() != null) {

                        address += listAddresses.get(0).getThoroughfare() + ", ";

                    }

                    if (listAddresses.get(0).getLocality() != null) {

                        address += listAddresses.get(0).getLocality() + ", ";

                    }

                    if (listAddresses.get(0).getPostalCode() != null) {

                        address += listAddresses.get(0).getPostalCode();

                    }

                    if (address.isEmpty()) {

                        address = "Who knows where you are, out at sea??";

                    }


                    Log.i("User First Address : ", address);

                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        // clear the map, choose the correct marker to show
        mMap.clear();

        if (title != "Hey! See any good pubs? Long press to store them.") {

            mMap.addMarker(new MarkerOptions().position(userLocation).title("Hello, I am a pub, come on in!  We are at:- ").snippet(address).icon(BitmapDescriptorFactory.fromResource(R.drawable.beer_marker128)));

        } else {

            mMap.addMarker(new MarkerOptions().position(userLocation).title(title).snippet("You are here:- " + address).icon(BitmapDescriptorFactory.fromResource(R.drawable.user_marker128)));
        }

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(userLocation, 18));

    }

    // set operations and classes on creation of the page
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */


    // get location from movement, find address, display a custom toast message
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {

                LatLng userLocation = new LatLng(location.getLatitude(), location.getLongitude());

                mMap.clear();
                mMap.addMarker(new MarkerOptions().position(userLocation).title("Hey! See any good pubs? Long press to store them.").icon(BitmapDescriptorFactory.fromResource(R.drawable.user_marker128)));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(userLocation, 18));

                Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());

                try {

                    List<Address> listAddresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);

                    if (listAddresses != null && listAddresses.size() > 0) {

                        String address = "";

                        if (listAddresses.get(0).getSubThoroughfare() != null) {

                            address += listAddresses.get(0).getSubThoroughfare() + " ";

                        }

                        if (listAddresses.get(0).getThoroughfare() != null) {

                            address += listAddresses.get(0).getThoroughfare() + ", ";

                        }

                        if (listAddresses.get(0).getLocality() != null) {

                            address += listAddresses.get(0).getLocality() + ", ";

                        }

                        if (listAddresses.get(0).getPostalCode() != null) {

                            address += listAddresses.get(0).getPostalCode();

                        }

                        if (address.isEmpty()) {

                            address = "Who knows where you are, out at sea??";

                        }

                        Log.i("User Current Address : ", address);

                        LayoutInflater inflater = getLayoutInflater();
                        View layout = inflater.inflate(R.layout.custom_toast,
                                (ViewGroup) findViewById(R.id.custom_toast_container));

                        TextView text = (TextView) layout.findViewById(R.id.text);
                        text.setText("Hey! You are here! See any good pubs? Long press to store them." + "\n\n" + address);

                        Toast toast = new Toast(getApplicationContext());
                        toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                        toast.setDuration(Toast.LENGTH_SHORT);
                        toast.setView(layout);
                        toast.show();

                    }

                } catch (IOException e) {

                    e.printStackTrace();

                }

                Log.i("User Location : ", userLocation.toString());

            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };

        // for older than 23
        if (Build.VERSION.SDK_INT < 23) {

            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);

        // for 23 and beyond
        } else {

            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);

            } else {

                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);

                Location lastKnownLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

                if (lastKnownLocation != null) {

                    LatLng userLocation = new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude());

                    mMap.clear();
                    mMap.addMarker(new MarkerOptions().position(userLocation).title("Hey! See any good pubs? Long press to store them.").icon(BitmapDescriptorFactory.fromResource(R.drawable.user_marker128)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(userLocation, 18));

                    Log.i("User Start Location : ", userLocation.toString());

                } else {

                    // this is just a bug fix for running the app in an emulator, new runs on the emulator throw up a no previous location error, causing app to crash.
                    LatLng userEmulatorDefault = new LatLng(-25.352594, 131.034361);

                    mMap.clear();
                    mMap.addMarker(new MarkerOptions().position(userEmulatorDefault).title("There ain't no pubs here you drongo! You can manually move location using Extended Controls").icon(BitmapDescriptorFactory.fromResource(R.drawable.user_marker128)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(userEmulatorDefault, 18));

                    Log.i("No emulator GPS : ", "Default Shift to Oz");

                }


            }
        }

        mMap.setOnMapLongClickListener(this);

        // user movements
        Intent intent = getIntent();

        if (intent.getIntExtra("storePubIdentity", 0) == 0) {

            locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

            locationListener = new LocationListener() {
                @Override
                public void onLocationChanged(Location location) {

                    centerMapOnLocation(location, "Hey! See any good pubs? Long press to store them.");

                    Log.i("User LocationStore : ", location.toString());

                }

                @Override
                public void onStatusChanged(String provider, int status, Bundle extras) {

                }

                @Override
                public void onProviderEnabled(String provider) {

                }

                @Override
                public void onProviderDisabled(String provider) {

                }
            };

            // for older than 23
            if (Build.VERSION.SDK_INT < 23) {

                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);

            // for 23 and beyond
            } else {

                if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

                    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);

                    Location lastKnownLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

                    centerMapOnLocation(lastKnownLocation, "Hey! See any good pubs? Long press to store them.");

                } else {

                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);

                }


            }


        } else {

            Location pubLocation = new Location(LocationManager.GPS_PROVIDER);
            pubLocation.setLatitude(StoreActivity.locations.get(intent.getIntExtra("storePubIdentity", 0)).latitude);
            pubLocation.setLongitude(StoreActivity.locations.get(intent.getIntExtra("storePubIdentity", 0)).longitude);

            centerMapOnLocation(pubLocation, StoreActivity.pubs.get(intent.getIntExtra("storePubIdentity", 0)));

        }


    }

    // gathering location info for stored pubs
    @Override
    public void onMapLongClick(LatLng latLng) {

        Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());

        String title = "Your beer lives here!  ";
        String address = "";

        try {

            List<Address> listAddresses = geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1);

            if (listAddresses != null && listAddresses.size() > 0) {

                if (listAddresses.get(0).getSubThoroughfare() != null) {

                    address += listAddresses.get(0).getSubThoroughfare() + " ";

                }

                if (listAddresses.get(0).getThoroughfare() != null) {

                    address += listAddresses.get(0).getThoroughfare() + ", ";

                }

                if (listAddresses.get(0).getLocality() != null) {

                    address += listAddresses.get(0).getLocality() + ", ";

                }

                if (listAddresses.get(0).getPostalCode() != null) {

                    address += listAddresses.get(0).getPostalCode();

                }

                if (address.isEmpty()) {

                    address = "Is this pub real, or did you just hallucinate it??";

                }

                Log.i("Pub Store Info :", address);

            }

        } catch (IOException e) {

            e.printStackTrace();

        }

        // storing pubs for no location information (address)
        if (address == "") {

            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm yyyy-MM-dd");

            address = "Unknown Pub: Timestamp [" + sdf.format(new Date()) + "]";

            Log.i("Pub Store Info :", "Unknown Pub");

        }

        // storing pubs, showing marker, displaying custom toast message
        mMap.addMarker(new MarkerOptions().position(latLng).title(title).snippet(address).icon(BitmapDescriptorFactory.fromResource(R.drawable.beer_marker128)));

        StoreActivity.pubs.add(address);
        StoreActivity.locations.add(latLng);

        StoreActivity.arrayAdapter.notifyDataSetChanged();

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast,
                (ViewGroup) findViewById(R.id.custom_toast_container));

        TextView text = (TextView) layout.findViewById(R.id.text);
        text.setText("This pub has been stored!" + "\n\n" + address);

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();

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