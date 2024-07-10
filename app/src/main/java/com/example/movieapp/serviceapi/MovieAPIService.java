package com.example.movieapp.serviceapi;

import com.example.movieapp.model.result;
import com.example.movieapp.model.result_tvshow;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieAPIService {
    @GET("movie/popular")
    Call<result> GetPopularMovies(@Query("api_key") String apiKey);
    @GET("tv/popular")
    Call<result_tvshow> GetPopularTVShows(@Query("api_key") String apiKey);
}
