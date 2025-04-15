package com.tiendadelibros.tiendadelibros;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class HistorialController {

    @FXML
    public void initialize() {
        System.out.println("Historial de Compras inicializado.");
    }
    
    @FXML
    private void volverAlInicio(ActionEvent event) {
        try {
            Parent inicioView = FXMLLoader.load(getClass().getResource("/vistas/vistaPrincipal.fxml"));
            Scene scene = ((Node) event.getSource()).getScene();
            scene.setRoot(inicioView);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
