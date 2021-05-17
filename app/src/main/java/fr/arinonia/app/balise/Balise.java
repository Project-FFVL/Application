package fr.arinonia.app.balise;

/**
 *  id : int<br>
 *  longitude : double<br>
 *  latitude : double<br>
 *  state : boolean<br>
 *  altitude : int<br>
 *  pressiure : int<br>
 *  wind_speed : int<br>
 *  wind_direction : int<br>
 *  wind_min : int<br>
 *  wind_max : int<br>
 *  temperature : int<br>
 *  hygrometry : int<br>
 */
public class Balise {

    private int id;
    private double longitude;
    private double latitude;
    private boolean state;


    public Balise(int id, double longitude, double latitude, boolean state) {
        this.id = id;
        this.longitude = longitude;
        this.latitude = latitude;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public boolean isState() {
        return state;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Balise{" +
                "id=" + id +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", state=" + state +
                '}';
    }
}
