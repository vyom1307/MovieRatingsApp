package com.example.movieapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.movieapp.model.Movie;
import com.example.movieapp.model.Repository;
import com.example.movieapp.model.Show;

import java.util.List;

public class MainActViewModel extends AndroidViewModel {
    private Repository repository;

    public MainActViewModel(@NonNull Application application) {
        super(application);
        this.repository=new Repository(application);
    }
    public LiveData<List<Movie>>getAllMovies(){
        return repository.getMoviesLiveData();

    }
    public LiveData<List<Show>>getAllShows(){
        return repository.getTvShowLiveData();

    }

}
