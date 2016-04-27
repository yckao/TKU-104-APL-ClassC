import java.util.Scanner;


public class Uva10189 {
	
	static Scanner scanner;
	static int n=2,m=1;
	static char[][] map;
	//判斷位置是否合法
	private static int vaild(int x,int y){
		if(x>=m||y>=n)return 0;
		if(x<0||y<0)return 0;
		if(map[x][y]=='*')return 0;
		return 1;
	}
	//將地雷周圍合法位置全數+1
	private static void add(int x,int y){
		map[x][y]='*';
		for(int i=-1;i<=1;i++)
			for(int j=-1;j<=1;j++)
				if(vaild(x+i,y+j)==1) map[x+i][y+j]++;
	}
	
	private static void solve(){
		int count = 1;
		//讀取大小判斷是否為0
		while((n = scanner.nextInt())!=0 && (m = scanner.nextInt())!=0){
			//指定新的地圖
			map = new char[m][n];
			//初始化地圖為字元0
			for(int i=0;i<n;i++)
				for(int j=0;j<m;j++)
					map[j][i] = '0';
			//讀檔
			for(int i=0;i<n;i++){
				String input = scanner.next();
				char[] str = input.toCharArray();
				//char[] str = scanner.next().toCharArray();
				//如果這個位子是地雷 周圍數字+1
				for(int j=0;j<m;j++)
					if(str[j]=='*')add(j,i);
			}
			//輸出
			System.out.printf("Field #%d: ",count++).println();
			for(int i=0;i<n;i++){
				for(int j=0;j<m;j++)
					System.out.print(map[j][i]);
				System.out.println();
			}
			
			System.out.println();
		}
		
	}
	
	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		solve();
	}

}
