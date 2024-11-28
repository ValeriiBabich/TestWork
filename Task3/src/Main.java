import java.math.BigInteger;

public class Main {

    // Method to calculate the sum of the digits of the factorial of a number
    static void sumOfFactorialDigits(int n){
        BigInteger factorial = BigInteger.ONE;

        // Calculate the factorial of n
        for (int i = 2; i <= n; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        String factorialStr = factorial.toString();
        int sumOfDigits = 0;

        // Iterate over each character in the string representation of the factorial
        for (char digit : factorialStr.toCharArray()) {
            sumOfDigits += Character.getNumericValue(digit);
        }


        System.out.println("Sum of " + n + "! digits = " + sumOfDigits);
    }

    public static void main(String[] args) {
        int n = 100;
        sumOfFactorialDigits(n);
    }
}
