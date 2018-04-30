package uk.ac.tees.p4072709.yourreview;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.content.Intent;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.ActionCodeResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivityOD extends AppCompatActivity {

    private Button  btnChangePassword, btnConPass, btnSignOut, btnContinue;
    private EditText newPass, conNewPass;
    private ProgressBar progressBar;
    private FirebaseAuth.AuthStateListener authListener;
    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_od);
        setTitle("My Account");

        auth = FirebaseAuth.getInstance();

        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null) {
                    startActivity(new Intent(MainActivityOD.this, SignUp.class));
                    finish();
                }
            }
        };


        btnChangePassword = (Button) findViewById(R.id.btnChangePass);
        btnContinue = (Button) findViewById(R.id.btnMAConToHome);
        btnSignOut = (Button) findViewById(R.id.btnMASignOut);
        btnConPass = (Button) findViewById(R.id.btnConPass);


        newPass = (EditText) findViewById(R.id.MANewPass);
        conNewPass = (EditText) findViewById(R.id.MAConNewPass);


        newPass.setVisibility(View.GONE);
        conNewPass.setVisibility(View.GONE);

        btnConPass.setVisibility(View.GONE);


        progressBar = (ProgressBar) findViewById(R.id.progressBar4);

        if (progressBar != null) {
            progressBar.setVisibility(View.GONE);
        }



        btnChangePassword.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                newPass.setVisibility(View.VISIBLE);
                conNewPass.setVisibility(View.VISIBLE);
                btnConPass.setVisibility(View.VISIBLE);
            }
        });

        btnConPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                if (user != null && !newPass.getText().toString().trim().equals("")){
                    if (newPass.getText().toString().trim().length() < 8 ) {
                        newPass.setError("Password too short, please enter 8 or more characters");
                        progressBar.setVisibility(View.GONE);
                    } else if (newPass != conNewPass){
                        Toast.makeText(MainActivityOD.this, "Passwords don't match!", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        user.updatePassword(newPass.getText().toString().trim())
                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {
                                            Toast.makeText(MainActivityOD.this, "Password is update, please sign in again", Toast.LENGTH_SHORT).show();
                                            signOut();
                                            progressBar.setVisibility(View.GONE);
                                        } else {
                                            Toast.makeText(MainActivityOD.this, "Failed to update password", Toast.LENGTH_SHORT).show();
                                            progressBar.setVisibility(View.GONE);
                                        }

                                    }
                                });


                    }
                } else if (newPass.getText().toString().trim().equals("")) {
                    newPass.setError("Enter Password");
                    progressBar.setVisibility(View.GONE);
                }
            }
        });


        btnSignOut.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                signOut();
                Intent mySignOutIntent = new Intent(MainActivityOD.this,
                        MainActivity.class);
                startActivity(mySignOutIntent);
            }
        });

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent continueIntent = new Intent(MainActivityOD.this, Home.class);
                startActivity(continueIntent);
            }
        });

    }

    public void signOut() {
        auth.signOut();
    }

    @Override
    protected void onResume() {
        super.onResume();
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onStart() {
        super.onStart();
        auth.addAuthStateListener(authListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (authListener != null) {
            auth.removeAuthStateListener(authListener);
        }
    }

}
