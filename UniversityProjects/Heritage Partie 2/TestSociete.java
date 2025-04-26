import java.util.Date;
import java.util.ArrayList;

// Classe Employee
class Employee {
    protected String nom, prenom, adresse, CIN, matricule;
    protected Date dateEmbauche;
    protected double salaire;

    public Employee(String nom, String prenom, String adresse, String CIN, 
                    String matricule, Date dateEmbauche, double salaire) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.CIN = CIN;
        this.matricule = matricule;
        this.dateEmbauche = dateEmbauche;
        this.salaire = salaire;
    }

    public void afficher() {
        System.out.println("Nom: " + nom + ", Prénom: " + prenom);
    }
}

// Classe EmployeeAssure
class EmployeeAssure extends Employee {
    private String numeroCNSS;
    private Date dateInscriptionCNSS;

    public EmployeeAssure(String nom, String prenom, String adresse, String CIN, 
                          String matricule, Date dateEmbauche, double salaire,
                          String numeroCNSS, Date dateInscriptionCNSS) {
        super(nom, prenom, adresse, CIN, matricule, dateEmbauche, salaire);
        this.numeroCNSS = numeroCNSS;
        this.dateInscriptionCNSS = dateInscriptionCNSS;
    }

    @Override
    public void afficher() {
        super.afficher();
        System.out.println("Numéro CNSS: " + numeroCNSS);
    }
}

// Classe EmployeeNonAssure
class EmployeeNonAssure extends Employee {
    public EmployeeNonAssure(String nom, String prenom, String adresse, String CIN, 
                             String matricule, Date dateEmbauche, double salaire) {
        super(nom, prenom, adresse, CIN, matricule, dateEmbauche, salaire);
    }
}

// Classe Societe
class Societe {
    private String code, raisonSociale;
    private ArrayList<Employee> employes = new ArrayList<>();

    public void ajouterEmploye(Employee e) { employes.add(e); }
    public boolean rechercherEmploye(String matricule) {
        for (Employee e : employes) {
            if (e.matricule.equals(matricule)) return true;
        }
        return false;
    }
    public void supprimerEmploye(String matricule) {
        employes.removeIf(e -> e.matricule.equals(matricule));
    }
}
class TestSociete {
    public static void main(String[] args) {
        Societe societe = new Societe();
        EmployeeAssure emp1 = new EmployeeAssure("Doe", "John", "123 Main St", "CIN123", 
                                                 "MAT123", new Date(), 5000.0, 
                                                 "CNSS123", new Date());
        EmployeeNonAssure emp2 = new EmployeeNonAssure("Smith", "Jane", "456 Elm St", "CIN456", 
                                                       "MAT456", new Date(), 4000.0);
        
        societe.ajouterEmploye(emp1);
        societe.ajouterEmploye(emp2);
        System.out.println(societe.rechercherEmploye("MAT123"));
    }
}