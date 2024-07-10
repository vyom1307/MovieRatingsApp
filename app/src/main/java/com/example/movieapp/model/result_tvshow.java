package com.example.movieapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class result_tvshow {
    @SerializedName("page")
    int page;

    @SerializedName("results")
    List<Show> results;

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

    public void setResults(List<Show> results) {
        this.results = results;
    }
    public List<Show> getResults() {
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
