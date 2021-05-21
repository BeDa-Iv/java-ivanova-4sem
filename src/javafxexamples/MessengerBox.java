package javafxexamples;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MessengerBox extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Мессенджер");

        Parent ui = createInterface();
        primaryStage.setScene(new Scene(ui, 640, 440));

        primaryStage.show();
    }

    private Parent createInterface() {
        TextArea allMessages = new TextArea();

        TextField newMessage = new TextField();
        newMessage.setMaxHeight(Double.MAX_VALUE);

        Button b = new Button("Отправить");
        b.setMaxHeight(Double.MAX_VALUE);

        Label l = new Label("Контакты");

        ObservableList<String> listContacts = FXCollections.observableArrayList (
                "Я", "больше", "не могу", "думать", "Мне", "больно", "думать");
        ListView<String> contacts = new ListView<>(listContacts);

        HBox message = new HBox(newMessage, b);
        VBox leftSide = new VBox(allMessages, message);
        VBox rightSide = new VBox(l, contacts);
        HBox socialNet = new HBox(leftSide, rightSide);

        HBox.setHgrow(newMessage, Priority.ALWAYS);
        VBox.setVgrow(allMessages, Priority.ALWAYS);
        VBox.setVgrow(contacts, Priority.ALWAYS);
        HBox.setHgrow(leftSide, Priority.ALWAYS);

        message.setPrefHeight(100);
        b.setPrefWidth(100);
        l.setPrefHeight(50);
        rightSide.setPrefWidth(200);

        b.addEventHandler(ActionEvent.ACTION, actionEvent -> {
            allMessages.setText(allMessages.getText() + newMessage.getText() + "\n");
            newMessage.clear();
        });

        return socialNet;
    }
}
