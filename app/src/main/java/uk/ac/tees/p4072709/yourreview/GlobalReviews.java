package uk.ac.tees.p4072709.yourreview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GlobalReviews extends AppCompatActivity {

    private Button Home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_global_reviews);

        Home = (Button) findViewById(R.id.btnHome);

        //returns to the home page
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start NewActivity.class
                Intent HomeIntent = new Intent(GlobalReviews.this,
                        Home.class);
                startActivity(HomeIntent);
            }
        });
    }
}
