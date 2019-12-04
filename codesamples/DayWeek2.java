import java.util.Scanner;
import java.time.LocalTime;
public class DayWeek { 
	public static String getDay(int day, int month, int year) {    
		LocalTime l=LocalDate.of(year,month,day);
		return l.getDayOfWeek();
      }
		//demo change from local
	  public static void main(String arga[]){
		Scanner s=new Scanner(System.in);
		int d=s.nextInt();
		int m=s.nextInt();
		int y=s.nextInt();
		System.out.print(getDay(d,m,y));
	  }
}