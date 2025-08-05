package test;

public class FarewellGoodbye{
    public static void main(String[] args){
        for (int i = 0; i < 3; i++) {
        	goodbyeMethod(i);
        	System.out.println(); 
        }
    }

    public static void goodbyeMethod(int i){
        System.out.println("Farewell,\n" 
                        + "goodbye,\n"
                        + "au revoir,");
        
        if (i == 0){
           System.out.println("good night!,\n" 
                        + "It's time, to go,\n"
                        + "and I'll be out of sight!"); 
        }
        
        else if (i==1) {
        	System.out.println("take care!,\n" 
                    + "I'll say, goodbye,\n"
                    + "that's neither here nor there!"); 
        }
        	
        else{
        	System.out.println("see you later!,\n" 
                    + "I hope, you think,\n"
                    + "I'm a lover, not a hater!"); 
		}
        
        
    }
       
}


/*
 * 
public class FarewellGoodbye{
    public static void main(String[] args){
        for (int i = 0; i < 3; i++) {
        	goodbyeMethod(i);
        	System.out.println(); 
        }
    }

    public static void iTwo(){
        System.out.println("take care!\n" 
                    + "I'll say, goodbye,\n"
                    + "that's neither here nor there!"); }


    public static void goodbyeMethod(int i){
        System.out.println("Farewell,\n" 
                        + "goodbye,\n"
                        + "au revoir,");
        
        if (i == 0){
           System.out.println("good night!\n" 
                        + "It's time, to go,\n"
                        + "and I'll be out of sight!"); 
        }
        
        else if (i==1) {
        	iTwo();
        }
        	
        else{
        	System.out.println("see you later!\n" 
                    + "I hope, you think,\n"
                    + "I'm a lover, not a hater!"); 
		}
        
        
    }
       
}


 */


