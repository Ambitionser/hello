package Algorithm_mianshi;

public class Median {
	/*public static double findMedianSortedArrays(int[] A,int[] B){
		int m=A.length;
		int n=B.length;
		if(A==null)
			A=new int[0];
		if(B==null)
			B=new int[0];
		if(m<n){//确保第一个数组比第二个长
			return findMedianSortedArrays(B,A);
		}
		if(n==0){//长度小的数组为null
			return  A[(m-1)/2]+A[m/2];
		}
		int lo=0;
		int hi=n*2;
		int mid1;
		int mid2;
		double l1;
		double l2;
		double r1;
		double r2;
		while (lo<=hi){
			mid2=(lo+hi)/2;
			mid1=m+n-mid2;
			l1=(mid1==0)?Integer.MIN_VALUE:A[(mid1-1)/2];
			l2=(mid2==0)?Integer.MIN_VALUE:B[(mid2-1)/2];
			r1=(mid1==m*2)?Integer.MAX_VALUE:A[mid1/2];
			r2=(mid2==n*2)?Integer.MAX_VALUE:B[mid2/2];
			if(l1>r2){
				lo=mid2+1;
			}else if(l2>r1){
				hi=mid2-1;
			}else{
				return (Math.max(l1, l2)+Math.min(r1, r2))/2;
			}
		}
		return -1;
	}
	public static void main(String[] args){
		int[] A={1,2,3,4,5};
		int[] B={1,3,5,6};
		System.out.println(findMedianSortedArrays(A, B));
	}*/
	public static double  findMedianSortedArrays(int[] A,int[] B){
		int n=A.length;
		int m=B.length;
		int total=n+m;
	
		if(total%2==0){
			return (find_Kth(total/2+1,A,B,0,0)+find_Kth(total/2,A,B,0,0))/2.0;
		}
		else{
			return find_Kth(total/2,A,B,0,0);
		}
	}
	public static int find_Kth(int k ,int[] A,int[] B,int s1,int s2){
		if(A.length<=s1)
			return B[k/2-1];
		if(B.length<=s2)
			return A[k/2-1];
		if(k==1)
			return  Math.min(A[s1], B[s2]);
		int m1=s1+k/2-1;
		int m2=s2+k/2-1;
		
		int mid1=m1<A.length?A[m1]:Integer.MAX_VALUE;
		int mid2=m2<B.length?B[m2]:Integer.MAX_VALUE;
		if(mid1<mid2){
			return find_Kth(k-k/2,A,B,m1+1,s2);
		}
		else{
			return find_Kth(k-k/2,A,B,s1,m2+1);
		}
	}
	public static void main(String[] args){
		int[] A={1,2,3,4,5};
		int[] B={1,3,5,6};
		System.out.println(findMedianSortedArrays(A, B));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
