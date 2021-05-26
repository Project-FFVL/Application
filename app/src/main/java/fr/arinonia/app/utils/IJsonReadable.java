package fr.arinonia.app.utils;

public interface IJsonReadable {
    String getUrlContents(String theUrl);
    void jsonDeserialize();
}
