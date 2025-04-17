class Point{
    private double x,y;
    Point(double x,double y){
        this.x=x;
        this.y=y;
    }
    public String toString(){
        return "p=("+this.x+","+this.y+").";
    }
}

class cercle extends Point{
    protected double r;
    cercle(double x,double y,double r){
        super(x,y);
        this.r=r;
    }
    double surface(){
        return 3.14*r*r;
    }
    @Override public String toString(){
        return super.toString()+"r="+this.r+".";
    }
}

class cylindre extends cercle{
    private double h;
    cylindre(double x,double y,double r,double h){
        super(x,y,r);
        this.h=h;
    }
    @Override double surface(){
        return 2*super.surface()+2*3.14*r*h;
    }
    @Override public String toString(){
        return super.toString()+"h="+this.h+".";
    }
}

public class Test {
    public static void main(String[] args) {
        /* un point est défini par ses coordonées x et y */
        Point p = new Point(2.5, 7);
        System.out.println("Point : "+p);
        /* un cercle est défini par x et y de son centre et par son rayon */
        cercle c = new cercle(2.5, 7, 3);
        System.out.println("Cercle : "+c+" et sa surface : "+c.surface());
        /* un cylindre est défini par x et y de son centre, par son rayon et par sa hauteur */
        cylindre cc = new cylindre(2.5, 7, 3, 5);
        System.out.println("Cylindre : "+cc+" et son surface : "+cc.surface());
    }
}
