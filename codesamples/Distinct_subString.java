import java.util.*;
public class Distinct_subString{
	public static void main(String []args){
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		int c=0;
		ArrayList<String> set = new ArrayList<String>();
		
		
		
		String s=str;
		int n=str.length();
        for (int i = 0; i < n; i++) {
            for (int j = s.length()-1; j >= 0; j--) {
                String elem = s.substring(0, j+1);
                if (!set.contains(elem)) {
					System.out.println(elem);
                    set.add(elem);
					c++;
                }
            }
			if(s.length()>2){
				s=str.substring(i+1,n);
			}else if(s.length()==2){
				s=Character.toString(s.charAt(1));
			}
        }
		System.out.print(c);
	}
}