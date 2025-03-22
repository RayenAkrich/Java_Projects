public class Exercice6 {
    public static void main (String args[]){
        System.out.println("les entiers <=100 non multiple de 3 : ");
        for (int i =0; i<=100; i++){
            if (i%3 !=0 ){
                System.out.println(i);
            }

            /*deuxieme methode 
            if (i%3 ==0 ){
                continue;
            }
            System.out.println(i);
            */

            /*troisieme methode
            if (i%3 == 0){}
            else {System.out.println(i);}
            */
        }
    }
}
