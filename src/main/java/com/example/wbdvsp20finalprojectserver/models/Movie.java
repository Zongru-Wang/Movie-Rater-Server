package com.example.wbdvsp20finalprojectserver.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String imdbId;
    private String title;
    private String plot;
    private String poster;

    @ManyToOne
    @JsonIgnore
    private User user;

    public User getUser() {return user;}

    public void setUser(User user) {this.user = user;}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public Movie() {
    }

    public Movie(int id, String imdbId, String title, String plot, String poster) {
        this.id = id;
        this.imdbId = imdbId;
        this.title = title;
        this.plot = plot;
        this.poster = poster;
    }
}
