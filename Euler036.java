public class Euler036 {
	public static void main(String args[]) {
		int total = 0;
		for(int i = 0; i < 1_000_000; i++) {
			String dec = Integer.toString(i);
			String bin = Integer.toBinaryString(i);
			if( isPalindrome(dec) && isPalindrome(bin) )
				total += i;
		}
		System.out.println(total);
	}
	
	public static boolean isPalindrome(String s) {
		if(s.length() < 2) 
			return true;
		return s.charAt(0) == s.charAt(s.length()-1) && isPalindrome( s.substring(1, s.length()-1));
	}
}