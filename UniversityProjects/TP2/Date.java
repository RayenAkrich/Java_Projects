public class Date {
    private int jour,mois,annee;
    Date(int jour,int mois,int annee){
        this.jour=jour;
        this.mois=mois;
        this.annee=annee;
    }
    Date(){
        this.jour=1;
        this.mois=1;
        this.annee=2000;
    }
    int nombreJours(){
        int[] joursParMois={31,28,31,30,31,30,31,31,30,31,30,31};
        return joursParMois[mois-1];
    }
    boolean dateValide(){
        if(mois<1 || mois>12 || jour<1 || jour>nombreJours() || annee<0){
            return false;
        }
        return true;
    }
    Date lendemain(){
        Date d=new Date();
        d.jour=jour;
        d.mois=mois;
        d.annee=annee;
        d.jour++;
        if(d.jour>nombreJours()){
            d.jour=1;
            d.mois++;
            if(d.mois>12){
                d.mois=1;
                d.annee++;
            }
        }
        return d;
    }
    void affichage(){
        System.out.println("La date jj/mm/aaaa : "+this.jour+"/"+this.mois+"/"+this.annee);
    }
    void modifierDate(int jour,int mois,int annee){
        this.jour=jour;
        this.mois=mois;
        this.annee=annee;
    }
    public static void main(String[] argv){
        if(argv.length==3){
            Date d=new Date(Integer.parseInt(argv[0]),Integer.parseInt(argv[1]),Integer.parseInt(argv[2]));
            if(d.dateValide()){
                d.affichage();
                System.out.println("Le nombre de jours dans le mois : "+d.nombreJours());
                Date d2=d.lendemain();
                System.out.println("La date du lendemain : ");
                d2.affichage();
            }else{
                System.out.println("Date invalide");
            }
        }else{
            System.out.println("Veuillez entrez 3 arguments");
        }
    }
}
