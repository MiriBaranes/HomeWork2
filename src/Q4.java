import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {
        int[] fullArray = fullArrayFilling();
        printArr(fullArray);
        System.out.println();//new line
        int[] arrayWithoutRepetitions = arrayWithoutRepetitions(fullArray);
        System.out.println("Array without repetitions:  ");
        printArr(arrayWithoutRepetitions);
    }

    public static int[] fullArrayFilling (){
        Scanner scanner= new Scanner(System.in);
        int size;
        int value;
        do {
            System.out.println("Enter array size : ");
            size= scanner.nextInt();
        }
        while (size<0);
        int [] fullArray = new  int[size];
        for (int i = 0; i<fullArray.length; i++ ){
            System.out.println("Enter a value : ");
            value= scanner.nextInt();
            fullArray[i]=value;
        }
        return fullArray;
    }
    public static int determineDistincterArraySize(int[] arr) {
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    counter++;
                    break;
                }
            }
        }
        return counter;
    }

    public static boolean isExistsNumInTheArray(int numToCheck, int[] arr) {
        boolean result = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == numToCheck) {
                result = true;
                break;
            }
        }
        return result;
    }


    public static int[] arrayWithoutRepetitions(int[] arr) {
        int[] newArrayWithoutRepetitions = new int[arr.length - determineDistincterArraySize(arr)];
        int newArrIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!isExistsNumInTheArray(arr[i], newArrayWithoutRepetitions)) {
                newArrayWithoutRepetitions[newArrIndex] = arr[i];
                newArrIndex++;
            }
        }
        return newArrayWithoutRepetitions;
    }

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }

    }


}
