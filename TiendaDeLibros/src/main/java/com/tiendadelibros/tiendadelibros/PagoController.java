package com.tiendadelibros.tiendadelibros;

import java.io.IOException;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class PagoController {
    @FXML
    public void initialize() {
        System.out.println("Vista de Pago inicializada.");
    }

    @FXML
    private void volverAlInicio(ActionEvent event) {
        try {
            Parent principal = FXMLLoader.load(getClass().getResource("/vistas/vistaPrincipal.fxml"));
            Scene scene = ((Node) event.getSource()).getScene();
            scene.setRoot(principal);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void pagarConMercadoPago(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Pago con Mercado Pago");
        alert.setHeaderText("Pago Procesado");
        alert.setContentText("Su pago con Mercado Pago se realizo exitosamente.");
        alert.showAndWait();
        irInicio(event);
    }

    @FXML
    private void pagarConVisa(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Pago con Visa");
        alert.setHeaderText("Pago Procesado");
        alert.setContentText("Su pago con Visa se realizo exitosamente.");
        alert.showAndWait();
        irInicio(event);
    }

    @FXML
    private void pagarConMasterCard(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Pago con MasterCard");
        alert.setHeaderText("Pago Procesado");
        alert.setContentText("Su pago con MasterCard se realizo exitosamente.");
        alert.showAndWait();
        irInicio(event);
    }

    @FXML
    private void pagarConEfectivo(ActionEvent event) {

        double totalPrice = 100.00;

        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Pago en Efectivo");
        dialog.setHeaderText("Ingrese la cantidad en efectivo que entrega:");
        dialog.setContentText("Monto entregado:");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            try {
                double montoEntregado = Double.parseDouble(result.get());
                if (montoEntregado < totalPrice) {
                    Alert insufficientAlert = new Alert(Alert.AlertType.ERROR);
                    insufficientAlert.setTitle("Pago Fallido");
                    insufficientAlert.setHeaderText("Saldo Insuficiente");
                    insufficientAlert.setContentText("El monto entregado ($" + montoEntregado +
                            ") es menor al total ($" + totalPrice + ").");
                    insufficientAlert.showAndWait();
                } else {
                    double cambio = montoEntregado - totalPrice;
                    Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                    successAlert.setTitle("Pago Exitoso");
                    successAlert.setHeaderText("Compra Exitosa");
                    successAlert.setContentText("Su pago se realizó correctamente.\nSu cambio es: $" +
                            String.format("%.2f", cambio));
                    successAlert.showAndWait();
                    irInicio(event);
                }
            } catch (NumberFormatException e) {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setTitle("Error de Entrada");
                errorAlert.setHeaderText("Valor no valido");
                errorAlert.setContentText("Por favor, ingrese un numero valido.");
                errorAlert.showAndWait();
            }
        }
    }

    private void irInicio(ActionEvent event) {
        try {
            Parent inicioView = FXMLLoader.load(getClass().getResource("/vistas/vistaPrincipal.fxml"));
            Scene scene = ((Node) event.getSource()).getScene();
            scene.setRoot(inicioView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}