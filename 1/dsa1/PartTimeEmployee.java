package dsa1;

class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;
    private static final double OVERTIME_RATE_PARTTIME = 78000; // Tarif lembur pegawai paruh waktu

    public PartTimeEmployee(String name, double hourlyRate, int hoursWorked) {
        super(name);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = Math.max(0, hoursWorked); // Validasi jam kerja negatif
    }

    @Override
    public double calculateSalary() {
        double regularPay = Math.min(hoursWorked, 40) * hourlyRate;
        double overtimePay = Math.max(0, hoursWorked - 40) * OVERTIME_RATE_PARTTIME;
        return regularPay + overtimePay;
    }
}