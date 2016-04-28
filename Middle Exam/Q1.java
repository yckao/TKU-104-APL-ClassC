import java.util.Scanner;
public class Q1 {
	private static Scanner stdScanner;
	public static void main(String[] args) {
		stdScanner = new Scanner(System.in);
		int[] n = new int[2];
		for(int i=0;i<2;i++){
			System.out.printf("n%d: ",i+1);
			n[i] = stdScanner.nextInt();
		}
		System.out.print("Ans: ");
		if(n[0]+n[1]!=stdScanner.nextInt())
			System.out.printf("Wrong!\n%d + %d = %d",n[0],n[1],n[0]+n[1]);
		else
			System.out.printf("Correct!");
	}
}