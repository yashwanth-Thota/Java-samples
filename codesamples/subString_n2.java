import java.util.*;

public class subString_n2{
	public static void main(String [] args){
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		int off=0;
		int cur=0;
		int end=s.length();
		
		Set<String> set=new HashSet<String>();
		while(off!=end){
			String res=s.substring(cur,end-off);
			if(!res.equals(""))
				
				set.add(res);
			if(cur!=(end-off)) cur++;
			else{
				cur=0;
				off++;
			}
		}
		System.out.print(set.size());
	}
}