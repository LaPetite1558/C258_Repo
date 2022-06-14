package WeekOne;/*
1) WAP to print below patterns using any loop of your choice
******
*****
****
***
**
*
2) Same as above but backwards
3) Print Christmas Tree
   *
  ***
 *****
*******
   **
   **
4) WAP to filter even numbers from [2,3,55,65,42,67]
5) WAP to filter out even and odd numbers from array of numbers from 1 to 50 using function,
input one array,
output two array.
6) WAP to perform sorting of below array [2,34,56,12,34,1,5]
using function both in ascending and descending order one by one.
Input one array and output two array.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static java.lang.System.out;

public class Lab2 {
    // Program 1
    /*
    Takes int n as input
    Prints stars in a decrementing loop starting from n and ending with 1
     */
    public static void printDown(int n) {
        for (int i = n; i > 0; i--) {
            for (int j = 1; j <= i; j++) {
                out.print("*");
            }
            out.print("\n");
        }
    }

    // Program 2
    /*
    Takes int n as input
    Prints stars in an incrementing loop starting from 1 and ending with n
     */
    public static void printUp(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                out.print("*");
            }
            out.print("\n");
        }
    }

    // Program 3
    /*
    Prints 4 layers of stars in incrementing odd numbers starting from 1 and ending at 7
    After printing layers, prints two lines of 3 stars
     */
    public static void printTree() {
        for (int i = 1; i <= 7; i++) {
            if (i%2 != 0) {
                for (int j = 3; j >= i-j; j--) {
                    out.print(" ");
                }
                for (int k = 0; k < i; k++) {
                    out.print("*");
                }
                out.print("\n");
            }
        }
        for (int i = 0; i < 2; i++) {
            out.println("  " + "***");
        }
    }

    // Program 4
    /*
    Takes input of int array
    Instantiate 2 Integer ArrayLists
    Iterates through int array
        - if array element is even, add to even number ArrayList
        - if array element is not even, add to odd number ArrayList
    Add even and odd number ArrayLists to List
    Returns a List of 2 Integer ArrayLists
     */
    public static List<?>[] evenOdds(int[] arr) {
        List<Integer> evens = new ArrayList<>();
        List<Integer> odds = new ArrayList<>();

        for (int a : arr) {
            if (a%2 == 0) {
                evens.add(a);
            } else odds.add(a);
        }
        List<?>[] result = new List[2];
        result[0] = evens;
        result[1] = odds;
        return result;
    }

    // Program 5
    /*
    Takes input of int array
    Instantiate 1 Integer ArrayList
    Iterates through int array
        - if array element is even, add to ArrayList
    Returns 1 Integer ArrauList
     */
    public static List<Integer> getEven(int[] arr) {
        List<Integer> evens = new ArrayList<>();

        for (int a : arr) {
            if (a%2 == 0) {
                evens.add(a);
            }
        }
        return evens;
    }

    // Program 6
    /*
    Takes input of Integer array
    Instantiate two Integer ArrayLists
    Sort ascending Integer ArrayList in default ascending order
    Sort descending Integer ArrayList in reverse order
    Add ascending and descending ArrayLists to List
    Returns a List of two Integer ArrayLists
     */
    public static List<?>[] sortArr(Integer[] arr) {
        List<Integer> ascending = new ArrayList<>(Arrays.asList(arr));
        List<Integer> descending = new ArrayList<>(Arrays.asList(arr));

        Collections.sort(ascending);
        descending.sort(Collections.reverseOrder());

        List<?>[] result = new List[2];
        result[0] = ascending;
        result[1] = descending;

        return result;
    }

    public static void insertionSort(Integer[] arr) {
        List<Integer> ascending = new ArrayList<>(Arrays.asList(arr));
        List<Integer> descending = new ArrayList<>(Arrays.asList(arr));
        int n = arr.length;

        // ascending
        for (int i = 0; i < n; i++) {
            int curr = ascending.get(i);
            int j = i-1;

            while (j >= 0 && ascending.get(j) > curr) {
                int prev = ascending.get(j);
                ascending.set(j+1, prev);
                j -= 1;
            } ascending.set(j+1, curr);
        }
        out.println(ascending);

        // descending
        for (int i = 0; i < n; i++) {
            int curr = descending.get(i);
            int j = i-1;

            while (j >= 0 && descending.get(j) < curr) {
                int prev = descending.get(j);
                descending.set(j+1, prev);
                j -= 1;
            } descending.set(j+1, curr);
        }
        out.println(descending);

    }

//    public static void bubbleSort(Integer[] arr) {
//
//        // ascending
//        for (int i = 0; i < arr.length - 1; i++) {
//            for (int j = 0; j < arr.length - i - 1; j++) {
//                if (arr[j] > arr[j+1]) {
//                    int e = arr[j];
//                    arr[j] = arr[j+1];
//                    arr[j+1] = e;
//                }
//            }
//        }
//
//        List<Integer> ascending = new ArrayList<>(Arrays.asList(arr));
//        out.println(ascending);
//
//        // descending
//        for (int i = 0; i < arr.length - 1; i++) {
//            for (int j = 0; j < arr.length - i - 1; j++) {
//                if (arr[j] < arr[j+1]) {
//                    int e = arr[j];
//                    arr[j] = arr[j+1];
//                    arr[j+1] = e;
//                }
//            }
//        }
//
//        List<Integer> descending = new ArrayList<>(Arrays.asList(arr));
//        out.println(descending);
//    }

    public static void main(String[] args) {

        out.println("---Program 1---");
        printDown(6);
        out.print("\n\n");

        out.println("---Program 2---");
        printUp(6);
        out.print("\n\n");

        out.println("---Program 3---");
        printTree();
        out.print("\n\n");

        int[] numbers = {2,3,55,65,42,67};

        List<Integer> evens = getEven(numbers);
        out.println("---Program 4---");
        out.println(evens);
        out.print("\n\n");

        List<?>[] evenOdds = evenOdds(numbers);
        out.println("---Program 5---");
        out.println("Even numbers: " + evenOdds[0]);
        out.println("Odd numbers: " + evenOdds[1]);
        out.print("\n\n");

        Integer[] arr = {2,34,56,12,34,1,5};
        List<?>[] sorted = sortArr(arr);
        out.println("---Program 6---");
        out.println("Ascending: " + sorted[0]);
        out.println("Descending: " + sorted[1]);
        out.print("\n\n");

        insertionSort(arr);

        // only works in java 18
//        for (int i = 5; i > 0; i--) {
//            out.println("*".repeat(i));
//        }
//
//        for (int i = 1; i < 6; i++) {
//            out.println("*".repeat(i));
//        }
    }
}