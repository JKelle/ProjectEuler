public class Euler027 {
	private static boolean[] isPrime = new boolean[100_000_000];
	
	public static void main(String[] args) {
		setIsPrime();
		
		//asn is [a, b, count]
		int[] ans = new int[]{-1000, -1000, -1};
		
		for(int a = -999; a < 1000; a++)
			for(int b = -999; b < 1000; b++) {
				int x = 0;
				int count = 0;
				
				int f = x*x + a*x + b;
				while( f >= 0 && isPrime[f] ) {
					count++;
					x++;
					f = x*x + a*x + b;
				}
				if(count > ans[2])
					ans = new int[]{a, b, count};
			}
		
		System.out.println(ans[0] +" * "+ ans[1] +" = "+ ans[0]*ans[1]);
	}
	
	private static void setIsPrime() {
		for(int i = 2; i < isPrime.length; i++)
			isPrime[i] = true;
		for(int i = 2; i < isPrime.length; i++)
			if( isPrime[i] )
				for(int j = 2; j*i < isPrime.length; j++)
					isPrime[i*j] = false;
	}
}
