import java.awt.Rectangle;

public class personTest {
	public static void main(String[] agrs) {
		
		classObj bob = new classObj();
		classObj alice = bob;
		
		bob.setNames("Bob", "Tiberus", "Johnson");
		System.out.println(alice.fullNameFirstNameFirst());
		
		int num1 = 7;
		int num2 = num1;
		num1 = 8;
		
		System.out.println(num2);
		
		Rectangle rect = new Rectangle(0, 0, 100, 100);
		
		Rectangle rect1 = new Rectangle(0, 0, 100, 100);
		Rectangle rect2 = new Rectangle(0 + 0, 0 * 0, 110 - 10, 1000 / 10);
		
		System.out.println(rect1.equals(rect2)); //Prints true
		System.out.println(rect2.equals(rect1)); //Prints true
		
		System.out.println(rect1 == rect2);
		
		System.out.println(bob.equals(alice));
		
		classObj charlie = new classObj();
		charlie.setNames("Bob", "Tiberus", "Johnson");
		
		System.out.println(bob == charlie); //despite same contents, output is false due to different memory addresses
		System.out.println(bob.equals(charlie)); //Original Output: Checks object.equals(object 0) (false) (same as ==)
		//Method was just overwritten with new method in classObj, will do different check based on method.
		
		classObj Dana = new classObj();
		System.out.println(Dana.fullNameFirstNameFirst());
		//System.out.println(Dana.birthDayOfMonth);
		
		System.out.println(classObj.NumberOfPeople);
		System.out.println(bob.NumberOfPeople); //this public int variable belongs to classobj, not to a instance
		
	}
}
