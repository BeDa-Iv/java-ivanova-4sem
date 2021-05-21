package fractals;

public class GradientPalette implements Palette {
    @Override
    public int colorize(double v) {

        int a = (int)Math.round((1 - v) * 255);
        /*
        Перевожу прозрачность из 0-1 в 0-255, а потом добавляю ее в уже готовый argb

        (1 - v) инвертирует цвета

        Итоговое значение int получаем сложением байтов, умноженных на а.
        Чтобы цвета были непрозрачными, необходим минус.
         */
        return -((a * 256 * 256) + (a * 256) + a);
    }
}
