package com.tiendadelibros.tiendadelibros;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;

public class CarroController {

    @FXML
    public void initialize() {
        System.out.println("Vista de Carro inicializada.");
    }

    @FXML
    private void volverAlInicio(ActionEvent event) {
        System.out.println("Volviendo a la vista principal desde Carro.");
        try {
            Parent principal = FXMLLoader.load(getClass().getResource("/vistas/vistaPrincipal.fxml"));
            Scene scene = ((Node) event.getSource()).getScene();
            scene.setRoot(principal);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void eliminarProducto(ActionEvent event) {
        System.out.println("Producto eliminado del Carro.");
        
    }
    
    @FXML
    private void procederAlPago(ActionEvent event) {
        System.out.println("Procediendo al pago.");
        try {
            Parent pago = FXMLLoader.load(getClass().getResource("/vistas/pago.fxml"));
            Scene scene = ((Node) event.getSource()).getScene();
            scene.setRoot(pago);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}