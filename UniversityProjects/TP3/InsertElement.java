import java.util.Scanner;

public class InsertElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        do {
            System.out.print("Entrez n (entre 0 et 10): ");
            n = scanner.nextInt();
        } while (n < 0 || n > 10);

        int[] array = new int[n];
        System.out.println("Entrez les " + n + " entiers:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.print("Entrez l'entier x à insérer: ");
        int x = scanner.nextInt();

        int p;
        do {
            System.out.print("Entrez la position p (entre 0 et " + (n-1) + "): ");
            p = scanner.nextInt();
        } while (p < 0 || p >= n);

        int[] newArray = new int[n + 1];
        for (int i = 0; i < p; i++) newArray[i] = array[i];
        newArray[p] = x;
        for (int i = p; i < n; i++) newArray[i + 1] = array[i];

        for (int i = 0; i < newArray.length; i++) {
            System.out.print(newArray[i] + " ");
        }
    }
}