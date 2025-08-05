package test;

public class StarFigures{
    public static void main(String[] args){
        fiveStars();
        twoStars();

        System.out.println();
        
        fiveStars();
        twoStars();
        fiveStars();
        
        System.out.println();
        
        oneStar();
        fiveStars();
        twoStars();
    }

    public static void fiveStars(){
        System.out.println("*****");
        System.out.println("*****");
    }

    public static void twoStars(){
        System.out.println(" * *");
        System.out.println("  *");
        System.out.println(" * *");
    }

    public static void oneStar(){
        System.out.println("  *");
        System.out.println("  *");
        System.out.println("  *");
    }

    

}