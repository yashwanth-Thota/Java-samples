import java.util.*;
public class Substring_n{
	public static void main(String []args){
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		int c=0;
		
		int n=str.length();
		
		Map<Character,Integer> map =
                    new HashMap<Character, Integer>();
        for(int i=0;i<n;i++)
        {
            if (map.keySet().contains(str.charAt(i)))
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
            else
                map.put(str.charAt(i), 1);
        }
		c=(n*(n+1))/2;
		for (Map.Entry<Character,Integer> entry : map.entrySet())
        {
            
            Integer val = entry.getValue();
			System.out.println(entry.getKey()+" : "+val);
			if(val>1) c-=val;
		}
        
		System.out.print(c);
	}
}