public class Point {
    private double x,y;
    Point(double x,double y){
        this.x=x;
        this.y=y;
    }
    void affiche(){
        System.out.println("p=("+this.x+","+this.y+").");
    }
    void translate(double dx,double dy){
        this.x+=dx;
        this.y+=dy;
    }
    public static void main(String[] argv){
        Point p = new Point(2.5,7);
        p.affiche();
        p.translate(2,3);
        p.affiche();
    }
}