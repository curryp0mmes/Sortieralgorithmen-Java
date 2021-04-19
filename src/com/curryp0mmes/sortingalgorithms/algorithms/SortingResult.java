package com.curryp0mmes.sortingalgorithms.algorithms;

public class SortingResult {

    SortingResult(char[] outputArray, int schleifendurchläufe, int vergleiche, int tauschaufwand) {
        this.schleifendurchläufe = schleifendurchläufe;
        this.vergleiche = vergleiche;
        this.tauschaufwand = tauschaufwand;
        this.array = outputArray;
    }

    SortingResult(char[] outputArray) {
        this.array = outputArray;
    }

    public int getSchleifendurchläufe() {
        return schleifendurchläufe;
    }

    public int getVergleiche() {
        return vergleiche;
    }

    public int getTauschaufwand() {
        return tauschaufwand;
    }

    public char[] getArray() {
        return array;
    }

    int schleifendurchläufe = 0;
    int vergleiche = 0;
    int tauschaufwand = 0;
    char[] array = null;
}
