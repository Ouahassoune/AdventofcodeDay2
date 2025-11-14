package org.example;


import java.util.ArrayList;
import java.util.TreeSet;

/**
 * @author Ouahassoune
 **/
public class Analyse_Rapport {

    public static boolean rapportChecker(String reportLine){

        if(!reportLine.isBlank()){

         String trimmedReportLine = reportLine.trim();
         String[] splittedReportLine = trimmedReportLine.split(" ");

         int [] rapportLine = new int[splittedReportLine.length];
         boolean rapportcroissant = true;
         boolean rapportdecroissant = true;

         // Convertir chaque niveau de String a Integer
         for(int i = 0; i < splittedReportLine.length; i++){
             rapportLine[i] = Integer.parseInt(splittedReportLine[i]);
         }

        // Je Teste les différences entre les niveaux
        for(int i=0; i < rapportLine.length - 1; i++){

            int difference_niveau = Math.abs(rapportLine[i] - rapportLine[i+1]);

            if(!(difference_niveau > 0 && difference_niveau < 4)){
                return false;
            }
        }

        //Je Vérifie si croissante ou décroissante
        for(int i=0; i < rapportLine.length -1; i++){
         if(rapportLine[i] > rapportLine[i+1]){
             rapportcroissant = false;
             break;
         }
        }
        for(int i=0; i < rapportLine.length- 1; i++){
            if(rapportLine[i] < rapportLine[i+1]){
                rapportdecroissant = false;
                break;
            }
        }


            return rapportcroissant || rapportdecroissant;
        }

        return false;

    }

    public static boolean rapportChecker2(String reportLine){
        if(!reportLine.isBlank()){
           if(!rapportChecker(reportLine)){
               String trimmedReportLine = reportLine.trim();
               String[] splittedReportLine = trimmedReportLine.split(" ");

               ArrayList<Integer> rapportLine = new ArrayList<>();

               // Convertir chaque niveau de String a Integer
               for (String s : splittedReportLine) {
                   rapportLine.add(Integer.parseInt(s));
               }

               for(int i=0; i < rapportLine.size(); i++){
                   ArrayList<Integer> modifiedReport = new ArrayList<>(rapportLine);
                   modifiedReport.remove(i);

                   StringBuilder modifiedReportLine = new StringBuilder();
                   for (Integer num : modifiedReport) {
                       modifiedReportLine.append(num).append(" ");
                   }

                   if (rapportChecker(modifiedReportLine.toString().trim())) {
                       return true;
                   }
               }

           }
           else{
               return true ;
           }
        }
        return false;
    }
}
