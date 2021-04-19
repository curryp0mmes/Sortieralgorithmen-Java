package com.curryp0mmes.sortingalgorithms.algorithms;

public class SelectionSort implements Algorithm {
    @Override
    public SortingResult sort(char[] inputArray) {
        char outputArray[] = inputArray;
        int tauschaufwand = 0;
        int vergleiche = 0;
        int schleifendurchlaeufe = 0;

        for(int pos = 0; pos < inputArray.length; pos++) {
            int kleinster = pos;
            for(int i = pos + 1; i < inputArray.length; i++) {
                ++schleifendurchlaeufe;
                ++vergleiche;
                if(outputArray[i] < outputArray[kleinster]) kleinster = i;
            }
            if(kleinster != pos) {
                char uebertrag = outputArray[kleinster];
                outputArray[kleinster] = outputArray[pos];
                outputArray[pos] = uebertrag;
                tauschaufwand++;
            }

        }

        return new SortingResult(outputArray, schleifendurchlaeufe, vergleiche, tauschaufwand);
    }
}
