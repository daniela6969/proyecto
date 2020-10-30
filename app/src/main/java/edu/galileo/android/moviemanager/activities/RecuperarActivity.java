package edu.galileo.android.moviemanager.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import edu.galileo.android.moviemanager.R;

public class RecuperarActivity extends AppCompatActivity {
    private Button btnRecupera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar);
        btnRecupera= (Button) findViewById(R.id.btnRecordar);

        btnRecupera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

}
