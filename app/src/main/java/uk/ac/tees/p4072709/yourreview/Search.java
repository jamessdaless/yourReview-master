package uk.ac.tees.p4072709.yourreview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Search extends AppCompatActivity {

    private Button Home, search, clear;
    public static EditText artist;
    public static TextView results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("Search Artists");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Home = (Button) findViewById(R.id.btnHome);
        search = (Button) findViewById(R.id.btnSearch);
        clear = (Button) findViewById(R.id.btnClear);
        results = (TextView) findViewById(R.id.txtResults);
        artist = (EditText) findViewById(R.id.txtSearch);

    //return to home
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start NewActivity.class
                Intent HomeIntent = new Intent(Search.this,
                        Home.class);
                startActivity(HomeIntent);
            }
        });

        search.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                returnData process = new returnData();
                process.execute();
            }

        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                results.setText("");
            }
        });


    }
}
