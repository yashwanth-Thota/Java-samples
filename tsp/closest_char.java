import java.util.*;
import java.lang.*;

public class closest_char{
    
    
    public static List<Integer> noAdjacentDup(String s,List<Integer> x1)
    {
        int n = s.length();
		
		List<Integer> res=new ArrayList<Integer>();
        for(int x :x1){
			int count=0,diff=n,z=0;
            for(int j=0;j<n;j++){
				
				if(s.charAt(j)==s.charAt(x)){
					count++;
					if(diff>Math.abs(x-j)&&j!=x){
						diff=Math.abs(x-j);
						z=j;
					}
				}
			
			}
            
			if(count==1) res.add(-1);
			else res.add(z);
		}
        return res;
    }
    
    
    public static void main(String argc[]){

        String s = "geeksforgeeks";
		List<Integer> l=new ArrayList<Integer>();
		l.add(1);
		l.add(2);
		l.add(5);
        System.out.println(noAdjacentDup(s,l));
        
    }
    
}