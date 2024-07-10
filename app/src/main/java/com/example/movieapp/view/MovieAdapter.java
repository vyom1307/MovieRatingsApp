package com.example.movieapp.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieapp.R;
import com.example.movieapp.databinding.ListItemBinding;
import com.example.movieapp.model.Movie;
import com.example.movieapp.model.Show;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Show> tvShows;

    public MovieAdapter(Context context, ArrayList<Show> movies) {
        this.context = context;
        this.tvShows = movies;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         ListItemBinding listItemBinding= DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.list_item,parent,false);
         return new ViewHolder(listItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

       Show tvShow = tvShows.get(position);
        holder.binding.setShow(tvShow);
    }

    @Override
    public int getItemCount() {
        return tvShows.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ListItemBinding binding;
        public ViewHolder( ListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }

    }
}
