import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double r1, i1, r2, i2;

        System.out.print("Введіть дійсну частину c1 (real1): ");
        r1 = scanner.nextDouble();

        System.out.print("Введіть уявну частину c1 (imag1): ");
        i1 = scanner.nextDouble();

        System.out.print("Введіть дійсну частину c2 (real2): ");
        r2 = scanner.nextDouble();

        System.out.print("Введіть уявну частину c2 (imag2): ");
        i2 = scanner.nextDouble();

        System.out.println("\nДякую! Обчислюю...");

        Complex c1 = new Complex(r1, i1);
        Complex c2 = new Complex(r2, i2);

        System.out.println("Перше число (c1): " + c1);
        System.out.println("Друге число (c2): " + c2);
        System.out.println("------------------------------");

        System.out.println("c1 + c2 = " + c1.add(c2));
        System.out.println("c1 - c2 = " + c1.subtract(c2));
        System.out.println("c1 * c2 = " + c1.multiply(c2));

        Complex divResult = c1.divide(c2);
        if (divResult == null) {
            System.out.println("c1 / c2 = Помилка: Ділення на комплексний нуль (0 + 0i)");
        } else {
            System.out.println("c1 / c2 = " + divResult);
        }

        System.out.println("------------------------------");

        System.out.printf("Модуль |c1| = %.4f%n", c1.modulus());
        System.out.printf("Модуль |c2| = %.4f%n", c2.modulus());
        System.out.printf("Аргумент arg(c1) = %.4f рад%n", c1.argument());
        System.out.printf("Аргумент arg(c2) = %.4f рад%n", c2.argument());

        System.out.println("------------------------------");
        System.out.println("Демонстрація equals:");

        Complex c3 = new Complex(r1, i1);
        System.out.println("Третє число (c3):  " + c3);

        System.out.println("c1 == c1: " + (c1 == c1));
        System.out.println("c1 == c3: " + (c1 == c3));
        System.out.println("c1.equals(c3): " + c1.equals(c3));
        System.out.println("c1.equals(c2): " + c1.equals(c2));

        scanner.close();
    }
}