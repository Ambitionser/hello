package Algorithm_mianshi;
import java.util.Scanner;
public class Solution {
	public String longestPalindrome(String s){
		/*if(s==null||s.length()<=1)
			return s;
		int len=s.length();
		int Maxlen=1;
		boolean[][] Bob=new boolean[len][len];
		String longest=null;
		for(int l =0;l<s.length();l++){
			for(int i=0;i<len-1;i++){
				int j =i+1;
				if(s.charAt(i)==s.charAt(j)&&(j-i<=2||Bob[i+1][j-1])){
					Bob[i][j]=true;
					if(j-i+1>Maxlen){
						Maxlen=j-i+1;
						longest=s.substring(i, j+1);
					}
				}	
			}
		}
		return longest;*/
		if(s==null||s.length()<2)
			return s;
		int maxlength=0;
		int length=s.length();
		String longest=null;
		boolean[][] table=new boolean[length][length];
		//判断单个字符是否为回文
		for(int i =0;i<s.length();i++){
			table[i][i]=true;
			longest=s.substring(i, i+1);
			maxlength=1;
		}
		//判断两个字符是否为回文
		for (int i=0;i<length-1;i++){
			if(s.charAt(i)==s.charAt(i+1)){
				table[i][i+1]=true;
				longest=s.substring(i,i+2);
				maxlength=2;
			}
		}
		//求长度大于2的子串是否为回文
		for(int len =3;len<=length;len++){
			for(int i=0,j;(j=i+len-1)<=length-1;i++){
				if(s.charAt(i)==s.charAt(j)){
					table[i][j]=table[i+1][j-1];
					if(table[i][j]&&maxlength<len){
						longest=s.substring(i, j+1);
					maxlength=len;
					}	
				}else{
					table[i][j]=false;
				}
			}
		}
		return longest;
		
	}
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		System.out.println("please enter a String");
		String s= input.nextLine();
		Solution Lon=new Solution();
		System.out.println("The longest subString is "+Lon.longestPalindrome(s));
	}
}
