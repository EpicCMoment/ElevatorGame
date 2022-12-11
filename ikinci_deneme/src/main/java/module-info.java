module com.example.ikinci_deneme {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ikinci_deneme to javafx.fxml;
    exports com.example.ikinci_deneme;
}