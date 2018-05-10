package uk.ac.tees.p4072709.yourreview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyArtists extends AppCompatActivity {

    String artist = "";
    private Button save, home;
    private EditText artistt;
    private String[] artists = {};
    private ListView listView;
    private ArrayAdapter adapter;

    final DatabaseHelper db = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_artists);
        setTitle("My Artists");

        save = (Button) findViewById(R.id.btnMASave);
        home = (Button) findViewById(R.id.btnMAHome);
        artistt = (EditText) findViewById(R.id.txtMAname);

        home.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent HomeIntent = new Intent(MyArtists.this,
                        Home.class);
                startActivity(HomeIntent);

            }
        }));

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast t;
                if (artistt.getText().toString().equals("")) {
                    t = Toast.makeText(getApplicationContext(), "Please enter a artist", Toast.LENGTH_SHORT);
                    t.show();
                } else {

                    db.addArtist(artistt.getText().toString());
                    t = Toast.makeText(getApplicationContext(), "Saved Artist", Toast.LENGTH_SHORT);
                    t.show();
                    artistt.setText("");

                }
            }
        });




    }
}