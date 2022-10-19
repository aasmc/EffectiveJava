package ru.aasmc.effectivejava.chapter_04.item_17;

/**
 * Example of effectively final class.
 */
public class ComplexWithFactory {
    private final double re;
    private final double im;

    private ComplexWithFactory(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public static ComplexWithFactory valueOf(double re, double im) {
        return new ComplexWithFactory(re, im);
    }

    public double realPart() {
        return re;
    }

    public double imaginaryPart() {
        return im;
    }

    public ComplexWithFactory plus(ComplexWithFactory c) {
        return new ComplexWithFactory(re + c.re, im + c.im);
    }

    public ComplexWithFactory minus(ComplexWithFactory c) {
        return new ComplexWithFactory(re - c.re, im - c.im);
    }

    public ComplexWithFactory times(ComplexWithFactory c) {
        return new ComplexWithFactory(re * c.re - im * c.im, re * c.im + im * c.re);
    }

    public ComplexWithFactory divideBy(ComplexWithFactory c) {
        double tmp = c.re * c.re + c.im * c.im;
        return new ComplexWithFactory(
                (re * c.re + im * c.im) / tmp,
                (im * c.re - re * c.im) / tmp
        );
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof ComplexWithFactory)) return false;
        ComplexWithFactory c = (ComplexWithFactory) o;
        return Double.compare(c.re, re) == 0
                && Double.compare(c.im, im) == 0;
    }

    @Override
    public int hashCode() {
        return 31 * Double.hashCode(re) + Double.hashCode(im);
    }

    @Override
    public String toString() {
        return "(" + re + " + " + im + "i)";
    }
}
