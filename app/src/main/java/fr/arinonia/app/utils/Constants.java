package fr.arinonia.app.utils;


public class Constants {

    public static final String API_URL = "http://195.133.81.183/cours/response.json";

    public static String getBaliseUrlById(final int id) {
        return "http://195.133.81.183/cours/balise_" + id + ".json";
    }

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

