import java.util.Date;
import java.util.GregorianCalendar;

public class MainProgram {



    public static void main(String[] args) {

        Date hireDate = new GregorianCalendar(2020, 4, 15).getTime();


        Payment employee1 = new Payment(
                "Іван",
                "Петренко",
                hireDate,
                50000.0,
                10.0,
                19.5,
                20,
                22
        );


        System.out.println("--- Розрахунок зарплати ---");
        System.out.println(employee1);
    }
}