import java.util.LinkedList;

public class Euler038 {
	public static void main(String[] args) {
		LinkedList<String> prods = new LinkedList<String>();
		int max = 0;
		
		for(int i = 2; i < 100_000_000; i++) {
			prods.clear();
			int numDigits = 0;
			for(int j = 1; j < 9 && numDigits < 9; j++) {
				String prod = Integer.toString(i*j);
				prods.add(prod);
				numDigits += prod.length();
				
				prod = "";
				for(String s : prods) {
					prod += s;
				}
				
				int result = isPan(prod);
				
				if( result == -1 )
					break;
				else if( result == 1 ) {
					int num = Integer.parseInt(prod);
					if( num > max )
						max = num;
				}
			}
		}
		System.out.println(max);
	}
	
	// returns -1 if duplicate digit or if zero exists
	//			0 if not full
	//			1 if the string is a 1-9 pandigital number
	public static int isPan( String s ) {
		boolean[] digits = new boolean[9];
		for(char c : s.toCharArray()) {
			if( c == '0' || digits[c-'0'-1] )
				return -1;
			digits[c-'0'-1] = true;
		}
		for(boolean b : digits)
			if(!b)
				return 0;
		return 1;
	}
}