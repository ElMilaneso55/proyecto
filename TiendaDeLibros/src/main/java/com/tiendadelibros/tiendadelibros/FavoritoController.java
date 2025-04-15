package com.tiendadelibros.tiendadelibros;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;

public class FavoritoController {

    @FXML
    public void initialize() {
        System.out.println("Vista de Favorito inicializada.");
    }

    @FXML
    private void volverAlInicio(ActionEvent event) {
        System.out.println("Volviendo a la vista principal desde Favorito.");
        try {
            Parent principal = FXMLLoader.load(getClass().getResource("/vistas/vistaPrincipal.fxml"));
            Scene scene = ((Node) event.getSource()).getScene();
            scene.setRoot(principal);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void eliminarFavorito(ActionEvent event) {
        System.out.println("Producto eliminado de Favorito.");
       
    }
    
    @FXML
    private void irCarrito(ActionEvent event) {
        System.out.println("Navegando a Carro de Compras...");
        try {
            Parent carroView = FXMLLoader.load(getClass().getResource("/vistas/carro.fxml"));
            Scene scene = ((Node) event.getSource()).getScene();
            scene.setRoot(carroView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}