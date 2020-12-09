import java.util.Random;
import java.util.Scanner;

public class Randomizer {
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);

    public void randomizer() {
        System.out.println("Enter min value:");
        int min = scanner.nextInt();
        System.out.println("Enter max value:");
        int max = scanner.nextInt();
        int[] array = new int[max - min + 1];
        int count = 0;
        if (min < 1 || max > 499 || min > max) {
            throw new IllegalArgumentException("Incorrect value! Correct value [1 - 500]");
        }

        while (true) {

            String operation = scanner.nextLine();
            if (operation.equalsIgnoreCase("exit")) {
                System.out.println("Are you sure that you want to quit the app?");
                String exitQuestion = scanner.nextLine();
                if (exitQuestion.equalsIgnoreCase("yes")) {
                    System.exit(0);
                } else if (exitQuestion.equalsIgnoreCase("no")) {
                    System.out.println("Select operation: ");
                    continue;
                } else {
                    System.out.println("Your response incorrect!");
                    System.out.println("Select operation:");
                    continue;
                }
            }  if (operation.equalsIgnoreCase("help")) {
                help();
            }
                if (operation.equalsIgnoreCase("generate")) {
                if (array.length -1 == count) {
                    System.out.println("All unique numbers are over! Bye!");
                    System.exit(0);
                }
                    while (true) {
                        int randomValue = (random.nextInt(max - min) + 1) + min;
                        if (array[randomValue - min] == 0) {
                            array[randomValue - min] = randomValue;
                            System.out.println(randomValue);
                            count++;
                            break;
                        }
                    }
                }

            }
        }
    public void help() {
        System.out.println("This is a console application.");
        System.out.println("In witch You can set range of random numbers.");
        System.out.println("And it outputs a random number within a given range.");
        System.out.println("The minimum start number of the range must be greater than or equal to 1.");
        System.out.println("The maximum number must be less than or equal to 500.");
        System.out.println("Floating point numbers are prohibited.");
        System.out.println("You have 3 commands.");
        System.out.println("First command it is 'generate'.");
        System.out.println("When You select 'generate' the program generate random number from the given range.");
        System.out.println("Second command 'exit' completes the process of executing the program.");
        System.out.println("The last command 'help' show all information about the program.");
    }
}
