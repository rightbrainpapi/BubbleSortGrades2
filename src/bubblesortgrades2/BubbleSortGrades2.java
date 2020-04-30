/**
 *
 * @author Darnell Simon
 * @since 4.28.2020
 *
 * This program bubble sorts two columns by based on the grade String.
 *
 *
 *
 */
package bubblesortgrades2;

import java.io.File;
import java.util.Scanner;

public class BubbleSortGrades2 {

    public static void main(String[] args) throws Exception {
        final int MAXNUMBER = 100;

        int count;
        int[] id = new int[MAXNUMBER];
        String[] grade = new String[MAXNUMBER];

        count = populateArray(id, grade);
        bubbleSort(id, grade, count);

        System.out.println("ID\tGRADE");
        for (int i = 0; i < count; i++) {
            System.out.printf("%d\t%s\n", id[i], grade[i]);
        }
    } // end main

    //////////////////////////////
    ////////Populate Array////////
    //////////////////////////////
    public static int populateArray(int[] id, String[] grade) throws Exception {
        Scanner sc = new Scanner(new File("BubbleSortGrades.txt"));
        int count = 0;
        while (sc.hasNext()) {
            //does the line stat with a letter?
            id[count] = sc.nextInt();
            grade[count] = sc.next();
            count++;
        }
        return count;
    } // end populateArray

    /////////////////////////////////
    ////////Bubble Sort Array////////
    ///////////////////////////////// 
    public static void bubbleSort(int[] id, String[] grade, int n) {
        int hold, j, pass;
        String temp;
        boolean switched = true;
        for (pass = 0; pass < n - 1 && switched; pass++) {
            // outer loop controles the number of passes
            switched = false; // initially no interchanges have been // made one this pass
            for (j = 0; j < n - pass - 1; j++) {
                // inner loop governs each individual pass
                if (grade[j].compareToIgnoreCase(grade[j + 1]) > 0) { // is grade[j] larger than grade[j+1]
                    // elements are out of order an interhcange is necessary 
                    switched = true;
                    hold = id[j];
                    id[j] = id[j + 1];
                    id[j + 1] = hold;
                    //changing the second column Grade
                    temp = grade[j];
                    grade[j] = grade[j + 1];
                    grade[j + 1] = temp;
                } // end if
            } // end for (j = 0 ...
        }//endfor(pass=0... } // end bubbleSort method
    } // end BubbleSort class

}
