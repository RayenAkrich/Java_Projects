public class Compte {
    private int numero;
    private float solde;
    private Personne client;

    public Compte(int numero, float solde, Personne client) {
        this.numero = numero;
        this.solde = solde;
        this.client = client;
    }

    public float getSolde(){return solde;}
    public int getNumero(){return numero;}
    public Personne getClient(){return client;}

    public void setSolde(float solde){this.solde = solde;}
    public void setNumero(int numero){this.numero = numero; }
    public void setClient(Personne client){this.client = client;}

    public boolean autoriser(float montant) {
        return solde >= montant;
    }

    public void Deposer(float montant) {
        solde += montant;
    }

    public boolean Retirer(float montant) {
        if (autoriser(montant)) {
            solde -= montant;
            return true;
        }
        return false;
    }

    public void Afficher() {
        System.out.println("Compte " + numero + " - Solde: " + solde + " Dinar, Client: " + client.getNom() + " " + client.getPrenom());
    }

    public static void main(String[] args) {
        Personne p = new Personne("Rayen", "Akriche", "NchalahLprepaTmout");

        Compte c1 = new Compte(001, 0f, p); 
        Compte c2 = new Compte(002, 0f, p); 

        p.ajouterCompte(c1);
        p.ajouterCompte(c2);

        System.out.println("Informations de la personne après création des comptes:");
        p.afficher();

        c1.Deposer(100);
        c2.Deposer(100);

        c1.Retirer(50);

        System.out.println("Informations des comptes après transactions:");
        c1.Afficher();
        c2.Afficher();

        System.out.println("Informations de la personne après transactions:");
        p.afficher();
    }
}

class Personne {
    private String nom;
    private String prenom;
    private String motDePasse;
    private Compte[] comptes;
    private int nombreComptes;

    public Personne(String nom, String prenom, String motDePasse) {
        this.nom = nom;
        this.prenom = prenom;
        this.motDePasse = motDePasse;
        this.comptes = new Compte[10]; 
        this.nombreComptes = 0; 
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public boolean verifierMotDePasse(String mdp) {
        return motDePasse.equals(mdp);
    }

    public boolean ajouterCompte(Compte c) {
        if (c.getClient() == this && nombreComptes < comptes.length) {
            comptes[nombreComptes] = c; 
            nombreComptes++;
            return true;
        }
        return false;
    }

    public void afficher() {
        System.out.println("Client: " + nom + " " + prenom + ", Nombre de comptes: " + nombreComptes);
    }
}