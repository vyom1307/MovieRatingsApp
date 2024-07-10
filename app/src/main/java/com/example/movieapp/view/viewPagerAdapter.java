package com.example.movieapp.view;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;

import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.movieapp.Mshows;
import com.example.movieapp.model.Movie;
import com.example.movieapp.model.Show;
import com.example.movieapp.tvlist;

import java.util.ArrayList;

public class viewPagerAdapter extends FragmentStateAdapter {
    ArrayList<Show> tvShow;
    ArrayList<Movie> movies;
    public String[] tabTitles = new String[]{"TV Shows", "Movies", "Cartoons"};

    public viewPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle, ArrayList<Movie> movies,ArrayList<Show> tvShow) {
        super(fragmentManager, lifecycle);
        this.movies = movies;
        this.tvShow = tvShow;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position) {
            case 0:
                return new tvlist(tvShow);
            case 1:
                return new Mshows(movies);
            case 2:
                return new tvlist(tvShow);
            default:
                return new tvlist(tvShow);
        }
    }

    @Override
    public int getItemCount() {
        return tabTitles.length;
    }

}
