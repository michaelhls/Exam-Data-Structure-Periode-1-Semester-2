package dsa1;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.NumberFormat;

public class Main {
    private static ArrayList<Employee> employeeList = new ArrayList<>(); // Menyimpan data pegawai
    private static Scanner scanner = new Scanner(System.in);
    private static NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(); // Format uang

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Sistem Manajemen Pegawai ---");
            System.out.println("1. Tambah Pegawai Tetap");
            System.out.println("2. Tambah Pegawai Paruh Waktu");
            System.out.println("3. Tampilkan Daftar Pegawai");
            System.out.println("4. Keluar");
            System.out.print("Pilih opsi: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Konsumsi newline

            switch (choice) {
                case 1:
                    // Input Pegawai Tetap
                    System.out.print("Masukkan nama: ");
                    String ftName = scanner.nextLine();
                    System.out.print("Masukkan total jam kerja: ");
                    int ftHours = scanner.nextInt();
                    scanner.nextLine(); // Konsumsi newline
                    System.out.print("Masukkan gaji bulanan: ");
                    double ftSalary = scanner.nextDouble();
                    scanner.nextLine(); // Konsumsi newline

                    Employee fullTime = new FullTimeEmployee(ftName, ftSalary, ftHours);
                    employeeList.add(fullTime); // Simpan ke ArrayList
                    System.out.println("Total Gaji: " + currencyFormat.format(fullTime.calculateSalary()));
                    break;

                case 2:
                    // Input Pegawai Paruh Waktu
                    System.out.print("Masukkan nama: ");
                    String ptName = scanner.nextLine();
                    System.out.print("Masukkan total jam kerja: ");
                    int ptHours = scanner.nextInt();
                    scanner.nextLine(); // Konsumsi newline
                    System.out.print("Masukkan tarif per jam: ");
                    double ptRate = scanner.nextDouble();
                    scanner.nextLine(); // Konsumsi newline

                    Employee partTime = new PartTimeEmployee(ptName, ptRate, ptHours);
                    employeeList.add(partTime); // Simpan ke ArrayList
                    System.out.println("Total Gaji: " + currencyFormat.format(partTime.calculateSalary()));
                    break;

                case 3:
                    // Tampilkan Daftar Pegawai
                    System.out.println("\n--- Daftar Pegawai ---");
                    for (Employee emp : employeeList) {
                        System.out.println("Nama: " + emp.getName());
                        System.out.println("Gaji: " + currencyFormat.format(emp.calculateSalary()));
                        System.out.println("------------------------");
                    }
                    break;

                case 4:
                    System.out.println("Program selesai. Terima kasih!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }
}