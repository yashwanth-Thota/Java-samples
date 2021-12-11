import java.util.*;

public class subString_n2{
    
	public static void main(String [] args){
		Scanner sc=new Scanner(System.in);
		int[] arr= new int[]{1,3,5,6,4};
	    System.out.println(lcmForSubset(arr,0));
	}
	
	static int lcm(int x,int y){
        return (x*y)/findgcd(x,y);
     }
     
     static int findgcd(int X, int Y){
         
         if(X==0) return Y;
         
         return findgcd(Y%X,X);
         
     }
     
	static int lcmForSubset(int[] subset, int index){
       
       if(subset.length-2==index)
            return lcm(subset[index],subset[index+1]);
       
       if(subset.length-1==index) 
            return subset[index];
       
       if(index >= subset.length)
                return 1;
       
       return lcm(lcmForSubset(subset,index+2), lcm(subset[index],subset[index+1]));
   }
}
