package fr.arinonia.app.balise;

public class Balise {

    private int id;
    private double longitude;
    private double latitude;
    private boolean state;
    private int altitude;
    private int pressiure;
    private int wind_speed;
    private int wind_direction;
    private int wind_min;
    private int wind_max;
    private int temperature;
    private int hygrometry;

    public Balise(int id, double longitude, double latitude, boolean state, int altitude, int pressiure, int wind_speed, int wind_direction, int wind_min, int wind_max, int temperature, int hygrometry) {
        this.id = id;
        this.longitude = longitude;
        this.latitude = latitude;
        this.state = state;
        this.altitude = altitude;
        this.pressiure = pressiure;
        this.wind_speed = wind_speed;
        this.wind_direction = wind_direction;
        this.wind_min = wind_min;
        this.wind_max = wind_max;
        this.temperature = temperature;
        this.hygrometry = hygrometry;
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

    public int getAltitude() {
        return altitude;
    }

    public int getPressiure() {
        return pressiure;
    }

    public int getWind_speed() {
        return wind_speed;
    }

    public int getWind_direction() {
        return wind_direction;
    }

    public int getWind_min() {
        return wind_min;
    }

    public int getWind_max() {
        return wind_max;
    }

    public int getTemperature() {
        return temperature;
    }

    public int getHygrometry() {
        return hygrometry;
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

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    public void setPressiure(int pressiure) {
        this.pressiure = pressiure;
    }

    public void setWind_speed(int wind_speed) {
        this.wind_speed = wind_speed;
    }

    public void setWind_direction(int wind_direction) {
        this.wind_direction = wind_direction;
    }

    public void setWind_min(int wind_min) {
        this.wind_min = wind_min;
    }

    public void setWind_max(int wind_max) {
        this.wind_max = wind_max;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public void setHygrometry(int hygrometry) {
        this.hygrometry = hygrometry;
    }

    @Override
    public String toString() {
        return "Balise{" +
                "id=" + id +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", state=" + state +
                ", altitude=" + altitude +
                ", pressiure=" + pressiure +
                ", wind_speed=" + wind_speed +
                ", wind_direction=" + wind_direction +
                ", wind_min=" + wind_min +
                ", wind_max=" + wind_max +
                ", temperature=" + temperature +
                ", hygrometry=" + hygrometry +
                '}';
    }
}
