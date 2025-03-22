public class Exercice7 {
    public static void main (String args[]){
        float prix_unitaire = Float.parseFloat(args[0]);
        float taux_horaire =Float.parseFloat(args[1]);
        double heure_supp = 0;

        if (taux_horaire <= 39){
            System.out.println("pas d'heure supplementaires");
        }
        else if ((taux_horaire > 39) && (taux_horaire <= 44)){
            heure_supp = (taux_horaire - 39 )* prix_unitaire * 0.5; 
        }
        else if ((taux_horaire > 44) && (taux_horaire <= 49)){
            heure_supp = (taux_horaire - 44 ) * prix_unitaire * 0.75 + ( 5 * prix_unitaire *0.5);
        }
        else {
            heure_supp = (taux_horaire - 49 ) * prix_unitaire  +(5* prix_unitaire * 0.75 ) + ( 5 * prix_unitaire *0.5);

        }
       
        System.out.println("le montant des heures supplementaires est : "+ heure_supp);
        
    }
}
