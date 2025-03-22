public class Palindrome {
    public static void main(String[] args){
        if (args.length != 1){
            System.out.println("Veuillez entrer une chaine sans espaces !");
        }
        else{
            System.out.println("L'inverse de laval est "+Palindrome.inverse(args[0]));
            if(args[0].equals(Palindrome.inverse(args[0]))){
                System.out.println(Palindrome.inverse(args[0])+" est un palindrome");
            }
            else{
                System.out.println(Palindrome.inverse(args[0])+" n''est pas un palindrome");
            }
            
        }
    }
    public static String inverse(String s) {
        char[] envers=new char[s.length()];
        for(int i=0;i<s.length();i++){
            envers[i]=s.charAt(s.length()-i-1);
        }   
        String result=new String(envers);
        return result;
    }
}