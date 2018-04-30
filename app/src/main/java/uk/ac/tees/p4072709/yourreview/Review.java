package uk.ac.tees.p4072709.yourreview;

import java.io.Serializable;

public class Review{
    int id;
    String name;
    String review;
    String user;
    String location;

    public Review(String string, String cursorString, String review, String user, int anInt) {

    }

    public Review(String name, String review, String user, String location) {
        this.review = review;
        this.user = user;
        this.location = location;
    }


    public Review(int id, String name, String review, String user, String location) {
        this.id = id;
        this.name = name;
        this.review = review;
        this.user = user;
        this.location = location;
    }

    public Review() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
