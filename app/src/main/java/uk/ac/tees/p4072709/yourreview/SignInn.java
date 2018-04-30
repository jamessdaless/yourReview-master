package uk.ac.tees.p4072709.yourreview;

import android.content.Intent;
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

public class SignInn extends AppCompatActivity {

    private Button signin, cancel;
    private EditText emailtext, passtext;
    private String pass, email;
    private FirebaseAuth auth;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_inn);
        setTitle("Sign In");

        auth = FirebaseAuth.getInstance();

        if (auth.getCurrentUser() != null) {
            startActivity(new Intent(SignInn.this, MainActivityOD.class));
            finish();
        }

        setContentView(R.layout.activity_sign_inn);

        cancel = (Button) findViewById(R.id.btnSUCancel);
        signin = (Button) findViewById(R.id.btnSILogin);
        emailtext = (EditText) findViewById(R.id.SIEmaill);
        passtext = (EditText) findViewById(R.id.SIPassword);
        progressBar = (ProgressBar) findViewById(R.id.progressBar2);
        auth = FirebaseAuth.getInstance();

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignInn.this, MainActivity.class));
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailtext.getText().toString();
                final String password = passtext.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter your email address", Toast.LENGTH_SHORT ).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter your password", Toast.LENGTH_SHORT ).show();
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                //authenticate user
                auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(SignInn.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressBar.setVisibility(View.GONE);
                                if (!task.isSuccessful()) {
                                    if (password.length() < 8)
                                    {
                                        passtext.setError("Password is too short, please enter 8 characters minimum!");
                                    } else {
                                        Toast.makeText(SignInn.this, "Authentication failed, check your email and password ", Toast.LENGTH_SHORT).show();
                                    }
                                } else {
                                    Intent intent = new Intent(SignInn.this, MainActivityOD.class );
                                    startActivity(intent);
                                    finish();
                                }



                            }
                        });
            }
        });

    };
};





