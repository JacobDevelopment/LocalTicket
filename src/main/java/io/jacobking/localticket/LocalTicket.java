package io.jacobking.localticket;

import io.jacobking.localticket.core.config.Config;
import io.jacobking.localticket.core.config.ConfigReader;
import io.jacobking.localticket.core.misc.Version;
import io.jacobking.localticket.core.utility.FileCommons;
import io.jacobking.localticket.core.utility.FileIO;
import io.jacobking.localticket.database.Database;
import io.jacobking.localticket.gui.ScreenHandler;
import io.jacobking.localticket.gui.impl.DashboardScreen;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

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
        createChangelog();
        Config.getInstance().initialize();
        Database.getInstance();

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

    private static void createChangelog() throws IOException {
        if (FileIO.doesFileExist(FileCommons.CHANGELOG_DIRECTORY)) {
            appendChanges();
            return;
        }

        if (FileIO.createFile(FileCommons.CHANGELOG_DIRECTORY)) {
            final File file = new File(FileCommons.CHANGELOG_DIRECTORY);
            FileIO.writeToFile(file, Version.CURRENT.getChangelog());
        }

    }

    private static void appendChanges() throws IOException {
        final Version current = Version.CURRENT;
        if (current.isNewestVersion()) {
            final Path path = Paths.get(FileCommons.CHANGELOG_DIRECTORY);
            final List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            final File file = new File(FileCommons.CHANGELOG_DIRECTORY);
            if (lines.isEmpty()) {
                FileIO.writeToFile(file, Version.CURRENT.getChangelog());
                return;
            }

            final String version = Version.CURRENT.toString();
            if (lines.contains(version))
                return;

            try (final FileWriter fileWriter = new FileWriter(FileCommons.CHANGELOG_DIRECTORY, true)) {
                final String changelog = Version.CURRENT.getChangelog();
                fileWriter.append(changelog);
            }

        }
    }
}