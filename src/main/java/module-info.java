module org.iap.oop.demojdbc {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.iap.oop.demojdbc to javafx.fxml;
    exports org.iap.oop.demojdbc;
}