package io.jacobking.localticket.gui.controller;

import io.jacobking.localticket.gui.ScreenHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.chrono.Chronology;
import java.util.ResourceBundle;

public class TicketController implements Initializable {

    @FXML
    private TextField subjectField;

    @FXML
    private DatePicker date;

    @FXML
    private ComboBox<String> priorityBox;

    @FXML
    private TextArea informationArea;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeDataPicker();
        initializeComboBox();
        initializeInformationArea();
    }


    private void initializeDataPicker() {
        date.setChronology(Chronology.from(LocalDateTime.now()));
    }

    private void initializeComboBox() {
        priorityBox.getItems().add("Low");
        priorityBox.getItems().add("Medium");
        priorityBox.getItems().add("High");
        priorityBox.getItems().add("Emergency");
    }

    private void initializeInformationArea() {
        informationArea.setWrapText(true);
    }

    @FXML
    private void onOpen() {
        ScreenHandler.getInstance().displayAsPopup("ticket-viewer");
    }

    @FXML
    private void onClear() {
        informationArea.setText(null);
        subjectField.setText(null);
    }
}
