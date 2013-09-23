import java.util.ArrayList;

public class Euler049 {
	
	private static boolean[] isPrime = new boolean[10000];
	
	public static void main(String args[]) {
		long startT = System.currentTimeMillis();
		//assume all are prime
		for(int i = 2; i < isPrime.length; i++)
			isPrime[i] = true;
		setIsPrime();
		
		for(int i = 1000; i < 10000; i++)
			if(isPrime[i])
				for(int j = i+1; j < 10000; j++)
					if( isPrime[j] && isPerm(i, j) ) {
						int k = j+(j-i);
							if( k < isPrime.length && isPrime[k] && isPerm(j, k) )
								System.out.printf("%5d%5d%5d\n", i, j, k);
					}
							
		long endT = System.currentTimeMillis();
		System.out.println((int)(endT-startT));
	}
	
	private static void setIsPrime() {
		for(int i = 2; i < isPrime.length; i++)
			if( isPrime[i] )
				for(int j = 2; j*i < isPrime.length; j++)
					isPrime[i*j] = false;
	}
	
	private static boolean isPerm(int a, int b) {
		ArrayList<Integer> A = new ArrayList<Integer>();
		ArrayList<Integer> B = new ArrayList<Integer>();
		
		for(int i = 0; i < 4; i++) {
			A.add( a%10 );
			a /= 10;
			
			B.add( b%10 );
			b /= 10;
		}
		
		for(Integer n : A) {
			int i = B.indexOf(n);
			if(i == -1)
				return false;
			B.remove(i);
		}
		return true;
	}
}