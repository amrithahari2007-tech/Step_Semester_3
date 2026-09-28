class PayrollAccount {
    private double basicSalary;
    private double bonus;

    public PayrollAccount(double openingSalary) {
        if (openingSalary < 0) {
            System.out.println("Warning: negative salary not allowed. Starting at 0.");
            basicSalary = 0;
        } else {
            basicSalary = openingSalary;
        }
        bonus = 0;
    }

    public void creditBonus(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid bonus amount: must be greater than 0.");
            return;
        }
        bonus += amount;
        System.out.println("Bonus credited: Rs " + amount);
    }

    public void deductTax(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("Invalid tax percent: must be between 0 and 100.");
            return;
        }
        basicSalary -= basicSalary * percent / 100;
        System.out.println("Tax deducted: " + (int) percent + "%");
    }

    public double getNetSalary() {
        return basicSalary + bonus;
    }
}

public class Main1 {
    public static void main(String[] args) {
        PayrollAccount acc = new PayrollAccount(50000);
        acc.creditBonus(5000);
        acc.deductTax(10);
        System.out.println("Net salary: Rs " + acc.getNetSalary());
    }
}