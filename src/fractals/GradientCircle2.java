package fractals;

public class GradientCircle2 implements Fractal {

    @Override
    public double evaluate(double x, double y) {
        double r = Math.pow(x, 2) + Math.pow(y, 2);
        if (r > 6400)
            return 1;
        else
            return Math.sqrt(r / 6400.0);
    }
}