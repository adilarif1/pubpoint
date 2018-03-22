package uk.ac.uws.pubpoint;

/**
 * LanderActivity, PubPoint.
 * Built by - B00147369, B00221290, B00257014
 * Nov/Dec 2016
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class LanderActivity extends AppCompatActivity {

    private ImageView landerLogoButton;

    // for movement to StoreActivity
    public void init() {

        ImageView imageView = (ImageView) findViewById(R.id.landerLogo);

        imageView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), StoreActivity.class);

                startActivity(intent);

            }

        });

    }

    // set operations and classes on creation of the page
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lander);

        init();

    }
}