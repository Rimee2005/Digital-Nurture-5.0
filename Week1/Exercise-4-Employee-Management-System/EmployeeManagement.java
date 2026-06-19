public class EmployeeManagement {

    private Employee[] employees;
    private int count;

    public EmployeeManagement(int size) {
        employees = new Employee[size];
        count = 0;
    }

    // Add Employee
    public void addEmployee(Employee employee) {

        if (count < employees.length) {
            employees[count] = employee;
            count++;
            System.out.println("Employee added successfully.");
        } else {
            System.out.println("Employee array is full.");
        }
    }

    // Search Employee
    public Employee searchEmployee(int employeeId) {

        for (int i = 0; i < count; i++) {

            if (employees[i].employeeId == employeeId) {
                return employees[i];
            }
        }

        return null;
    }

    // Traverse Employees
    public void displayEmployees() {

        System.out.println("\nEmployee Records:");

        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }

    // Delete Employee
    public void deleteEmployee(int employeeId) {

        int index = -1;

        for (int i = 0; i < count; i++) {

            if (employees[i].employeeId == employeeId) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Employee not found.");
            return;
        }

        for (int i = index; i < count - 1; i++) {
            employees[i] = employees[i + 1];
        }

        employees[count - 1] = null;
        count--;

        System.out.println("Employee deleted successfully.");
    }

    public static void main(String[] args) {

        EmployeeManagement ems = new EmployeeManagement(10);

        ems.addEmployee(new Employee(101, "Rimjhim", "Developer", 50000));
        ems.addEmployee(new Employee(102, "Aman", "Tester", 40000));
        ems.addEmployee(new Employee(103, "Priya", "Manager", 70000));

        ems.displayEmployees();

        System.out.println("\nSearching Employee ID 102:");
        Employee employee = ems.searchEmployee(102);

        if (employee != null) {
            System.out.println(employee);
        } else {
            System.out.println("Employee not found.");
        }

        ems.deleteEmployee(102);

        ems.displayEmployees();
    }
}