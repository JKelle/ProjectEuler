import java.util.Scanner;
import java.io.File;

public class Euler042 {
	public static void main(String[] args) {
		int count = 0;
		try{
			Scanner read = new Scanner( new File("words.txt") );
			
			while(read.hasNext()) {
				read.useDelimiter("\",\"");
				String word = read.next();
				int wordVal = getWordVal(word);
				double res = (-1 + Math.sqrt(1+4*2*wordVal))/2;
				if( Math.abs(res-(int)res) < .0001 )
					count++;
			}

			read.close();
		}
		catch(Exception e) {
			System.out.println(e);
			System.exit(1);
		}
		
		System.out.println(count);
	}
	
	private static int getWordVal(String s) {
		int val = 0;
		for(int i = 0; i < s.length(); i++)
			val += s.charAt(i) - 'A' + 1;
		return val;
	}
}