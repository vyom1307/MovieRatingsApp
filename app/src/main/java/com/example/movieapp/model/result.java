package com.example.movieapp.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class result {
    @SerializedName("page")
    int page;

    @SerializedName("results")
    List<Movie> results;

    @SerializedName("total_pages")
    int totalPages;

    @SerializedName("total_results")
    int totalResults;


    public void setPage(int page) {
        this.page = page;
    }
    public int getPage() {
        return page;
    }

    public void setResults(List<Movie> results) {
        this.results = results;
    }
    public List<Movie> getResults() {
        return results;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }
    public int getTotalResults() {
        return totalResults;
    }
}
