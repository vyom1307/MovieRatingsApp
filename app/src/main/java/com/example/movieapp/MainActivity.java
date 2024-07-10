package com.example.movieapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager2.widget.ViewPager2;

import com.example.movieapp.databinding.ActivityMainBinding;
import com.example.movieapp.databinding.FragmentTvlistBinding;
import com.example.movieapp.model.Movie;
import com.example.movieapp.model.Show;
import com.example.movieapp.view.HoriMovieAdapter;
import com.example.movieapp.view.MovieAdapter;
import com.example.movieapp.view.viewPagerAdapter;
import com.example.movieapp.viewmodel.MainActViewModel;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Movie> movies;
    private ArrayList<Show> tvShow;

    private HoriMovieAdapter horiMovieAdapter;

    private RecyclerView recyclerViewTop;
    private SwipeRefreshLayout swipeRefreshLayout;

    private ActivityMainBinding activityMainBinding;
    private MainActViewModel mainActViewModel;
    private ViewPager2 viewPager2;
    private TabLayout tabLayout;
    private viewPagerAdapter viewpagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        activityMainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        mainActViewModel=new ViewModelProvider(this).get(MainActViewModel.class);
        getPopularMovies();
        getPopularTv();
        swipeRefreshLayout=activityMainBinding.swipeLayout;
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getPopularMovies();
                getPopularTv();

            }
        });
        }


    private void getPopularMovies() {
        mainActViewModel.getAllMovies().observe(this,new Observer<List<Movie>>() {


            @Override
            public void onChanged(List<Movie> movieList) {
                   movies=(ArrayList<Movie>) movieList;
                   displayMovies();
            }


        });
    }
    private void getPopularTv() {
        mainActViewModel.getAllShows().observe(this,new Observer<List<Show>>() {


            @Override
            public void onChanged(List<Show> movieList) {
                tvShow=(ArrayList<Show>) movieList;
                displayTv();
            }


        });
    }

    private void displayMovies() {

        recyclerViewTop = activityMainBinding.recyclerViewTop;

        horiMovieAdapter = new HoriMovieAdapter(this, movies);


        recyclerViewTop.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewTop.setItemAnimator(new DefaultItemAnimator());
        recyclerViewTop.setHasFixedSize(true);

        int startPosition = movies.size() * 50;
        recyclerViewTop.scrollToPosition(startPosition - (startPosition % movies.size()));
        recyclerViewTop.setAdapter(horiMovieAdapter);
        horiMovieAdapter.notifyDataSetChanged();
    }
    private void displayTv() {
        viewpagerAdapter=new viewPagerAdapter(getSupportFragmentManager(),getLifecycle(),movies,tvShow);


        viewPager2=activityMainBinding.viewPager;
        tabLayout=activityMainBinding.tabLayout;
      //  viewPager2.setOrientation(ViewPager2.ORIENTATION_VERTICAL);
        viewPager2.setAdapter(viewpagerAdapter);
        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> tab.setText(viewpagerAdapter.tabTitles[position])).attach();




    }
}