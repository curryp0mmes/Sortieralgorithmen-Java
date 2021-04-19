package com.curryp0mmes.sortingalgorithms.algorithms;

import com.curryp0mmes.sortingalgorithms.algorithms.template.Algorithm;
import com.curryp0mmes.sortingalgorithms.algorithms.template.SortingResult;

public class SelectionSort implements Algorithm {
    @Override
    public SortingResult sort(char[] inputArray) {
        int tauschaufwand = 0;
        int vergleiche = 0;
        int schleifendurchlaeufe = 0;

        for(int pos = 0; pos < inputArray.length; pos++) {
            int kleinster = pos;
            for(int i = pos + 1; i < inputArray.length; i++) {
                ++schleifendurchlaeufe;
                ++vergleiche;
                if(inputArray[i] < inputArray[kleinster]) kleinster = i;
            }
            if(kleinster != pos) {
                char uebertrag = inputArray[kleinster];
                inputArray[kleinster] = inputArray[pos];
                inputArray[pos] = uebertrag;
                tauschaufwand++;
            }

        }

        return new SortingResult(inputArray, schleifendurchlaeufe, vergleiche, tauschaufwand);
    }
}
