module io.jacobking.localticket {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.zaxxer.hikari;
    requires org.xerial.sqlitejdbc;

    opens io.jacobking.localticket to javafx.fxml;
    opens io.jacobking.localticket.gui.controller to javafx.fxml;
    exports io.jacobking.localticket;
    exports io.jacobking.localticket.gui.controller to javafx.fxml;

    opens io.jacobking.localticket.core.object to javafx.base;
    exports io.jacobking.localticket.core.object to javafx.base;

    opens io.jacobking.localticket.database;
    exports io.jacobking.localticket.database to com.zaxxer.hikari;
}

