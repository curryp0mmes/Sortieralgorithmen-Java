package com.curryp0mmes.sortingalgorithms.algorithms;

public class BubbleSort implements Algorithm {


    @Override
    public SortingResult sort(char[] inputArray) {
        char outputArray[] = inputArray;


        for(int pos = 0; pos < inputArray.length; pos++) {
            for(int i = pos + 1; i <= inputArray.length; i++) {
                compare(a,b);

            }
            if(kleinster != pos) {
                char uebertrag = outputArray[kleinster];
                outputArray[kleinster] = outputArray[pos];
                outputArray[pos] = uebertrag;
            }

        }





        return new SortingResult(outputArray, 0, 0, 0);
    }
}
