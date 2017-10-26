package Algorithm_mianshi;
import java.io.IOException;
import java.util.Stack;
public class Notation {

	public static void main(String[] args)throws IOException {
		String[] tokens=new String[]{"2","1","+","3","*"};
		System.out.println(Evalu(tokens) );
	}
	/**
	 * 逆波兰计算表达式
	 */
	
	public static int Evalu(String[] tokens){
		int returnValue=0;
		Stack<String> stack= new Stack<String>();
		String operators="+-*/";
		for (String t : tokens) {
			if(!operators.contains(t))
				stack.push(t);//如果不是字符+-*/那就存入栈中
			else{
				int a=Integer.valueOf(stack.pop());
				int b=Integer.valueOf(stack.pop());
				int index=operators.indexOf(t);
				switch(index){
					case 0://此处不能用单引号 因为char型不能转换成String型
						stack.push(String.valueOf(a+b));
						break;
					case 1:
						stack.push(String.valueOf(b-a));
						break;
					case 2:
						stack.push(String.valueOf(a*b));
						break;
					case 3:
						stack.push(String.valueOf(b/a));
						break;
				}
			}
		}
		returnValue=Integer.valueOf(stack.pop());
		return returnValue;
		
	}

}
