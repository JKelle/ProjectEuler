import java.util.LinkedList;
import java.util.List;

public class Euler043 {	
	private static long sum = 0L;
	private static int[] primes = new int[]{2,3,5,7,11,13,17};
	
	public static void main(String[] args) {
		LinkedList<Integer> digits = new LinkedList<Integer>();
		for(int i = 0; i < 10; i++)
			digits.add(i);
		getPerms(digits);
		System.out.println("sum = "+ sum);
	}
	
	public static void getPerms(List<Integer> original) {		
		getPermsHelper(original, new LinkedList<Integer>());
	}	
	private static void getPermsHelper(List<Integer> remaining, List<Integer> cur) {
		if(remaining.size() == 0) {
			check(cur);
			return;
		}
		for(int i = 0; i < remaining.size(); i++) {
			cur.add( remaining.remove(i));
			getPermsHelper(remaining, cur);
			remaining.add(i, cur.remove(cur.size()-1));
		}
	}
	
	private static void check(List<Integer> digits) {
		for(int j = 1; j < 8; j++) {
			int num = 0;
			for(int k = 0; k < 3; k++)
				num += digits.get(j+k)*(int)Math.pow(10, 2-k);
			
			if( num % primes[j-1] != 0 )
				return;
		}
		sum += EulerMath.digitsToLong(digits);
	}
}