package Algorithm_mianshi;

import java.util.ArrayList;
import java.util.Iterator;

public class RegularEx {
	public boolean isMatch(String s,String p){
		if(p.length()==0)
			return s.length()==0;
		if(p.length()==1||p.charAt(1)!='*'){
			if(s.length()<1||(p.charAt(0)!='.'&&s.charAt(0)!=p.charAt(0)))
				return false;
			return isMatch(s.substring(1),p.substring(1));
		}
		else{
			int len=s.length();
			int i =-1;
			while(i<len&&(i<0||p.charAt(0)=='.'||p.charAt(0)==s.charAt(i))){
				if (isMatch(s.substring(i+1),p.substring(2)))
					return  true;
				i++;
			}
				return false;
		}
	}
	public static void main(String[] args){
		/*
		String os_name=System.getProperty("os.name");
		System.out.println(os_name);
		if("Windows 10".equals(os_name))
			System.out.println("¼ÌÐø°²×°");
		ArrayList<String> arr=new ArrayList<String>();
		arr.add("Â½");
		arr.add("Ïô");
		arr.add("·å");
		Iterator it= arr.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		*/
		RegularEx ex= new RegularEx();
		String s="aaa";
		String p="aa";
		System.out.println(ex.isMatch(s, p));
		
	}
	

}
