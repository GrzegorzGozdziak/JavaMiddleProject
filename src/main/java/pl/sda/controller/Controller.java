package pl.sda.controller;

import javafx.scene.control.Alert;

public class Controller {

    protected void showAlertError(String message) {
        showAlert(Alert.AlertType.ERROR, message); //Wrong Posta Code
    }

    protected void showAlertConfirmation(String message) {
        showAlert(Alert.AlertType.CONFIRMATION, message); //Wrong Posta Code
    }

    private void showAlert(Alert.AlertType alertType, String message) {
        new Alert(alertType, message).show(); //Wrong Posta Code
    }
}
