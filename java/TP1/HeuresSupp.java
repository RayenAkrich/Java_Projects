package exercice7;
import java.util.Scanner;


public class HeuresSupp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //le nombre total d'heures travaillées et le taux horaire
        System.out.print("Entrez le nombre total d'heures travaillées : ");
        int heuresTravaillees = scanner.nextInt();

        System.out.print("Entrez le taux horaire de l'employé (€) : ");
        double tauxHoraire = scanner.nextDouble();

        double montantSupp;

        // Calcul du salaire en fonction des heures travaillées
        if (heuresTravaillees <= 39) {
            montantSupp = 0;
        }
        else {
            // 40 à 44 heures
            if (heuresTravaillees <= 44) {
                int heures50 = heuresTravaillees - 39;
                montantSupp = heures50 * tauxHoraire * 1.5;
            }

            // 45 à 49 heures
            else if (heuresTravaillees <= 49) {
                int heures75 = heuresTravaillees - 44;
                montantSupp = (5 * tauxHoraire * 1.5) + (heures75 * tauxHoraire * 1.75);
            }

            // au-delà de 49 heures
            else {
                int heures100 = heuresTravaillees - 49;
                montantSupp =(5 * tauxHoraire * 1.5) + (5 * tauxHoraire * 1.75) + (heures100 * tauxHoraire * 2);
            }
        }

        // Affichage du salaire total
        System.out.printf("Le montant supplémentaire de l'employé est : %.2f €\n", montantSupp);

        scanner.close();
    }
}
