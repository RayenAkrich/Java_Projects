public class Temps {
    private int heure,minute,seconde;
    Temps(int heure){
        if(heure<0){
            this.heure=0;}
        else{this.heure=heure;
        this.minute=0;
        this.seconde=0;}
    }
    Temps(int heure,int minute){
        if(heure<0){
            this.heure=0;}
        else{this.heure=heure;}
        if(minute<0){
            this.minute=0;}
        else{this.minute=minute;}
        this.seconde=0;
    }
    Temps(int heure,int minute,int seconde){
        if(heure<0){
            this.heure=0;}
        else{this.heure=heure;}
        if(minute<0){
            this.minute=0;}
        else{this.minute=minute;}
        if(seconde<0){
            this.seconde=0;}
        else{this.seconde=seconde;}
    }
    void affichage(){
        System.out.println("Il est "+this.heure+" heures "+this.minute+" minutes "+this.seconde+" secondes.");
    }
    public static void main(String[] argv){
        Temps t=new Temps(10);t.affichage();
        t=new Temps(10,12);t.affichage();
        t=new Temps(10,12,45);t.affichage();
    }
}
