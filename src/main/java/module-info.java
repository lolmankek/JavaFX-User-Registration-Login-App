module org.example.projectz {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;


    opens org.example.projectz to javafx.fxml;
    exports org.example.projectz;
}