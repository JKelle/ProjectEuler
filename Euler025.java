import java.util.LinkedList;
import java.math.BigInteger;

public class Euler025 {
	
	public static void main(String args[]) {
		LinkedList<BigInteger> fList = new LinkedList<BigInteger>();
		fList.addFirst(new BigInteger("1"));
		fList.addFirst(new BigInteger("1"));
		
		while(true) {
			BigInteger next = new BigInteger("0");
			fList.addFirst( next.add(fList.get(0)).add(fList.get(1)) );

			if( numDigits(fList.getFirst()) == 1000 ) {
				System.out.println(fList.size());
				break;
			}
		}
	}
	
	private static int numDigits(BigInteger b) {
		int numDigits = 0;
		while( !b.equals(BigInteger.ZERO) ) {
			numDigits++;
			b = b.divide(BigInteger.TEN);
		}
		return numDigits;
	}
}