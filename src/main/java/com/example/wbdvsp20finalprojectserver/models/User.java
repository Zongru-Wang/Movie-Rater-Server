package com.example.wbdvsp20finalprojectserver.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phoneNum = "4000000000";
    private String type = "viewer";
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Movie> likedMovies;

    private ArrayList<String> likedMovieIds = new ArrayList<String>();
    private ArrayList<Integer> followingIds = new ArrayList<Integer>();
    private ArrayList<Integer> followerIds = new ArrayList<Integer>();

    public ArrayList<Integer> getFollowingIds() {
        return followingIds;
    }

    public void setFollowingIds(ArrayList<Integer> followingIds) {
        this.followingIds = followingIds;
    }


    public ArrayList<Integer> getFollowerIds() {
        return followerIds;
    }

    public void setFollowerIds(ArrayList<Integer> followerIds) {
        this.followerIds = followerIds;
    }


    @OneToMany
    private List<User> followings;

    @OneToMany
    private List<User> followers;

    public List<User> getFollowings() {
        return followings;
    }

    public void setFollowings(List<User> followings) {
        this.followings = followings;
    }

    public List<User> getFollowers() {
        return followers;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }


    public ArrayList<String> getLikedMovieIds() {
        return likedMovieIds;
    }

    public void setLikedMovieIds(ArrayList<String> likedMovieIds) {
        this.likedMovieIds = likedMovieIds;
    }



    public List<Movie> getLikedMovies() {
        return likedMovies;
    }

    public void setLikedMovies(List<Movie> likedMovies) {
        this.likedMovies = likedMovies;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public String getPhoneNum() {return phoneNum;}

    public void setPhoneNum(String phoneNum) {this.phoneNum = phoneNum;}

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }




}
