package fr.arinonia.app.utils;

public class Constants {

    public static final String API_URL = "http://195.133.81.183/cours/response.json";

    public static final String URL_SERVER = "http://arinonia.ovh/reponse.json";
    public static final String RESSOURCE_BAlISE = "/balises";
    public static final String RESSOURCE_USER = "/user";
    public static final boolean DEBUG = Boolean.parseBoolean("true");

    //obtenir toutes les balises  - Methode get
    // key_api
    //URL_SERVER+RESSOURCE_BALISE

    //obtenir une balise  - Methode get
    // key_api
    //URL_SERVER+RESSOURCE_BALISE+"/idBalise"

    //Se logger   - Methode post
    //URL_SERVER+RESSOURCE_USER
    //data : { "login" : "....", "password" : "hash...." }
    //reponse : key_api
}

