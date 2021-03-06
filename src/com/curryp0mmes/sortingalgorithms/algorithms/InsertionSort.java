package com.curryp0mmes.sortingalgorithms.algorithms;

import com.curryp0mmes.sortingalgorithms.algorithms.template.Algorithm;
import com.curryp0mmes.sortingalgorithms.algorithms.template.SortingResult;

public class InsertionSort implements Algorithm {
    @Override
    public SortingResult sort(char[] inputArray) {
        int tauschaufwand = 0;
        int vergleiche = 0;
        int schleifendurchlaeufe = 0;

        for(int pos = 1; pos < inputArray.length; pos++) {
            for(int i = pos; i > 0; i--) {
                vergleiche++;
                schleifendurchlaeufe++;
                if(inputArray[i-1] > inputArray[i])
                {
                    char uebertrag = inputArray[i];
                    inputArray[i] = inputArray[i-1];
                    inputArray[i-1] = uebertrag;
                    tauschaufwand++;
                }
            }
        }
        return new SortingResult(inputArray, schleifendurchlaeufe, vergleiche, tauschaufwand);
    }
}
