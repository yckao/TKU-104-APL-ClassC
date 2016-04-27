public class Stack_Ver2<T> {
	
	private class Stack_Mem<T>{
		public Stack_Mem<T> perv;
		T value;
		public Stack_Mem(Stack_Mem<T> perv, T value){
			this.perv = perv;
			this.value = value;
		}
	}
	
	private Stack_Mem<T> top;
	
	public Stack_Ver2(){
		this.top = new Stack_Mem<T>(null, null);
	}
	
	public void push(T obj){
		this.top = new Stack_Mem<T>(this.top, obj);
	}
	
	public boolean isEmpty(){
		if(this.top.perv == null) return true;
		return false;
	}
	
	public T top(){
		return this.top.value;
	}
	
	public void pop() {
		if(this.top.perv!=null)
			this.top = this.top.perv;
	}
}
