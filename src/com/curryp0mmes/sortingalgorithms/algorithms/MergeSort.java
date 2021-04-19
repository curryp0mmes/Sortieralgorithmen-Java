package com.curryp0mmes.sortingalgorithms.algorithms;

import com.curryp0mmes.sortingalgorithms.algorithms.template.Algorithm;
import com.curryp0mmes.sortingalgorithms.algorithms.template.SortingResult;

public class MergeSort implements Algorithm {
    private int tauschaufwand = 0;
    private int vergleiche = 0;
    private int schleifendurchlaeufe = 0;

    @Override
    public SortingResult sort(char[] inputArray) {
        tauschaufwand = 0;
        vergleiche = 0;
        schleifendurchlaeufe = 0;

        char outputArray[] = mergeSort(inputArray, 0, inputArray.length-1);

        return new SortingResult(outputArray, schleifendurchlaeufe, vergleiche, tauschaufwand);
    }

    private char[] mergeSort(char[] arr, int from, int to) {
        schleifendurchlaeufe++;
        vergleiche++;
        if(from < to) {
            int half = (from + to) / 2;
            arr = mergeSort(arr, from, half);
            arr = mergeSort(arr,half + 1, to);
            return merge(arr, from, half+1, to);
        }
        return arr;
    }


    private char[] merge(char[] arr, int from, int middle, int end) {
        char output[] = arr.clone();

        int pos = from;
        int posL = from;
        int posR = middle;
        while(posL < middle && posR <= end) {
            vergleiche += 2;
            if(arr[posL] < arr[posR]) {
                output[pos] = arr[posL];
                tauschaufwand++;
                posL++;
                pos++;
            }
            else{
                output[pos] = arr[posR];
                tauschaufwand++;
                posR++;
                pos++;
            }
            vergleiche++;
        }
        for(int i = posL; i < middle; i++) {
            output[pos] = arr[i];
            pos++;
        }
        for(int i = posR; i <= end; i++) {
            output[pos] = arr[i];
            pos++;
        }
        return output;
    }
}
