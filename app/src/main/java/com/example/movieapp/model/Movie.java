package com.example.movieapp.model;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;
import java.util.Locale;

import com.bumptech.glide.Glide;
import com.example.movieapp.BR;
import com.google.gson.annotations.SerializedName;

public class Movie extends BaseObservable {
    @SerializedName("adult")
    boolean adult;

    @SerializedName("backdrop_path")
    String backdropPath;

    @SerializedName("genre_ids")
    List<Integer> genreIds;

    @SerializedName("id")
    int id;

    @SerializedName("original_language")
    String originalLanguage;

    @SerializedName("original_title")
    String originalTitle;

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

    @SerializedName("release_date")
    Date releaseDate;
    @BindingAdapter("releaseDate")
    public static void setDateText(TextView textView, Date date) {
        if (date != null) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy", Locale.getDefault());
            textView.setText("("+formatter.format(date)+")");
        } else {
            textView.setText("");
        }
    }

    @SerializedName("title")
    String title;

    @SerializedName("video")
    boolean video;

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

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }
    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }
    public String getOriginalTitle() {
        return originalTitle;
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

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
    public Date getReleaseDate() {
        return releaseDate;
    }
        @Bindable
    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }
    public String getTitle() {

        return title;

    }

    public void setVideo(boolean video) {
        this.video = video;
    }
    public boolean getVideo() {
        return video;
    }
    @Bindable

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
        notifyPropertyChanged(BR.voteAverage);
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
