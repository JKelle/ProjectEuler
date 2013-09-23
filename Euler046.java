public class Euler046 {
	private static int N = 10_000;
	
	public static void main(String[] args) {
		boolean[] isPrime = EulerMath.getSieve(N);
		boolean found = false;
		
		for(int c = 9; c < isPrime.length; c += 2)
			if( !isPrime[c] ) {
				found = false;
				for(int p = 2; !found && p < c; p++) {
					if( !isPrime[p] ) continue;
					for(int s = 1; !found && p+2*s*s <= c; s++)
						if( c == p+2*s*s )
							found = true;
				}
				if( !found ) {
					System.out.println(c);
					break;
				}
			}
	}
}