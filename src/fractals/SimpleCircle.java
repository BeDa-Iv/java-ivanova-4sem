package fractals;

public class SimpleCircle implements Fractal {
    @Override
    public double evaluate(double x, double y) {
        double r = Math.pow(x, 2) + Math.pow(y , 2);
        if (r > 6400)
            return 1;
        else
            return 0;
    }
}
