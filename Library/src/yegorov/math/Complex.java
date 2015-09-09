package yegorov.math;

/**
 * Created by Yegorov Artem <yegorov0725@yandex.ru>
 */
public class Complex extends Number {

    private double real;
    private double imag;


    public Complex() {
        this.real = 0d;
        this.imag = 0d;
    }


    public Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    /**
     * Addition operations
     * @param z other complex number
     * @return Complex object
     */
    public Complex add(Complex z) {

        this.real += z.getReal();
        this.imag += z.getImag();

        return this;
    }

    /**
     * Subtraction operations
     * @param z other complex number
     * @return Complex object
     */
    public Complex sub(Complex z) {

        this.real -= z.getReal();
        this.imag -= z.getImag();

        return this;
    }

    /**
     * Multiplication operations
     * @param z other complex number
     * @return Complex object
     */
    public Complex mul(Complex z) {

        double real = this.real * z.getReal() - this.imag * z.getImag();
        double imag = this.imag * z.getReal() + this.real * z.getImag();

        this.real = real;
        this.imag = imag;

        return this;
    }

    /**
     * Division operations
     * @param z other complex number
     * @return Complex object
     */
    public Complex div(Complex z) {

        double d = this.imag * this.imag + z.getImag() * z.getImag();

        double real = (this.real * z.getReal() + this.imag * z.getImag()) / d;
        double imag = (this.imag * z.getReal() - this.real * z.getImag()) / d;

        this.real = real;
        this.imag = imag;

        return this;
    }


    public static Complex add(Complex z1, Complex z2) {
        return Complex.instanseOf(z1).add(z2);
    }

    public static Complex sub(Complex z1, Complex z2) {
        return Complex.instanseOf(z1).sub(z2);
    }

    public static Complex mul(Complex z1, Complex z2) {
        return Complex.instanseOf(z1).mul(z2);
    }

    public static Complex div(Complex z1, Complex z2) {
        return Complex.instanseOf(z1).div(z2);
    }



    public static Complex instanseOf(Complex z) {
        return new Complex(z.getReal(), z.getImag());
    }

    /**
     * @param real Real part of the complex number
     * @param imag - Imaginary part of the complex number
     * @return New complex number
     */
    public static Complex fromCanonical(double real, double imag) {
        return new Complex(real, imag);
    }

    /**
     * @param module Absolute value (or modulus or magnitude) of a complex number sqrt(real^2 + imag^2)
     * @param arg - The argument of z (in many applications referred to as the "phase") is the angle of the radius OP
     *              with the positive real axis,
     * @return New complex number
     */
    public static Complex fromPolar(double module, double arg) {

        double tanArg = Math.tan(arg);

        double real = Math.sqrt((tanArg * tanArg * module * module) / (1 + tanArg * tanArg));
        double imag = real / tanArg;

        return new Complex(real, imag);
    }

    /**
     * @param module Absolute value (or modulus or magnitude) of a complex number sqrt(real^2 + imag^2)
     * @param arg - The argument of z (in many applications referred to as the "phase") is the angle of the radius OP
     *              with the positive real axis,
     * @return New complex number
     */
    public static Complex fromExponent(double module, double arg) {

        Complex c = Complex.fromPolar(module, arg);

        return c;
    }

    /*
    * Real part of the complex number
    */
    public double getReal() {
        return real;
    }

    /*
    * Imaginary part of the complex number
    */
    public double getImag() {
        return imag;
    }

    /*
    * Absolute value (module) of the complex number (sqrt(real^2 + imag^2))
    */
    public double getModule() {
        return Math.sqrt(real * real + imag * imag);
    }

    /*
    * Argument is a function operating on complex numbers.
    * It gives the angle between the positive real axis to the line joining the point to the origin
    */
    public double getArg() {
        // https://en.wikipedia.org/wiki/Complex_number#Polar_form
        double arcTan = Math.atan(imag / real); //Math.atan2(imag, real);
        double result;

        if(real > 0)
            result = arcTan;
        else if(real < 0 && imag >= 0)
            result = arcTan + Math.PI;
        else if(real < 0 && imag < 0)
            result = arcTan - Math.PI;
        else if(real == 0 && imag > 0)
            result = Math.PI / 2.0;
        else if(real == 0 && imag < 0)
            result = -Math.PI / 2.0;
        else
            result = Double.NaN;
        return result;

    }


    /*
    * @return String canonical form, example: 6,00 + i*3,00
    */
    public String toCanonicalForm() {
        return String.format("%.5f %c i*%.5f", real, imag >= 0 ? '+' : '-', Math.abs(imag));
    }

    /*
    * @return String polar (trigonometric) form, example:  2*(cos(0,52) + i*sin(0,52))
    */
    public String toPolarForm() {
        double arg = getArg();

        return String.format("%.5f*(cos(%.5f) %c i*sin(%.5f))",
                getModule(),
                arg,
                '+', //sinFi >= 0 ? '+' : '-',
                arg);
    }

    /*
    * @return String exponent form, example: 2,00*e^(i*0,53)
    */
    public String toExponentForm() {
        return String.format("%.5f*e^(i*%.5f)", getModule(), getArg());
    }

    @Override
    public String toString() {
        return String.format("Complex{real=%f, imag=%f}", real, imag);
    }



    @Override
    public int intValue() {
        return (int) getModule();
    }

    @Override
    public long longValue() {
        return (long) getModule();
    }

    @Override
    public float floatValue() {
        return (float) getModule();
    }

    @Override
    public double doubleValue() {
        return getModule();
    }
}
