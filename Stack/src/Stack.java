import java.util.Arrays;
import java.util.*;
/* Usage
	Stack<YourType> var = new Stack<YourType>();
*/
// Java Type Template
public class Stack<T> {
	//set initial length
	static int length = 10;
	//template type name as data
	T[] data = (T[])new Object[length];
	//top index
	int top = 0;
	

	//push on the top using type t
	public void push(T obj){
		//if top >= length extend length;
		if(top>=length){
			length *= 2;
			data = Arrays.copyOf(data, length);
			System.out.println("Struct Length Extend.");
		}
		//add object
		data[top++]=obj;
	}
	//return wheater Struct is empty
	public boolean isEmpty(){
		if(top==0) return true;
		return false;
	}
	//return object type T on the top
	public T top(){
		return data[top-1];
	}
	//pop Top data
	public void pop(){
		data[--top] = null;
		//if top < length/3 && length/2 >= 10 detend half size of struct;
		if(top<=length/3&&length/2>=10){
			length/=2;
			data = Arrays.copyOf(data, length);
			System.out.println("Struct Length Detend.");
		}
	}
}
