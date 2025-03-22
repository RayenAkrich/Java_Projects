import java.util.Scanner;

public class SearchArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[10];
        System.out.println("Entrez 10 entiers:");
        for (int i = 0; i < 10; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.print("Entrez l'entier x à rechercher: ");
        int x = scanner.nextInt();
        int index = -1;
        for (int i = 0; i < 10; i++) {
            if (array[i] == x) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            System.out.println("L'élément se trouve à l'indice " + index);
        } else {
            System.out.println("L’élément recherché n’existe pas dans le tableau");
        }
    }
}