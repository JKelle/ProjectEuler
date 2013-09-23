import java.util.List;

public class Euler034 {
	public static void main(String[] args) {
		int N = 1_000_000;
		int total = 0;
		
		for(int i = 10; i < N; i++) {
			List<Integer> digits = EulerMath.intToDigits(i);
			int sum = 0;
			for(int j = 0; j < digits.size() && sum <= i; j++)
				sum += EulerMath.fact( digits.get(j) );
			if( sum == i )
				total += i;
		}
		
		System.out.println(total);
	}
}