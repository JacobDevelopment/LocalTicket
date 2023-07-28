module io.jacobking.localticket {
    requires javafx.controls;
    requires javafx.fxml;
            
        requires org.controlsfx.controls;
                            
    opens io.jacobking.localticket to javafx.fxml;
    exports io.jacobking.localticket;
}