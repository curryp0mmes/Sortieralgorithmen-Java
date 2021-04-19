package com.curryp0mmes.sortingalgorithms.algorithms;

import com.curryp0mmes.sortingalgorithms.algorithms.template.Algorithm;
import com.curryp0mmes.sortingalgorithms.algorithms.template.SortingResult;

public class BubbleSort implements Algorithm {
    @Override
    public SortingResult sort(char[] inputArray) {
        int tauschaufwand = 0;
        int vergleiche = 0;
        int schleifendurchlaeufe = 0;

        for(int laenge = inputArray.length; laenge > 0; laenge--) {
            boolean swapped = false;
            for(int i = 0; i < laenge - 1; i++) {
                schleifendurchlaeufe++;
                vergleiche++;
                if(inputArray[i] > inputArray[i+1])
                {
                    char uebertrag = inputArray[i];
                    inputArray[i] = inputArray[i+1];
                    inputArray[i+1] = uebertrag;
                    swapped = true;
                    tauschaufwand++;
                }
            }
            if(!swapped) {
                break;
            }
        }
        return new SortingResult(inputArray, schleifendurchlaeufe, vergleiche, tauschaufwand);
    }
}
