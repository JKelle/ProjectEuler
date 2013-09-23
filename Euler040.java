import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Euler040 {
	private static int N = 1_000_000;
	
	public static void main(String[] args) {
		List<Integer> digits = new ArrayList<Integer>(1_000_000);
		List<Integer> iList = new LinkedList<Integer>();
		for(int i = 1; digits.size() < N; i++) {
			iList = EulerMath.intToDigits(i);
			while(!iList.isEmpty())
				digits.add(iList.remove(0));
		}
		
		int ans = 1;
		for(int i = 1; i <= 6; i++)
			ans *= digits.get( (int)Math.pow(10,i)-1 );
		System.out.println(ans);
	}
}