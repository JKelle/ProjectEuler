import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


public class Euler067 {
	static Scanner reader;

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
		lists.add(new ArrayList<Integer>());
		lists.add(new ArrayList<Integer>());
		
		setReader();
	
		int row = 1;
		ArrayList<Integer> newList = lists.get(row%2);
		ArrayList<Integer> oldList = lists.get((row+1)%2);
		
		//row 1
		newList.add(reader.nextInt());
		row++;
		
		while(reader.hasNext()) {
			newList = lists.get(row%2);
			oldList = lists.get((row+1)%2);			
			newList.clear();
			
			//first column
			newList.add( reader.nextInt() + oldList.get(0) );
			
			//middle columns
			for(int i = 1; i < row-1; i++)
				newList.add( reader.nextInt() + Math.max(oldList.get(i-1), oldList.get(i)) );
			
			//last column
			newList.add( reader.nextInt() + oldList.get(oldList.size()-1) );
			row++;
		}

		int max = Integer.MIN_VALUE;
		for(int num : newList)
			if( num > max )
				max = num;
		
		System.out.println(max);
	}
	
	
	
	public static void setReader() {
		String file = "euler067.txt";
		try {
			reader = new Scanner( new File(file) );
		}
		catch(Exception e) {
			System.out.println(e);
			System.exit(1);
		}
	}
}
