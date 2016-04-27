import java.util.Scanner;
import java.util.Arrays;
class CharCount {
	public char ch;
	public int times;
	public CharCount(char ch,int count) {
		this.ch = ch;
		this.times = count;
	}
	//比較兩個Char Count 哪個大 自己比右邊大回傳-1 (不用交換位置)
	//不然回傳1 (要交換位置)
	public int campareTo(CharCount r){
		if(this.times>r.times||this.times==r.times&&this.ch>r.ch)
			return -1;
		return 1;
	}
}

class Main {
	private static Scanner stdScanner;
	public static void main(String[] args) {
		stdScanner = new Scanner(System.in);
		CharCount[] counts = new CharCount[255];
		for(int i=0;i<255;i++)
			counts[i] = new CharCount((char)i,0);
		int t = stdScanner.nextInt();
		
		while(t-->0){
			String str = stdScanner.nextLine().toUpperCase();
			for(int i=0;i<str.length();i++)
				if('A'<=str.charAt(i) && str.charAt(i)<='Z')
					counts[(int)str.charAt(i)].times++;
		}
		//Arrays 的 Sort 以下的寫法僅適用於Java SE8 (Lambda)
		Arrays.sort(counts, (l,r)-> l.campareTo(r));
		
		for(int i=0;i<255&&counts[i].times>0;i++)
			System.out.println(counts[i].ch+" "+counts[i].times);
	}
}