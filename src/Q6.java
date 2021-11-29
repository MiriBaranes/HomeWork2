import java.util.Scanner;

public class Q6 {
    public static void main(String[] args) {
        int[] userInputArray1 = {20,30,40,50,30,12,14};
        int[] userInputArray2 = {11,12,13,20,30,10,30,10};
        int[] cuttingArray = newContainerArray(userInputArray1, userInputArray2);
        boolean foreignArrays = foreignArrays(userInputArray1, userInputArray2);
        System.out.println("Its foreign arrays ? " +foreignArrays);
            printArray(cuttingArray);
        }
    public static int[] fullArrayFilling (){ //// In case values need to be entered from the user
        Scanner scanner= new Scanner(System.in);
        int size;
        int value;
        do {
            System.out.println("Enter array size : ");
            size= scanner.nextInt();
        }
        while (size<0);
        int [] fullArray = new int [size];
        for (int i = 0; i<fullArray.length; i++ ){
            do {
                System.out.println("enter a value : ");
                value =  scanner.nextInt();
            }
            while (value < 10 || value >= 100 );
            fullArray[i]=value;
        }
        return fullArray;
    }

    public static int[] newContainerArray(int[] array1, int[] array2) {
        int[] newContainerArray = new int[array1.length];
        int index = 0;
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                for (int k = 0; k < newContainerArray.length; k++) {
                    if (array1[i] == array2[j] && array1[i] != newContainerArray[k] && k == index) {
                        newContainerArray[index] = array1[i];
                        index++;
                        break;
                    }
                    if (array1[i] == newContainerArray[k]) {
                        break;
                    }
                }
            }
        }
        int[] finalArray = new int[index];
        for (int i = 0; i < finalArray.length; i++) {
            finalArray[i] = newContainerArray[i];

        }
        return finalArray;
    }

    public static boolean foreignArrays(int[] array1UserInput, int[] array2UserInput) {
        boolean foreignArrays = false;
        int[] array = newContainerArray(array1UserInput, array2UserInput);
        if (array.length == 0) {
            foreignArrays = true;
        }
        return foreignArrays;
    }
    public static void printArray (int [] array){

        for (int i=0; i< array.length; i++){
            System.out.print(array[i] + " , ");
        }
    }
}