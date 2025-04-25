// TODO 1 : Constructeur paramétré pour Etudiant
public abstract class Etudiant {

    private int identifiant;
    private String nom;
    private String prenom;
    private float moyenne;


    public Etudiant(int identifiant, String nom,String prenom,float moyenne) {
        this.identifiant = identifiant;
        this.nom = nom;
        this.prenom = prenom;
        this.moyenne = moyenne;
    }

    // Getters et setters 
    public int getIdentifiant() {
        return identifiant;
    }
    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public float getMoyenne() {
        return moyenne;
    }
    public void setMoyenne(float moyenne) {
        this.moyenne = moyenne;
    }

    // TODO 2 : Redéfinir equals()
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Etudiant)) {
            return false;
        }
        else{
            Etudiant etudiant = (Etudiant) obj;
            return identifiant == etudiant.identifiant && nom.equals(etudiant.nom);
        }
    }

    // TODO 3 : Redéfinir toString()
    @Override
    public String toString() {
        return "Etudiant{" +
                "identifiant=" + identifiant +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", moyenne=" + moyenne +
                '}';
    }

    abstract public void ajouterUneAbsence() ;
    public static void main(String[] args) {
        // TODO 4 : Tester les classes ici
        Ecole ecole = new Ecole("Ecole de Test");
        Etudiant3eme etudiant3eme = new Etudiant3eme(1, "Akriche", "Rayen", 15.0f, "Système");
        EtudiantAlternance etudiantAlternance = new EtudiantAlternance(2, "Bchir", "Frij", 1.0f, 1000);

        try {
            ecole.ajouterEtudiant(etudiant3eme);
            ecole.ajouterEtudiant(etudiantAlternance);
            System.out.println(ecole.toString());
        } catch (EtudiantExisteException | DepasseNbreMax e) {
            System.out.println(e.getMessage());
        }
        try {
            Ecole nouvelleEcole = new Ecole("Nouvelle Ecole");
            Ecole.changerEcole(etudiant3eme, nouvelleEcole);
            System.out.println(nouvelleEcole.toString());
        } catch (EtudiantExisteException | DepasseNbreMax e) {
            System.out.println(e.getMessage());
        }

    }
}

// TODO 5 : Déclaration de Etudiant3eme
class Etudiant3eme extends Etudiant {
    private String branche;

    // TODO 6 : Constructeur paramétré
    public Etudiant3eme(int identifiant, String nom,String prenom, float moyenne, String branche) {
        super(identifiant, nom,prenom, moyenne);
        this.branche = branche;
    }
    public String getBranche() {
        return branche;
    }
    public void setBranche(String branche) {
        this.branche = branche;
    }
    
    // TODO 7 : Implémentation de ajouterUneAbsence()
    @Override
    public void ajouterUneAbsence() {
        setMoyenne(getMoyenne() - 0.5f);
    }
}

// TODO 8 : Déclaration de EtudiantAlternance
class EtudiantAlternance extends Etudiant {
    private int salaire;

    // TODO 9 : Constructeur paramétré
    public EtudiantAlternance(int identifiant, String nom,String prenom, float moyenne, int salaire) {
        super(identifiant, nom,prenom, moyenne);
        this.salaire = salaire;
    }
    public int getSalaire() {
        return salaire;
    }
    public void setSalaire(int salaire) {
        this.salaire = salaire;
    }

    // TODO 10 : Implémentation de ajouterUneAbsence()
    @Override
    public void ajouterUneAbsence() {
        salaire -= 50;
    }

    // TODO 11 : Redéfinir toString()
    @Override
    public String toString() {
        return super.toString() + ", salaire=" + salaire;
    }
}
//Exception du nbmax
class DepasseNbreMax extends Exception {
    public DepasseNbreMax(String message) {
        super(message);
    }
    
}
// TODO 20 : Exception personnalisée
class EtudiantExisteException extends Exception {
    public EtudiantExisteException(String message) {
        super(message);
    }
}

class Ecole {
    private String nom;
    private Etudiant[] etudiants;
    private int nombreEtudiants;
    private static final int CAPACITE_MAX = 500;

    // TODO 12 : Constructeur de Ecole
    public Ecole(String nom) {
        this.nom = nom;
        this.etudiants = new Etudiant[CAPACITE_MAX];
        this.nombreEtudiants = 0;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public Etudiant[] getEtudiants() {
        return etudiants;
    }
    public void setEtudiants(Etudiant[] etudiants) {
        this.etudiants = etudiants;
    }
    public int getNombreEtudiants() {
        return nombreEtudiants;
    }
    public void setNombreEtudiants(int nombreEtudiants) {
        this.nombreEtudiants = nombreEtudiants;
    }

    // TODO 13 et 15 : Modifier ajouterEtudiant() avec vérification
    // TODO 21 : Lever une exception si étudiant existe
    public void ajouterEtudiant(Etudiant etudiant) throws EtudiantExisteException,DepasseNbreMax {
        if (rechercherEtudiant(etudiant) != -1) {
            throw new EtudiantExisteException("Étudiant déjà inscrit");
        }
        if (nombreEtudiants < CAPACITE_MAX) {
            etudiants[nombreEtudiants++] = etudiant;
        }
        else{
            throw new DepasseNbreMax("vous avez dépassé le nmbre max d'etudiants");
        }
    }

    // TODO 14 : Implémentation de rechercherEtudiant()
    public int rechercherEtudiant(Etudiant e) {
        for (int i = 0; i < nombreEtudiants; i++) {
            if (etudiants[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    // TODO 16 : Calcul de la moyenne des 3A
    public float getMoyenneDes3A() {
        float somme = 0;
        int count = 0;
        for (int i = 0; i < nombreEtudiants; i++) {
            if (etudiants[i] instanceof Etudiant3eme) {
                somme += etudiants[i].getMoyenne();
                count++;
            }
        }
        return count == 0 ? 0 : somme / count;
    }

    // TODO 17 : Moyenne des salaires des alternants
    public float moyenneSalaireAlternants() {
        float somme = 0;
        int count = 0;
        for (int i = 0; i < nombreEtudiants; i++) {
            if (etudiants[i] instanceof EtudiantAlternance) {
                somme += ((EtudiantAlternance) etudiants[i]).getSalaire();
                count++;
            }
        }
        return count == 0 ? 0 : somme / count;
    }

    // TODO 18 : Redéfinir toString() pour Ecole
    @Override
    public String toString() {
        String s;
        s = "Ecole{" +
                "nom='" + nom + '\'' +
                ", etudiants=";
        for (int i = 0; i < nombreEtudiants; i++) {
            s += etudiants[i].toString() + "\n";
        }
        s += '}';
        return s;
    }

    // TODO 19 et 22 : Méthode changerEcole()
    public static void changerEcole(Etudiant etd, Ecole nouvelleEcole) throws EtudiantExisteException, DepasseNbreMax {
        nouvelleEcole.ajouterEtudiant(etd);
    }
}