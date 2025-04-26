public class Exercice2 {
    public static void main(String args[]){
        float moyenne = Float.parseFloat(args[0]);

        if (moyenne < 9.75){
            System.out.println("refuse");
        }
        else if (moyenne <10){
            System.out.println("admis avec rachat");
        }
        else if (moyenne<12){
            System.out.println("admis mention passable");
        }
        else if ( moyenne<14){
            System.out.println("admis mention assez bien ");
        }
        else if (moyenne<16){
            System.out.println("admis mention bien");
        }
        else if (moyenne<18){
            System.out.println("admis mention bien");
        }
        else if(moyenne <20){
            System.out.println("honorable");
        }
        else{
            System.out.println("moyenne non valide");
        }
    }
}
