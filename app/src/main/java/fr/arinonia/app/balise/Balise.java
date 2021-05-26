package fr.arinonia.app.balise;

import java.util.ArrayList;
import java.util.List;

public class Balise {
    private String etat;
    private String pression_atmospherique;
    private String temperature;
    private String hygrometrie;
    private String vitesse_vent;
    private String direction_vent;
    private String vent_minimum;
    private String vent_maximum;
    private List<WindSpeed> wind_history = new ArrayList<>();

    public Balise(String etat, String pression_atmospherique, String temperature, String hygrometrie, String vitesse_vent, String direction_vent, String vent_minimum, String vent_maximum, List<WindSpeed> wind_history) {
        this.etat = etat;
        this.pression_atmospherique = pression_atmospherique;
        this.temperature = temperature;
        this.hygrometrie = hygrometrie;
        this.vitesse_vent = vitesse_vent;
        this.direction_vent = direction_vent;
        this.vent_minimum = vent_minimum;
        this.vent_maximum = vent_maximum;
        this.wind_history = wind_history;
    }

    public String getEtat() {
        return etat;
    }

    public String getPression_atmospherique() {
        return pression_atmospherique;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getHygrometrie() {
        return hygrometrie;
    }

    public String getVitesse_vent() {
        return vitesse_vent;
    }

    public String getDirection_vent() {
        return direction_vent;
    }

    public String getVent_minimum() {
        return vent_minimum;
    }

    public String getVent_maximum() {
        return vent_maximum;
    }

    public List<WindSpeed> getWind_history() {
        return wind_history;
    }
}
