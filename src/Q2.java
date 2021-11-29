import java.util.Scanner;

public class Q2 {
    public static final int ARRAY_SIZE = 10;

    public static void main(String[] args) {
        int[] arr = new int[ARRAY_SIZE];
        printNumbersBiggerThanAverage(arr);
    }

    public static void printNumbersBiggerThanAverage(int[] arr) {
        Scanner scanner = new Scanner(System.in);
        double sum = 0; /// double for the average calculation
        double average;
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Enter number");
            arr[i] = scanner.nextInt();
            sum = arr[i] + sum;
        }
        average = sum / arr.length;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > average) {
                System.out.print(arr[i] + ",");
            }
        }
    }


}

