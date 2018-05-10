package uk.ac.tees.p4072709.yourreview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class NewReview extends AppCompatActivity {

    private Button discard, save;
    private EditText review, username, location, name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_review);
        setTitle("New Review");

        final Context con = this;
        discard = (Button) findViewById(R.id.btnNRCancel);
        save = (Button) findViewById(R.id.btnNRSave);
        review = (EditText) findViewById(R.id.nrText);
        username = (EditText) findViewById(R.id.nrUsername);
        location = (EditText) findViewById(R.id.nrLocation);
        name = (EditText) findViewById(R.id.txtReviewName);

        final DatabaseHelper db = new DatabaseHelper(this);

        /* saving the review */
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast t;
                if (username.getText().toString().equals("")) {
                    t = Toast.makeText(getApplicationContext(), "Please enter a name", Toast.LENGTH_SHORT);
                    t.show();
                } else {

                    db.addReview(username.getText().toString(),name.getText().toString(), location.getText().toString(), review.getText().toString());
                    t = Toast.makeText(getApplicationContext(), "Saved Review", Toast.LENGTH_SHORT);
                    t.show();
                    username.setText("");
                    location.setText("");
                    name.setText("");
                    review.setText("");

                }
            }
        });


        /* user presses discard, goes back to the home page */
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
