public class Euler039 {
	public static void main(String[] args) {
		// [max p, max # solutions]
		int[] max = new int[2];
		
		for(int p = 5; p < 1001; p++) {
			int numSols = 0;
			
			for(int c = 1; c < p/2; c++)
				for(int a = 1; a < c; a++) {
					double b = Math.sqrt(c*c - a*a);
					if( Math.abs(b - (int)b) < .001 && a < (int)b && a+((int)b)+c == p )
						numSols++;
				}
			if(numSols > max[1])
				max = new int[]{p, numSols};
		}
		
		System.out.println("p = "+ max[0] +"\t#solutions = "+ max[1]);
	}
}