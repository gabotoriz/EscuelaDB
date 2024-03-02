module utc.mx.escueladb {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires org.kordamp.ikonli.core;
    requires MaterialFX;
    requires mysql.connector.j;
    requires java.sql;
    opens utc.mx.escueladb to javafx.fxml;
    exports utc.mx.escueladb;
    exports utc.mx.escueladb.Controllers;
    opens utc.mx.escueladb.Controllers to javafx.fxml;
    exports utc.mx.escueladb.Models;
    opens utc.mx.escueladb.Models to javafx.fxml;
    exports utc.mx.escueladb.Controllers.Login;
    opens utc.mx.escueladb.Controllers.Login to javafx.fxml;
}