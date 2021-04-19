package com.curryp0mmes.sortingalgorithms.algorithms.template;

public class SortingResult {

    public SortingResult(char[] outputArray, int schleifendurchlaeufe, int vergleiche, int tauschaufwand) {
        this.schleifendurchlaeufe = schleifendurchlaeufe;
        this.vergleiche = vergleiche;
        this.tauschaufwand = tauschaufwand;
        this.array = outputArray;
    }

    public int getSchleifendurchlaeufe() {
        return schleifendurchlaeufe;
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

    int schleifendurchlaeufe;
    int vergleiche;
    int tauschaufwand;
    char[] array;
}
