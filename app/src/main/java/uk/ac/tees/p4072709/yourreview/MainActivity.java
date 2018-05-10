package uk.ac.tees.p4072709.yourreview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("YourReview");


        Button signup = (Button) findViewById(R.id.btnSignUp);
        Button signin = (Button) findViewById(R.id.btnSignIn);

        /* sign in button to take user to the sign in page */
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start NewActivity.class
                Intent mySignInIntent = new Intent(MainActivity.this,
                        SignInn.class);
                startActivity(mySignInIntent);
            }
        });

        /* takes the user to the registration page */
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start NewActivity.class
                Intent mySignUpIntent = new Intent(MainActivity.this,
                       SignUp.class);
                startActivity(mySignUpIntent);
            }
        });

    }
}
