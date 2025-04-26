public class Rectangle {
    private float longueur,largeur;
    Rectangle(float longueur,float largeur){
        this.largeur=largeur;
        this.longueur=longueur;
    }
    Rectangle(){
        this.largeur=12;
        this.longueur=7;
    }
    float permimetre(){
        return (longueur+largeur)*2;
    }
    float surface(){
        return largeur*longueur;
    }
    void affichage(){
        System.out.println("La largeur : "+this.largeur+", la longueur : "+this.longueur+", son perimetre : "+this.permimetre()+", son surface : "+this.surface());
    }
    void modifierRectangle(float longueur,float largeur){
        this.largeur=largeur;
        this.longueur=longueur;
    }
    public static void main(String[] argv){

        System.out.println("Question 1) :");
        Rectangle rect=new Rectangle(7.5F,3.8F);
        rect.affichage();

        System.out.println("Question 2) :");
        Rectangle rect2=new Rectangle();
        rect2.affichage();

        System.out.println("Question 3) :");
        Rectangle rect3=new Rectangle();
        rect3.modifierRectangle(16.3F,15F);
        rect3.affichage();

        System.out.println("Question 4-a) :");
        Rectangle r=new Rectangle();    /*Pour la question 4-a)*/
        r.affichage();  /*La largeur et la longeur sont = 0*/

        System.out.println("Question 4-b) :");
        Rectangle rect4=new Rectangle();   /*Pour la question 4-b) */
        rect4.affichage();  /*Non , un erreur : manque d'arguments*/
        
    }
}
