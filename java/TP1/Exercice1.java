public class Exercice1 {
    public static void main (String args[]){
        int somme=0;

        for (int i=1 ; i<=100; i++){
            somme += i;
        }
       
        /*boucle while  
        int i=0; 
        while (i<=100){
            somme += i;
            i++;
        }
        */

        /* boucle do while
        int i=0;
        do{
            somme +=i;
            i++;
        }while(i<=100);
        */

        
        System.out.println("resultat = "+ somme);
    }
}