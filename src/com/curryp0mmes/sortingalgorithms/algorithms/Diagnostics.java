package com.curryp0mmes.sortingalgorithms.algorithms;

public class Diagnostics {
    Diagnostics(int aufwand1, int aufwand2, int tauschaufwand) {
        this.aufwand1 = aufwand1;
        this.aufwand2 = aufwand2;
        this.tauschaufwand = tauschaufwand;
    }
    Diagnostics(int aufwand1, int aufwand2, int tauschaufwand, int[] outputArray) {
        this.aufwand1 = aufwand1;
        this.aufwand2 = aufwand2;
        this.tauschaufwand = tauschaufwand;
        this.output = outputArray;
    }

    int aufwand1 = 0;
    int aufwand2 = 0;
    int tauschaufwand = 0;
    int[] output = null;
}
