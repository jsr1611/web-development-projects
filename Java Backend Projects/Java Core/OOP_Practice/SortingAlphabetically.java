package variables.OOP_Practice;

import java.util.Arrays;

public class SortingAlphabetically {

        public static boolean isAlphabetized(String[] groceryList) {
            for(int i=0; i < groceryList.length-1; i++){
                System.out.println(groceryList[i] + " ? " + groceryList[i+1]);
                if(groceryList[i].compareTo(groceryList[i+1]) > 0){
                    return false;
                }
            }
            return true;
        }

        public static String[] sorted(String[] arr, boolean asc){
            String[] result = new String[arr.length];
            if(asc){
                for(int i=0; i < arr.length; i++){
                    String smallest = arr[i];
                    for(int j=i+1; j < arr.length; j++){
                        if(smallest.compareTo(arr[j]) < 0){
                            smallest = arr[j];
                        }
                    }
                    result[i] = smallest;
                }
            }
            else {
                for(int i=0; i < arr.length; i++){
                    String biggest = arr[i];
                    for(int j=i+1; j < arr.length; j++){
                        if(biggest.compareTo(arr[j]) > 0){
                            biggest = arr[j];
                        }
                    }
                    result[i] = biggest;
                }
            }
            return result;
        }

        public static void main(String[] args) {
            // Below is a sample test case you can use to run your code.
            // Try playing around with different values in the array to test edge cases
            String[] groceryList = {"apples", "banana", "bananas", "chocolate"};
            System.out.println(Arrays.toString(groceryList));
            System.out.println(Arrays.toString(sorted(groceryList, true)));
        }

}


