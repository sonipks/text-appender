module com.pks.textappender {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;

    opens com.pks.textappender to javafx.fxml;
    exports com.pks.textappender;
    exports com.pks.textappender.controller;
    opens com.pks.textappender.controller to javafx.fxml;
    exports com.pks.textappender.helper;
    opens com.pks.textappender.helper to javafx.fxml;
}