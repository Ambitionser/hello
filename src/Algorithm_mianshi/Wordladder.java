package Algorithm_mianshi;

import java.util.HashSet;
import java.util.LinkedList;

/*
import java.util.HashSet;
import java.util.LinkedList;
class wordNode{
	String word;
	int numStep;
	public wordNode(String word,int numStep){
		this.word=word;
		this.numStep=numStep;
	}
}
public class Wordladder {
	public static int ladderlength(String starword,String endword,HashSet<String>wordDict){
		LinkedList<wordNode>queue=new LinkedList<wordNode>();
		queue.add(new wordNode(starword,1));
		wordDict.add(endword);
		while(!queue.isEmpty()){
			wordNode top=queue.remove();
			String word=top.word;
			if(word.equals(endword)){
				return top.numStep;
			}
			char[] arr=word.toCharArray();
			for(int i =0;i<arr.length;i++){
				for(char c='a';c<'z';c++){
					char temp=arr[i];
					if(arr[i]!=c){
						arr[i]=c;
					}
					
					String newWord=new String(arr);
					if(wordDict.contains(newWord)){
						queue.add(new wordNode(newWord,top.numStep+1));
						wordDict.remove(newWord);
					}
					arr[i]=temp;
				}
			}
			
		}
		return 0;																																						
		
	}
	public static void main(String[] args){
		String starword="hit";
		String endword="cog";
		HashSet<String> wordDict=new HashSet<String>();
		wordDict.add("dot");
		wordDict.add("dog");
		wordDict.add("lot");
		wordDict.add("log");
		wordDict.add("cog");
		System.out.println("最短的长度为："+ladderlength(starword, endword, wordDict));
		
	}
}

import java.util.HashSet;  
import java.util.LinkedList;  
  
public class Wordladder {  
  
    public static void main(String[] args) {  
        String start = "hit";  
        String end = "cog";  
        HashSet<String> dict = new HashSet<String>();  
        dict.add("hot");  
        dict.add("dot");  
        dict.add("dog");  
        dict.add("lot");  
        dict.add("cog");  
        System.out.println(ladderLength(start, end, dict));  
    }  
  
     public static int ladderLength(String start, String end, HashSet<String> dict) {  
           
            if (dict.size() == 0)    
                return 0;   
       
            LinkedList<String> wordQueue = new LinkedList<String>();  
            LinkedList<Integer> distanceQueue = new LinkedList<Integer>();  
       
            wordQueue.add(start);  
            distanceQueue.add(1);  
       
            while(!wordQueue.isEmpty()){  
                String currWord = wordQueue.pop();  
                Integer currDistance = distanceQueue.pop();  
                if(currWord.equals(end)){  
                    return currDistance;  
                }  
                for(int i=0; i<currWord.length(); i++){  
                    char[] currCharArr = currWord.toCharArray();  
                    for(char c='a'; c<='z'; c++){  
                        currCharArr[i] = c;  
       
                        String newWord = new String(currCharArr);  
                        if(dict.contains(newWord)){  
                            wordQueue.add(newWord);  
                            distanceQueue.add(currDistance+1);  
                            dict.remove(newWord);  
                        }  
                    }  
                }  
            }  
                return 0;  
        }  
}  
*/
public class Wordladder{
	public static int  ladderlength(String start,String end,HashSet<String> dict){
		if(dict.size()==0)
			return 0;
		LinkedList<String> wordQueue=new LinkedList<String>();
		LinkedList<Integer> DistanceQueue=new LinkedList<Integer>();
		wordQueue.add(start);
		DistanceQueue.add(1);
		while(!wordQueue.isEmpty()){
			String currWord=wordQueue.pop();
			Integer currDistance=DistanceQueue.pop();
			if(currWord.equals(end))
				return currDistance;
			for(int i=0;i<currWord.length();i++){
				char[] arr=currWord.toCharArray();
				for(char c='a';c<'z';c++){
					arr[i]=c;
					
					String newWord=new String(arr);
					if(dict.contains(newWord)){
						wordQueue.add(newWord);
						DistanceQueue.add(currDistance+1);
						dict.remove(newWord);//从字典里面去掉单词
					}
				}
			}
		}
		return 0;
	}
	public static void main(String[] args){
		HashSet<String> dict=new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		dict.add("cog");
		String start="hit";
		String end="cog";
		System.out.println("最短的长度为："+ladderlength(start, end, dict));
	}
}


