import java.util.Scanner;

public class Q5 {
    public static final int FINISH = -1;
        public static void main(String[] args) {
            int [] array = fillingAnArrayWithValues();
            int topIndex = topIndex(array);
            System.out.println("the index summit is : " + topIndex);
        }
            public static int [] fillingAnArrayWithValues(){

            Scanner scanner = new Scanner(System.in);
            int size;
            do {
                System.out.println("Enter a size : ");
                size = scanner.nextInt();
            }
            while (size<0);

            int[] array = new int[size];
            for (int i = 0; i < array.length; i++) {
                System.out.println("Enter a value :");
                int value = scanner.nextInt();
                array[i] = value;
            }
            return array;
        }

        public static int topIndex (int [] array){
            int topIndex =0;
            for (int i = 0; i < array.length-1; i++){
                if (array[i] > array[i+1] && i!=0 ){
                    topIndex = i;
                    if (topIndex==array.length-1){
                        topIndex=FINISH;
                    }
                    break;
                }
                else if (array[i] >= array[i+1] && i==0){
                    topIndex=FINISH;
                    break;
                }
                else{
                    topIndex=FINISH;
                }
            }
            if (topIndex!=FINISH){
                for (int i =topIndex+1 ; i <array.length-1; i++){
                    if (array[i] < array[i+1]){
                        topIndex=FINISH;
                        break;
                    }
                }
            }
            return topIndex;
        }
    }
