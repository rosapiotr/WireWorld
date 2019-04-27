package main;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class WireWorld extends Application {

    @Override
    public void start(Stage primaryStage) {

        Pane pane = null;
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/WindowScreen.fxml"));

        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scene scene = new Scene(pane);

        primaryStage.setScene(scene);
        primaryStage.setTitle("WireWorld");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}