public class Euler041 {
	private static int N = 10_000_000;
	
	public static void main(String[] args) {
		boolean[] sieve = EulerMath.getSieve(N);
		boolean found = false;
		
		for(int i = N-1; i > 1 && !found; i--)
			if( sieve[i] && EulerMath.isPandigital(i, 1) ) {
				System.out.println(i);
				found = true;
			}
	}
}