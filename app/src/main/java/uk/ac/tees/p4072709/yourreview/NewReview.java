package uk.ac.tees.p4072709.yourreview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NewReview extends AppCompatActivity {
    private Button discard, save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_review);
        setTitle("New Review");

        discard = (Button) findViewById(R.id.btnNRCancel);
        save = (Button) findViewById(R.id.btnNRSave);
        DatabaseHelper db = new DatabaseHelper(this);



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
