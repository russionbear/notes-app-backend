module com.russionbear.notesappwindow {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
                            
    opens com.russionbear.notesappwindow to javafx.fxml;
    exports com.russionbear.notesappwindow;
}