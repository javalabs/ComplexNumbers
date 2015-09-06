package test;


import yegorov.math.Complex;

/**
 * Created by Admin on 06.09.2015.
 */
public class Main {
    public static void main(String[] args) {

        Complex c = Complex.fromCanonical(3, -4); //Complex.fromPolar(5, Math.toRadians());

        c.add(Complex.fromCanonical(-3, 4));

        System.out.println(Complex.add(Complex.fromCanonical(4, 2), Complex.fromCanonical(2, 1)).toCanonicalForm());

        /*
        System.out.println(c.toCanonicalForm());
        System.out.println(c.toPolarForm());
        System.out.println(c.toExponentForm());
        */

    }
}
