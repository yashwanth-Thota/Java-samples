import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Scanner;
public class IpChec{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		
		
		
		while(sc.hasNext()){
			String Ip=sc.next();
		System.out.println(Ip.matches(new MyRegex().pattern));
		}
	}
}
class MyRegex{
    String pattern;
	MyRegex(){
		
		
		
		
		
		//pattern="[0-1]{0,1}\\d{0,2}|2([0-4]{0,1}\\d{0,1}|5[0-5]{0,1})";
		pattern="([0-1]{0,1}\\d{0,2}|2([0-4]{0,1}\\d{0,1}|5[0-5]{0,1}))\\.([0-1]{0,1}\\d{0,2}|2([0-4]{0,1}\\d{0,1}|5[0-5]{0,1}))\\.([0-1]{0,1}\\d{0,2}|2([0-4]{0,1}\\d{0,1}|5[0-5]{0,1}))\\.([0-1]{0,1}\\d{0,2}|2([0-4]{0,1}\\d{0,1}|5[0-5]{0,1}))";
		//pattern="[0-1]{0,1}\\d{0,2}\\.[0-1]{0,1}\\d{0,2}\\.[0-1]{0,1}\\d{0,2}\\.[0-1]{0,1}\\d{0,2}|2[0-4]\\d{0,1}\\.2[0-4]\\d{0,1}\\.2[0-4]\\d{0,1}\\.2[0-4]\\d{0,1}|25[0-5]{0,1}\\.25[0-5]{0,1}\\.25[0-5]{0,1}\\.25[0-5]{0,1}";
		}
}