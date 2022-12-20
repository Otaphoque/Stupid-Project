module com.example.demo1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens truc to javafx.fxml;
    exports truc;
}