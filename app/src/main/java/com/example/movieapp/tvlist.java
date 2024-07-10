package com.example.movieapp;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.movieapp.databinding.FragmentTvlistBinding;
import com.example.movieapp.model.Movie;
import com.example.movieapp.model.Show;
import com.example.movieapp.view.MovieAdapter;
import com.example.movieapp.view.viewPagerAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link tvlist#newInstance} factory method to
 * create an instance of this fragment.
 */
public class tvlist extends Fragment {
   private RecyclerView recyclerView;
   private FragmentTvlistBinding fragmentTvlistBinding;
    private MovieAdapter movieAdapter;
   private ArrayList<Show>tvshows;

    // TODO: Rename parameter arguments, choose names that match


    public tvlist( ArrayList<Show> movie) {

        // Required empty public constructor
        this.tvshows=movie;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentTvlistBinding= DataBindingUtil.inflate(inflater,R.layout.fragment_tvlist,container,false);
        recyclerView=fragmentTvlistBinding.recyclerView;
        movieAdapter=new MovieAdapter(getContext(),tvshows);
        recyclerView.setLayoutManager(new GridLayoutManager(this.getContext(),2));
        recyclerView.setAdapter(movieAdapter);
        return recyclerView;

    }
}