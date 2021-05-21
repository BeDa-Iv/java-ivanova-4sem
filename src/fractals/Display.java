package fractals;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Display extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Задачи про картинки");

        Parent ui = createInterface();
        primaryStage.setScene(new Scene(ui));

        primaryStage.show();
    }

    private Parent createInterface() {
        int w = 200;
        int h = 200;
        double x0 = -80;
        double y0 = 80;
        double d = 160.0 / w;

        // Задача 1
        WritableImage imageSimpleCircle = new WritableImage(w, h);
        ImageView imageViewSimpleCircle = new ImageView(imageSimpleCircle);
        PixelWriter fractalWriterSimpleCircle =  imageSimpleCircle.getPixelWriter();

        SimpleCircle simpleCircle = new SimpleCircle();
        SimplePalette simplePalette = new SimplePalette();

        for (int _x = 0; _x < w; _x++) {
            for (int _y = 0; _y < h; _y++) {
                double x = x0 + d * _x;
                double y = y0 - d * _y;
                double v = simpleCircle.evaluate(x, y);
                int color = simplePalette.colorize(v);
                fractalWriterSimpleCircle.setArgb(_x, _y, color);
            }
        }

        // Задача 1'
        WritableImage imageGradientCircle = new WritableImage(w, h);
        ImageView imageViewGradientCircle = new ImageView(imageGradientCircle);
        PixelWriter fractalGradientWriter = imageGradientCircle.getPixelWriter();

        GradientCircle gradientCircle= new GradientCircle();
        GradientPalette grayPalette = new GradientPalette();

        for (int _x = 0; _x < w; _x++) {
            for (int _y = 0; _y < h; _y++) {
                double x = x0 + d * _x;
                double y = y0 - d * _y;
                double v = gradientCircle.evaluate(x, y);
                int color = grayPalette.colorize(v);
                fractalGradientWriter.setArgb(_x, _y, color);
            }
        }

        // Задача 1"
        WritableImage imageGradientCircle2 = new WritableImage(w, h);
        ImageView imageViewGradientCircle2 = new ImageView(imageGradientCircle2);
        PixelWriter fractalGradientWriter2 = imageGradientCircle2.getPixelWriter();

        GradientCircle2 gradientCircle2 = new GradientCircle2();

        for (int _x = 0; _x < w; _x++) {
            for (int _y = 0; _y < h; _y++) {
                double x = x0 + d * _x;
                double y = y0 - d * _y;
                double v = gradientCircle2.evaluate(x, y);
                int color = grayPalette.colorize(v);
                fractalGradientWriter2.setArgb(_x, _y, color);
            }
        }

        // Задача 2
        WritableImage imageRGB = new WritableImage(256, 256);
        ImageView imageViewRGB = new ImageView(imageRGB);
        PixelWriter fractalRGBWriter = imageRGB.getPixelWriter();

        for (int x = 0; x < 256; x++) {
            for (int y = 0; y < 256; y++) {
                fractalRGBWriter.setArgb(x, y,
                        -((x * 256 * 256) - (y * 256) + 100));
            }
        }

        // Задача 3
        WritableImage imageHSB = new WritableImage(360, 100);
        ImageView imageViewHSB = new ImageView(imageHSB);
        PixelWriter fractalHSBWriter = imageHSB.getPixelWriter();

        for (int x = 0; x < 360; x++) {
            for (int y = 0; y < 100; y++) {
                fractalHSBWriter.setColor(x, y,
                        Color.hsb(x, y / 99.0, 1));
            }
        }

        return new HBox(imageViewSimpleCircle, imageViewGradientCircle, imageViewGradientCircle2, imageViewRGB, imageViewHSB);
    }
}