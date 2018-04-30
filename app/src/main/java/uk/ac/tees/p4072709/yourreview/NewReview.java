package uk.ac.tees.p4072709.yourreview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NewReview extends AppCompatActivity {
    private Button discard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_review);
        setTitle("New Review");

        discard = (Button) findViewById(R.id.btnNRCancel);
        DatabaseHelper db = new DatabaseHelper(this);

        //inserting some default reviews
        db.addReview(new Review("The Cribs @ Empire", "played all the classics, was great", "james_dales@hotmail.com", "Middlesborugh"));
        db.addReview(new Review("Taylor Swift @ Manchester Arena", "bangers galore, she was outstanding", "james_dales@hotmail.com", "Manchester"));

        discard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent HomeIntent = new Intent(NewReview.this,
                        Home.class);
                startActivity(HomeIntent);
            }
        });

    }
}
