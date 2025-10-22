public class Main {

    public static void main(String[] args) {

        // (Радіус 10, центр в 0,0)
        Circle c1 = new Circle(10, 0, 0);
        System.out.println(c1);
        System.out.println("--- Створено Коло 1 (Радіус 10, Центр 0,0) ---");


        System.out.printf("Довжина кола: %.2f%n", c1.getCircumference());
        System.out.printf("Площа круга: %.2f%n", c1.getArea());


        // Ця точка (5, 5) має бути всередині
        boolean test1 = c1.isInside(5, 5);
        System.out.println("Точка (5, 5) всередині? " + test1); // Має бути true

        // Ця точка (15, 0) має бути ззовні
        boolean test2 = c1.isInside(15, 0);
        System.out.println("Точка (15, 0) всередині? " + test2); // Має бути false


        System.out.println("\n--- Тестування перетинів ---");

        // Створюємо друге коло, яке трохи зсунуте
        Circle c2 = new Circle(10, 5, 0); // Радіус 10, центр в 5,0
        int points = c1.getIntersectionPoints(c2);
        System.out.println("Перетин c1 та c2 (очікуємо 2): " + points);


        // Радіус 10, центр в 20,0 (сума радіусів = 10+10=20)
        Circle c3 = new Circle(10, 20, 0);
        points = c1.getIntersectionPoints(c3);
        System.out.println("Торкання c1 та c3 (очікуємо 1): " + points);


        // Маленьке коло всередині c1
        Circle c4 = new Circle(2, 1, 1); // Радіус 2, центр в 1,1
        points = c1.getIntersectionPoints(c4);
        System.out.println("c4 всередині c1 (очікуємо 0): " + points);


        // Повністю ідентичне коло
        Circle c5 = new Circle(10, 0, 0);
        points = c1.getIntersectionPoints(c5);
        System.out.println("Ідентичні c1 та c5 (очікуємо -1): " + points);
    }
}