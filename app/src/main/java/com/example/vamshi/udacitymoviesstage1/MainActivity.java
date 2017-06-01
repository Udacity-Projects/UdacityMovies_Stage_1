package com.example.vamshi.udacitymoviesstage1;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroupOverlay;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    static GridView myGridView;
    static List<MovieObject> Movies;
    static GridViewAdapter myAdapter;
    static ProgressBar myProgress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Movies = new ArrayList<>();
        myProgress = (ProgressBar)findViewById(R.id.progressDialog);
        myProgress.setVisibility(View.VISIBLE);
        myGridView = (GridView) findViewById(R.id.myGridLayout);
        myGridView.setVisibility(View.GONE);

        DownloadTask newTask = new DownloadTask();
        newTask.execute("https://api.themoviedb.org/3/movie/top_rated?api_key=984eb4f6c311eabbe5fd13dc82c16ab7&language=en-US&page=1");

        myAdapter = new GridViewAdapter(Movies,this);
        //myGridView.setAdapter(myAdapter);

    }
}
