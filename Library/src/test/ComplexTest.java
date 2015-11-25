import org.junit.Test;
import yegorov.math.Complex;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;

public class ComplexTest {
    private double delta = 0.00001;
    /*
    1. Проверить, что при создания комплексного числа статическими методами,
    комплексное число корректно инициализируется входящими параметрами.
     */
    @Test
    public void testFromCanonical() throws Exception {
        Complex complex = Complex.fromCanonical(20d, 25d);

        assertEquals(20d, complex.getReal(), delta);
        assertEquals(25d, complex.getImag(), delta);


        // Проверка граничных условий
        // Левая граница
        complex = Complex.fromCanonical(Double.MIN_VALUE + 0.99, Double.MIN_VALUE + 0.99);
        assertEquals(Double.MIN_VALUE + 0.99, complex.getReal(), delta);
        assertEquals(Double.MIN_VALUE + 0.99, complex.getImag(), delta);

        complex = Complex.fromCanonical(Double.MIN_VALUE, Double.MIN_VALUE);
        assertEquals(Double.MIN_VALUE, complex.getReal(), delta);
        assertEquals(Double.MIN_VALUE, complex.getImag(), delta);

        complex = Complex.fromCanonical(Double.MIN_VALUE - 0.99, Double.MIN_VALUE - 0.99);
        assertEquals(Double.MIN_VALUE - 0.99, complex.getReal(), delta);
        assertEquals(Double.MIN_VALUE - 0.99, complex.getImag(), delta);

        // Середина
        complex = Complex.fromCanonical(0 + 0.59, 0 + 0.59);
        assertEquals(0 + 0.59, complex.getReal(), delta);
        assertEquals(0 + 0.59, complex.getImag(), delta);

        complex = Complex.fromCanonical(0, 0);
        assertEquals(0, complex.getReal(), delta);
        assertEquals(0, complex.getImag(), delta);

        complex = Complex.fromCanonical(0 - 0.59, 0 - 0.59);
        assertEquals(0 - 0.59, complex.getReal(), delta);
        assertEquals(0 - 0.59, complex.getImag(), delta);

        // Правая граница
        complex = Complex.fromCanonical(Double.MAX_VALUE + 0.99, Double.MAX_VALUE + 0.99);
        assertEquals(Double.MAX_VALUE + 0.99, complex.getReal(), delta);
        assertEquals(Double.MAX_VALUE + 0.99, complex.getImag(), delta);

        complex = Complex.fromCanonical(Double.MAX_VALUE, Double.MAX_VALUE);
        assertEquals(Double.MAX_VALUE, complex.getReal(), delta);
        assertEquals(Double.MAX_VALUE, complex.getImag(), delta);

        complex = Complex.fromCanonical(Double.MAX_VALUE - 0.99, Double.MAX_VALUE - 0.99);
        assertEquals(Double.MAX_VALUE - 0.99, complex.getReal(), delta);
        assertEquals(Double.MAX_VALUE - 0.99, complex.getImag(), delta);
    }

    @Test
    public void testFromPolar() throws Exception {
        Complex complex = Complex.fromPolar(10d, -2d);

        assertEquals(10d, complex.getModule(), delta);
        assertEquals(-2d, complex.getArg(), delta);

        // Проверка граничных условий
        // Левая граница
        complex = Complex.fromPolar(0d + 0.99, Double.MIN_VALUE + 0.99);
        assertEquals(0d + 0.99, complex.getModule(), delta);
        assertEquals(Double.MIN_VALUE + 0.99, complex.getArg(), delta);

        complex = Complex.fromPolar(0d, Double.MIN_VALUE);
        assertEquals(0d, complex.getModule(), delta);
        assertNotEquals(Double.MIN_VALUE, complex.getArg(), delta);

        complex = Complex.fromPolar(0d - 0.99, Double.MIN_VALUE - 0.99);
        assertNotEquals(0d - 0.99, complex.getModule(), delta);
        assertNotEquals(Double.MIN_VALUE - 0.99, complex.getArg(), delta);

        // Середина
        complex = Complex.fromPolar(Double.MAX_VALUE / 2d, 0d);
        assertNotEquals(Double.MAX_VALUE / 2d, complex.getModule(), delta);
        assertEquals(0d, complex.getArg(), delta);

        // Правая граница
        complex = Complex.fromPolar(Double.MAX_VALUE - 0.99, Double.MAX_VALUE - 0.99);
        assertNotEquals(Double.MAX_VALUE - 0.99, complex.getModule(), delta);
        assertNotEquals(Double.MAX_VALUE - 0.99, complex.getArg(), delta);

        complex = Complex.fromPolar(Double.MAX_VALUE, Double.MAX_VALUE);
        assertNotEquals(Double.MAX_VALUE, complex.getModule(), delta);
        assertNotEquals(Double.MAX_VALUE, complex.getArg(), delta);

        complex = Complex.fromPolar(Double.MAX_VALUE + 0.99, Double.MAX_VALUE + 0.99);
        assertNotEquals(Double.MAX_VALUE + 0.99, complex.getModule(), delta);
        assertNotEquals(Double.MAX_VALUE + 0.99, complex.getArg(), delta);
    }

    @Test
    public void testFromExponent() throws Exception {
        Complex complex = Complex.fromExponent(15d, 3d);

        assertEquals(15d, complex.getModule(), delta);
        assertEquals(3d, complex.getArg(), delta);

        // Проверка граничных условий
        // Левая граница
        complex = Complex.fromExponent(0d + 0.99, Double.MIN_VALUE + 0.99);
        assertEquals(0d + 0.99, complex.getModule(), delta);
        assertEquals(Double.MIN_VALUE + 0.99, complex.getArg(), delta);

        complex = Complex.fromExponent(0d, Double.MIN_VALUE);
        assertEquals(0d, complex.getModule(), delta);
        assertNotEquals(Double.MIN_VALUE, complex.getArg(), delta);

        complex = Complex.fromExponent(0d - 0.99, Double.MIN_VALUE - 0.99);
        assertNotEquals(0d - 0.99, complex.getModule(), delta);
        assertNotEquals(Double.MIN_VALUE - 0.99, complex.getArg(), delta);

        // Середина
        complex = Complex.fromExponent(Double.MAX_VALUE / 2d, 0d);
        assertNotEquals(Double.MAX_VALUE / 2d, complex.getModule(), delta);
        assertEquals(0d, complex.getArg(), delta);

        // Правая граница
        complex = Complex.fromExponent(Double.MAX_VALUE - 0.99, Double.MAX_VALUE - 0.99);
        assertNotEquals(Double.MAX_VALUE - 0.99, complex.getModule(), delta);
        assertNotEquals(Double.MAX_VALUE - 0.99, complex.getArg(), delta);

        complex = Complex.fromExponent(Double.MAX_VALUE, Double.MAX_VALUE);
        assertNotEquals(Double.MAX_VALUE, complex.getModule(), delta);
        assertNotEquals(Double.MAX_VALUE, complex.getArg(), delta);

        complex = Complex.fromExponent(Double.MAX_VALUE + 0.99, Double.MAX_VALUE + 0.99);
        assertNotEquals(Double.MAX_VALUE + 0.99, complex.getModule(), delta);
        assertNotEquals(Double.MAX_VALUE + 0.99, complex.getArg(), delta);
    }

    @Test
    public void testCreateComplex() throws Exception {
        Complex complex = Complex.CreateComplex(-10d, -5d, Complex.Presentation.CANONICAL);

        assertEquals(-10d, complex.getReal(), delta);
        assertEquals(-5d, complex.getImag(), delta);


        complex = Complex.CreateComplex(9d, 0d, Complex.Presentation.POLAR);

        assertEquals(9d, complex.getModule(), delta);
        assertEquals(0d, complex.getArg(), delta);


        complex = Complex.CreateComplex(16d, 1d, Complex.Presentation.EXPONENT);

        assertEquals(16d, complex.getModule(), delta);
        assertEquals(1d, complex.getArg(), delta);

        // Проверка граничных условий

        // CANONICAL

        // Левая граница
        complex = Complex.CreateComplex(Double.MIN_VALUE + 0.99, Double.MIN_VALUE + 0.99, Complex.Presentation.CANONICAL);
        assertEquals(Double.MIN_VALUE + 0.99, complex.getReal(), delta);
        assertEquals(Double.MIN_VALUE + 0.99, complex.getImag(), delta);

        complex = Complex.CreateComplex(Double.MIN_VALUE, Double.MIN_VALUE, Complex.Presentation.CANONICAL);
        assertEquals(Double.MIN_VALUE, complex.getReal(), delta);
        assertEquals(Double.MIN_VALUE, complex.getImag(), delta);

        complex = Complex.CreateComplex(Double.MIN_VALUE - 0.99, Double.MIN_VALUE - 0.99, Complex.Presentation.CANONICAL);
        assertEquals(Double.MIN_VALUE - 0.99, complex.getReal(), delta);
        assertEquals(Double.MIN_VALUE - 0.99, complex.getImag(), delta);

        // Середина
        complex = Complex.CreateComplex(0 - 0.59, 0 - 0.59, Complex.Presentation.CANONICAL);
        assertEquals(0 - 0.59, complex.getReal(), delta);
        assertEquals(0 - 0.59, complex.getImag(), delta);

        complex = Complex.CreateComplex(0, 0, Complex.Presentation.CANONICAL);
        assertEquals(0, complex.getReal(), delta);
        assertEquals(0, complex.getImag(), delta);

        complex = Complex.CreateComplex(0 + 0.59, 0 + 0.59, Complex.Presentation.CANONICAL);
        assertEquals(0 + 0.59, complex.getReal(), delta);
        assertEquals(0 + 0.59, complex.getImag(), delta);

        // Правая граница
        complex = Complex.CreateComplex(Double.MAX_VALUE - 0.99, Double.MAX_VALUE - 0.99, Complex.Presentation.CANONICAL);
        assertEquals(Double.MAX_VALUE - 0.99, complex.getReal(), delta);
        assertEquals(Double.MAX_VALUE - 0.99, complex.getImag(), delta);

        complex = Complex.CreateComplex(Double.MAX_VALUE, Double.MAX_VALUE, Complex.Presentation.CANONICAL);
        assertEquals(Double.MAX_VALUE, complex.getReal(), delta);
        assertEquals(Double.MAX_VALUE, complex.getImag(), delta);

        complex = Complex.CreateComplex(Double.MAX_VALUE + 0.99, Double.MAX_VALUE + 0.99, Complex.Presentation.CANONICAL);
        assertEquals(Double.MAX_VALUE + 0.99, complex.getReal(), delta);
        assertEquals(Double.MAX_VALUE + 0.99, complex.getImag(), delta);

        // POLAR

        // Левая граница
        complex = Complex.CreateComplex(0d + 0.99, Double.MIN_VALUE + 0.99, Complex.Presentation.POLAR);
        assertEquals(0d + 0.99, complex.getModule(), delta);
        assertEquals(Double.MIN_VALUE + 0.99, complex.getArg(), delta);

        complex = Complex.CreateComplex(0d, Double.MIN_VALUE, Complex.Presentation.POLAR);
        assertEquals(0d, complex.getModule(), delta);
        assertNotEquals(Double.MIN_VALUE, complex.getArg(), delta);

        complex = Complex.CreateComplex(0d - 0.99, Double.MIN_VALUE - 0.99, Complex.Presentation.POLAR);
        assertNotEquals(0d - 0.99, complex.getModule(), delta);
        assertNotEquals(Double.MIN_VALUE - 0.99, complex.getArg(), delta);

        // Середина
        complex = Complex.CreateComplex(Double.MAX_VALUE / 2d, 0d, Complex.Presentation.POLAR);
        assertNotEquals(Double.MAX_VALUE / 2d, complex.getModule(), delta);
        assertEquals(0d, complex.getArg(), delta);

        // Правая граница
        complex = Complex.CreateComplex(Double.MAX_VALUE - 0.99, Double.MAX_VALUE - 0.99, Complex.Presentation.POLAR);
        assertNotEquals(Double.MAX_VALUE - 0.99, complex.getModule(), delta);
        assertNotEquals(Double.MAX_VALUE - 0.99, complex.getArg(), delta);

        complex = Complex.CreateComplex(Double.MAX_VALUE, Double.MAX_VALUE, Complex.Presentation.POLAR);
        assertNotEquals(Double.MAX_VALUE, complex.getModule(), delta);
        assertNotEquals(Double.MAX_VALUE, complex.getArg(), delta);

        complex = Complex.CreateComplex(Double.MAX_VALUE + 0.99, Double.MAX_VALUE + 0.99, Complex.Presentation.POLAR);
        assertNotEquals(Double.MAX_VALUE + 0.99, complex.getModule(), delta);
        assertNotEquals(Double.MAX_VALUE + 0.99, complex.getArg(), delta);

        // EXPONENT

        // Левая граница
        complex = Complex.CreateComplex(0d + 0.99, Double.MIN_VALUE + 0.99, Complex.Presentation.EXPONENT);
        assertEquals(0d + 0.99, complex.getModule(), delta);
        assertEquals(Double.MIN_VALUE + 0.99, complex.getArg(), delta);

        complex = Complex.CreateComplex(0d, Double.MIN_VALUE, Complex.Presentation.EXPONENT);
        assertEquals(0d, complex.getModule(), delta);
        assertNotEquals(Double.MIN_VALUE, complex.getArg(), delta);

        complex = Complex.CreateComplex(0d - 0.99, Double.MIN_VALUE - 0.99, Complex.Presentation.EXPONENT);
        assertNotEquals(0d - 0.99, complex.getModule(), delta);
        assertNotEquals(Double.MIN_VALUE - 0.99, complex.getArg(), delta);

        // Середина
        complex = Complex.CreateComplex(Double.MAX_VALUE / 2d, 0d, Complex.Presentation.EXPONENT);
        assertNotEquals(Double.MAX_VALUE / 2d, complex.getModule(), delta);
        assertEquals(0d, complex.getArg(), delta);

        // Правая граница
        complex = Complex.CreateComplex(Double.MAX_VALUE - 0.99, Double.MAX_VALUE - 0.99, Complex.Presentation.EXPONENT);
        assertNotEquals(Double.MAX_VALUE - 0.99, complex.getModule(), delta);
        assertNotEquals(Double.MAX_VALUE - 0.99, complex.getArg(), delta);

        complex = Complex.CreateComplex(Double.MAX_VALUE, Double.MAX_VALUE, Complex.Presentation.EXPONENT);
        assertNotEquals(Double.MAX_VALUE, complex.getModule(), delta);
        assertNotEquals(Double.MAX_VALUE, complex.getArg(), delta);

        complex = Complex.CreateComplex(Double.MAX_VALUE + 0.99, Double.MAX_VALUE + 0.99, Complex.Presentation.EXPONENT);
        assertNotEquals(Double.MAX_VALUE + 0.99, complex.getModule(), delta);
        assertNotEquals(Double.MAX_VALUE + 0.99, complex.getArg(), delta);
    }


    /*
    2.	Проверить, что при создании методом instanseOf (копирование объекта) копии комплексного числа,
    исходный и новый объект находятся в одинаковом внутреннем состоянии.
     */
    @Test
    public void testInstanseOf() throws Exception {
        Complex oldComplex = Complex.fromCanonical(10, 10);

        assertNotNull(oldComplex);

        Complex newComplex = Complex.instanseOf(oldComplex);

        assertEquals(oldComplex.getReal(), newComplex.getReal(), delta);
        assertEquals(oldComplex.getImag(), newComplex.getImag(), delta);
        assertEquals(oldComplex.getModule(), newComplex.getModule(), delta);
        assertEquals(oldComplex.getArg(), newComplex.getArg(), delta);
    }


    /*
    3.	Проверить, что методы представляющие комплексное число в виде строки,
    соответствуют внутреннему состоянию объекта, а также методы получения результата
    комплексного числа в тригонометрической форме и экспоненциальной форме возвращают
    корректное значения угла в указанных единицах.
     */
    @Test
    public void testToCanonicalForm() throws Exception {
        Complex complex = Complex.fromCanonical(-5, 2);

        assertNotNull(complex);

        assertEquals(String.format("%.5f + i*%.5f", -5d, 2d), complex.toCanonicalForm());

    }

    @Test
    public void testToPolarForm() throws Exception {
        Complex complex = Complex.fromPolar(5.5, 2.2);

        assertNotNull(complex);

        assertEquals(String.format("%.5f*(cos(%.5f) + i*sin(%.5f))", 5.5, 2.2, 2.2),
                complex.toPolarForm(Complex.AngleUnit.RADIAN));

        assertEquals(String.format("%.5f*(cos(%.5f) + i*sin(%.5f))", 5.5, Math.toDegrees(2.2), Math.toDegrees(2.2)),
                complex.toPolarForm(Complex.AngleUnit.DEGREE));

        assertEquals(String.format("%.5f*(cos(%.5f) + i*sin(%.5f))", 5.5, 2.2 * (200d / Math.PI), 2.2 * (200d / Math.PI)),
                complex.toPolarForm(Complex.AngleUnit.GRAD));
    }

    @Test
    public void testToExponentForm() throws Exception {
        Complex complex = Complex.fromExponent(10.5, 1.5);

        assertNotNull(complex);

        assertEquals(String.format("%.5f*e^(i*%.5f)", 10.5, 1.5),
                complex.toExponentForm(Complex.AngleUnit.RADIAN));

        assertEquals(String.format("%.5f*e^(i*%.5f)", 10.5, Math.toDegrees(1.5)),
                complex.toExponentForm(Complex.AngleUnit.DEGREE));

        assertEquals(String.format("%.5f*e^(i*%.5f)", 10.5, 1.5 * (200d / Math.PI)),
                complex.toExponentForm(Complex.AngleUnit.GRAD));
    }


    /*
    4.	Проверить, что арифметические операции (сложение, вычитание, деление, умножение)
    выполняются корректно и изменяют состояние объекта с которого вызывается соответствующий метод.
     */
    @Test
    public void testAdd() throws Exception {
        Complex complex = Complex.fromCanonical(10, -7);

        assertNotNull(complex);

        Complex newComplex = Complex.fromCanonical(20, 10).add(complex);

        assertEquals(30d, newComplex.getReal(), delta);
        assertEquals(3d, newComplex.getImag(), delta);
    }

    @Test
    public void testSub() throws Exception {
        Complex complex = Complex.fromCanonical(20, 7);

        assertNotNull(complex);

        Complex newComplex = Complex.fromCanonical(10, 10).sub(complex);

        assertEquals(-10d, newComplex.getReal(), delta);
        assertEquals(3d, newComplex.getImag(), delta);
    }

    @Test
    public void testMul() throws Exception {
        Complex complex = Complex.fromCanonical(20, 4);

        assertNotNull(complex);

        Complex newComplex = Complex.fromCanonical(10, 7).mul(complex);

        assertEquals(20d * 10d - (4d * 7d), newComplex.getReal(), delta);
        assertEquals(20d * 7d + 10d * 4d, newComplex.getImag(), delta);
    }

    @Test
    public void testDiv() throws Exception {
        Complex complex = Complex.fromCanonical(3, -7);

        assertNotNull(complex);

        Complex newComplex = Complex.fromCanonical(5, 7).div(complex);

        assertEquals((5d * 3d + (7d * -7d)) / (7d * 7d + (-7d * -7d)), newComplex.getReal(), delta);
        assertEquals((7d * 3d - (5d * -7d)) / (7d * 7d + (-7d * -7d)), newComplex.getImag(), delta);
    }


    /*
    5.	Проверить, что арифметические операции (сложение, вычитание, деление, умножение)
    в статических методах выполняются корректно и не изменяют внутреннего состояния входящих параметров,
    т. е. результат возвращается новым объектом.
     */
    @Test
    public void testAdd1() throws Exception {
        Complex complex1 = Complex.fromCanonical(10, 7);
        Complex complex2 = Complex.fromCanonical(20, 10);

        assertNotNull(complex1);
        assertNotNull(complex2);

        Complex newComplex = Complex.add(complex1, complex2);

        // Новый объект корректный
        assertEquals(30d, newComplex.getReal(), delta);
        assertEquals(17d, newComplex.getImag(), delta);

        // Входящие параметры не изменились
        assertEquals(10d, complex1.getReal(), delta);
        assertEquals(7d, complex1.getImag(), delta);
        assertEquals(20d, complex2.getReal(), delta);
        assertEquals(10d, complex2.getImag(), delta);
    }

    @Test
    public void testSub1() throws Exception {
        Complex complex1 = Complex.fromCanonical(10, 7);
        Complex complex2 = Complex.fromCanonical(20, 10);

        assertNotNull(complex1);
        assertNotNull(complex2);

        Complex newComplex = Complex.sub(complex1, complex2);

        // Новый объект корректный
        assertEquals(-10d, newComplex.getReal(), delta);
        assertEquals(-3d, newComplex.getImag(), delta);

        // Входящие параметры не изменились
        assertEquals(10d, complex1.getReal(), delta);
        assertEquals(7d, complex1.getImag(), delta);
        assertEquals(20d, complex2.getReal(), delta);
        assertEquals(10d, complex2.getImag(), delta);
    }

    @Test
    public void testMul1() throws Exception {
        Complex complex1 = Complex.fromCanonical(20, 4);
        Complex complex2 = Complex.fromCanonical(10, 7);

        assertNotNull(complex1);
        assertNotNull(complex2);

        Complex newComplex = Complex.mul(complex1, complex2);

        // Новый объект корректный
        assertEquals(20d * 10d - (4d * 7d), newComplex.getReal(), delta);
        assertEquals(20d * 7d + 10d * 4d, newComplex.getImag(), delta);

        // Входящие параметры не изменились
        assertEquals(20d, complex1.getReal(), delta);
        assertEquals(4d, complex1.getImag(), delta);
        assertEquals(10d, complex2.getReal(), delta);
        assertEquals(7d, complex2.getImag(), delta);
    }

    @Test
    public void testDiv1() throws Exception {
        Complex complex1 = Complex.fromCanonical(5, 7);
        Complex complex2 = Complex.fromCanonical(3, -7);

        assertNotNull(complex1);
        assertNotNull(complex2);

        Complex newComplex = Complex.div(complex1, complex2);

        // Новый объект корректный
        assertEquals((5d * 3d + (7d * -7d)) / (7d * 7d + (-7d * -7d)), newComplex.getReal(), delta);
        assertEquals((7d * 3d - (5d * -7d)) / (7d * 7d + (-7d * -7d)), newComplex.getImag(), delta);

        // Входящие параметры не изменились
        assertEquals(5d, complex1.getReal(), delta);
        assertEquals(7d, complex1.getImag(), delta);
        assertEquals(3d, complex2.getReal(), delta);
        assertEquals(-7d, complex2.getImag(), delta);
    }
}