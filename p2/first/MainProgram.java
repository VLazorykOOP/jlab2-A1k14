import java.util.Date;
import java.util.GregorianCalendar;

public class MainProgram {



    public static void main(String[] args) {

        Date hireDate = new GregorianCalendar(2020, 4, 15).getTime();


        Payment employee1 = new Payment(
                "Іван",                  // firstName
                "Петренко",             // lastName
                hireDate,                // hireDate
                50000.0,                 // salary (оклад)
                10.0,                    // bonusPercentage (10% надбавки)
                19.5,                    // taxPercentage (19.5% податку)
                20,                      // daysWorked (відпрацьовано 20 днів)
                22                       // totalWorkingDays (всього 22 роб. дні)
        );

        // --- 3. Виводимо результати в консоль ---
        // Використовуємо методи, які ми створили

        System.out.println("--- Розрахунок зарплати ---");
        System.out.println("Працівник: " + employee1.getFirstName() + " " + employee1.getLastName());
        System.out.println("Стаж роботи (повних років): " + employee1.calculateExperienceYears());

        System.out.println("---------------------------");

        // Виводимо суми, які були автоматично розраховані в конструкторі
        // (Використовуємо `printf` для гарного форматування грошей)
        System.out.printf("Нарахована сума: %.2f грн%n", employee1.getAccruedAmount());
        System.out.printf("Утримана сума (податок): %.2f грн%n", employee1.getDeductedAmount());

        System.out.println("---------------------------");
        System.out.printf("Сума до видачі ('на руки'): %.2f грн%n", employee1.getNetSalary());
    }
}