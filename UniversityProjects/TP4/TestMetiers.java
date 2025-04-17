class Personne {
    protected String name;

    Personne(String name){
        this.name=name;
    }
    void affiche(){
        System.out.println("Je suis " + name);
    }
}

class Forgeron extends Personne {
    Forgeron(String name){
        super(name);
    }
    @Override void affiche(){
        System.out.println("Je suis " + name + " le forgeron");
    }
}

class Meunuiser extends Personne{
    Meunuiser(String name){
        super(name);
    }
    @Override void affiche(){
        System.out.println("Je suis " + name + " le menuisier");
    }
}

class TestMetiers{
    public static void main (String[] args){
        Personne[] personnes = new Personne[4];
        personnes[0]=new Personne("Salah");
        personnes[1]=new Forgeron("Ali");
        personnes[2]=new Meunuiser("Mohamed");
        personnes[3]=new Forgeron("Amor");
        for (int i=0;i<personnes.length;i++){
            personnes[i].affiche();
        }
    }
}