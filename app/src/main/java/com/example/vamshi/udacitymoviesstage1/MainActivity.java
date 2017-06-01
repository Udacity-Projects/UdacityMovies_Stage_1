package com.example.vamshi.udacitymoviesstage1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    static GridView myGridView;
    static List<MovieObject> Movies;
    static GridViewAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myGridView = (GridView) findViewById(R.id.mYGridLayout);

        DownloadTask newTask = new DownloadTask();
        newTask.execute("https://api.themoviedb.org/3/movie/top_rated?api_key=984eb4f6c311eabbe5fd13dc82c16ab7&language=en-US&page=1");

        myAdapter = new GridViewAdapter(Movies,this);


    }
}
