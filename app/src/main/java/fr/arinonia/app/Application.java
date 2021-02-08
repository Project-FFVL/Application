package fr.arinonia.app;

import fr.arinonia.app.activity.LoadingScreen;
import fr.arinonia.app.files.FileManager;

public class Application {

    private final LoadingScreen loadingScreen;
    private final FileManager fileManager;

    public Application(LoadingScreen loadingScreen) {
        this.loadingScreen = loadingScreen;
        this.fileManager = new FileManager();
    }

    public FileManager getFileManager() {
        return fileManager;
    }
}
