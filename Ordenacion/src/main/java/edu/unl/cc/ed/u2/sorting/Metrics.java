package edu.unl.cc.ed.u2.sorting;
/**
 * @author Steeven Pardo, Darwin Correa
 * Clase auxiliar para instrumentar algoritmos de ordenación
 * Incluye instrumentación: comparaciones, movimientos y tiempo de ejecución.
 */
public class Metrics {
    private long comparisons;
    private long swaps;
    private long startTime;
    private long endTime;
    private long timeNs;

    public void reset() {
        comparisons = 0;
        swaps = 0;
        startTime = 0;
        endTime = 0;
    }

    public void addComparison() {
        comparisons++;
    }

    public void addSwap() {
        swaps++;
    }

    public void startTimer() {
        startTime = System.nanoTime();
    }

    public void stopTimer() {
        endTime = System.nanoTime();
    }

    public long getComparisons() {
        return comparisons;
    }

    public long getSwaps() {
        return swaps;
    }

    public long getElapsedTime() {
        return endTime - startTime;
    }

    public long getTimeNs() {
        return timeNs;
    }

    public void setTimeNs(long timeNs) {
        this.timeNs = timeNs;
    }

    public void setTime(long l) {
        this.timeNs = l;
    }

    @Override
    public String toString() {
        return "Comparisons: " + comparisons +
                ", Swaps: " + swaps +
                ", Time(ns): " + getElapsedTime();
    }
}