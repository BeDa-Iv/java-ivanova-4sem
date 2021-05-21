package fractals;

public interface Palette {

    /**
     * Определяет цвет для числа в диапазоне от 0 до 1
     * @param v число от 0 до 1
     * @return цвет числа
     */
    int colorize(double v);
}
