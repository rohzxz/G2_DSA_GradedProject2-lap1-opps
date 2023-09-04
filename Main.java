import java.util.Random;
import java.util.Scanner;

class Employee {

    private String firstName;
    private String lastName;
    private String emailAddress;
    private String password;

    public Employee(String firstName, String lastName, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = CredentialService.generateEmailAddress(firstName, lastName, department);
        this.password = CredentialService.generatePassword();
    }

    public void displayCredentials() {
        System.out.println("Dear " + firstName + ", your generated credentials are as follows:");
        System.out.println("Email ---> " + emailAddress);
        System.out.println("Password ---> " + password);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the department from the following:");
        System.out.println("1. Technical");
        System.out.println("2. Admin");
        System.out.println("3. Human Resources");
        System.out.println("4. Legal");

        int departmentChoice = scanner.nextInt();
        String department;

        switch (departmentChoice) {
            case 1:
                department = "Technical";
                break;
            case 2:
                department = "Admin";
                break;
            case 3:
                department = "Human Resource";
                break;
            case 4:
                department = "Legal";
                break;
            default:
                System.out.println("Invalid department choice. Defaulting to 'Technical'.");
                department = "Technical";
        }

        Employee employee = new Employee("Harshit", "Choudary", department);
        employee.displayCredentials();

        scanner.close();
    }
}

class CredentialService {

    private static Random random = new Random();

    public static String generatePassword() {
        StringBuilder password = new StringBuilder();
        password.append(randomDigit());
        password.append(randomChar('A', 'Z'));
        password.append(randomChar('a', 'z'));
        password.append(randomChar('!', '@'));
        password.append(randomChar('A', 'Z')); // Adding one more capital letter for complexity
        return password.toString();
    }

    public static String generateEmailAddress(String firstName, String lastName, String department) {
        return String.format("%s%s@%s.company.com", firstName.toLowerCase(), lastName.toLowerCase(),
                department.toLowerCase());
    }

    private static char randomChar(char from, char to) {
        int range = to - from + 1;
        return (char) (from + random.nextInt(range));
    }

    private static int randomDigit() {
        return random.nextInt(10);
    }
}
