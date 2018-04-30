package uk.ac.tees.p4072709.yourreview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyReviews extends AppCompatActivity {

    String text = "";
    private ListView listView;
    private Button home;
    private ArrayAdapter adapter;
    private String[] reviewss = {};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_reviews);
        setTitle("My Reviews");

        listView = (ListView) findViewById(R.id.reviews_list_view);
        DatabaseHelper db = new DatabaseHelper(this);

        Button newReview = (Button) findViewById(R.id.btnMRNewReviews);
        Button home = (Button) findViewById(R.id.btnHome);

        //inserting some default reviews
        db.addReview(new Review("The Cribs @ Empire", "played all the classics, was great", "james_dales@hotmail.com", "Middlesborugh"));
        db.addReview(new Review("Taylor Swift @ Manchester Arena", "bangers galore, she was outstanding", "james_dales@hotmail.com", "Manchester"));

        newReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start NewActivity.class
                Intent myAccountIntent = new Intent(MyReviews.this,
                        NewReview.class);
                startActivity(myAccountIntent);
            }
        });

        List<Review> reviews = new ArrayList<>();
            reviews = db.getAllReviews();
            Log.d("REVIEW ARRAY", reviews.toString());


        for (Review r : reviews) {
            //String log = "ID: " + r.getId() + ", Name: " + r.getName() + ", Review: " + r.getReview() + ", User: " +
           //         r.getUser() + ", Location: " + r.getLocation();
            //text = text + log;

            reviewss = Arrays.copyOf(reviewss, reviewss.length + 1);
            reviewss[reviewss.length - 1] = "ID: " + r.getId() + ", Name: " + r.getName() + ", Review: " + r.getReview() + ", User: " +
                    r.getUser() + ", Location: " + r.getLocation();

        }

        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, reviewss);
        ListView listView = (ListView) findViewById(R.id.reviews_list_view);
        listView.setAdapter(adapter);


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
