import java.util.LinkedList; //274.75
import java.util.ArrayList;	//318.45

public class Euler024 {
	private static int N = 10;
	private static LinkedList<String> digits = new LinkedList<String>();
	private static ArrayList<LinkedList<String>> perms = new ArrayList<LinkedList<String>>();
	
	public static void main(String[] args) {
		for(int i = 0; i < N; i++)
			digits.add(""+ i);
		permute( digits, new LinkedList<String>() );
		System.out.println(perms.get(perms.size()-1));
	}
	
	private static void permute(LinkedList<String> remaining, LinkedList<String> cur) {
		if(perms.size() == 1000000)
			return;
		if( remaining.size() == 0 )
			perms.add(new LinkedList<String>(cur));
		
		for(int i = 0; i < remaining.size(); i++) {
			String s = remaining.remove(i);	
			cur.add(s);
			permute(remaining, cur);
			remaining.add(i, cur.removeLast() );
		}
	}
}