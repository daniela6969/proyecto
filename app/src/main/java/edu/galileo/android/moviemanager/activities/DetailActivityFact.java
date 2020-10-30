package edu.galileo.android.moviemanager.activities;

import edu.galileo.android.moviemanager.R;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DetailActivityFact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_detail_fact);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.setTitle("Mi Factura");

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }
}
