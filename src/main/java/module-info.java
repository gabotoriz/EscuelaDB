module utc.mx.escueladb {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;

    opens utc.mx.escueladb to javafx.fxml;
    exports utc.mx.escueladb;
}