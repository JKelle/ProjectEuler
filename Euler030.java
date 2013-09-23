import java.util.ArrayList;

public class Euler030 {
	private static int P = 5;
	
	public static void main(String[] args) {
		int max = (int)(6*Math.pow(9, P));
		ArrayList<Integer> ans = new ArrayList<Integer>();
		
		for(int i = 2; i < max; i++) {
			int x = i;
			ArrayList<Integer> digits = getDigits(i);
			while( digits.size() > 0 && x >= 0 )
				x -= Math.pow(digits.remove(digits.size()-1), P);
			if(x == 0 && digits.size() == 0)
				ans.add(i);
		}
		
		int sum = 0;
		for(Integer num : ans)
			sum += num;
		System.out.println(sum);
	}
	
	private static ArrayList<Integer> getDigits(int x) {
		ArrayList<Integer> list = new ArrayList<Integer>(6);
		while(x > 0) {
			list.add(x%10);
			x /= 10;
		}
		return list;
	}
}
