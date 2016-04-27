import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Stack_Ver2<Person> stack = new Stack_Ver2<Person>();
		System.out.print("放入堆疊操作：\n");
		System.out.println("輸入姓名 年齡進行放入堆疊操作:");
		Person p;
		while((p = new Person())!=null&&!(p.name = scan.next()).equals("0")){
			p.age = scan.nextInt();
			stack.push(p);
		}
		System.out.println("取出堆疊操作: 按任意非0 鍵進行取出堆疊操作:");
		String input;
		while(!stack.isEmpty()&&!(input = scan.next()).equals("0")){
			p = (Person)stack.top();
			stack.pop();
			System.out.printf("取出堆疊的資料是(%s,%d)\n" ,p.name,p.age);
		}
		System.out.println("測試結束！");
	}

}
