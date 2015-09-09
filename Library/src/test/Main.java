package test;


import yegorov.math.Complex;

/**
 * Created by Admin
 */
public class Main {
    public static void main(String[] args) {

        Complex c = Complex.fromCanonical(2, -7);
        Complex c2 = Complex.fromPolar(5, Math.toRadians(45));

        c.add(c2);

        Complex z = Complex.mul(c, Complex.fromExponent(5, Math.PI));

        System.out.println(c.toCanonicalForm());
        System.out.println(z.toPolarForm());
        System.out.println(c2.toExponentForm());


    }
}
