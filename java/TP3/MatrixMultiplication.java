import java.util.Scanner;

public class MatrixMultiplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Première matrice:");
        System.out.print("Nombre de lignes: ");
        int m = scanner.nextInt();
        System.out.print("Nombre de colonnes: ");
        int n = scanner.nextInt();
        int[][] a = new int[m][n];
        System.out.println("Entrez les éléments de la première matrice:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Deuxième matrice:");
        System.out.print("Nombre de lignes: ");
        int n2 = scanner.nextInt();
        System.out.print("Nombre de colonnes: ");
        int p = scanner.nextInt();
        int[][] b = new int[n2][p];
        System.out.println("Entrez les éléments de la deuxième matrice:");
        for (int i = 0; i < n2; i++) {
            for (int j = 0; j < p; j++) {
                b[i][j] = scanner.nextInt();
            }
        }

        if (n != n2) {
            System.out.println("Les matrices ne peuvent pas être multipliées.");
            return;
        }

        int[][] c = new int[m][p];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < p; j++) {
                for (int k = 0; k < n; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        System.out.println("Résultat de la multiplication:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < p; j++) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
    }
}