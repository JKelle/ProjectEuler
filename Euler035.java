import java.util.LinkedList;
import java.util.List;

public class Euler035 {
	public static int N = 1_000_000;
	
	public static void main(String[] args) {
		boolean[] isPrime = EulerMath.getSieve(N);
		int count = 0;
		
		for(int i = 2; i < isPrime.length; i++)
			if(isPrime[i]) {
				List<LinkedList<Integer>> perms = getCircularPerms( EulerMath.intToDigits(i) );
				boolean add = true;
				
				for(int j = 0; j < perms.size() && add; j++)
					if( !isPrime[ EulerMath.digitsToInt(perms.get(j)) ] )
						add = false;
				
				if(add)
					count++;
		}
		System.out.println("\n"+ count);	
	}
	
	public static List<LinkedList<Integer>> getCircularPerms( List<Integer> digits ) {
		List<LinkedList<Integer>> perms = new LinkedList<LinkedList<Integer>>();
		
		for(int i = 0; i < digits.size(); i++) {
			digits.add(digits.remove(0));
			perms.add( new LinkedList<Integer>(digits) );
		}
		
		return perms;
	}
}