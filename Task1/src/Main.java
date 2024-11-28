import java.util.Scanner;

public class Main {

    // Method to calculate the factorial of a number
    static long factorial(int number) {
        long res = 1;
        for (int i = 2; i <= number; i++)
            res *= i;
        return res;
    }

    // Method to calculate the result using the formula:
    // C(n) = (2n)! / [(n+1)! * n!] where is:
    // "2n" is number of brackets
    // "(n + 1)" is corresponds to a correction to take only the correct paths of  "opened" brackets
    // "n" is number of "closed" brackets
    static long giveResult(int n) {
        return factorial(2 * n) / (factorial(n + 1) * factorial(n));
    }


    // Uncomment this method to create a table of results for the first 10 values
    /*
    static void createTableOfFirstTenResults() {
        System.out.println("Number of brackets | Result");
        System.out.println("-----------------------------");
        for (int i = 1; i <= 10; i++) { // Loop from 1 to 10
            System.out.printf("%18d | %6d%n", i, giveResult(i)); // Display the result for each value of n
        }
    }
    */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of brackets : ");
        int n = sc.nextInt();

        if (n >= 0) {
            System.out.println("Result: " + giveResult(n));

            // Uncomment the line below to display a table of results for the first 10 values
            // createTableOfFirstTenResults();
        } else {
            System.out.println("Number of brackets must be greater than or equal to 0");
        }
    }
}
