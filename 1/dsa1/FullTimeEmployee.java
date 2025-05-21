package dsa1;

class FullTimeEmployee extends Employee {
    private double monthlySalary;
    private int hoursWorked;
    private static final double OVERTIME_RATE_FULLTIME = 150000; // Tarif lembur pegawai tetap

    public FullTimeEmployee(String name, double monthlySalary, int hoursWorked) {
        super(name);
        this.monthlySalary = monthlySalary;
        this.hoursWorked = Math.max(0, hoursWorked); // Validasi jam kerja negatif
    }

    @Override
    public double calculateSalary() {
        double overtimePay = 0;
        if (hoursWorked > 40) {
            overtimePay = (hoursWorked - 40) * OVERTIME_RATE_FULLTIME;
        }
        return monthlySalary + overtimePay;
    }
}
