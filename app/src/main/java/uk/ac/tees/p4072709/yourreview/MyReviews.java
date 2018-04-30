package uk.ac.tees.p4072709.yourreview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class MyReviews extends AppCompatActivity {

    String text = "";
    private ListView reviewList;
    private Button home;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_reviews);
        setTitle("My Reviews");

        reviewList = (ListView) findViewById(R.id.reviews_list_view);
        DatabaseHelper db = new DatabaseHelper(this);

        Button newReview = (Button) findViewById(R.id.btnMRNewReviews);
        Button home = (Button) findViewById(R.id.btnHome);

        newReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start NewActivity.class
                Intent myAccountIntent = new Intent(MyReviews.this,
                        NewReview.class);
                startActivity(myAccountIntent);
            }
        });

        List<Review> reviews = db.getAllReviews();

        for (Review r : reviews) {
            String log = "ID: " + r.getId() + ", Name: " + r.getName() + ", Review: " + r.getReview() + ", User: " +
                    r.getUser() + ", Location: " + r.getLocation();
            text = text + log;
        }

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent HomeIntent = new Intent(MyReviews.this,
                        Home.class);
                startActivity(HomeIntent);
            }
        });

    }
}
