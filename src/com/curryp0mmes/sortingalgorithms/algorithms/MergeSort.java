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

    /**
     *
     * Ein Tauschaufwand entspricht, wenn nicht einfach nur das linke array und dann das rechte abgelesen wird.
     * Wenn sich also aus dem rechten Array bedient wird, bevor das linke leer ist, zählt es als tauschaufwand.
     *
     * @param arrL
     * @param arrR
     * @return  merged Array
     */

    private char[] merge(char[] arrL, char[] arrR) {
        char[] output = new char[arrL.length + arrR.length];
        int pos = 0;
        int posL = 0;
        int posR = 0;
        while(posL < arrL.length && posR < arrR.length) {   //2 vergleiche + 1 Schleifendurchlauf
            vergleiche+=2;
            schleifendurchlaeufe++;
            if(arrL[posL] < arrR[posR]) {   //1 vergleich
                output[pos] = arrL[posL];
                posL++;
            }
            else{
                output[pos] = arrR[posR];   //1 "tausch", da hier aus dem rechten bedient wird
                posR++;
                tauschaufwand++;
            }
            vergleiche++;
            pos++;
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
