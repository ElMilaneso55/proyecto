module com.tiendadelibros.tiendadelibros {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;

    opens com.tiendadelibros.tiendadelibros to javafx.fxml;
    exports com.tiendadelibros.tiendadelibros;
}
