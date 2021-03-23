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
    private int altitude;
    private int pressiure;
    private int wind_speed;
    private int wind_direction;
    private int wind_min;
    private int wind_max;
    private int temperature;
    private int hygrometry;

    /**
     * @param id : id of balise
     * @param longitude : longitude of balise
     * @param latitude : latitude of balise
     * @param state : h
     * @param altitude :h h
     * @param pressiure : h
     * @param wind_speed : h
     * @param wind_direction : h
     * @param wind_min : h
     * @param wind_max : h
     * @param temperature : h h
     * @param hygrometry : h
     */
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

    /**
     * @return id
     */
    public int getId() {
        return this.id;
    }

    /**
     * @return longitude
     */
    public double getLongitude() {
        return this.longitude;
    }

    /**
     * @return latitude
     */
    public double getLatitude() {
        return this.latitude;
    }

    /**
     * @return state
     */
    public boolean isState() {
        return this.state;
    }

    /**
     * @return altitude
     */
    public int getAltitude() {
        return this.altitude;
    }

    /**
     * @return pressiure
     */
    public int getPressiure() {
        return this.pressiure;
    }

    /**
     * @return wind_speed
     */
    public int getWind_speed() {
        return this.wind_speed;
    }

    /**
     * @return wind_direction
     */
    public int getWind_direction() {
        return this.wind_direction;
    }

    /**
     * @return wind_min
     */
    public int getWind_min() {
        return this.wind_min;
    }

    /**
     * @return wind_max
     */
    public int getWind_max() {
        return this.wind_max;
    }

    /**
     * @return temperature
     */
    public int getTemperature() {
        return this.temperature;
    }

    /**
     * @return hygrometry
     */
    public int getHygrometry() {
        return this.hygrometry;
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
                "id=" + this.id +
                ", longitude=" + this.longitude +
                ", latitude=" + this.latitude +
                ", state=" + this.state +
                ", altitude=" + this.altitude +
                ", pressiure=" + this.pressiure +
                ", wind_speed=" + this.wind_speed +
                ", wind_direction=" + this.wind_direction +
                ", wind_min=" + this.wind_min +
                ", wind_max=" + this.wind_max +
                ", temperature=" + this.temperature +
                ", hygrometry=" + this.hygrometry +
                '}';
    }
}
