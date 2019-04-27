package main;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

public class Animation {

    private Timeline timeline;
    private DoubleProperty speed;
    private int[][] tab;        // zapełniona przez akcję choose() w kontrolerze
    private Logic logic;
    private IntegerProperty quantity = new SimpleIntegerProperty(1);        //liczba generacji do wykonania
    private BooleanProperty disableAllProperty = new SimpleBooleanProperty(true);

    public Animation(GridPane root) {
        speed = new SimpleDoubleProperty(0.5);        //szybkosc przeprowadzania generacji
        logic = new Logic(root);
    }

    public void fill() {
        timeline = new Timeline();
        timeline.setCycleCount(quantity.getValue());                    //ustawiamy liczbe generacji

        KeyFrame keyFrame = new KeyFrame(Duration.seconds(speed.getValue()), new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {

                if (quantity.getValue() > 0) {
                    logic.clear();
                    logic.paint(tab);
                    logic.change(tab);
                    quantity.setValue(quantity.get() - 1);                                //zminiejszamy ilosc o jeden
                }
            }
        });

        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
    }

    public void pause() {                            //metoda do zatrzymania symulacji
        timeline.pause();
    }

    public DoubleProperty speedProperty() {
        return speed;
    }

    public int[][] getTab() {
        return tab;
    }

    public void setTab(int[][] tab) {
        this.tab = tab;
    }

    public Logic getLogic() {
        return logic;
    }

    public void setQuantity(int quantity) {
        this.quantity.setValue(quantity);
    }

    public IntegerProperty getQuantity() {
        return quantity;
    }
}
