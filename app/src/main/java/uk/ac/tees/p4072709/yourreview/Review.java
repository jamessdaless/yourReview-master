package uk.ac.tees.p4072709.yourreview;


public class Review {
    private int id;
    private String name;
    private String review;
    private String user;
    private String location;

    public Review(String s, String s1, String s2, String middlesborugh) {

    }

    public Review(int idd, String reviewName, String revieww, String userr, String locationn) {
        this.id = idd;
        this.name = reviewName;
        this.review = revieww;
        this.user = userr;
        this.location = locationn;
    }



    public int getId() {
        return id;
    }

    public void setId(int idd) {
        this.id = idd;
    }

    public String getName() {
        return name;
    }

    public void setName(String namee) {
        this.name = namee;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String revieww) {
        this.review = revieww;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String userr) {
        this.user = userr;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String locationn) {
        this.location = locationn;
    }
}
