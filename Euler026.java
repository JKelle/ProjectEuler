import java.util.ArrayList;

public class Euler026 {
	public static void main(String[] CHEESE) {
		int[] ans = new int[]{ 1, -1};
		for(int den = 1; den < 1000; den++) {
			int count = -1;
			ArrayList<Integer> xs = new ArrayList<Integer>();
			ArrayList<Integer> top = new ArrayList<Integer>();
			int x = 1;
			
			while( x != 0 ) {
				xs.add(x);
				top.add(x/den);
				x = (x - den*(x/den))*10;
				
				int i = xs.indexOf(x);
				if( i >= 0 ) {
					count = top.size()-i;
					break;
				}
			}
			if(count > ans[1]) {
				ans[0] = den;
				ans[1] = count;
			}
		}
		System.out.println(ans[0] +", "+ ans[1]);
	}
}