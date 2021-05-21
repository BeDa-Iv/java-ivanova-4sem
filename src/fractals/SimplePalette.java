package fractals;

public class SimplePalette implements Palette{
    @Override
    public int colorize(double v) {
        if (v > 0.5)
            return  0xFFFFFFFF;
        else
            return 0xFF000000;
    }
}
