package javafxexamples;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class ObservablesInTheInterfaceExamples extends Application {

    private TextField textInput;
    private Label label1;
    private Label label2;
    private Label label3;
    private Label label4;
    private Label label5;
    private Label label6;
    private ListView<String> listView;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Примеры наблюдаемых значений");
        Parent parent = initInterface();
        primaryStage.setScene(new Scene(parent));
        primaryStage.show();
        initInteraction();
    }

    private Parent initInterface() {
        textInput = new TextField("-- введите текст --");
        label1 = new Label();
        label2 = new Label();
        label3 = new Label();
        label4 = new Label();
        label5 = new Label();
        label6 = new Label();
        listView = new ListView<>();
        final VBox vBox = new VBox(textInput, label1, label2, label3, label4, label5, label6, listView);
        vBox.setStyle("-fx-font-size: 2em");
        return vBox;
    }

    private void initInteraction() {
        textInput.addEventHandler(ActionEvent.ACTION, e -> {
            String textFromUser = textInput.getText();
            label1.setText(textFromUser);
        });

        textInput.textProperty().addListener((value, oldValue, newValue) ->
                label2.setText(newValue)
        );

        textInput.addEventHandler(KeyEvent.ANY, e -> {
            String textFromUser = textInput.getText();
            label3.setText(textFromUser);
            System.out.println("сработало событие клавиатуры");
        });

        label4.textProperty().bind(textInput.textProperty());

        label5.textProperty().bind(Bindings.createStringBinding(
                () -> textInput.getText().toUpperCase(),
                textInput.textProperty()
        ));

        label6.textProperty().bind(Bindings.concat(
                "Вы написали <<",
                textInput.textProperty(),
                ">>."
        ));

    }

}
