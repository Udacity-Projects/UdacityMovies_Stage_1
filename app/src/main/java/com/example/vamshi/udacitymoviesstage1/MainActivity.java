package com.example.vamshi.udacitymoviesstage1;

import android.content.DialogInterface;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroupOverlay;
import android.widget.AdapterView;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    static GridView myGridView;
    static List<MovieObject> Movies;
    static GridViewAdapter myAdapter;
    static ProgressBar myProgress;

    public Boolean popular = true;
    public Boolean Rating = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Movies = new ArrayList<>();
        myProgress = (ProgressBar)findViewById(R.id.progressDialog);
        myProgress.setVisibility(View.VISIBLE);
        myGridView = (GridView) findViewById(R.id.myGridLayout);
        myGridView.setVisibility(View.GONE);


        LoadUI();

        myAdapter = new GridViewAdapter(Movies,this);
        //myGridView.setAdapter(myAdapter);

        myGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                MovieObject temo = Movies.get(position);

                Intent in = new Intent(MainActivity.this, DisplayMovieDetails.class);
                in.putExtra("POSTER_URL", temo.getMovieURL());
                in.putExtra("ORIGINAL_TITLE", temo.getMovieOriginalTitle());
                in.putExtra("SYNOPSIS", temo.getMovieSynopsis());
                in.putExtra("RATING", temo.getMovieRating());
                in.putExtra("RELEASE_DATE", temo.getMovieReleaseDate());
                in.putExtra("ORIGINAL_TITLE", temo.getMovieOriginalTitle());
                startActivity(in);


            }
        });

    }

    private void LoadUI() {

        Movies.clear();

        DownloadTask newTask = new DownloadTask();
        if((Rating == true)&& (popular == false)) {


            newTask.execute("https://api.themoviedb.org/3/movie/top_rated?api_key=984eb4f6c311eabbe5fd13dc82c16ab7&language=en-US&page=1");
            myGridView.setAdapter(myAdapter);


        }

        if((Rating == false)&& (popular == true)){

            newTask.execute("https://api.themoviedb.org/3/movie/popular?api_key=984eb4f6c311eabbe5fd13dc82c16ab7&language=en-US&page=1");
            myGridView.setAdapter(myAdapter);


        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.PopularitySort:
                popular = true;
                Rating = false;
                LoadUI();


                myAdapter.notifyDataSetChanged();

            case R.id.Ratings:
                popular = false;
                Rating = true;

                LoadUI();
                myAdapter.notifyDataSetChanged();
        }
        return super.onOptionsItemSelected(item);
    }

}
