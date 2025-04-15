package com.tiendadelibros.tiendadelibros;

import com.tiendadelibros.tiendadelibros.clases.Libro;
import com.tiendadelibros.tiendadelibros.clases.LibroDAO;
import java.io.IOException;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class CategoriaController {

    @FXML
    private FlowPane categoriaContainer; 
    @FXML
    private TextField buscadorField; 
    @FXML
    private ComboBox<String> editorialCombo; 
    @FXML
    private ComboBox<String> autorCombo; 
    @FXML
    
   
    public void initialize() {
        cargarLibros(); 
        cargarFiltros(); 
    }

    private void cargarLibros() {
        LibroDAO dao = new LibroDAO(); 
        List<Libro> libros = dao.getLibros(); 

        categoriaContainer.getChildren().clear();

        for (Libro libro : libros) {
            VBox tarjeta = crearTarjetaLibro(libro);
            categoriaContainer.getChildren().add(tarjeta); 
        }
    }

    private VBox crearTarjetaLibro(Libro libro) {
        VBox tarjeta = new VBox(); 
        tarjeta.setStyle("-fx-background-color: white; -fx-padding: 10; -fx-border-color: #ccc; -fx-border-radius: 5;");
        tarjeta.setSpacing(10);

        ImageView imagenLibro = new ImageView(new Image("file:src/main/resources/images/" + libro.getImagen()));
        imagenLibro.setFitWidth(100);
        imagenLibro.setFitHeight(150);

        Label tituloLabel = new Label(libro.getTitulo());
        tituloLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
        Label autorLabel = new Label("Por: " + libro.getAutor());
        Label precioLabel = new Label("$" + libro.getPrecio());

        tarjeta.getChildren().addAll(imagenLibro, tituloLabel, autorLabel, precioLabel);
        return tarjeta;
    }

    private void cargarFiltros() {
        LibroDAO dao = new LibroDAO();

        List<String> editoriales = dao.obtenerEditoriales();
        if (editoriales != null) {
            editorialCombo.getItems().clear();
            editorialCombo.getItems().addAll(editoriales);
        }

        List<String> autores = dao.obtenerAutores();
        if (autores != null) {
            autorCombo.getItems().clear();
            autorCombo.getItems().addAll(autores);
        }
    }

    @FXML
    public void accionBuscar() {
        String textoBusqueda = buscadorField.getText().trim();
        if (textoBusqueda.isEmpty()) {
            System.out.println("No se ingreso texto para buscar.");
            return;
        }
        LibroDAO dao = new LibroDAO();
        List<Libro> libros = dao.buscarPorTitulo(textoBusqueda);
        categoriaContainer.getChildren().clear(); 
        for (Libro libro : libros) {
            VBox tarjeta = crearTarjetaLibro(libro);
            categoriaContainer.getChildren().add(tarjeta);
        }
    }

    @FXML
    private void filtrarPorEditorial(ActionEvent event) {
        String editorialSeleccionada = editorialCombo.getValue();
        if (editorialSeleccionada == null) {
            System.out.println("Seleccione una editorial para filtrar.");
            return;
        }

        LibroDAO dao = new LibroDAO();
        List<Libro> libros = dao.buscarPorEditorial(editorialSeleccionada);

        categoriaContainer.getChildren().clear(); 

        for (Libro libro : libros) {
            VBox tarjeta = crearTarjetaLibro(libro);
            categoriaContainer.getChildren().add(tarjeta);
        }
    }

    @FXML
    private void filtrarPorAutor(ActionEvent event) {
        String autorSeleccionado = autorCombo.getValue();
        if (autorSeleccionado == null) {
            System.out.println("Seleccione un autor para filtrar.");
            return;
        }

        LibroDAO dao = new LibroDAO();
        List<Libro> libros = dao.buscarPorAutor(autorSeleccionado);

        categoriaContainer.getChildren().clear(); 

        for (Libro libro : libros) {
            VBox tarjeta = crearTarjetaLibro(libro);
            categoriaContainer.getChildren().add(tarjeta);
        }
    }

    @FXML
    private void irInicio(ActionEvent event) {
        cambiarVista("/vistas/vistaPrincipal.fxml", event);
    }

    @FXML
    private void irHistorial(ActionEvent event) {
        cambiarVista("/vistas/historial.fxml", event);
    }

    @FXML
    private void irFavoritos(ActionEvent event) {
        cambiarVista("/vistas/favorito.fxml", event);
    }

    @FXML
    private void irRegistrarse(ActionEvent event) {
        cambiarVista("/vistas/registrarse.fxml", event);
    }

    @FXML
    private void irLogin(ActionEvent event) {
        cambiarVista("/vistas/login.fxml", event);
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
}