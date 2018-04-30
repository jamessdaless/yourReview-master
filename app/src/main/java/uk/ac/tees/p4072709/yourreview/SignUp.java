package uk.ac.tees.p4072709.yourreview;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.*;
import static android.R.attr.name;
import static android.R.attr.progress;


public class SignUp extends AppCompatActivity implements View.OnClickListener {


    private Button SignUp, Cancel;
    private EditText SUEmail, SUPass, SUCPass;
    private String email, pass, cpass;
    private FirebaseAuth auth;
    private ProgressBar progressBar;

    //FirebaseDatabase database;
    //DatabaseReference ref;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("Registration Page");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up2);

        auth = FirebaseAuth.getInstance();
        //progressDialog = new ProgressDialog(this);


        SignUp = (Button) findViewById(R.id.btnSUConfirm);
        Cancel = (Button) findViewById(R.id.btnSUCancel);


        SUEmail = (EditText) findViewById(R.id.SUEmail);
        SUPass = (EditText) findViewById(R.id.SUPassword);
        SUCPass = (EditText) findViewById(R.id.SUCPass);
        progressBar = (ProgressBar) findViewById(R.id.progressBar3);

        SignUp.setOnClickListener(this);
        Cancel.setOnClickListener(this);
    }

    private void registerUser() {

        String email = SUEmail.getText().toString().trim();
        String pass = SUPass.getText().toString().trim();
        String cpass = SUCPass.getText().toString().trim();


        if (TextUtils.isEmpty(email)) {
            //no email
            Toast.makeText(this, "Please enter your email", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(cpass)) {
            //no confirmpass
            Toast.makeText(this, "Please confirm your password", Toast.LENGTH_SHORT).show();
            return;
        }

        if (pass.length() < 8) {
            //password length
            Toast.makeText(getApplicationContext(), "Password too short, enter minimum 8 characters!", Toast.LENGTH_SHORT).show();
            return;
        }

        /*if (pass != cpass) {
            Toast.makeText(getApplicationContext(), "Passwords do not match!", Toast.LENGTH_SHORT).show();
            return;
        } */

        progressBar.setVisibility(View.VISIBLE);

        auth.createUserWithEmailAndPassword(email, cpass)
                .addOnCompleteListener(SignUp.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Toast.makeText(SignUp.this, "sign up complete" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Toast.makeText(SignUp.this, "Authentication failed." + task.getException(),
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            startActivity(new Intent(SignUp.this, SignInn.class));
                            finish();
                        }
                    }
                });
    }

    @Override
    public void onClick(View v) {
        if (v == SignUp) {
            registerUser();
        }

        if (v == Cancel) {
            //set to login page
            startActivity(new Intent(SignUp.this, MainActivity.class));
            finish();
        }
    }


    }




