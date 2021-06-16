package fractals;

public class IterationMandelbrot implements Fractal {

    @Override
    public double evaluate(double x, double y) {
        double xz = 0;
        double yz = 0;
        int k = 4;
        int N = 1000;

        for (double i = 0; i < N; i++) {
            double _xz = xz * xz + x - yz * yz;
            double _yz = y + 2 * xz * yz;
            xz = _xz;
            yz = _yz;
            if ((xz * xz + yz * yz) > k * k) {
                return i / N;
            }
        }
        return 1;
    }
}
