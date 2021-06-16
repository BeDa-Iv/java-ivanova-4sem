package fractals;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import static javafx.scene.input.MouseEvent.MOUSE_PRESSED;
import static javafx.scene.input.MouseEvent.MOUSE_RELEASED;

public class DisplayMandelbrot extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Мандельброт(кривой, но как смогла)");

        Parent ui = createInterface();
        primaryStage.setScene(new Scene(ui));

        primaryStage.show();

        initInteraction();
    }

    int w = 600;
    int h = 600;
    double x0 = -2;
    double y0 = 2;
    double d = 4.0 / w;
    double _x;
    double _y;

    IterationMandelbrot iterationMandelbrot = new IterationMandelbrot();
    WritableImage image = new WritableImage(w, h);
    ImageView imageView = new ImageView(image);
    PixelWriter pixelWriter = image.getPixelWriter();
    GradientPalette grayPalette = new GradientPalette();

    private void initInteraction() {
        EventHandler<ScrollEvent> scaleEventHandler = e -> {
                    if (e.getDeltaY() > 0) {
                        x0 = x0 + e.getX() * d - e.getX() * d / 1.5;
                        y0 = y0 + e.getY() * d - e.getY() * d / 1.5;
                        d = d / 1.5;
                    } else if (e.getDeltaY() < 0) {
                        x0 = x0 + e.getX() * d - e.getX() * d * 1.5;
                        y0 = y0 + e.getY() * d - e.getY() * d * 1.5;
                        d = d * 1.5;
                    }
                    if (e.getSource().equals(imageView)) {
                        drawMandelbrot(pixelWriter, grayPalette, x0, y0, d);
                    }
                };

        EventHandler<MouseEvent> moveEventHandler = e -> {
                    if (e.getEventType().equals(MOUSE_PRESSED)) {
                        _x = e.getX();
                        _y = e.getY();
                    }
                    if (e.getEventType().equals(MOUSE_RELEASED)){
                        double x2 = e.getX();
                        double y2 = e.getY();

                        x0 = x0 + d * (x2 - _x);
                        y0 = y0 - d * (y2 - _y);

                        if (e.getSource().equals(imageView)) {
                            drawMandelbrot(pixelWriter, grayPalette, x0, y0, d);
                        }
                    }
                };

        imageView.addEventHandler(MouseEvent.ANY, moveEventHandler);
        imageView.addEventHandler(ScrollEvent.ANY, scaleEventHandler);
    }


    public void drawMandelbrot(PixelWriter pixelWriter, GradientPalette grayPalette, double x0, double y0, double d) {
        for (int _x = 0; _x < w; _x++) {
            for (int _y = 0; _y < h; _y++) {
                double x = x0 + d * _x;
                double y = y0 - d * _y;
                double v = iterationMandelbrot.evaluate(x, y);
                int color = grayPalette.colorize(v);
                pixelWriter.setArgb(_x, _y, color);
            }
        }
    }

    private Parent createInterface() {
        drawMandelbrot(pixelWriter, grayPalette, x0, y0, d);
        return new HBox(imageView);
    }
}
