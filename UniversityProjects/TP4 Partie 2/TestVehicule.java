// Classe Vehicule
class Vehicule {
    private boolean moteur;
    private int nbPneus;

    public Vehicule(boolean moteur, int nbPneus) {
        this.moteur = moteur;
        this.nbPneus = nbPneus;
    }

    public boolean getMoteur() { return moteur; }
    public int getNbPneus() { return nbPneus; }

    public void afficher() {
        System.out.println("Moteur: " + getMoteur() + ", NbPneus: " + getNbPneus());
    }
}

// Classe Automobile
class Automobile extends Vehicule {
    private int nbcylindres;
    private int puissanceCylindre;

    public Automobile(boolean moteur, int nbPneus, int nbcylindres, int puissanceCylindre) {
        super(moteur, nbPneus);
        this.nbcylindres = nbcylindres;
        this.puissanceCylindre = puissanceCylindre;
    }

    public int getPuissance() { return nbcylindres * puissanceCylindre; }
    public void setPuissance(int p) { puissanceCylindre = p; }
    public void setNbcylindre(int n) { nbcylindres = n; }

    // Surcharge (overloading) de afficher()
    public void afficher(int nbPneus) {
        System.out.println("Automobile - NbPneus: " + nbPneus + ", Puissance: " + getPuissance());
    }
}

class TestVehicule {
    public static void main(String[] args) {
        Vehicule v = new Automobile(true, 4, 6, 100); // Polymorphisme
        System.out.println(v instanceof Automobile); // Affiche true

        // Solution pour appeler getPuissance() :
        if (v instanceof Automobile) {
            ((Automobile) v).getPuissance(); // Downcasting
        }
    }
}