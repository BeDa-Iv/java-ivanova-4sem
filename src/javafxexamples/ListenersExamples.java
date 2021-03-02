package javafxexamples;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ListenersExamples extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Пример про слушателей");

        Parent ui = createInterface();
        primaryStage.setScene(new Scene(ui, 640, 480));

        primaryStage.show();
    }

    private Parent createInterface() {

        Button b = new Button("Кнопка");

        b.addEventHandler(ActionEvent.ACTION, actionEvent -> {
            System.out.println(actionEvent.getSource());
            System.out.println("Не нажимай больше эту кнопку");
        });

        b.addEventHandler(MouseEvent.MOUSE_ENTERED, mouseEvent -> {
            System.out.println("x,y = " + mouseEvent.getX() + " " + mouseEvent.getY());
            System.out.println("Уведи мышь, эту кнопку нельзя нажимать");
        });

        b.setOnAction(actionEvent -> {
            System.out.println("событие нажатия через свойство onAction");
        });

        return b;
    }
}
