package com.Elysian.SpringBootExercise.controller.payload;

import java.util.List;

public class NewsResponse {
    private String status;
    private Integer page;
    private List<News> news;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }
}
