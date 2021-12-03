import java.util.Scanner;
import java.util.Arrays;

//Week 8 assignment for Sean Millham
//This assignment is to preset the user with a menu of options
//it should let the user add a certain number of employees that they dictate 
//it should also allow the user to add new employee data, such as employee name, id number, and salary
//It then should allow the user to be able to recall each user input, then call specific information 
//it should also recall salaries and organize them based off of range
class Week8_Assignment {
    private static Scanner Week8Assignment;

    public static void main(String[] args) {
        Scanner Week8AUser = new Scanner(System.in);
        String EmployeeNames[] = {};
        // array for employee names
        int EmployeeIDNumbers[] = {};
        // array for employee ID numbers
        int EmployeeSalaries[] = {};
        //// array for employee salaries
        System.out.println("Welcome to the employee data storage system.");
        System.out.println("Would you like to make changes to the database? Please type 1 for yes, and 0 for no.");
        int User_Changes = Week8AUser.nextInt();
        System.out.println("Please choose from the selection below: ");
        // while loop that starts off the loop for the program
        while (User_Changes > 0) {
            System.out.println("1.) Enter new employee data." + "\n" + "2.) Recall all employee data" + "\n"
                    + "3.) Recall specific employee data" + "\n"
                    + "4.) Recall all salaries, then organize them by the dollar amount." + "\n" + "10.) Exit");
            int Employee_Info = Week8AUser.nextInt();
            if (Employee_Info == 1) {
                System.out.println("How many employee's are you processing data for? ");
                int User_Answer = Week8AUser.nextInt();
                // next while loop that allows for the uploading and adding of new employees.
                while (User_Answer > EmployeeNames.length) {
                    System.out.println("Please submit the employee's name: ");
                    String Names = Week8AUser.next();
                    EmployeeNames = Arrays.copyOf(EmployeeNames, EmployeeNames.length + 1);
                    EmployeeNames[EmployeeNames.length - 1] = Names;
                    System.out.println("Please submit the employee's ID number: ");
                    int ID = Week8AUser.nextInt();
                    EmployeeIDNumbers = Arrays.copyOf(EmployeeIDNumbers, EmployeeIDNumbers.length + 1);
                    EmployeeIDNumbers[EmployeeIDNumbers.length - 1] = ID;
                    System.out.println("Please submit the employee's salary: ");
                    int Salary = Week8AUser.nextInt();
                    EmployeeSalaries = Arrays.copyOf(EmployeeSalaries, EmployeeSalaries.length + 1);
                    EmployeeSalaries[EmployeeSalaries.length - 1] = Salary;
                }
            }
            // next if statement for recalling all personell currently employed
            if (Employee_Info == 2) {
                if (EmployeeNames.length > 0)
                    for (int EmployeeInfo = 0; EmployeeInfo < EmployeeNames.length; EmployeeInfo++) {
                        System.out.print("Employee name: " + (EmployeeNames[EmployeeInfo]) + "\n"
                                + "Employee ID number: " + (EmployeeIDNumbers[EmployeeInfo]) + "\n" + "Salary: "
                                + (EmployeeSalaries[EmployeeInfo]) + "\n");
                    }
            }
            if (EmployeeNames.length == 0) {
                System.out.println("Error: database is empty.");
            }
            // next if statement for looking up employees with their ID number
            if (Employee_Info == 3) {
                if (EmployeeNames.length > 0)
                    System.out.println("Please submit the employee ID number:");
                int Recall = Week8AUser.nextInt();
                int Recall1 = (Recall - 1);
                System.out.print("Employee: " + (EmployeeNames[Recall1]) + "\n" + "Salary: "
                        + (EmployeeSalaries[Recall1]) + "\n" + (EmployeeIDNumbers[Recall1]) + "\n");
            }
            if (EmployeeNames.length == 0) {
                System.out.println("Error: Database is empty.");
            }
            // next if statement for organizing salaries
            if (Employee_Info == 4) {
                if (EmployeeNames.length > 0)
                    System.out.println(Arrays.toString(EmployeeSalaries));
                Arrays.sort(EmployeeSalaries);
                System.out.println(Arrays.toString(EmployeeSalaries));
            }
            if (EmployeeNames.length == 0) {
                System.out.println("Error: Database is empty.");
            }
            // exit for program
            if (Employee_Info == 10) {
                break;
            }

        }

    }

}
