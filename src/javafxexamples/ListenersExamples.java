package javafxexamples;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ListenersExamples extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Пример про слушателей");

        Parent ui = createInterface();
        primaryStage.setScene(new Scene(ui, 640, 440));

        primaryStage.show();
    }

    private Parent createInterface() {

        Button b = new Button("Кнопка");
        b.setPrefSize(200,50);

        Label label = new Label("Не трогайте кнопочку, она спит");
        label.setStyle("-fx-font-size: 20px");

        VBox vb = new VBox(label, b);
        vb.setAlignment(Pos.CENTER);

        String[] phrases = new String[] {"Не нажимай больше на эту кнопку!", "Я просил, не нажимай больше на эту кнопку!", "По-человечески же просят, ну!", "Последнее предупреждение!!!"};

        ImageView img = new ImageView(new Image("file:image/boop.jpg"));

        b.setOnAction(new EventHandler<>() {
            int counter = 0;
            @Override
            public void handle(ActionEvent event) {
                if (counter == 4) {
                    vb.getChildren().clear();
                    vb.getChildren().add(img);
                } else {
                    label.setText(phrases[counter++]);
                }
            }
        });

        return vb;
    }
}
