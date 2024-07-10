package com.example.movieapp;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.movieapp.databinding.FragmentMshowsBinding;
import com.example.movieapp.databinding.FragmentTvlistBinding;
import com.example.movieapp.model.Movie;
import com.example.movieapp.model.Show;
import com.example.movieapp.view.MovieAdapter;
import com.example.movieapp.view.tvAdapter;
import com.example.movieapp.viewmodel.MainActViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Mshows#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Mshows extends Fragment {
    private ArrayList<Movie>movies;
    private RecyclerView recyclerView;
    private FragmentMshowsBinding fragmentMshowBinding;
    private tvAdapter movieAdapter;




    public Mshows(ArrayList<Movie>movie) {
        // Required empty public constructor
        this.movies=movie;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        fragmentMshowBinding= DataBindingUtil.inflate(inflater,R.layout.fragment_mshows,container,false);
        recyclerView=fragmentMshowBinding.recyclerView;
        movieAdapter=new tvAdapter(getContext(),movies);
        recyclerView.setLayoutManager(new GridLayoutManager(this.getContext(),2));
        recyclerView.setAdapter(movieAdapter);
        return recyclerView;

    }
}