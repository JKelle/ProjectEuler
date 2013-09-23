public class Euler037 {
	public static void main(String args[]) {
		boolean[] isPrime = EulerMath.getSieve(1_000_000);
		int total = 0;
		
		for(int i = 10; i < isPrime.length; i++)
			if( isPrime[i] ) {
				boolean add = true;
				int x = i;
				int numDigits = 0;
				
				// Removes least significant
				while( add && x > 0 ) {
					if( isPrime[x] ) {
						numDigits++;
						x /= 10;
					}
					else
						add = false;
				}
				
				x = i;
				
				// Removes most significant
				while( add && numDigits > 0 ) {
					if( isPrime[x] ) {
						x = i%(int)(Math.pow(10, numDigits-1));
						numDigits--;
					}
					else
						add = false;
				}

				if(add)
					total += i;
			}
		System.out.println("total = "+ total);
	}
}