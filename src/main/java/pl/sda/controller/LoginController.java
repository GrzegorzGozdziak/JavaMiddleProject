package pl.sda.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import pl.sda.model.User;
import pl.sda.service.UserService;

public class LoginController {

    @FXML
    private Button submit;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField loginTextField;

    @FXML
    void submitOnAction(ActionEvent event) {
//        System.out.println(loginTextField.getText());
//
//        System.out.println(passwordField.getText());
        Alert alert1 = new Alert(Alert.AlertType.INFORMATION, "Zalogowany");
        Alert alert2 = new Alert(Alert.AlertType.WARNING, "Błędne dane logowania");

        UserService userService = new UserService();
        User user = new User(loginTextField.getText(),passwordField.getText());
        if(userService.authenticate(user)) {
            alert1.show();
        } else {
            alert2.show();
        }

    }



}
