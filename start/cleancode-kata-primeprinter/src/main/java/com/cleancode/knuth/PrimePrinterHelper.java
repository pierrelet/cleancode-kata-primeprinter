package com.cleancode.knuth;

public class PrimePrinterHelper {

    public void generatePrimes(int maxPrimes, int rowsPerPage, int columnsPerPage, int maxOrder, int[] numbers, int[] multiples) {
        int j = 1;
        int k = 1;
        numbers[1] = 2;
        int ord = 2;
        int square = 9;

        while (k < maxPrimes) {
            do {
                j += 2;
                if (j == square) {
                    ord++;
                    square = numbers[ord] * numbers[ord];
                    multiples[ord - 1] = j;
                }
                int n = 2;
                boolean isPrime = true;
                while (n < ord && isPrime) {
                    while (multiples[n] < j) {
                        multiples[n] += numbers[n] + numbers[n];
                    }
                    if (multiples[n] == j) {
                        isPrime = false;
                    }
                    n++;
                }
                if (isPrime) {
                    k++;
                    numbers[k] = j;
                }
            } while (j < maxPrimes);
        }
    }
}
