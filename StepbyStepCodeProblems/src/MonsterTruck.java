public class MonsterTruck extends Truck {

    @Override
    public void m1() {
        // override m1 to print monster 1
        System.out.println("monster 1");
    }

    @Override
    public void m2() {
        // call Truck's m2() to print "truck 1"
        super.m1();
        // then call Car's m1() to print "car 1"
        super.m2();
    }

    @Override
    public String toString() {
        // reuse Truck's toString() which returns "vroomvroom"
        return "monster " + super.toString();
    }

    // Example main method to test
    public static void main(String[] args) {
        MonsterTruck mt = new MonsterTruck();
        mt.m1();          // prints "monster 1"
        mt.m2();          // prints "truck 1" then "car 1"
        System.out.println(mt);  // prints "monster vroomvroom"
    }
}

