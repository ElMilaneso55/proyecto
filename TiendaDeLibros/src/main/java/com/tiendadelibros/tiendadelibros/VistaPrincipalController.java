package com.tiendadelibros.tiendadelibros;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import java.io.IOException;
import javafx.scene.layout.FlowPane;


public class VistaPrincipalController {

    @FXML
    private FlowPane categoriaContainer;
    
    @FXML
    private TextField buscadorField;

    @FXML
    public void initialize() {
        System.out.println("Vista Principal inicializada.");
    }

    
    @FXML
    private void irInicio(ActionEvent event) {
        System.out.println("Recargando la vista principal...");
        try {
            Parent vistaPrincipal = FXMLLoader.load(getClass().getResource("/vistas/vistaPrincipal.fxml"));
            Scene currentScene = ((Node) event.getSource()).getScene();
            currentScene.setRoot(vistaPrincipal);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void irHistorial(ActionEvent event) {
        System.out.println("Navegando a Historial...");
         try {
            Parent historialView = FXMLLoader.load(getClass().getResource("/vistas/historial.fxml"));
            Scene currentScene = ((Node) event.getSource()).getScene();
            currentScene.setRoot(historialView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void irFavoritos(ActionEvent event) {
        System.out.println("Navegando a Favoritos...");
        try {
            Parent favoritoView = FXMLLoader.load(getClass().getResource("/vistas/favorito.fxml"));
            Scene currentScene = ((Node) event.getSource()).getScene();
            currentScene.setRoot(favoritoView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void irRegistrarse(ActionEvent event) {
        System.out.println("Navegando a Registrarse...");
        try {
            Parent registrarseView = FXMLLoader.load(getClass().getResource("/vistas/registrarse.fxml"));
            Scene currentScene = ((Node) event.getSource()).getScene();
            currentScene.setRoot(registrarseView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void irLogin(ActionEvent event) {
        try {
            Parent loginView = FXMLLoader.load(getClass().getResource("/vistas/login.fxml"));
            Scene currentScene = ((Node) event.getSource()).getScene();
            currentScene.setRoot(loginView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void irCategorias(ActionEvent event) {
        System.out.println("Navegando a Categorias...");
  
         try {
             Parent categoriasView = FXMLLoader.load(getClass().getResource("/vistas/categoria.fxml"));
             Scene currentScene = ((Node) event.getSource()).getScene();
             currentScene.setRoot(categoriasView);
         } catch (IOException e) {
             e.printStackTrace();
         }
    }

    @FXML
    private void accionBuscar(ActionEvent event) {
        String query = buscadorField.getText();
        System.out.println("Buscando: " + query);
    }

    @FXML
    private void accionCuenta(ActionEvent event) {
        System.out.println("Acción: Ingrese a su cuenta");
        try {
            Parent loginView = FXMLLoader.load(getClass().getResource("/vistas/login.fxml"));
            Scene currentScene = ((Node) event.getSource()).getScene();
            currentScene.setRoot(loginView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void accionDescuento(ActionEvent event) {
        System.out.println("Acción: Productos con descuento");
        try {
            Parent descuentoView = FXMLLoader.load(getClass().getResource("/vistas/descuento.fxml"));
            Scene currentScene = ((Node) event.getSource()).getScene();
            currentScene.setRoot(descuentoView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void accionMasVendidos(ActionEvent event) {
        System.out.println("Acción: Más vendidos");
        try {
            Parent masVendidoView = FXMLLoader.load(getClass().getResource("/vistas/masVendido.fxml"));
            Scene currentScene = ((Node) event.getSource()).getScene();
            currentScene.setRoot(masVendidoView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
     

}
