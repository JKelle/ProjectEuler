import java.math.BigInteger;

public class Euler048 {
	public static void main(String[] args) {
		BigInteger sum = new BigInteger("0");
		for(int i = 1; i < 1001; i++) {
			BigInteger term = new BigInteger(i +"");
			sum = sum.add( term.pow(i) );
		}
		String s = sum.toString();
		System.out.println(s.substring(s.length()-10, s.length()));
	}
}