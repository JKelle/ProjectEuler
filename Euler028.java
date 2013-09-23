
public class Euler028 {
	public static void main(String[] args) {
		int sum = 1;
		for(int i = 2; i < 1001; i += 2) {
			int e = i*i+1;
			int o = (i+1)*(i+1);
			int old_o = (i-1)*(i-1);
			int ul = (e+o)/2;
			int lr = (e+old_o)/2;
			
			sum += e + o + ul + lr;
		}
		
		System.out.println(sum);	
	}
}
