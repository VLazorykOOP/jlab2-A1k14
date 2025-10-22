import java.lang.Math;

public class Complex {

    private final double real;
    private final double imag;

    public Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public Complex add(Complex other) {
        double newReal = this.real + other.real;
        double newImag = this.imag + other.imag;
        return new Complex(newReal, newImag);
    }

    public Complex subtract(Complex other) {
        double newReal = this.real - other.real;
        double newImag = this.imag - other.imag;
        return new Complex(newReal, newImag);
    }

    public Complex multiply(Complex other) {
        double newReal = (this.real * other.real) - (this.imag * other.imag);
        double newImag = (this.real * other.imag) + (this.imag * other.real);
        return new Complex(newReal, newImag);
    }

    public Complex divide(Complex other) {
        double denominator = other.real * other.real + other.imag * other.imag;

        if (denominator == 0) {
            return null;
        }

        double newReal = ((this.real * other.real) + (this.imag * other.imag)) / denominator;
        double newImag = ((this.imag * other.real) - (this.real * other.imag)) / denominator;

        return new Complex(newReal, newImag);
    }

    public double modulus() {
        return Math.sqrt(this.real * this.real + this.imag * this.imag);
    }

    public double argument() {
        return Math.atan2(this.imag, this.real);
    }

    @Override
    public String toString() {
        String sign = (this.imag >= 0) ? "+" : "-";
        return String.format("%.4f %s %.4fi", this.real, sign, Math.abs(this.imag));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Complex that = (Complex) obj;
        return Double.compare(that.real, real) == 0 &&
                Double.compare(that.imag, imag) == 0;
    }

    @Override
    public int hashCode() {
        int result = 17;
        int realHash = Double.hashCode(real);
        int imagHash = Double.hashCode(imag);
        result = 31 * result + realHash;
        result = 31 * result + imagHash;
        return result;
    }
}