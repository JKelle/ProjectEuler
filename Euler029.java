import java.math.BigInteger;
import java.util.HashSet;

public class Euler029 {
	public static void main(String[] args) {
		HashSet<BigInteger> set = new HashSet<BigInteger>();
		int N = 100;
	
		for(BigInteger a = new BigInteger("2"); a.intValue() <= N; a = a.add(BigInteger.ONE))
			for(int b = 2; b <= N; b++)
				set.add(a.pow(b));
		
		System.out.println(set.size());
	}
}