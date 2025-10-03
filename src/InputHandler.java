import java.util.Scanner;
public class InputHandler {

    public static Scanner input = new Scanner(System.in);


    public static String getString(){
        return input.nextLine();
    }

    public static int getInt(){
        while(!input.hasNextInt()){
            System.out.println("Invalid input. Please try again with a number!");
            input.nextLine();
        }

        // Declare variable to be able to clear the scanner to not end up in a forever-loop
        int result = input.nextInt();
        input.nextLine();
        return result;
    }
}
