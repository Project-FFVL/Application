package fr.arinonia.app.data;

public class Balise {

    private final long id;
    private final double latitude;
    private final double longitude;
    private final String name;


    public Balise(long id, double latitude, double longitude, String name) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getName() {
        return name;
    }
}
