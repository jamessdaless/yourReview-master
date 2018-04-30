package uk.ac.tees.p4072709.yourreview;

import java.io.Serializable;

/**
 * Created by James on 3/22/2018.
 */

public class User implements Serializable {

    private int id;
    private String forename;
    private String surname;
    private String email;
    private String Pass;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // user details
    User(int id, String fn, String sn, String e) {
        this.id = id;
        this.forename = fn;
        this.surname = sn;
        this.email = e;
        //this.Pass = p;

    }

    User(int id, String fn, String sn, String e, String p) {
        this(id, fn, sn, e);
        this.Pass = p;
    }



    //getters and setters
    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String pass) {
        Pass = pass;
    }

}