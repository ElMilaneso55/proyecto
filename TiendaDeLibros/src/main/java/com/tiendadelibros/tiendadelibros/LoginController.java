package com.tiendadelibros.tiendadelibros;

import com.tiendadelibros.tiendadelibros.clases.UsuarioDAO; // Usamos UsuarioDAO para consultas
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private TextField correoField; 

    @FXML
    private PasswordField passwordField; 

    @FXML
    private void initialize() {
        System.out.println("Login inicio.");
    }

  
    @FXML
    private void iniciarSesion(ActionEvent event) {
        String correo = correoField.getText().trim(); 
        String password = passwordField.getText().trim(); 

        if (correo.isEmpty() || password.isEmpty()) {
            mostrarAlerta(AlertType.WARNING, "Datos incompletos", "Por favor, llene todos los campos.");
            return; 
        }

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        boolean usuarioExiste = usuarioDAO.verificarCredenciales(correo, password);

        if (usuarioExiste) {
            mostrarAlerta(AlertType.INFORMATION, "Inicio exitoso", "¡Bienvenido!");
            navegarAInicio(event); 
        } else {
            mostrarAlerta(AlertType.ERROR, "Cuenta no encontrada", "La cuenta no existe. Por favor, cree una cuenta.");
        }
    }

    @FXML
    private void irRegistrarse(ActionEvent event) {
        System.out.println("Navegando a Registrarse...");
        cambiarVista("/vistas/registrarse.fxml", event);
    }


    @FXML
    private void volverAlInicio(ActionEvent event) {
        System.out.println("Volviendo a la pagina de inicio...");
        cambiarVista("/vistas/vistaPrincipal.fxml", event);
    }


    private void cambiarVista(String ruta, ActionEvent event) {
        try {
            Parent nuevaVista = FXMLLoader.load(getClass().getResource(ruta));
            Scene escenaActual = ((Node) event.getSource()).getScene();
            escenaActual.setRoot(nuevaVista);
        } catch (IOException e) {
            System.err.println("No se pudo cargar la vista: " + ruta);
            e.printStackTrace();
        }
    }

 
    private void mostrarAlerta(AlertType tipo, String titulo, String mensaje) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

 
    private void navegarAInicio(ActionEvent event) {
        cambiarVista("/vistas/vistaPrincipal.fxml", event);
    }
}