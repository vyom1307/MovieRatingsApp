package com.example.movieapp.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieapp.R;


import com.example.movieapp.databinding.ListItemHoriBinding;
import com.example.movieapp.model.Movie;

import java.util.ArrayList;

public class HoriMovieAdapter extends RecyclerView.Adapter<HoriMovieAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Movie> movies;

    public HoriMovieAdapter(Context context, ArrayList<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListItemHoriBinding listItemBinding= DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.list_item_hori,parent,false);
        return new ViewHolder(listItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int actualPosition = position % movies.size();
        Movie movie = movies.get(actualPosition);
        holder.binding.setMovie(movie);
    }

    @Override
    public int getItemCount() {
            return movies.size()*100;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ListItemHoriBinding binding;
        public ViewHolder( ListItemHoriBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }

    }
}

