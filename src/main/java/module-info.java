module com.example.typokopia {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires javafx.graphics;

    opens com.example.typokopia to javafx.fxml;
    exports com.example.typokopia;
}