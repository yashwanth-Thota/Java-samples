/**
	Author:YASHWANTH THOTA
**/
import java.util.Scanner;
import java.util.Stack;
public class balanced_braces{
	public static void main(String []args){
		Scanner sc=new Scanner(System.in);
		
		String str=sc.nextLine();
		boolean f=true;
	
		Stack<Character> stk=new Stack<Character>();
		for(int i=0;i<str.length();i++)
		{
			char ch=str.charAt(i);
			if(ch=='('||ch=='['||ch=='{') stk.push(ch);
			else if((ch==')'&&(stk.isEmpty()||stk.pop()!='('))||(ch=='}'&&(stk.isEmpty()||stk.pop()!='{'))||(ch==']'&&(stk.isEmpty()||stk.pop()!='['))){
					f=false;
					break;
			}
			
		}
		if(f!=false&&stk.isEmpty()){
			f=true;
		}
		if(f){
			System.out.print("YES");
		}else{
			System.out.print("NO");
		}
	}
}
