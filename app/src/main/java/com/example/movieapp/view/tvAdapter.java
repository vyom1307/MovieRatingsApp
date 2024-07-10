package com.example.movieapp.view;

import android.content.Context;
import android.view.LayoutInflater;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieapp.R;

import com.example.movieapp.databinding.MovLostTiemBinding;
import com.example.movieapp.model.Movie;


import java.util.ArrayList;

public class tvAdapter extends RecyclerView.Adapter<tvAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Movie> movies;

    public tvAdapter(Context context, ArrayList<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MovLostTiemBinding binding= DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.mov_lost_tiem,parent,false);
        ViewHolder holder = new ViewHolder(binding);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Movie movie=movies.get(position);
        holder.binding.setMovie(movie);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        MovLostTiemBinding binding;
        public ViewHolder(MovLostTiemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

    }



}
