module com.example.tp1javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.Orchad to javafx.fxml;
    exports com.example.Orchad;
}