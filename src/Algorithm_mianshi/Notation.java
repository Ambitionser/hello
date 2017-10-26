package Algorithm_mianshi;
import java.io.IOException;
import java.util.Stack;
public class Notation {

	public static void main(String[] args)throws IOException {
		String[] tokens=new String[]{"2","1","+","3","*"};
		System.out.println(Evalu(tokens) );
	}
	/**
	 * �沨��������ʽ
	 */
	
	public static int Evalu(String[] tokens){
		int returnValue=0;
		Stack<String> stack= new Stack<String>();
		String operators="+-*/";
		for (String t : tokens) {
			if(!operators.contains(t))
				stack.push(t);//��������ַ�+-*/�Ǿʹ���ջ��
			else{
				int a=Integer.valueOf(stack.pop());
				int b=Integer.valueOf(stack.pop());
				int index=operators.indexOf(t);
				switch(index){
					case 0://�˴������õ����� ��Ϊchar�Ͳ���ת����String��
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
