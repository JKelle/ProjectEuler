import java.util.HashSet;
import java.util.TreeMap;

public class Euler047 {
	private static int N = 1_000_000;
	
	public static void main(String[] args) {
		boolean[] isPrime = EulerMath.getSieve(N);
		HashSet<Integer> primeFactors = new HashSet<Integer>();
		TreeMap<Integer, HashSet<Integer>> map = new TreeMap<Integer, HashSet<Integer>>();
		
		for(int i = 2; i < N && map.size() < 4; i++) {
			int x = i;
			primeFactors = new HashSet<Integer>();
			for(int p = 2; x > 0 && p < N; p++)
				if( isPrime[p] && x%p == 0 ) {
						primeFactors.add(p);
						x /= p;
				}
			if( primeFactors.size() == 4 )
				map.put(i, primeFactors);
			else
				map.clear();
		}
		System.out.println(map);
	}
}