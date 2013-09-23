import java.util.HashSet;

public class Euler032 {
	private static boolean[] digits;
	
	public static void main(String[] args) {
		int sum = 0;
		HashSet<Integer> prods = new HashSet<Integer>();
		
		for(int i = 2; i < 10_000; i++) {
			for(int j = i+1; j < 10_000; j++) {
				int k = i*j;
				if( isPan(i, j, k) ) {
					boolean added = prods.add(k); 
					System.out.printf("%6d%6d%6d", i, j, i*j);
					if(!added)
						System.out.print(" *");
					System.out.println();
					if( added )
						sum += k;
				}
			}
		}
		
		System.out.println(sum);
	}
	
	// contatonates a, b, and c. return true if concatonated number is 1-9 pandigital
	public static boolean isPan(int a, int b, int c) {
		digits = new boolean[9];
		return isPan(c) && isPan(b) && isPan(a) && isPan();
	}
	
	private static boolean isPan(int x) {
		if(x < 0)
			return false;
		while(x > 0) {
			int y = x%10;
			if( y == 0 || digits[y-1] )
				return false;
			digits[y-1] = true;
			x /=10;
		}
		return true;
	}
	
	private static boolean isPan() {
		for(boolean b : digits)
			if(!b)
				return false;
		return true;
	}
}
