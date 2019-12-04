import java.util.*;
public class sortDates{
	public static void main(String []args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		ArrayList<String> dates=new ArrayList<String>(Arrays.asList("20 Jan 1997","31 Mar 1952","04 Jun 1992","31 Dec 1997","14 Nov 1984"));
		/*for(int i=0;i<n;i++){
			dates.add(sc.next());
		}*/
		for(String str : sort(dates)){
		System.out.println(str);}
	}
	public static ArrayList<String> sort(ArrayList<String> dates){
		ArrayList<String> months=new ArrayList<String>(Arrays.asList("Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"));
		ArrayList<String> y=new ArrayList<String>();
		ArrayList<String> d=new ArrayList<String>();
		ArrayList<String> m=new ArrayList<String>();
		ArrayList<String> res=new ArrayList<String>();
		for(String str : dates){
			d.add(str.substring(0,2));
			m.add(str.substring(3,6));
			y.add(str.substring(7,11));
		}
		for(int i=0;i<dates.size();i++)
		{
			
			for(int j=0;j<dates.size();j++){
				String yi=y.get(i);
				String di=d.get(i);
				int mi=months.indexOf(m.get(i));
				String mis=m.get(i);
				String yj=y.get(j);
				String dj=d.get(j);
				int mj=months.indexOf(m.get(j));
				String mjs=m.get(j);
				if(Integer.parseInt(yi)<Integer.parseInt(yj)){
					
					y.set(i,yj);
					d.set(i,dj);
					m.set(i,mjs);
					y.set(j,yi);
					d.set(j,di);
					m.set(j,mis);
				}else if(Integer.parseInt(yi)==Integer.parseInt(yj)){
					if(mi<mj){
						d.set(i,dj);
						m.set(i,mjs);
						d.set(j,di);
						m.set(j,mis);
					}else if(mi==mj){
						if(Integer.parseInt(di)<Integer.parseInt(dj)){
							d.set(i,dj);
							d.set(j,di);
						}
					}
				}
			}
		}
		for(int i=0;i<dates.size();i++){
			res.add(d.get(i)+" "+m.get(i)+" "+y.get(i));
		}
			return res;
	}
}