public class EssaiePile {

    static class PilePleineException extends Exception {
        public PilePleineException(String message) {
            super(message);
        }
    }
    
    // Exception pour pile vide
    static class PileVideException extends Exception {
        public PileVideException(String message) {
            super(message);
        }
    }

    public static class Pile {
        private int[] elements;
        private int sommet;
        private int max;
    
        public Pile(int max) {
            this.max = max;
            elements = new int[max];
            sommet = -1;
        }
    
        public Pile() { 
            this(100); // Taille par défaut : 100
        }
    
        public void empiler(int n) throws PilePleineException {
            if (estPleine()) {
                throw new PilePleineException("Erreur : Impossible d'empiler, la pile est pleine !");
            }
            elements[++sommet] = n;
        }
    
        public int depiler() throws PileVideException {
            if (estVide()) {
                throw new PileVideException("Erreur : Impossible de dépiler, la pile est vide !");
            }
            return elements[sommet--];
        }
    
        public boolean estVide() { 
            return sommet == -1; 
        }
    
        public boolean estPleine() { 
            return sommet == max - 1; 
        }
    
        public void listenPile() throws PileVideException {
            if (estVide()) {
                throw new PileVideException("Erreur : Impossible d'afficher, la pile est vide !");
            }
            System.out.print("Contenu de la pile : ");
            for (int i = 0; i <= sommet; i++) {
                System.out.print(elements[i] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Pile p = new Pile(3); // Pile de taille 3

        // Test d'empilage
        try {
            p.empiler(10);
            p.empiler(20);
            p.empiler(30);
            p.listenPile(); // Affiche : 10 20 30
            p.empiler(40); // Lève PilePleineException
        } catch (PilePleineException e) {
            System.out.println(e.getMessage());
        } catch (PileVideException e) {
            System.out.println(e.getMessage());
        }

        // Test de dépilage
        try {
            System.out.println("Élément dépilé : " + p.depiler()); // 30
            System.out.println("Élément dépilé : " + p.depiler()); // 20
            System.out.println("Élément dépilé : " + p.depiler()); // 10
            p.depiler(); // Lève PileVideException
        } catch (PileVideException e) {
            System.out.println(e.getMessage());
        }

        // Test d'affichage d'une pile vide
        try {
            p.listenPile(); // Lève PileVideException
        } catch (PileVideException e) {
            System.out.println(e.getMessage());
        }
    }
}