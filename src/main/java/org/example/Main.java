package org.example;

import java.util.Scanner;

/**
 * @author Ouahassoune
 **/
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int safeReportsCount = 0;
        int safeReportsCountafterdelete = 0;
        System.out.println("Entrez les rapports (une ligne par rapport). Tapez 'fin' pour arrêter.");
        while (scanner.hasNextLine()) {
            String reportLine = scanner.nextLine();
            if (reportLine.equalsIgnoreCase("fin")) {
                break;
            }
            if (Analyse_Rapport.rapportChecker(reportLine)) {
                safeReportsCount++;
            }
            if (Analyse_Rapport.rapportChecker2(reportLine)) {
                safeReportsCountafterdelete++;
            }
        }
        System.out.println("Nombre de rapports sûrs : " + safeReportsCount);
        System.out.println("Nombre de rapports sûrs apres suppression : " + safeReportsCountafterdelete);

        scanner.close();

    }
}