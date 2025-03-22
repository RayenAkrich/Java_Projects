import java.util.Scanner;

public class ReverseArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez la taille du tableau: ");
        int size = scanner.nextInt();
        int[] array = new int[size];
        System.out.println("Entrez les éléments du tableau:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        reverse(array);
        System.out.println("Tableau inversé:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }

    public static void reverse(int[] array) {
        int n = array.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = array[i];
            array[i] = array[n - 1 - i];
            array[n - 1 - i] = temp;
        }
    }
}