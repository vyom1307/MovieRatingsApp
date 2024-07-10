package com.example.movieapp.model;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.example.movieapp.R;
import com.example.movieapp.serviceapi.MovieAPIService;
import com.example.movieapp.serviceapi.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {
    private ArrayList<Movie> movies=new ArrayList<>();
    private MutableLiveData<List<Movie>> moviesLiveData=new MutableLiveData<>();

    private ArrayList<Show> tvShows=new ArrayList<>();
    private MutableLiveData<List<Show>> tvShowLiveData=new MutableLiveData<>();
    private Application application;

    public Repository(Application application) {
        this.application = application;
    }

    public Repository(){
        moviesLiveData.setValue(movies);
        tvShowLiveData.setValue(tvShows);

    }
    public MutableLiveData<List<Movie>> getMoviesLiveData() {
        MovieAPIService movieService= RetrofitInstance.getService();
        Call<result> call=movieService.GetPopularMovies(application.getString(R.string.api_key));
        call.enqueue(new Callback<result>() {
            @Override
            public void onResponse(Call<result> call, Response<result> response) {
                result r=response.body();
                if(r!=null&&r.getResults()!=null){
                    movies=(ArrayList<Movie>) r.getResults();
                    moviesLiveData.setValue(movies);
                }
            }

            @Override
            public void onFailure(Call<result> call, Throwable throwable) {

            }
        });
        return moviesLiveData;
    }
    public MutableLiveData<List<Show>> getTvShowLiveData() {
        MovieAPIService movieService= RetrofitInstance.getService();
        Call<result_tvshow> call=movieService.GetPopularTVShows(application.getString(R.string.api_key));
        call.enqueue(new Callback<result_tvshow>() {
            @Override
            public void onResponse(Call<result_tvshow> call, Response<result_tvshow> response) {
                result_tvshow r=response.body();
                if(r!=null&&r.getResults()!=null){
                    tvShows=(ArrayList<Show>) r.getResults();
                    tvShowLiveData.setValue(tvShows);
                }
            }

            @Override
            public void onFailure(Call<result_tvshow> call, Throwable throwable) {

            }


        });
        return tvShowLiveData;
    }
}
