import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    int id;
    String name;
    double salary;
    double deduction;

    Employee(int id, String name, double salary, double deduction) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.deduction = deduction;
    }

    double netPayment() {
        return salary - deduction;
    }
}

public class OrganizationSystem {

    static ArrayList<Employee> employees = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    
    // ADD EMPLOYEE
    
    static void addEmployee() {

        System.out.println("\n--- ADD EMPLOYEE ---");

        System.out.print("Enter employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        // Check duplicate ID
        if (findEmployee(id) != null) {
            System.out.println("Error: Employee ID already exists.");
            return;
        }

        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();

        System.out.print("Enter salary: ");
        double salary = scanner.nextDouble();

        System.out.print("Enter deduction: ");
        double deduction = scanner.nextDouble();

        // Validation
        if (id <= 0) {
            System.out.println("Error: ID must be greater than 0.");
            return;
        }

        if (name.trim().isEmpty()) {
            System.out.println("Error: Name cannot be empty.");
            return;
        }

        if (salary < 0) {
            System.out.println("Error: Salary cannot be negative.");
            return;
        }

        if (deduction < 0) {
            System.out.println("Error: Deduction cannot be negative.");
            return;
        }

        if (deduction > salary) {
            System.out.println("Error: Deduction cannot be greater than salary.");
            return;
        }

        employees.add(new Employee(id, name, salary, deduction));

        System.out.println("Employee added successfully!");
    }

    // FIND EMPLOYEE
    
    static Employee findEmployee(int id) {

        for (Employee employee : employees) {

            if (employee.id == id) {
                return employee;
            }
        }

        return null;
    }

    // VIEW ALL EMPLOYEES
    
    static void viewEmployees() {

        System.out.println("\n--- ALL EMPLOYEES ---");

        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }

        for (Employee employee : employees) {

            System.out.println("----------------------------------");
            System.out.println("ID: " + employee.id);
            System.out.println("Name: " + employee.name);
            System.out.println("Salary: " + employee.salary);
            System.out.println("Deduction: " + employee.deduction);
            System.out.println("Net Payment: " + employee.netPayment());
        }

        System.out.println("----------------------------------");
    }

    // SEARCH EMPLOYEE
    
    static void searchEmployee() {

        System.out.println("\n--- SEARCH EMPLOYEE ---");

        System.out.print("Enter employee ID: ");
        int id = scanner.nextInt();

        Employee employee = findEmployee(id);

        if (employee == null) {
            System.out.println("Employee not found.");
            return;
        }

        System.out.println("\nEmployee Found!");
        System.out.println("ID: " + employee.id);
        System.out.println("Name: " + employee.name);
        System.out.println("Salary: " + employee.salary);
        System.out.println("Deduction: " + employee.deduction);
        System.out.println("Net Payment: " + employee.netPayment());
    }

    // UPDATE EMPLOYEE
    
    static void updateEmployee() {

        System.out.println("\n--- UPDATE EMPLOYEE ---");

        System.out.print("Enter employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Employee employee = findEmployee(id);

        if (employee == null) {
            System.out.println("Employee not found.");
            return;
        }

        System.out.print("Enter new name: ");
        String name = scanner.nextLine();

        System.out.print("Enter new salary: ");
        double salary = scanner.nextDouble();

        System.out.print("Enter new deduction: ");
        double deduction = scanner.nextDouble();

        if (name.trim().isEmpty()) {
            System.out.println("Error: Name cannot be empty.");
            return;
        }

        if (salary < 0) {
            System.out.println("Error: Salary cannot be negative.");
            return;
        }

        if (deduction < 0 || deduction > salary) {
            System.out.println("Error: Invalid deduction.");
            return;
        }

        employee.name = name;
        employee.salary = salary;
        employee.deduction = deduction;

        System.out.println("Employee updated successfully!");
    }

    // DELETE EMPLOYEE
   
    static void deleteEmployee() {

        System.out.println("\n--- DELETE EMPLOYEE ---");

        System.out.print("Enter employee ID: ");
        int id = scanner.nextInt();

        Employee employee = findEmployee(id);

        if (employee == null) {
            System.out.println("Employee not found.");
            return;
        }

        System.out.println("Employee: " + employee.name);

        System.out.print("Are you sure you want to delete this employee? (yes/no): ");
        scanner.nextLine();
        String confirmation = scanner.nextLine();

        if (confirmation.equalsIgnoreCase("yes")) {

            employees.remove(employee);

            System.out.println("Employee deleted successfully!");

        } else {

            System.out.println("Delete operation cancelled.");
        }
    }

    // CALCULATE PAYMENT
   
    static void calculatePayment() {

        System.out.println("\n--- CALCULATE PAYMENT ---");

        System.out.print("Enter employee ID: ");
        int id = scanner.nextInt();

        Employee employee = findEmployee(id);

        if (employee == null) {
            System.out.println("Employee not found.");
            return;
        }

        double payment = employee.netPayment();

        System.out.println("\nPayment Information");
        System.out.println("-------------------------");
        System.out.println("Employee: " + employee.name);
        System.out.println("Salary: " + employee.salary);
        System.out.println("Deduction: " + employee.deduction);
        System.out.println("Net Payment: " + payment);
    }

    // GENERATE REPORT

    static void generateReport() {

        System.out.println("\n==========================================");
        System.out.println("        EMPLOYEE PAYMENT REPORT");
        System.out.println("==========================================");

        if (employees.isEmpty()) {
            System.out.println("No employee records available.");
            return;
        }

        for (Employee employee : employees) {

            System.out.println("------------------------------------------");
            System.out.println("ID: " + employee.id);
            System.out.println("Name: " + employee.name);
            System.out.println("Salary: " + employee.salary);
            System.out.println("Deduction: " + employee.deduction);
            System.out.println("Net Payment: " + employee.netPayment());
        }

        System.out.println("------------------------------------------");
    }

    // MAIN MENU

    public static void main(String[] args) {

        int choice;

        System.out.println("==========================================");
        System.out.println("       ORGANIZATION X MANAGEMENT SYSTEM");
        System.out.println("==========================================");

        do {

            System.out.println("\n========== MAIN MENU ==========");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Calculate Payment");
            System.out.println("7. Generate Report");
            System.out.println("8. Exit");
            System.out.println("===============================");

            System.out.print("Choose an option: ");

            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    addEmployee();
                    break;

                case 2:
                    viewEmployees();
                    break;

                case 3:
                    searchEmployee();
                    break;

                case 4:
                    updateEmployee();
                    break;

                case 5:
                    deleteEmployee();
                    break;

                case 6:
                    calculatePayment();
                    break;

                case 7:
                    generateReport();
                    break;

                case 8:
                    System.out.println("\nThank you for using Organization X System.");
                    break;

                default:
                    System.out.println("Invalid option. Please choose 1-8.");
            }

        } while (choice != 8);

        scanner.close();
    }
}
