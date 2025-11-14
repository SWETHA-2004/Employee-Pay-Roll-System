package miniproject;

import java.io.*;
import java.util.ArrayList;
abstract class Employee implements Serializable {
    Integer emp_id;
    String emp_name;
    Double Basic_salary;
    String bankname;
    String accnum;
    String dof;
    Integer lop;
    String Pfnum;
    Integer std_days;
    String Location;
    Integer wkd;
    String dpt;
    Integer mgmtlevel;
    String Facility;
    String Entity;
    String PfUna;
    Double Net_salary;

    abstract void Calculatesalary();
    abstract void displayPayslip();
    abstract void generatepayslip();

    public Employee(Integer emp_id, String emp_name, Double Basic_salary, String bankname, String accnum, String dof,Integer lop, String Pfnum, Integer std_days, String Location, Integer wkd, String dpt,Integer mgmtlevel, String Facility, String Entity, String PfUna) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.Basic_salary = Basic_salary;
        this.bankname = bankname;
        this.accnum = accnum;
        this.dof = dof;
        this.lop = lop;
        this.Pfnum = Pfnum;
        this.std_days = std_days;
        this.Location = Location;
        this.wkd = wkd;
        this.dpt = dpt;
        this.mgmtlevel = mgmtlevel;
        this.Facility = Facility;
        this.Entity = Entity;
        this.PfUna = PfUna;
    }
}
class Permanent extends Employee {
    Double hra, da, tax, grosssalary;

    Permanent(Integer emp_id, String emp_name, Double Basic_salary, String bankname, String accnum, String dof,Integer lop, String Pfnum, Integer std_days, String Location, Integer wkd, String dpt,Integer mgmtlevel, String Facility, String Entity, String PfUna) {
        super(emp_id, emp_name, Basic_salary, bankname, accnum, dof, lop, Pfnum, std_days, Location, wkd,dpt, mgmtlevel, Facility, Entity, PfUna);
    }

    void Calculatesalary() {
        hra = 0.2 * Basic_salary;
        da = 0.1 * Basic_salary;
        grosssalary = hra + da + Basic_salary;
        tax = 0.05 * grosssalary;
        Net_salary = grosssalary - tax;
    }

    public void displayPayslip() {
        System.out.println("\n******** PAYSLIP (Permanent) ********");
        System.out.println("Employee ID   : " + emp_id);
        System.out.println("Name          : " + emp_name);
        System.out.println("Department    : " + dpt);
        System.out.println("Location      : " + Location);
        System.out.println("Date of Join  : " + dof);
        System.out.println("Bank Name     : " + bankname);
        System.out.println("Account No.   : " + accnum);
        System.out.println("PF Number     : " + Pfnum);
        System.out.println("PF UAN        : " + PfUna);
        System.out.println("Basic Salary  : " + Basic_salary);
        System.out.println("HRA (20%)     : " + hra);
        System.out.println("DA (10%)      : " + da);
        System.out.println("Tax (5%)      : " + tax);
        System.out.println("Net Salary    : " + Net_salary);
        System.out.println("Facility      : " + Facility);
        System.out.println("Entity        : " + Entity);
        System.out.println("**************************************\n");
    }

    public void generatepayslip() {
        String filename = "Payslip_" + emp_id + ".txt";
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            pw.println("******** PAYSLIP (Permanent) ********");
            pw.println("Employee ID   : " + emp_id);
            pw.println("Name          : " + emp_name);
            pw.println("Department    : " + dpt);
            pw.println("Location      : " + Location);
            pw.println("Date of Join  : " + dof);
            pw.println("Bank Name     : " + bankname);
            pw.println("Account No.   : " + accnum);
            pw.println("PF Number     : " + Pfnum);
            pw.println("PF UAN        : " + PfUna);
            pw.println("--------------------------------------");
            pw.println("Basic Salary  : " + Basic_salary);
            pw.println("HRA (20%)     : " + hra);
            pw.println("DA (10%)      : " + da);
            pw.println("Tax (5%)      : " + tax);
            pw.println("Net Salary    : " + Net_salary);
            pw.println("Facility      : " + Facility);
            pw.println("Entity        : " + Entity);
            pw.println("**************************************");
            System.out.println("Payslip generated successfully: " + filename);
        } catch (Exception e) {
            System.out.println("Error generating payslip: " + e.getMessage());
        }
    }
}

class Contract extends Employee {//CONTRACT EMPLOYEE
    Double bonus;

    Contract(Integer emp_id, String emp_name, Double Basic_salary, String bankname, String accnum, String dof,Integer lop, String Pfnum, Integer std_days, String Location, Integer wkd, String dpt,Integer mgmtlevel, String Facility, String Entity, String PfUna) {
        super(emp_id, emp_name, Basic_salary, bankname, accnum, dof, lop, Pfnum, std_days, Location, wkd,dpt, mgmtlevel, Facility, Entity, PfUna);
    }

    void Calculatesalary() {
        bonus = 0.1 * Basic_salary;
        Net_salary = Basic_salary + bonus;
    }

    public void displayPayslip() {
        System.out.println("\n******** PAYSLIP (Contract) ********");
        System.out.println("Employee ID   : " + emp_id);
        System.out.println("Name          : " + emp_name);
        System.out.println("Department    : " + dpt);
        System.out.println("Location      : " + Location);
        System.out.println("Date of Join  : " + dof);
        System.out.println("Bank Name     : " + bankname);
        System.out.println("Account No.   : " + accnum);
        System.out.println("Bonus (10%)   : " + bonus);
        System.out.println("Net Salary    : " + Net_salary);
        System.out.println("Facility      : " + Facility);
        System.out.println("Entity        : " + Entity);
        System.out.println("************************************\n");
    }

    public void generatepayslip() {
        String filename = "Payslip_" + emp_id + ".txt";
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            pw.println("******** PAYSLIP (Contract) ********");
            pw.println("Employee ID   : " + emp_id);
            pw.println("Name          : " + emp_name);
            pw.println("Department    : " + dpt);
            pw.println("Location      : " + Location);
            pw.println("Date of Join  : " + dof);
            pw.println("Bank Name     : " + bankname);
            pw.println("Account No.   : " + accnum);
            pw.println("------------------------------------");
            pw.println("Basic Salary  : " + Basic_salary);
            pw.println("Bonus (10%)   : " + bonus);
            pw.println("Net Salary    : " + Net_salary);
            pw.println("Facility      : " + Facility);
            pw.println("Entity        : " + Entity);
            pw.println("************************************");
            System.out.println("Payslip generated successfully: " + filename);
        } catch (Exception e) {
            System.out.println("Error generating payslip: " + e.getMessage());
        }
    }
}
public class Employeepayroll {
    java.util.Scanner sc = new java.util.Scanner(System.in);
    ArrayList<Employee> employee = new ArrayList<>();
    public void saveToTextFile() {
        try {
            FileWriter fw = new FileWriter("employees.txt"); 
            PrintWriter pw = new PrintWriter(fw);

            for (Employee e : employee) {
                pw.println("==================================");
                pw.println("Employee ID   : " + e.emp_id);
                pw.println("Employee Name : " + e.emp_name);
                pw.println("Basic Salary  : " + e.Basic_salary);
                pw.println("Bank Name     : " + e.bankname);
                pw.println("Account No    : " + e.accnum);
                pw.println("Date of Join  : " + e.dof);
                pw.println("Loss of Pay   : " + e.lop);
                pw.println("PF Number     : " + e.Pfnum);
                pw.println("Standard Days : " + e.std_days);
                pw.println("Location      : " + e.Location);
                pw.println("Worked Days   : " + e.wkd);
                pw.println("Department    : " + e.dpt);
                pw.println("Mgmt Level    : " + e.mgmtlevel);
                pw.println("Facility      : " + e.Facility);
                pw.println("Entity        : " + e.Entity);
                pw.println("PF UAN No.    : " + e.PfUna);
                pw.println("Employee Type : " + e.getClass().getSimpleName());
                pw.println("Net Salary    : " + e.Net_salary);
                pw.println("==================================");
                pw.println();
            }System.out.println("Employee details saved to employees.txt successfully!");
        } catch (IOException ex) {
            System.out.println("Error writing to text file: " + ex.getMessage());
        }
    }
    public void loadFromFile() {
        File file = new File("employees.dat");
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                employee = (ArrayList<Employee>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error loading employees: " + e.getMessage());
            }
        }
    }
    public void addemployee() {
        System.out.println("Enter Employee ID : ");
        Integer emp_id = sc.nextInt();
        for (Employee e : employee) {
            if (e.emp_id.equals(emp_id)) {
                System.out.println(" Employee ID already exists! Please use a different ID.");
                return;
            }
        }
        System.out.println("Enter Employee Name : ");
        String emp_name = sc.next();

        System.out.println("Enter Basic Salary : ");
        Double Basic_salary = sc.nextDouble();

        System.out.println("Enter Bank Name : ");
        String bankname = sc.next();

        System.out.println("Enter Account Number : ");
        String accnum = sc.next();

        System.out.println("Enter Date of Joining : ");
        String dof = sc.next();

        System.out.println("Enter Number of LOP (Loss of Pay) Days : ");
        Integer lop = sc.nextInt();
        
        System.out.println("Enter PF Number : ");
        String Pfnum = sc.next();

        System.out.println("Enter Standard Working Days : ");
        Integer std_days = sc.nextInt();
       
        System.out.println("Enter Location : ");
        String Location = sc.next();

        System.out.println("Enter Worked Days : ");
        Integer wkd = sc.nextInt();

        System.out.println("Enter Department : ");
        String dpt = sc.next();

        System.out.println("Enter Management Level : ");
        Integer mgmtlevel = sc.nextInt();

        System.out.println("Enter Facility : ");
        String Facility = sc.next();

        System.out.println("Enter Entity : ");
        String Entity = sc.next();

        System.out.println("Enter PF UAN : ");
        String PfUna = sc.next();

        System.out.println("Select Employee Type : ");
        System.out.println("1. Permanent");
        System.out.println("2. Contract");
        int choice = sc.nextInt();

        Employee emp = null;
        if (choice == 1) {
            emp = new Permanent(emp_id, emp_name, Basic_salary, bankname, accnum, dof, lop, Pfnum, std_days, Location,wkd, dpt, mgmtlevel, Facility, Entity, PfUna);
        } else if (choice == 2) {
            emp = new Contract(emp_id, emp_name, Basic_salary, bankname, accnum, dof, lop, Pfnum, std_days, Location,wkd, dpt, mgmtlevel, Facility, Entity, PfUna);
        } else {
            System.out.println("Invalid type!");
            return;
        }

        emp.Calculatesalary();
        employee.add(emp);
        saveToTextFile();
        System.out.println("Employee added successfully!");
    }
    public void displayAllEmployees() {
        if (employee.isEmpty()) {
            System.out.println("No employees found!");
            return;
        }
        System.out.println("\n---- Employee Details ----");
        for (Employee e : employee) {
            System.out.println("ID: " + e.emp_id + " | Name: " + e.emp_name +
                    " | Basic: " + e.Basic_salary +
                    " | Type: " + e.getClass().getSimpleName());
        }
    }
    public void generateslips() {
        System.out.println("Enter Employee ID : ");
        Integer id = sc.nextInt();
        for (Employee e : employee) {
            if (e.emp_id.equals(id)) {
                e.displayPayslip();
                e.generatepayslip();
                return;
            }
        }
        System.out.println("Employee Not Found");
    }
    public static void main(String[] args) {
        Employeepayroll epr = new Employeepayroll();
        epr.loadFromFile();
        int option;
        do {
            System.out.println("\n========= EMPLOYEE MENU =========");
            System.out.println("1. Add Employee");
            System.out.println("2. Display Employees Info");
            System.out.println("3. Generate Pay Slip");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");
            option = epr.sc.nextInt();

            switch (option) {
                case 1 -> epr.addemployee();
                case 2 -> epr.displayAllEmployees();
                case 3 -> epr.generateslips();
                case 4 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }
        } while (option != 4);
    }
}
