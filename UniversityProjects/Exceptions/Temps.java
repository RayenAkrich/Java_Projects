public class Temps {
    private int h, min, sec;

    public Temps(int h, int m, int s) throws TempsException {
        if (h >= 24 || m >= 60 || s >= 60 || h < 0 || m < 0 || s < 0)
            throw new TempsException("Temps invalide");
        this.h = h;
        this.min = m;
        this.sec = s;
    }

    public static void main(String[] args) {
        try {
            Temps t = new Temps(24, 12, 70);
        } catch (TempsException e) {
            System.out.println(e.getMessage());
        }
    }
}

class TempsException extends Exception {
    public TempsException(String msg) { super(msg); }
}

/* Question 3:
    public static void main(String[] args) {
        try {
            // Vérifier qu'il y a 3 arguments
            if (args.length != 3) {
                throw new TempsException("Usage: java Temps <heures> <minutes> <secondes>");
            }

            // Lire les 3 entiers depuis args
            int h = Integer.parseInt(args[0]);
            int m = Integer.parseInt(args[1]);
            int s = Integer.parseInt(args[2]);

            // Créer l'objet Temps
            Temps t = new Temps(h, m, s);
            System.out.println("Temps valide : " + h + "h " + m + "min " + s + "s");

        } catch (NumberFormatException e) {
            System.out.println("Erreur : les arguments doivent être des entiers");
        } catch (TempsException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
 */