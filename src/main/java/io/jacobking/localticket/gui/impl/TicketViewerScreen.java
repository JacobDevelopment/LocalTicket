package io.jacobking.localticket.gui.impl;

import io.jacobking.localticket.gui.Screen;
import javafx.stage.Stage;

public class TicketViewerScreen extends Screen {


    public TicketViewerScreen() {
        super(400, 400, "ticket-viewer");
    }

    @Override
    protected void initialize(Stage stage) {
        configure(stage);
    }
}
