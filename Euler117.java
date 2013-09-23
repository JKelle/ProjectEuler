public class Euler117 {
	private static long count = 0;
	private static int len = 50;
	private static long[] counts;
	
	public static void main(String[] args) {
		counts = new long[len+1];
		for(int n = 1; n <= len; n++) {
			e117(n);
			counts[n] = count;
			System.out.printf("%2d %d\n", n, count);
			count = 0L;
		}
	}
	
	public static void e117(long n) {
		if(counts[(int)n] != 0) 
			count += counts[(int)n];
		else if(n <= 4)
			switch((int)n){
				case 1 : count += 1; break;
				case 2 : count += 2; break;
				case 3 : count += 4; break;
				case 4 : count += 8; break;
			}
		else {
			e117(n-1);
			e117(n-2);
			e117(n-3);
			e117(n-4);
		}
	}
}