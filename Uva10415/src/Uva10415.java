import java.util.*;

class Uva10415 {
	static int res[];
	static Scanner scan;
	static int getFinger(char c) {
		//把16進位轉成2進位 會發現我是用bit來存每隻手指
		int[] keysMap = {0x1CF,0x1CE,0x1CC,0x1C8,0x1C0,0x180,0x100,0x80,0x3CE,0x3CC,0x3C8,0x3C0,0x380,0x300};
		if(c>='c'&&c<='g') return keysMap[c - 'c'];
		if(c>='a'&&c<='b') return keysMap['g'-'c' + c - 'a' + 1];
		if(c>='C'&&c<='G') return keysMap[c - 'C' + 7];
		if(c>='A'&&c<='B') return keysMap['G'-'C' + c - 'A' + 8];
		return 0;
	}
	
	static void add(int x) {
		for(int i=0;i<10;i++)
			if((x&(1<<i))>0) res[i]++;
	}
	
	public static void main(String[] args) {
		System.out.println(getFinger('b'));
		scan = new Scanner(System.in);
		int t = scan.nextInt();
		while(t-- > 0){
			String input = scan.next();
			res = new int[10];
			//caculate
			add(getFinger(input.charAt(0)));
			for(int i=1;i<input.length();i++) {
				int last = getFinger(input.charAt(i-1)),now = getFinger(input.charAt(i));
				//位元運算 ^為互斥 代表兩個相比有變化的
				//再跟原本的做&判斷哪些bit原本就有
				//然後減掉
				add((last^now)-(last&(last^now)));
			}
			//output
			for(int i=9;i>=0;i--)
				System.out.print(res[i]+" ");
			System.out.println();
		}
	}
}