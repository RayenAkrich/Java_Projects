import java.util.Scanner;

public class MatrixProgram {
    private static int[][] T = new int[5][5];
    private static int currentRows = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Saisir le numéro de l’opération");
            System.out.println("1. Remplir la matrice");
            System.out.println("2. Supprimer une ligne");
            System.out.println("3. Afficher la matrice");
            System.out.println("4. Tester si le tableau est magique");
            System.out.println("5. Exit");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    remplirMatrice(scanner);
                    break;
                case 2:
                    supprimerLigne(scanner);
                    break;
                case 3:
                    afficherMatrice();
                    break;
                case 4:
                    testMagique();
                    break;
                case 5:
                    System.out.println("Au revoir!");
                    break;
                default:
                    System.out.println("Choix invalide.");
            }
        } while (choice != 5);
    }

    private static void remplirMatrice(Scanner scanner) {
        System.out.println("Entrez 25 entiers positifs:");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int num;
                do {
                    num = scanner.nextInt();
                    if (num < 0) System.out.println("Entrez un entier positif.");
                } while (num < 0);
                T[i][j] = num;
            }
        }
        currentRows = 5;
    }

    private static void supprimerLigne(Scanner scanner) {
        System.out.print("Entrez le numéro de la ligne à supprimer (1-" + currentRows + "): ");
        int row = scanner.nextInt() - 1;
        if (row < 0 || row >= currentRows) {
            System.out.println("Ligne invalide.");
            return;
        }
        int[][] newT = new int[currentRows - 1][5];
        int newRow = 0;
        for (int i = 0; i < currentRows; i++) {
            if (i != row) newT[newRow++] = T[i];
        }
        T = newT;
        currentRows--;
        System.out.println("Ligne supprimée.");
    }

    private static void afficherMatrice() {
        for (int i = 0; i < currentRows; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(T[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private static void testMagique() {
        if (currentRows != 5) {
            System.out.println("La matrice doit être 5x5 pour être magique.");
            return;
        }

        int magicSum = 0;
        for (int j = 0; j < 5; j++) magicSum += T[0][j];

        for (int i = 1; i < 5; i++) {
            int sum = 0;
            for (int j = 0; j < 5; j++) sum += T[i][j];
            if (sum != magicSum) {
                System.out.println("La matrice n'est pas magique.");
                return;
            }
        }

        for (int j = 0; j < 5; j++) {
            int sum = 0;
            for (int i = 0; i < 5; i++) sum += T[i][j];
            if (sum != magicSum) {
                System.out.println("La matrice n'est pas magique.");
                return;
            }
        }

        int diag1 = 0, diag2 = 0;
        for (int i = 0; i < 5; i++) {
            diag1 += T[i][i];
            diag2 += T[i][4 - i];
        }
        if (diag1 != magicSum || diag2 != magicSum) {
            System.out.println("La matrice n'est pas magique.");
            return;
        }

        System.out.println("La matrice est magique.");
    }
}