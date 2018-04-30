package uk.ac.tees.p4072709.yourreview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setTitle("Home");

        Button myAccount = (Button) findViewById(R.id.btnHMyAccount);
        Button SocialMedia = (Button) findViewById(R.id.btnHSocialMedia);
        Button Location = (Button) findViewById(R.id.btnHLocation);
        Button MyReviews = (Button) findViewById(R.id.btnHMyReviews);
        Button globalReviews = (Button) findViewById(R.id.btnHGlobalReviews);
        Button Search = (Button) findViewById(R.id.btnHSearch);
        Button myArtists = (Button) findViewById(R.id.btnHMyArtist);

        myAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start NewActivity.class
                Intent myAccountIntent = new Intent(Home.this,
                        MainActivityOD.class);
                startActivity(myAccountIntent);
            }
        });

        SocialMedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start NewActivity.class
                Intent mySMIntent = new Intent(Home.this,
                        SocialMedia.class);
                startActivity(mySMIntent);
            }
        });

        Location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start NewActivity.class
                Intent myLocationIntent = new Intent(Home.this,
                        Location.class);
                startActivity(myLocationIntent);
            }
        });

        MyReviews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start NewActivity.class
                Intent myReviewIntent = new Intent(Home.this,
                        MyReviews.class);
                startActivity(myReviewIntent);
            }
        });

        globalReviews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start NewActivity.class
                Intent globalReviewsIntent = new Intent(Home.this,
                        GlobalReviews.class);
                startActivity(globalReviewsIntent);
            }
        });

        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start NewActivity.class
                Intent SearchIntent = new Intent(Home.this,
                        Search.class);
                startActivity(SearchIntent);
            }
        });

        myArtists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start NewActivity.class
                Intent myAccountIntent = new Intent(Home.this,
                        MyArtists.class);
                startActivity(myAccountIntent);
            }
        });
    }


}
