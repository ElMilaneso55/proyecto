package com.tiendadelibros.tiendadelibros;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            
            System.out.println("Cargando vista principal...");
            Parent root = FXMLLoader.load(getClass().getResource("/vistas/login.fxml"));
            Scene scene = new Scene(root);

          
            primaryStage.setTitle("Tienda de Libros Online");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
