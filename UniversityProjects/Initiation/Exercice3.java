public class Exercice3 {
    public static void main(String args[]){
        System.out.println("Les anciens valeurs de a, b et c : ");
        System.out.println("a : "+ args[0]);
        System.out.println("b : "+ args[1]);
        System.out.println("c : "+ args[2]);

        int a=Integer.parseInt(args[0]);
        int b=Integer.parseInt(args[1]);
        int c=Integer.parseInt(args[2]);

        a = a + b + c; // a contient maintenant la somme de a, b et c
        b = a - (b + c); // b contient maintenant la valeur originale de a
        c = a - (b + c); // c contient maintenant la valeur originale de b
        a = a - (b + c); // a contient maintenant la valeur originale de c

        System.out.println("Les nouvelles valeurs de a, b et c : ");
        System.out.println("a : "+ a);
        System.out.println("b : "+ b);
        System.out.println("c : "+ c);


    }
}
