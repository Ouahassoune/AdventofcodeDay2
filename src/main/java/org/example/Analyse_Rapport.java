package org.example;



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


}
