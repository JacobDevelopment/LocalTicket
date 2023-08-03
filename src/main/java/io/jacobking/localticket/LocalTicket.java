package io.jacobking.localticket;

import io.jacobking.localticket.core.config.Config;
import io.jacobking.localticket.core.config.ConfigReader;
import io.jacobking.localticket.core.utility.FileCommons;
import io.jacobking.localticket.core.utility.FileIO;
import io.jacobking.localticket.gui.ScreenHandler;
import io.jacobking.localticket.gui.impl.DashboardScreen;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class LocalTicket extends Application {
    @Override
    public void start(Stage stage) {
        ScreenHandler.getInstance().display("dashboard");
    }

    public static void main(String[] args) throws IOException {
        final ConfigReader configReader = new ConfigReader();
        if (!configReader.initialized()) {
            return;
        }
        createReadMe();
        Config.getInstance().initialize();

        launch();
    }

    private static void createReadMe() throws IOException {
        if (FileIO.doesFileExist(FileCommons.README_DIRECTORY)) {
            return;
        }

        if (FileIO.createFile(FileCommons.README_DIRECTORY)) {
            final File file = new File(FileCommons.README_DIRECTORY);
            FileIO.writeToFile(file, FileCommons.README_COMMENTS);
        }
    }
}