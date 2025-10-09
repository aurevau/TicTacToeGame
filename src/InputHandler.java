import java.util.Scanner;

public class InputHandler {

    public static Scanner input = new Scanner(System.in);

    public static String getString() {

        String userInput = input.nextLine();
        if (userInput.equalsIgnoreCase("quit")) {
            System.exit(0);
        }
        return userInput;
    }

    public static String getName() {
        String name;


        boolean validLength;
        boolean validInput;
        while (true) {
            name = input.nextLine().toUpperCase();

            if (name.equalsIgnoreCase("quit")) {
                System.exit(0);
            }
            validLength = name.length() >= 2;
            validInput = name.matches("[a-zA-Z]+");

            if (validLength && validInput) {
                break;
            }

            if (!validInput) {
                System.out.println("Invalid input, name cannot contain numbers! Try again: ");
            } else if (!validLength) {
                System.out.println("Invalid input, name must be longer! Try again: ");
            }
        }
        return name;
    }

    public static int getInt() {
        while (!input.hasNextInt()) {
            System.out.println("Invalid input. Please try again with a number!");
            input.nextLine();
        }

        int result = input.nextInt();
        input.nextLine();
        if (result == -1) {
            System.exit(0);
        }

        if (result < -1) {
            System.out.println("Negative numbers not allowed!");
        }
        return result;
    }
}
