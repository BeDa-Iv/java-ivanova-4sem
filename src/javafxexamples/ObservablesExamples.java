package javafxexamples;

import javafx.beans.InvalidationListener;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

public class ObservablesExamples {

    public static void main(String[] args) {
        int x = 1;
        x = 2;

        SimpleIntegerProperty ox = new SimpleIntegerProperty(42);

        ox.addListener(value ->{
            System.out.println("значение изменилось, теперь оно " + ox.get());
        });

        ox.addListener((value, oldValue, newValue) -> {
            System.out.println("значение изменилось, оно было " + oldValue + ", теперь оно " + newValue);
        });

        ox.setValue(123);

        ObservableList<String> ol = FXCollections.observableArrayList();

        ol.addListener((InvalidationListener)  value -> {
            System.out.println("Список как-то изменился, теперь он: " + ol);
        });

        ol.addListener((ListChangeListener<String>) c -> {
            System.out.println("Список изменен:");
            while (c.next()) {
                System.out.println("  добавлено элементов:" + c.getAddedSize());
                System.out.println("  удалено элементов:" + c.getRemovedSize());
            }
        });

        ol.add("line 1");
        ol.add("line 2");
        ol.addAll("line3", "line4", "line5");

    }

}
