package com.example.movieapp.model;


import android.widget.ImageView;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;
import java.util.Locale;

import com.bumptech.glide.Glide;
import com.google.gson.annotations.SerializedName;


public class Show {
        @SerializedName("adult")
        boolean adult;

        @SerializedName("backdrop_path")
        String backdropPath;


        @SerializedName("genre_ids")
        List<Integer> genreIds;

        @SerializedName("id")
        int id;

        @SerializedName("origin_country")
        List<String> originCountry;

        @SerializedName("original_language")
        String originalLanguage;

        @SerializedName("original_name")
        String originalName;

        @SerializedName("overview")
        String overview;

        @SerializedName("popularity")
        double popularity;

        @SerializedName("poster_path")
        String posterPath;
    @BindingAdapter({"posterPath"})
    public static void loadImage(ImageView imageView, String url) {
        Glide.with(imageView.getContext()).load("https://image.tmdb.org/t/p/w500/" + url).into(imageView);
    }

        @SerializedName("first_air_date")
        Date firstAirDate;
    @BindingAdapter("firstAirDate")
    public static void setDateText(TextView textView, Date date) {
        if (date != null) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy", Locale.getDefault());
            textView.setText("("+formatter.format(date)+")");
        } else {
            textView.setText("");
        }
    }

        @SerializedName("name")
        String title;

        @SerializedName("vote_average")
        double voteAverage;

        @SerializedName("vote_count")
        int voteCount;


        public void setAdult(boolean adult) {
            this.adult = adult;
        }
        public boolean getAdult() {
            return adult;
        }

        public void setBackdropPath(String backdropPath) {
            this.backdropPath = backdropPath;
        }
        public String getBackdropPath() {
            return backdropPath;
        }

        public void setGenreIds(List<Integer> genreIds) {
            this.genreIds = genreIds;
        }
        public List<Integer> getGenreIds() {
            return genreIds;
        }

        public void setId(int id) {
            this.id = id;
        }
        public int getId() {
            return id;
        }

        public void setOriginCountry(List<String> originCountry) {
            this.originCountry = originCountry;
        }
        public List<String> getOriginCountry() {
            return originCountry;
        }

        public void setOriginalLanguage(String originalLanguage) {
            this.originalLanguage = originalLanguage;
        }
        public String getOriginalLanguage() {
            return originalLanguage;
        }

        public void setOriginalName(String originalName) {
            this.originalName = originalName;
        }
        public String getOriginalName() {
            return originalName;
        }

        public void setOverview(String overview) {
            this.overview = overview;
        }
        public String getOverview() {
            return overview;
        }

        public void setPopularity(double popularity) {
            this.popularity = popularity;
        }
        public double getPopularity() {
            return popularity;
        }

        public void setPosterPath(String posterPath) {
            this.posterPath = posterPath;
        }
        public String getPosterPath() {
            return posterPath;
        }

        public void setFirstAirDate(Date firstAirDate) {
            this.firstAirDate = firstAirDate;
        }
        public Date getFirstAirDate() {
            return firstAirDate;
        }

        public void setName(String name) {
            this.title = name;
        }
        public String getName() {
            return title;
        }

        public void setVoteAverage(double voteAverage) {
            this.voteAverage = voteAverage;
        }
        public double getVoteAverage() {
            return voteAverage;
        }

        public void setVoteCount(int voteCount) {
            this.voteCount = voteCount;
        }
        public int getVoteCount() {
            return voteCount;
        }

    }

