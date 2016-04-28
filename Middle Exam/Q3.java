import java.util.Scanner;

public class Q3 {
	private static Scanner stdScanner;
	public static void main(String[] args) {
		stdScanner = new Scanner(System.in);
		
		int t = stdScanner.nextInt();
		stdScanner.nextLine();
		
		int[] counts = new int['Z'-'A'+1];
		while(t-- > 0) {
			String input = stdScanner.nextLine().toUpperCase();
			for(int i=0;i<input.length();i++)
				if(input.charAt(i)<='Z'&&input.charAt(i)>='A')
					counts[input.charAt(i)-'A']++;
		}
		int max = 0;
		for(int i=0;i<'Z'-'A'+1;i++)
			if(counts[i]>max) max = counts[i];
		for(int i = max;i>0;i--)
			for(int j=('Z'-'A');j>=0;j--)
				if(i==counts[j])
					System.out.printf("%c %d\n",'A'+j,i);
	}
}