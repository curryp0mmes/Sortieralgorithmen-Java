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

        char[] outputArray = mergeSort(inputArray);

        return new SortingResult(outputArray, schleifendurchlaeufe, vergleiche, tauschaufwand);
    }

    private char[] mergeSort(char[] arr) {
        schleifendurchlaeufe++;
        vergleiche++;
        if(arr.length > 1) {
            int half = arr.length / 2;

            char[] arrL = new char[half];
            for(int i = 0; i < half; i++) {
                arrL[i] = arr[i];
            }

            char[] arrR = new char[arr.length - half];
            for (int i = half; i < arr.length;i++) {
                arrR[i-half] = arr[i];
            }

            arrL = mergeSort(arrL);
            arrR = mergeSort(arrR);
            char[] output = merge(arrL, arrR);
            return output;
        }
        return arr;
    }

    private char[] merge(char[] arrL, char[] arrR) {
        char[] output = new char[arrL.length + arrR.length];

        int pos = 0;
        int posL = 0;
        int posR = 0;
        while(posL < arrL.length && posR < arrR.length) {
            if(arrL[posL] < arrR[posR]) {
                output[pos] = arrL[posL];
                posL++;
            }
            else{
                output[pos] = arrR[posR];
                posR++;
            }
            pos++;
            tauschaufwand++;
            vergleiche++;
        }
        for(int i = posL; i < arrL.length; i++) {
            output[pos] = arrL[i];
            pos++;
        }
        for(int i = posR; i < arrR.length; i++) {
            output[pos] = arrR[i];
            pos++;
        }
        return output;
    }
}
