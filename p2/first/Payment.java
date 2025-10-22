import java.util.Calendar;
import java.util.Date;

public class Payment {
    private String firstName;
    private String lastName;
    private Date hireDate;
    private double salary; // Оклад
    private double bonusPercentage;
    private double taxPercentage;
    private int daysWorked;
    private int totalWorkingDays;

    private double accruedAmount; // Нарахована сума
    private double deductedAmount; // Утримана сума

    public Payment(String firstName, String lastName, Date hireDate, double salary,
                   double bonusPercentage, double taxPercentage, int daysWorked, int totalWorkingDays) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.hireDate = hireDate;
        this.salary = salary;
        this.bonusPercentage = bonusPercentage;
        this.taxPercentage = taxPercentage;
        this.daysWorked = daysWorked;
        this.totalWorkingDays = totalWorkingDays;

        this.calculateAccruedAmount();
        this.calculateDeductedAmount();
    }
    public double calculateAccruedAmount() {
        double salary_per_day = this.salary / this.totalWorkingDays;
        double total_salary = salary_per_day * this.daysWorked;
        total_salary += total_salary * this.bonusPercentage / 100;
        this.accruedAmount = total_salary;
        return this.accruedAmount;



    }

    public double calculateDeductedAmount() {
        this.deductedAmount = this.accruedAmount * this.taxPercentage / 100;
        return this.deductedAmount;
    }

    public int calculateExperienceYears() {
        Calendar now = Calendar.getInstance();

        Calendar hireCal = Calendar.getInstance();
        hireCal.setTime(this.hireDate); // Встановлюємо на дату прийому

        int currentYear = now.get(Calendar.YEAR);
        int hireYear = hireCal.get(Calendar.YEAR);

        int experience = currentYear - hireYear;

        int currentDayOfYear = now.get(Calendar.DAY_OF_YEAR);
        int hireDayOfYear = hireCal.get(Calendar.DAY_OF_YEAR);

        if (currentDayOfYear < hireDayOfYear) {
            experience--;
        }

        return experience;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getAccruedAmount() {
        return accruedAmount;
    }

    public double getDeductedAmount() {
        return deductedAmount;
    }

    public double getNetSalary() {
        return this.accruedAmount - this.deductedAmount;
    }

    @Override
    public String toString(){
        String name = String.format("Працівник: " + this.getFirstName() + " " + this.getLastName());
        String yearex = String.format("Стаж роботи (повних років): " + this.calculateExperienceYears());

        String line1 = String.format("---------------------------");

        String accrued = String.format("Нарахована сума: %.2f грн%n", this.getAccruedAmount());
        String deducted = String.format("Утримана сума (податок): %.2f грн%n", this.getDeductedAmount());

        String line2 = String.format("---------------------------");
        String salary = String.format("Сума до видачі ('на руки'): %.2f грн%n", this.getNetSalary());

    return name + "\n" + yearex + "\n" + line1 + "\n" + accrued + deducted + line2 + "\n" + salary;}

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        Payment other = (Payment) obj;
        return this.firstName.equals(other.firstName) &&
                this.lastName.equals(other.lastName) &&
                this.hireDate.equals(other.hireDate);
    }
}