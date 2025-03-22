import java.util.Scanner;  

public class Exercice4 {
       
    static String inverse (String s){
        int len = s.length();

        char[] envers;
        envers = new char[len];

        for (int i=0; i<len ; i++){
            envers[i] = s.charAt(len-i-1);
        }
        return new String (envers) ; 
    }

    static boolean est_palindrome (String s){
        return s.equals (inverse (s)); 
    }

    public static void main (String args[]){
        String chaine ;
        if (args.length == 1){
            chaine = args[0];
        }
        else{
            Scanner entree = new Scanner (System.in);
            System.out.print("Indiquer la chaine de caracteres : ");
            chaine = entree.nextLine();
            entree.close();
        }
        System.out.println("l'inverse de \"" + chaine + "\" est\" "+ inverse(chaine) + "\"");
        System.out.println("\""+ chaine + "\" "+ (est_palindrome(chaine) ? "est palindrome" : "n'est pas palindrome"));
    }

    
}
