package com.example.vamshi.udacitymoviesstage1;

/**
 * Created by Vamshi on 5/31/2017.
 */

public class MovieObject {

    private String movieTitle;
    private String movieURL;

    public MovieObject(String movieTitle, String movieURL) {
        this.movieTitle = movieTitle;
        this.movieURL = movieURL;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieURL() {
        return movieURL;
    }

    public void setMovieURL(String movieURL) {
        this.movieURL = movieURL;
    }
}
