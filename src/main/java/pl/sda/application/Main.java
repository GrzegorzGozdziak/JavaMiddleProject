package pl.sda.application;/**
 * Created by RENT on 2017-03-14.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/CompanyForm.fxml"));
//        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/LoginView.fxml"));

        StackPane stackPane = loader.load();
        Scene scene = new Scene(stackPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("My First JavaFX App - LOGOWANIE");

        primaryStage.show();

    }
}
