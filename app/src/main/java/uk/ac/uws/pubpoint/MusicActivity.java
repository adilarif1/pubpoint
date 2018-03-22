package uk.ac.uws.pubpoint;

/**
 * MusicActivity, PubPoint.
 * Built by - B00147369, B00221290, B00257014
 * Nov/Dec 2016
 */

import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MusicActivity extends AppCompatActivity implements View.OnClickListener {

    // set up Media Players for all songs
    MediaPlayer acdc;
    MediaPlayer chum;
    MediaPlayer queen;
    MediaPlayer wolf;
    MediaPlayer trex;
    MediaPlayer champ;
    MediaPlayer thin;
    MediaPlayer zz;


    // set operations and classes on creation of the page
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        // assign sound files to the correct media players
        acdc = MediaPlayer.create(getApplicationContext(), R.raw.ac_dc_drinkonme);
        chum = MediaPlayer.create(getApplicationContext(), R.raw.chumbawamba_tubthumping);
        queen = MediaPlayer.create(getApplicationContext(), R.raw.queen_dontstopmenow);
        wolf = MediaPlayer.create(getApplicationContext(), R.raw.steppenwolf_borntobewild);
        trex = MediaPlayer.create(getApplicationContext(), R.raw.t_rex_getiton);
        champ = MediaPlayer.create(getApplicationContext(), R.raw.the_champs_tequila);
        thin = MediaPlayer.create(getApplicationContext(), R.raw.thin_lizzy_whiskeyinthejar);
        zz = MediaPlayer.create(getApplicationContext(), R.raw.zz_top_beerdrinkers);


        // link button classes with the button themselves
        final Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        final Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        final Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);

        final Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);

        final Button button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(this);

        final Button button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(this);

        final Button button7 = (Button) findViewById(R.id.button7);
        button7.setOnClickListener(this);

        final Button button8 = (Button) findViewById(R.id.button8);
        button8.setOnClickListener(this);

   }


    // making the buttons play and pause when clicked by user
    // user can jump to each new song with previous song pausing and moving back to start
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            // first case is when the first button is clicked
            case R.id.button1:
                // if the first song is playing, pause playing it
                if (acdc != null && acdc.isPlaying()){
                    acdc.pause();

                }

                else if (chum.isPlaying()) {
                    chum.seekTo(0);
                    chum.pause();
                    acdc.start();
                }

                else if (queen.isPlaying()) {
                    queen.seekTo(0);
                    queen.pause();
                    acdc.start();
                }

                else if (wolf.isPlaying()) {
                    wolf.seekTo(0);
                    wolf.pause();
                    acdc.start();
                }

                else if (trex.isPlaying()) {
                    trex.seekTo(0);
                    trex.pause();
                    acdc.start();
                }

                else if (thin.isPlaying()) {
                    thin.seekTo(0);
                    thin.pause();
                    acdc.start();
                }

                else if (champ.isPlaying()) {
                    champ.seekTo(0);
                    champ.pause();
                    acdc.start();
                }

                else if (zz.isPlaying()) {
                    zz.seekTo(0);
                    zz.pause();
                    acdc.start();
                }
                // if the first song is not playing, start playing it
                else {
                    acdc.start();
                }

                break;

            // second case is when the second button is clicked
            case R.id.button2:
                    // if the second song is playing, pause playing it
                if (chum != null && chum.isPlaying()){
                    chum.pause();

                }

                else if (acdc.isPlaying()) {
                    acdc.seekTo(0);
                    acdc.pause();
                    chum.start();
                }

                else if (queen.isPlaying()) {
                    queen.seekTo(0);
                    queen.pause();
                    chum.start();
                }

                else if (wolf.isPlaying()) {
                    wolf.seekTo(0);
                    wolf.pause();
                    chum.start();
                }

                else if (trex.isPlaying()) {
                    trex.seekTo(0);
                    trex.pause();
                    chum.start();
                }

                else if (thin.isPlaying()) {
                    thin.seekTo(0);
                    thin.pause();
                    chum.start();
                }

                else if (champ.isPlaying()) {
                    champ.seekTo(0);
                    champ.pause();
                    chum.start();
                }

                else if (zz.isPlaying()) {
                    zz.seekTo(0);
                    zz.pause();
                    chum.start();
                }
                // if the second song is not playing, start playing it
                else {
                    chum.start();
                }

                break;

            // third case is when the third button is clicked
            case R.id.button3:
                    // if the third song is playing, pause playing it
                if (queen != null && queen.isPlaying()){
                    queen.pause();

                }

                else if (acdc.isPlaying()) {
                    acdc.seekTo(0);
                    acdc.pause();
                    queen.start();
                }

                else if (chum.isPlaying()) {
                    chum.seekTo(0);
                    chum.pause();
                    queen.start();
                }

                else if (wolf.isPlaying()) {
                    wolf.seekTo(0);
                    wolf.pause();
                    queen.start();
                }

                else if (trex.isPlaying()) {
                    trex.seekTo(0);
                    trex.pause();
                    queen.start();
                }

                else if (thin.isPlaying()) {
                    thin.seekTo(0);
                    thin.pause();
                    queen.start();
                }

                else if (champ.isPlaying()) {
                    champ.seekTo(0);
                    champ.pause();
                    queen.start();
                }

                else if (zz.isPlaying()) {
                    zz.seekTo(0);
                    zz.pause();
                    queen.start();
                }
                // if the third song is not playing, start playing it
                else {
                    queen.start();
                }

                break;

            // fourth case is when the fourth button is clicked
            case R.id.button4:
                // if the fourth song is playing, pause playing it
                if (wolf != null && wolf.isPlaying()){
                    wolf.pause();

                }

                else if (acdc.isPlaying()) {
                    acdc.seekTo(0);
                    acdc.pause();
                    wolf.start();
                }

                else if (chum.isPlaying()) {
                    chum.seekTo(0);
                    chum.pause();
                    wolf.start();
                }

                else if (queen.isPlaying()) {
                    queen.seekTo(0);
                    queen.pause();
                    wolf.start();
                }

                else if (trex.isPlaying()) {
                    trex.seekTo(0);
                    trex.pause();
                    wolf.start();
                }

                else if (thin.isPlaying()) {
                    thin.seekTo(0);
                    thin.pause();
                    wolf.start();
                }

                else if (champ.isPlaying()) {
                    champ.seekTo(0);
                    champ.pause();
                    wolf.start();
                }

                else if (zz.isPlaying()) {
                    zz.seekTo(0);
                    zz.pause();
                    wolf.start();
                }
                // if the fourth song is not playing, start playing it
                else {
                    wolf.start();
                }

                break;

            // the fifth case is when the fifth button is clicked
            case R.id.button5:
                // if the fifth song is playing, pause playing it
                if (trex != null && trex.isPlaying()){
                    trex.pause();

                }

                else if (acdc.isPlaying()) {
                    acdc.seekTo(0);
                    acdc.pause();
                    trex.start();
                }

                else if (chum.isPlaying()) {
                    chum.seekTo(0);
                    chum.pause();
                    trex.start();
                }

                else if (queen.isPlaying()) {
                    queen.seekTo(0);
                    queen.pause();
                    trex.start();
                }

                else if (wolf.isPlaying()) {
                    wolf.seekTo(0);
                    wolf.pause();
                    trex.start();
                }

                else if (thin.isPlaying()) {
                    thin.seekTo(0);
                    thin.pause();
                    trex.start();
                }

                else if (champ.isPlaying()) {
                    champ.seekTo(0);
                    champ.pause();
                    trex.start();
                }

                else if (zz.isPlaying()) {
                    zz.seekTo(0);
                    zz.pause();
                    trex.start();
                }
                // if the fifth song is not playing, start playing it
                else {
                    trex.start();
                }

                break;

            // sixth case is when the sixth button is clicked
            case R.id.button6:
                // if the sixth song is playing, pause playing it
                if (champ != null && champ.isPlaying()){
                    champ.pause();

                }

                else if (acdc.isPlaying()) {
                    acdc.seekTo(0);
                    acdc.pause();
                    champ.start();
                }

                else if (chum.isPlaying()) {
                    chum.seekTo(0);
                    chum.pause();
                    champ.start();
                }

                else if (queen.isPlaying()) {
                    queen.seekTo(0);
                    queen.pause();
                    champ.start();
                }

                else if (wolf.isPlaying()) {
                    wolf.seekTo(0);
                    wolf.pause();
                    champ.start();
                }

                else if (thin.isPlaying()) {
                    thin.seekTo(0);
                    thin.pause();
                    champ.start();
                }

                else if (trex.isPlaying()) {
                    trex.seekTo(0);
                    trex.pause();
                    champ.start();
                }

                else if (zz.isPlaying()) {
                    zz.seekTo(0);
                    zz.pause();
                    champ.start();
                }
                // if the sixth song is not playing, start playing it
                else {
                    champ.start();
                }

                break;

            // seventh case is when seventh button is clicked
            case R.id.button7:
                // if the seventh song is playing, pause playing it
                if (thin != null && thin.isPlaying()){
                    thin.pause();

                }

                else if (acdc.isPlaying()) {
                    acdc.seekTo(0);
                    acdc.pause();
                    thin.start();
                }

                else if (chum.isPlaying()) {
                    chum.seekTo(0);
                    chum.pause();
                    thin.start();
                }

                else if (queen.isPlaying()) {
                    queen.seekTo(0);
                    queen.pause();
                    thin.start();
                }

                else if (wolf.isPlaying()) {
                    wolf.seekTo(0);
                    wolf.pause();
                    thin.start();
                }

                else if (champ.isPlaying()) {
                    champ.seekTo(0);
                    champ.pause();
                    thin.start();
                }

                else if (trex.isPlaying()) {
                    trex.seekTo(0);
                    trex.pause();
                    thin.start();
                }

                else if (zz.isPlaying()) {
                    zz.seekTo(0);
                    zz.pause();
                    thin.start();
                }
                // if the seventh song is not playing, start playing it
                else {
                    thin.start();
                }

                break;

            // eighth case is when the eighth button is clicked
            case R.id.button8:
                // if the eighth song is playing, pause playing it
                if (zz != null && zz.isPlaying()){
                    zz.pause();

                }

                else if (acdc.isPlaying()) {
                    acdc.seekTo(0);
                    acdc.pause();
                    zz.start();
                }

                else if (chum.isPlaying()) {
                    chum.seekTo(0);
                    chum.pause();
                    zz.start();
                }

                else if (queen.isPlaying()) {
                    queen.seekTo(0);
                    queen.pause();
                    zz.start();
                }

                else if (wolf.isPlaying()) {
                    wolf.seekTo(0);
                    wolf.pause();
                    zz.start();
                }

                else if (champ.isPlaying()) {
                    champ.seekTo(0);
                    champ.pause();
                    zz.start();
                }

                else if (trex.isPlaying()) {
                    trex.seekTo(0);
                    trex.pause();
                    zz.start();
                }

                else if (thin.isPlaying()) {
                    thin.seekTo(0);
                    thin.pause();
                    zz.start();
                }
                // if the eighth song is not playing, start playing it
                else {
                    zz.start();
                }

                break;
        }
    }

    // this was needed to ensure the MPs did not fail when the user moved to another activity
    // it paused any song, stopped, released and ensured that MPs were available when the user next arrived in MusicActivity
    // unfortunately meant no music outside of MusicActivity
    // but this could be rectified with refactoring all code
    @Override
    protected void onPause() {
        super.onPause();
        if (acdc != null && acdc.isPlaying()){
            acdc.pause();
            if (isFinishing()){
                acdc.stop();
                acdc.release();
            }
        }

        else if (chum != null && chum.isPlaying()){
            chum.pause();
            if (isFinishing()){
                chum.stop();
                chum.release();
            }
        }

        else if (queen != null && queen.isPlaying()){
            queen.pause();
            if (isFinishing()){
                queen.stop();
                queen.release();
            }
        }

        else if (wolf != null && wolf.isPlaying()){
            wolf.pause();
            if (isFinishing()){
                wolf.stop();
                wolf.release();
            }
        }

        else if (trex != null && trex.isPlaying()){
            trex.pause();
            if (isFinishing()){
                trex.stop();
                trex.release();
            }
        }

        else if (champ != null && champ.isPlaying()){
            champ.pause();
            if (isFinishing()){
                champ.stop();
                champ.release();
            }
        }

        else if (thin != null && thin.isPlaying()){
            thin.pause();
            if (isFinishing()){
                thin.stop();
                thin.release();
            }
        }

        else if (zz != null && zz.isPlaying()){
            zz.pause();
            if (isFinishing()){
                zz.stop();
                zz.release();
            }
        }
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