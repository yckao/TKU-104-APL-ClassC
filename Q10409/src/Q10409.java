import java.util.Scanner;
//這題是我用來做設計模式-簡單工廠模式的練習
//暫時不懂繼承,封裝,多型等OOP技巧沒關係
//這題題目的部分本身問題是在於Rotate的時候要怎麼樣算
//看過即可


//IRotate
interface IRotate{
	void Rotate(Dice dice);
}
class Dice {
	int north=2,top=1,west=3;
}

//繼承於抽象類別的4個Rotate類別
class North implements IRotate {
	@Override
	public void Rotate(Dice dice) {
		int next = 7-dice.north;
		dice.north = dice.top;
		dice.top = next;
	}
}

class South implements IRotate {
	@Override
	public void Rotate(Dice dice) {
		int next = 7-dice.top;
		dice.top = dice.north;
		dice.north = next;
	}
}

class East implements IRotate {
	@Override
	public void Rotate(Dice dice) {
		int next = 7-dice.top;
		dice.top = dice.west;
		dice.west = next;	
	}
}


class West implements IRotate {
	@Override
	public void Rotate(Dice dice) {
		int next = 7-dice.west;
		dice.west = dice.top;
		dice.top = next;
	}
}
//簡單工廠
class RotateFactory{
	static IRotate generateRotate(String type){
		switch(type){
		case "north":
			return new North();
		case "south":
			return new South();
		case "east":
			return new East();
		case "west":
			return new West();
		}
		return null;
	}
}

public class Q10409 {
	
	static Scanner scanner;

	static Dice dice;
	private static void solve(){
		int n;
		while((n = scanner.nextInt())!=0){
			dice = new Dice();
			while(n-->0){
				IRotate rot = RotateFactory.generateRotate(scanner.next());
				rot.Rotate(dice);
			}
			System.out.println(dice.top);
		}
	}
	
	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		solve();
	}

}
