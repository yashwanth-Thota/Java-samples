import java.util.*;
public class Solution
{
	public static void main(String [] args)
	{
		Scanner sc=new Scanner(System.in);
		String str="1234567890";
		Set<ArrayList<Integer>> result=new HashSet<ArrayList<Integer>>();
		ArrayList<Integer> list=new ArrayList<Integer>();
		int cur=0,off=0,end=str.length();result.clear();list.clear();
		if(end==8)
		{
			while(cur!=end)
			{
				list.clear();
				for(int i=0;i<end-off;i++)
				{
					list.add((int)str.charAt(i)-48);
				}
				if(cur!=(end-off)) cur++;
				else
				{
					cur=0;
					off++;
				}
				result.add(list);
			}
		}
		else
		{
			int no_two_bits,temp=0,index=0,num,count;
			cur=0;off=0;
			while(cur!=end)
			{
			    count=8;
				list=new ArrayList<Integer>();index=0;temp=0;
				no_two_bits=end-8;
				while(index<cur)
				{
					list.add((int)str.charAt(index)-48);index++;count--;
				}
				while(temp!=no_two_bits&&(end-index>1))
				{
					num=Integer.parseInt(str.substring(index,index+2));
					if(num<=80&&num>=0)
					{
					list.add(num);count--;
					temp++;
					index+=2;
					   for(ArrayList l:GetNumbers(str.substring(index),count))
					   {
					       ArrayList<Integer> tempList=new ArrayList<Integer>();tempList.addAll(list);
					       tempList.addAll(l);
					       result.add(tempList);
					       index=end;
					   }
					    
					}else{
						list.add((int)str.charAt(index)-48);index++;
					}
				}
				for(int i=index;i<end;i++)
				{
					list.add((int)str.charAt(i)-48);
				}
				if(cur!=(end-off)) cur++;
				else
				{
					cur=0;
					off++;
				}
				if(list.size()==8)
				{
					result.add(list);
				}
			}
		}
		for(ArrayList temp :result)
			System.out.println(temp);
	}
	private static Set<ArrayList<Integer>> GetNumbers(String str,int count)
	{
	    Set<ArrayList<Integer>> result=new HashSet<ArrayList<Integer>>();
	    ArrayList<Integer> list;
	    int no_two_bits=str.length()-count,temp=0,index=0,num;
			int end=str.length(),cur=0,off=0;
			while(cur!=end)
			{
				list=new ArrayList<Integer>();index=0;temp=0;
				
				while(index<cur)
				{
					list.add((int)str.charAt(index)-48);index++;
				}
				while(temp!=no_two_bits&&(end-index>1)&&no_two_bits>0)
				{
					num=Integer.parseInt(str.substring(index,index+2));
					if(num<=80&&num>=0&&!list.contains(num))
					{
					list.add(num);
					temp++;
					index+=2;}else{
					    num=(int)str.charAt(index)-48;
						if(!list.contains(num))
						{list.add(num);index++;}
					}
				}
				for(int i=index;i<end;i++)
				{
				    num=(int)str.charAt(i)-48;
					if(!list.contains(num))
					    list.add(num);
				}
				if(cur!=(end-off)) cur++;
				else
				{
					cur=0;
					off++;
				}
				    if(list.size()==count)
				    {
					    result.add(list);
				    }
			}
	    return result;
	}
	
}