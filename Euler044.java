import java.util.ArrayList;

public class Euler044 {
	private static final int N = 10;
	
	public static void main(String[] args) {
		ArrayList<Long> pents = new ArrayList<Long>(N);
		long minDiff = Long.MAX_VALUE;
		
		long p = 0L;
		for(int n = 0; n < N && p < Long.MAX_VALUE/2; n++) {
			p = (3*n*n - n)/2;
			pents.add( p );
	//		System.out.println("***************");
			for(int i = pents.size()-2; i > 0; i--) {
	//			System.out.println(i);
				long diff = p - pents.get(i);
				long sum = p + pents.get(i);
				if( diff >= minDiff )
					break;
				long det = 4*3*2*sum;
				if(det < 0 || det == Long.MAX_VALUE)
					System.out.println("help");
				
				boolean hasDiff = pents.contains(diff); 
				boolean hasSum = Math.abs( (1 - Math.sqrt(1+det))/6.0 ) < .0001;
				if(hasDiff) System.out.println(n +" "+ i +" diff");
				if(hasSum) System.out.println(n +" "+ i +" sum");
				if( hasDiff && hasSum ) {
					minDiff = diff;
					System.out.println("new minDiff = "+ minDiff);
				}
			}
		}
		
		System.out.println(minDiff);
		long det = 4*3*(22+70);
		System.out.println(Math.abs( (1 + Math.sqrt(1+det))/6.0 ));
/*		
		System.out.println(pents);
		
		int n1, n2;
		
		
		for(int i = 1; i < pents.size(); i++) {
			for(int j = i+1; j < pents.size(); j++) {
				int diff = pents.get(j) - pents.get(i);
				long sum = ((long)pents.get(j)) + ((long)pents.get(i));
				System.out.println(sum);
				if( diff < minDiff ) {
					System.out.println("diff passed");
					if( pents.contains(diff) ) {
						System.out.println("passed");
						if( pents.contains(sum) ) {
							System.out.println("sum");
							n1 = i;
							n2 = j;
							minDiff = diff;
						}
					}
				}
//					System.out.println(n1 +" = "+ pents.get(n1) +"\t"+ n2 +" = "+ pents.get(n2));
			}
		}
*/	
	}
}