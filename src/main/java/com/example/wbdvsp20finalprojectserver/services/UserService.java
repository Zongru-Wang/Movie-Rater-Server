package com.example.wbdvsp20finalprojectserver.services;

import com.example.wbdvsp20finalprojectserver.models.Movie;
import com.example.wbdvsp20finalprojectserver.models.User;
import com.example.wbdvsp20finalprojectserver.repositories.MovieRepository;
import com.example.wbdvsp20finalprojectserver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    MovieRepository movieRepository;

    public List<User> findAllUsers() {
        return userRepository.findAllUsers();
    }

    public User findUserById(int uid) {
        return userRepository.findUserById(uid);
    }

    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    public User findUserByCredentials(String email, String password) {
        return userRepository.findUserByCredentials(email, password);
    }

    public int deleteUser(int uid) {

        List<User> users = userRepository.findAllUsers();
        for (User user : users) {
            ArrayList<Integer> followingIds = user.getFollowingIds();
            if (followingIds.contains(uid)) {
                int idx = followingIds.indexOf(uid);
                followingIds.remove(idx);
                user.setFollowingIds(followingIds);
                userRepository.save(user);
            }

            ArrayList<Integer> followerIds = user.getFollowerIds();
            if (followerIds.contains(uid)) {
                int idx = followerIds.indexOf(uid);
                followerIds.remove(idx);
                user.setFollowerIds(followerIds);
                userRepository.save(user);
            }
        }

        userRepository.deleteById(uid);


        return 1;
    }

    public int updateUser(int uid, User newUser) {
        User user =  userRepository.findUserById(uid);
        user.setFirstName(newUser.getFirstName());
        user.setLastName(newUser.getLastName());
        user.setPhoneNum(newUser.getPhoneNum());
        user.setPassword(newUser.getPassword());
        userRepository.save(user);
        return 1;
    }

    public User createUser(User newUser) {
        return userRepository.save(newUser);
    }


    public int likeMovie(int userId, String movieId) {
        User user =  userRepository.findUserById(userId);
        ArrayList<String> likedMovieIds = user.getLikedMovieIds();
        likedMovieIds.add(movieId);
        user.setLikedMovieIds(likedMovieIds);

        userRepository.save(user);
        return 1;
    }

    public int unLikeMovie(int userId, String movieId) {
        User user =  userRepository.findUserById(userId);
        ArrayList<String> likedMovieIds = user.getLikedMovieIds();
        likedMovieIds.remove(movieId);
        user.setLikedMovieIds(likedMovieIds);
        userRepository.save(user);
        return 1;
    }

    public List<String> getEmails() {
        List<String> emails = new ArrayList<String>();
        List<User> users = userRepository.findAllUsers();
        for(User user : users) {
            emails.add(user.getEmail());
        }
        return emails;
    }

    public int follow(int userId, int followId) {
        User user =  userRepository.findUserById(userId);
        ArrayList<Integer> followingIds = user.getFollowingIds();
        followingIds.add(followId);
        user.setFollowingIds(followingIds);
        userRepository.save(user);

        User follow =  userRepository.findUserById(followId);
        ArrayList<Integer> followerIds = follow.getFollowerIds();
        followerIds.add(userId);
        follow.setFollowerIds(followerIds);
        userRepository.save(follow);

        return 1;
    }

    public int unFollow(int userId, int followId) {
        User user =  userRepository.findUserById(userId);
        ArrayList<Integer> followingIds = user.getFollowingIds();
        int idx = followingIds.indexOf(followId);

        followingIds.remove(idx);
        user.setFollowingIds(followingIds);
        userRepository.save(user);

        User follow =  userRepository.findUserById(followId);
        ArrayList<Integer> followerIds = follow.getFollowerIds();
        int userIdx = followerIds.indexOf(userId);

        followerIds.remove(userIdx);
        follow.setFollowerIds(followerIds);
        userRepository.save(follow);
        return 1;
    }
}
