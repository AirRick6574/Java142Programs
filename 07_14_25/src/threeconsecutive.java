import java.util.Arrays;

public class threeconsecutive {
	public static boolean threeConsecutive(int num1, int num2, int num3) {
		
		int[] nums = {num1, num2, num3};
		Arrays.sort(nums);
		
		for (int i = 1; i < 3; i++){
			if (nums[i] != nums[i-1] + 1){ //2 does not equal nums(1-1) = 0 (1) + 1  //2 does not equal 1+1
				return false;
			}		
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(threeConsecutive(1, 3, 2));
		System.out.println(threeConsecutive(2, 3, 1));
		System.out.println(threeConsecutive(2, 3, 6));
		
		System.out.println();
		
		System.out.println(threeConsecutive(1, 2, 3));//true
		System.out.println(threeConsecutive(3, 2, 4));//true
		System.out.println(threeConsecutive(-10, -8, -9));//true
		
		System.out.println(threeConsecutive(3, 5, 7)); //false
		System.out.println(threeConsecutive(1, 2, 2)); //false
		System.out.println(threeConsecutive(7, 7, 9)); //false
	}
	
	
	
}
