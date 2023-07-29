package io.jacobking.localticket.gui;

import io.jacobking.localticket.LocalTicket;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class Screen {

    protected final String title = "LocalTicket";
    private final Screen parent;
    private final int width;
    private final int height;
    private final String name;
    public Screen(int width, int height, String name) {
        this.parent = null;
        this.width = width;
        this.height = height;
        this.name = name;
    }

    protected abstract void initialize(final Stage stage);

    protected final void configure(final Stage stage) {
        try {
            final FXMLLoader loader = getLoader();
            final Scene scene = new Scene(loader.load(), width, height);
            stage.setResizable(false);
            stage.setTitle(title);
            stage.setScene(scene);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace(); // TODO: Eventually add error handling system.
        }
    }

    private FXMLLoader getLoader() {
        final String path = getPath();
        return new FXMLLoader(LocalTicket.class.getResource(path));
    }

    private String getPath() {
        return name.concat(".fxml");
    }

    public Screen getParent() {
        return parent;
    }

    public String getName() {
        return name;
    }
}
