import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class EulerMath {
	
	public static ArrayList<LinkedList<String>> getPermutations(LinkedList<String> remaining) {
		ArrayList<LinkedList<String>> perms = new ArrayList<LinkedList<String>>();
		getPermutationsHelper(remaining, new LinkedList<String>(), perms);
		return perms;
	}
	private static void getPermutationsHelper(LinkedList<String> remaining, LinkedList<String> cur, ArrayList<LinkedList<String>> perms) {
		if( remaining.size() == 0 )
			perms.add(new LinkedList<String>(cur));
		
		for(int i = 0; i < remaining.size(); i++) {
			String s = remaining.remove(i);	
			cur.add(s);
			getPermutationsHelper(remaining, cur, perms);
			remaining.add(i, cur.removeLast() );
		}
	}
		
	//factorial
	public static int fact(int x) {
		int ans = 1;
		
		while(x > 1) {
			ans *= x;
			x--;
		}
		
		return ans;
	}

	//returns a list of digits
	//ex. f(24553) returns [2,4,5,5,3]
	public static List<Integer> longToDigits(long x) {
		LinkedList<Integer> digits = new LinkedList<Integer>();
		
		while(x > 0) {
			digits.addFirst( (int)x%10 );
			x /= 10;
		}
		
		return digits;
	}	
	public static List<Integer> intToDigits(int x) {
		return longToDigits((long)x);
	}
	

	
	//returns the number of digits in x
	public static int numDigits(int x) {
		int count = 0;
		while( x > 0 ) {
			count++;
			x /= 10;
		}
		return count;
	}
	
	//returns an int from a list of digits
	//ex. f( [2,5,6] ) returns 256
	public static int digitsToInt(List<Integer> list) {
		int ans = 0;
		for(int i = 0; i < list.size(); i++) {
			ans += list.get(i)*Math.pow(10, list.size()-i-1);
		}
		return ans;
	}
	public static long digitsToLong(List<Integer> list) {
		long ans = 0L;
		for(int i = 0; i < list.size(); i++) {
			ans += ((long)list.get(i))*Math.pow(10, list.size()-i-1);
		}
		return ans;
	}
	
	//returns a boolean array such that the i is prime if [i] is true
	public static boolean[] getSieve(int size) {
		boolean[] isPrime = new boolean[size];
		
		for(int i = 2; i < isPrime.length; i++)
			isPrime[i] = true;
		for(int i = 2; i < isPrime.length; i++)
			if( isPrime[i] )
				for(int j = 2; j*i < isPrime.length; j++)
					isPrime[i*j] = false;
		
		return isPrime;
	}
	
	//returns true is the number is a-n pandigital,
	//where n is the number of digits in x
	public static boolean isPandigital(int x, int a) {
		return isPandigital((long)x, a);
	}
	
	//returns true is the number is a-n pandigital,
	//where n is the number of digits in x
	public static boolean isPandigital(long x, int a) {
		int numDigits = Long.toString(x).length();
		boolean[] hasDigit = new boolean[numDigits];
		while(x > 0) {
			int digit = (int)(x%10);
			if( digit < a || digit > numDigits || hasDigit[digit] )
				return false;
			hasDigit[digit] = true;
			x /= 10;
		}
		
		for(int i = a; i < hasDigit.length; i++)
			if( !hasDigit[i] )
				return false;
		return true;
	}
	
	//returns a list of permutations, where a permutation is a list
	public static List<LinkedList<Integer>> getPerms(List<Integer> original) {
		List<LinkedList<Integer>> perms = new LinkedList<LinkedList<Integer>>();
		
		getPermsHelper(perms, original, new LinkedList<Integer>());
		
		return perms;
	}	
	private static void getPermsHelper(List<LinkedList<Integer>> perms, List<Integer> remaining, List<Integer> cur) {
		if(remaining.size() == 0) {
			perms.add( new LinkedList<Integer>(cur) );
			return;
		}
		for(int i = 0; i < remaining.size(); i++) {
			cur.add( remaining.remove(i));
			getPermsHelper(perms, remaining, cur);
			remaining.add(i, cur.remove(cur.size()-1));
		}
	}
}