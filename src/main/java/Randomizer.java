import java.util.Random;
import java.util.Scanner;

public class Randomizer {
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);

    public void run() {
        System.out.println("Enter minimum value:");
        int min = scanner.nextInt();
        System.out.println("Enter maximum value:");
        int max = scanner.nextInt();
        if (min < 1 || max > 500 || max < min) {
            throw new IllegalArgumentException("Incorrect value! Correct value [1 - 500] and minimum value should be less than maximum value.");
        }

        int[] array = new int[max - min + 1];
        int count = 0;

        String operation;
        while (true) {
            operation = scanner.nextLine();
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
            } else if (operation.equalsIgnoreCase("help")) {
                help();
            } else if (operation.equalsIgnoreCase("generate")) {
                if (array.length == count) {
                    System.out.println("All unique numbers are over! Bye!");
                    System.exit(0);
                }
                generate(min, max, array);
                count++;
            } else {
                System.out.println("Please use \"help\" to find out more information about the app.");
            }
            System.out.println("Enter operation");

        }
    }

    public void generate(int min, int max, int[] array) {
        while (true) {
            int randomValue = random.nextInt(max + 1 - min) + min;
            if (array[randomValue - min] == 0) {
                array[randomValue - min] = randomValue;
                System.out.println(randomValue);
                break;
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
        System.out.println("First command it is \"generate\".");
        System.out.println("When You select \"generate\" the program generate random number from the given range.");
        System.out.println("Second command \"exit\" completes the process of executing the program.");
        System.out.println("The last command \"help\" show all information about the program.");
    }
}