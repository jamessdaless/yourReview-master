package uk.ac.tees.p4072709.yourreview;

public class Artist {

    private int id;
    private String artistName;

    //default
    public Artist(String arctic_monkeys) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }
}
