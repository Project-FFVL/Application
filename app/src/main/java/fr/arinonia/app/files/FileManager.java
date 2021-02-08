package fr.arinonia.app.files;


import android.os.Environment;

import java.io.File;
import java.io.IOException;


public class FileManager {

    private final File root = new File(Environment.getDataDirectory(), "ffvl");
    private final File dataFolder = new File(root, "data");
    private final File baliseFav = new File(dataFolder, "fav.json");
    public FileManager() {

    }

    public void initFile() {
        if (!this.root.exists())
            this.root.mkdir();
        /*if (!this.dataFolder.exists())
            this.dataFolder.mkdir();
        if (!this.baliseFav.exists()) {
            try {
                this.baliseFav.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("json exist !");
        }*/
    }

}
