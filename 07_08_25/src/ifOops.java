public class ifOops {
    public static void main(String[] args) {
        int a = 7, b = 42;
        int smaller = minimum(a, b);
        
        if (smaller == a) {
            System.out.println("a is the smallest!");
        }
    }

    // returns which int is smaller
    public static int minimum(int a, int b) {
    	int smaller = 0;
    	
        if (a < b) {
             smaller = a;
        } 
        
        else if (a >= b) {
             smaller = b;
        }
        
		return smaller;
    }
}
