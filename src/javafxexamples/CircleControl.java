package javafxexamples;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class CircleControl extends Application {
    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("Управляю кругом");

        Parent ui = createInterface();
        primaryStage.setScene(new Scene(ui, 640, 440));

        primaryStage.show();
    }

    private Parent createInterface() {

        Label labelSlider = new Label("Радиус");
        Label labelCircleColor = new Label("Цвет круга");
        Label labelBackgroundColor = new Label("Цвет фона");

        Circle circle = new Circle();
        ColorPicker circleColor = new ColorPicker();
        ColorPicker backgroundColor = new ColorPicker();
        Slider slider = new Slider();
        Pane right = new Pane(circle);
        right.setStyle("-fx-background-color: white");

        VBox left = new VBox(labelSlider, slider, labelCircleColor, circleColor, labelBackgroundColor, backgroundColor);
        HBox all = new HBox(left, right);

        HBox.setHgrow(right, Priority.ALWAYS);
        left.setAlignment(Pos.CENTER);
        VBox.setVgrow(left, Priority.ALWAYS);
        left.setPrefWidth(200);

        circle.radiusProperty().bind(slider.valueProperty());
        circle.centerXProperty().bind(right.widthProperty().divide(2));
        circle.centerYProperty().bind(right.heightProperty().divide(2));
        circle.fillProperty().bind(circleColor.valueProperty());

        slider.maxProperty().bind(Bindings.createDoubleBinding(
                () -> Math.min(right.getHeight()/2,right.getWidth()/2),
                right.heightProperty(),right.widthProperty()
        ));

        return all;
    }
}