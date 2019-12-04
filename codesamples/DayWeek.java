import java.util.Scanner;
import java.util.Calendar;
public class DayWeek { 
	public static String getDay(String day, String month, String year) {    
		Calendar cal = Calendar.getInstance();
        cal.set(Integer.parseInt(year), Integer.parseInt(month)-1, Integer.parseInt(day));
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); 
		String Day[]={"SUNDAY","MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY","SATURDAY"};              
		return(Day[dayOfWeek-1]);
      }

	  public static void main(String arga[]){
		Scanner s=new Scanner(System.in);
		String d=s.next();
		String m=s.next();
		String y=s.next();
		System.out.print(getDay(d,m,y));
	  }
}