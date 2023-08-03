package io.jacobking.localticket.gui.controller;

import io.jacobking.localticket.core.object.Ticket;
import io.jacobking.localticket.gui.ScreenHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class TicketViewController implements Initializable {


    @FXML
    private TableView<Ticket> tableView;

    @FXML
    private TableColumn<Ticket, String> subjectColumn;

    @FXML
    private TableColumn<Ticket, String> priorityColumn;

    @FXML
    private TableColumn<Ticket, String> dateColumn;

    @FXML
    private TableColumn<Ticket, String> informationColumn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        configureTable();
    }

    private void configureTable() {
        setCellFactoryForColumns();
        tableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }

    private void setCellFactoryForColumns() {
        subjectColumn.setCellValueFactory(new PropertyValueFactory<>("Subject"));
        priorityColumn.setCellValueFactory(new PropertyValueFactory<>("Priority"));
        informationColumn.setCellValueFactory(new PropertyValueFactory<>("Information"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("Date"));
    }

    @FXML
    private void onOpenTicket() {

    }

    @FXML
    private void onDeleteTicket() {

    }

    @FXML
    private void onImportTicket() {

    }

    @FXML
    private void onExportTicket() {

    }

    @FXML
    private void onHelp() {

    }

    @FXML
    private void onCancel() {
        ScreenHandler.getInstance().close("ticket-viewer");
    }


}
