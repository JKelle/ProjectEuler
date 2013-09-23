public class Euler031 {
	public static int N = 200;
	public static void main(String[] args) {
		
		int count = 0;		
		for(int one = 0; one <= N; one++)
			for(int two = 0; one+two*2 <= N; two++)
				for(int five = 0; one+two*2+five*5 <= N; five++)
					for(int ten = 0; one+two*2+five*5+ten*10 <= N; ten++)
						for(int twenty = 0; one+two*2+five*5+ten*10+twenty*20 <= N; twenty++)
							for(int fifty = 0;  one+two*2+five*5+ten*10+twenty*20+fifty*50 <= N; fifty++)
								for(int hund = 0; one+two*2+five*5+ten*10+twenty*20+fifty*50+hund*100 <= N; hund++)
									for(int twoHund = 0; one+two*2+five*5+ten*10+twenty*20+fifty*50+hund*100+twoHund*200 <= N; twoHund++)
										if( one+two*2+five*5+ten*10+twenty*20+fifty*50+hund*100+twoHund*200 == N )
											count++;
		
		System.out.println(count);
	}
	
	public static void printRes(int one, int two, int five, int ten, int twenty, int fifty, int hund, int twoHund) {
		for(int i = 0; i < one; i++)
			System.out.print("one, ");
		for(int i = 0; i < two; i++)
			System.out.print("two, ");
		for(int i = 0; i < five; i++)
			System.out.print("five, ");
		for(int i = 0; i < ten; i++)
			System.out.print("ten, ");
		for(int i = 0; i < twenty; i++)
			System.out.print("twenty, ");
		for(int i = 0; i < fifty; i++)
			System.out.print("fifty, ");
		for(int i = 0; i < hund; i++)
			System.out.print("hund, ");
		for(int i = 0; i < twoHund; i++)
			System.out.print("twoHund, ");
		System.out.println();
	}
}