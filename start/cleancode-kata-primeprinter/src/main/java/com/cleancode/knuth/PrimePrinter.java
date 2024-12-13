package com.cleancode.knuth;

public class PrimePrinter {

    private static final int MAX_PRIMES = 1000;
    private static final int ROWS_PER_PAGE = 50;
    private static final int COLUMNS_PER_PAGE = 4;
    private static final int MAX_ORDER = 30;

    public static void main(String[] args) {
        // Création d'une instance de PrimePrinterHelper pour générer les nombres premiers
        PrimePrinterHelper helper = new PrimePrinterHelper();
        int[] primes = new int[MAX_PRIMES + 1];
        int[] multiples = new int[MAX_ORDER + 1];

        // Appel à la méthode pour générer les nombres premiers
        helper.generatePrimes(MAX_PRIMES, ROWS_PER_PAGE, COLUMNS_PER_PAGE, MAX_ORDER, primes, multiples);

        // Création d'une instance de PrimePrinter pour imprimer les résultats
        PrimePrinter printer = new PrimePrinter();
        printer.printPrimes(primes, MAX_PRIMES);
    }

    public void printPrimes(int[] primes, int maxPrimes) {
        // Logique pour afficher les nombres premiers par page
        int pageNumber = 1;
        int pageOffset = 1;

        while (pageOffset <= maxPrimes) {
            System.out.print("The First ");
            System.out.print(Integer.toString(maxPrimes));
            System.out.print(" Prime Numbers === Page ");
            System.out.print(Integer.toString(pageNumber));
            System.out.println("\n");

            for (int rowOffset = pageOffset; rowOffset <= pageOffset + ROWS_PER_PAGE - 1; rowOffset++) {
                for (int col = 0; col <= COLUMNS_PER_PAGE - 1; col++) {
                    if (rowOffset + col * ROWS_PER_PAGE <= maxPrimes)
                        System.out.printf("%10d", primes[rowOffset + col * ROWS_PER_PAGE]);
                }
                System.out.println();
            }
            System.out.println("\f");  // saut de page
            pageNumber++;
            pageOffset += ROWS_PER_PAGE * COLUMNS_PER_PAGE;
        }
    }
}
