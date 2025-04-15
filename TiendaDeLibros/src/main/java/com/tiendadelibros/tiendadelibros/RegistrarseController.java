package com.tiendadelibros.tiendadelibros;

import com.tiendadelibros.tiendadelibros.clases.UsuarioDAO;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegistrarseController {

    @FXML
    private TextField nombreField;

    @FXML
    private TextField apellidoField;

    @FXML
    private TextField correoField;

    @FXML
    private ComboBox<String> sexoCombo;

    @FXML
    private PasswordField passwordField;

    @FXML
    public void initialize() {
        System.out.println("Vista de Registrarse inicializada.");
        sexoCombo.getItems().addAll("Masculino", "Femenino", "Otro");
    }

    @FXML
    private void crearCuenta(ActionEvent event) {
        String nombre = nombreField.getText().trim();
        String apellido = apellidoField.getText().trim();
        String correo = correoField.getText().trim();
        String sexo = sexoCombo.getValue();
        String password = passwordField.getText().trim();

        if (nombre.isEmpty() || apellido.isEmpty() || correo.isEmpty() || sexo == null || password.isEmpty()) {
            mostrarAlerta(Alert.AlertType.WARNING, "Datos incompletos", "Por favor, llene todos los campos.");
            return;
        }

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        if (usuarioDAO.verificarCorreoExiste(correo)) {
            mostrarAlerta(Alert.AlertType.ERROR, "Correo duplicado", "Este correo ya está registrado. Use otro.");
            return;
        }

        boolean creado = usuarioDAO.crearUsuario(nombre, apellido, correo, sexo, password);
        if (creado) {
            mostrarAlerta(Alert.AlertType.INFORMATION, "Cuenta creada", "¡Su cuenta ha sido creada exitosamente!");
            volverAlInicio(event); 
        } else {
            mostrarAlerta(Alert.AlertType.ERROR, "Error al crear cuenta", "Hubo un problema, inténtelo de nuevo.");
        }
    }

    @FXML
    private void volverAlInicio(ActionEvent event) {
        System.out.println("Volviendo a la página de inicio...");
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

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}