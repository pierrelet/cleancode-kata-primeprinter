package com.cleancode.knuth;

public class PrimePrinterHelper {

    public void generatePrimes(int maxPrimes, int rowsPerPage, int columnsPerPage, int maxOrder, int[] primes, int[] multiples) {
        int j = 1;
        int k = 1;
        primes[1] = 2;
        int ord = 2;
        int square = 9;

        while (k < maxPrimes) {
            do {
                j += 2;
                if (j == square) {
                    ord++;
                    square = primes[ord] * primes[ord];
                    multiples[ord - 1] = j;
                }
                int n = 2;
                boolean jPrime = true;
                while (n < ord && jPrime) {
                    while (multiples[n] < j)
                        multiples[n] += primes[n] + primes[n];
                    if (multiples[n] == j)
                        jPrime = false;
                    n++;
                }
                if (jPrime) {
                    k++;
                    primes[k] = j;
                }
            } while (!isPrime(j, multiples, ord));
        }
    }

    private boolean isPrime(int j, int[] multiples, int ord) {
        for (int n = 2; n < ord; n++) {
            if (multiples[n] == j)
                return false;
        }
        return true;
    }
}
