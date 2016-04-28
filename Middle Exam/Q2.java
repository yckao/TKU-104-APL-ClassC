import java.util.Scanner;
public class Q2 {

	static int count;
	static void hanni(char src,char buf,char dst,int n) {
		if(n==1)
			System.out.printf("第%d次移動 盤子從%c移動到%c\n",++count,src,dst);
		else {
			hanni(src, dst, buf, n-1);
			hanni(src, buf, dst, 1);
			hanni(buf, src, dst, n-1);
		}
	}

	private static Scanner stdScanner;
	public static void main(String[] args) {
			stdScanner = new Scanner(System.in);
			System.out.print("請輸入盤子數量: ");
			hanni('A', 'B', 'C', stdScanner.nextInt());
			System.out.printf("執行完畢!共需執行%d次",count);
	}
}