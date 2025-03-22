import java.util.Scanner;

public class MinGap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez la taille du tableau: ");
        int size = scanner.nextInt();
        int[] array = new int[size];
        System.out.println("Entrez les éléments du tableau:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        int minGap = findMinGap(array);
        System.out.println("La différence minimale est " + minGap);
    }

    public static int findMinGap(int[] array) {
        if (array.length < 2) return 0;
        int min = Math.abs(array[1] - array[0]);
        for (int i = 1; i < array.length - 1; i++) {
            int gap = Math.abs(array[i+1] - array[i]);
            if (gap < min) min = gap;
        }
        return min;
    }
}