module com.example.tp1javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tp1javafx to javafx.fxml;
    exports com.example.tp1javafx;
}