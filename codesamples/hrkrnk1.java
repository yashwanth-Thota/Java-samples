import java.util.Scanner;
public class hrkrnk1{
		static int H=0,B=0; static boolean flag=true;
        static{
        Scanner sc=new Scanner(System.in);
        
        H=sc.nextInt();
        B=sc.nextInt();
        try{
               if(H<=0||B<=0){
                   flag=false;
                   throw new java.lang.Exception();
               }
        }catch(java.lang.Exception e){
            System.out.print("java.lang.Exception: Breadth and height must be positive");
        }
    
    }
	public static void main(String args[])
	{
		if(flag){
			int a=B*H;
			System.out.print(a);
		}
	}
	
}