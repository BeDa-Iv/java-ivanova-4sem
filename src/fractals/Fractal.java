package fractals;

public interface Fractal {

    /**
     * Для каждой точки плоскости выдает число от 0 до 1 ,чтобы можно было ее раскрасить
     * @param x координата по x
     * @param y координата по y
     * @return число от 0 до 1
     */
    double evaluate(double x, double y);
}