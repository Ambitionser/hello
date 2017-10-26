package Algorithm_mianshi;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
public class NiBoLan {
	public static Float houzhui(String e){
		Stack<String> s1 = new Stack<String>();//存放逆波兰式
		Stack<String> s2 = new Stack<String>();//存放操作符
		HashMap<String,Integer> hashmap=new HashMap<String,Integer>();
		//将指定值和指定键关联
		hashmap.put("(",0);
		hashmap.put("+", 1);
		hashmap.put("-", 1);
		hashmap.put("*", 2);
		hashmap.put("/", 2);
		for(int i=0;i<e.length();){
			StringBuffer digit = new StringBuffer();
			char c=e.charAt(i);
			//将数字存放在digit字符串中
			while(Character.isDigit(c)||c=='.'){
				digit.append(c);
				i++;
				c=e.charAt(i);
			}
			//说明没有数字
			if(digit.length()==0){
				switch(c){
				case '(':{
					s2.push(String.valueOf(c));
				break;
				}
				case ')':{
					String stmp=s2.pop();//操作符为)则将s2中所有操作符除了(都放入s1中
					if(!s2.isEmpty()||stmp.equals('(')){
						s1.push(stmp);
						stmp=s2.pop();
					}
					break;
					}
				case '=':{//若s2中还有操作符则入s1，逆波兰式构造结束
					String stmp;
					if(!s2.isEmpty()){
						stmp=s2.pop();
						s1.push(stmp);
					}
					s1.push("=");
					break;
					}
				default:{
					String stmp;
					while(!s2.isEmpty()){
						stmp=s2.pop();
						if(hashmap.get(stmp)>=hashmap.get(String.valueOf(c))){
							s1.push(stmp);
							}
						else{
							s2.push(stmp);
							}
					}
					s2.push(String.valueOf(c));
					break;
					}
				}
			}else{
				s1.push(String.valueOf(digit.toString()));
				continue;
			}
			i++;
		}
		
	ArrayList<String>stmp=new ArrayList<String>();
	for (String s : s1) {
		stmp.add(s);
	}
	return cacl(stmp);
}
	public static Float cacl(ArrayList<String> e){//计算逆波兰式
		Stack<Float> result=new Stack<Float>();
		float Result=0f;
		for(int i=0;i<e.size();i++){
			String c=e.get(i);
			if(c.length()==1&&Character.isDigit(c.charAt(0))){
				float a=result.pop();
				float b=result.pop();
				if(c.equals("+")){
					result.push(b+a);
				}else if(c.equals("-")){
					result.push(b-a);
				}else if(c.equals("*")){
					result.push(b*a);
				}else if(c.equals("/")){
					result.push(b/a);
				}
				else{
					Result=result.pop();
				}
			}
			else{
				result.push(Float.valueOf(c));
			}
		}
		return Result;
	}
	public static void main(String[] args){
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入个数");
		int n=scanner.nextInt();
		while(n>0){
			String s=scanner.next();
			System.out.printf("%.2f\n",houzhui(s));
			n--;
		}
	}
}
