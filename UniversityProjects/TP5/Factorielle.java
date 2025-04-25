public class Factorielle {

    public static class ExceptionGrand extends Exception {
        public ExceptionGrand(String msg) { super("ExceptionGrand: " + msg); }
    }

    public static class ExceptionNegatif extends Exception {
        private int valeur;
        public ExceptionNegatif(String msg) {super("ExceptionNegatif: " + msg); }
    }    
    public static long calcul(int n) throws ExceptionNegatif, ExceptionGrand {
        if (n < 0) throw new ExceptionNegatif(n+ " est négatif");
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
            if (fact < Long.MAX_VALUE / i) throw new ExceptionGrand(n + " est trop grand pour ce programme");
        }
        return fact;
    }

    public static void main(String[] args) {
        try {
            if (args.length == 0) {
                System.out.println("Indiquez le nombre d'entiers sur la ligne de commande");
                return;
            }
            int n = Integer.parseInt(args[0]);
            long result = calcul(n);
            System.out.println(n + "! = " + result);
        } catch (NumberFormatException e) {
            System.out.println("L'argument doit être entier");
        } catch (ExceptionNegatif | ExceptionGrand e) {
            System.out.println(e);
        }
    }
}