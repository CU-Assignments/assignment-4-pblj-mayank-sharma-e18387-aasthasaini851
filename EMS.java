//// Easy Level: Employee Management System
import java.util.*;

class Employee {
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getSalary() { return salary; }
    
    public void setName(String name) { this.name = name; }
    public void setSalary(double salary) { this.salary = salary; }
    
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Salary: " + salary;
    }
}

public class EmployeeManagement {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.println("1. Add Employee\n2. Update Employee\n3. Remove Employee\n4. Search Employee\n5. Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter ID, Name, Salary: ");
                    employees.add(new Employee(sc.nextInt(), sc.next(), sc.nextDouble()));
                    break;
                case 2:
                    System.out.print("Enter ID to update: ");
                    int updateId = sc.nextInt();
                    for (Employee e : employees) {
                        if (e.getId() == updateId) {
                            System.out.print("Enter new Name and Salary: ");
                            e.setName(sc.next());
                            e.setSalary(sc.nextDouble());
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter ID to remove: ");
                    int removeId = sc.nextInt();
                    employees.removeIf(e -> e.getId() == removeId);
                    break;
                case 4:
                    System.out.print("Enter ID to search: ");
                    int searchId = sc.nextInt();
                    for (Employee e : employees) {
                        if (e.getId() == searchId) System.out.println(e);
                    }
                    break;
                case 5:
                    sc.close();
                    return;
            }
        }
    }
}
