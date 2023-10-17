/*
* Desarrollo de Interfaces
* Mario Gallego González
* 2DAM
* 2023/24
* Lambda Mouse Event
*/
package es.ieslosmontecillos.lambdamouseevent;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LambdaDrag extends Application {

    private double xOffset = 0;
    private double yOffset = 0;

    @Override
    public void start(Stage stage) {
        StackPane root = new StackPane();
        Scene scene = new Scene(root, 320, 240);
        Text txt = new Text("Drag me anywhere you want");
        // Centra el texto a arrastrar
        StackPane.setAlignment(txt, javafx.geometry.Pos.CENTER);

        // Obtiene la posición inicial del nodo seleccionado(este caso el texto)
        txt.setOnMousePressed(e -> {
            xOffset = e.getSceneX();
            yOffset = e.getSceneY();
        });

        //
        txt.setOnMouseDragged(e -> {
            double x = e.getSceneX();
            double y = e.getSceneY();

            // Recoge la posición que sirve para mover el texto donde el cursor
            double deltaX = x - xOffset;
            double deltaY = y - yOffset;

            // Reposiciona el texto mediante el eje X y el eje Y
            txt.setTranslateX(txt.getTranslateX() + deltaX);
            txt.setTranslateY(txt.getTranslateY() + deltaY);

            // Guarda la última posición del texto.
            xOffset = x;
            yOffset = y;
        });

        // Añade el texto
        root.getChildren().add(txt);
        stage.setTitle("Drag the text");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}