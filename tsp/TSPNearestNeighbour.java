/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytsp;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author YASHWANTH
 */
public class TSPNearestNeighbour {
 
         private static int numberOfNodes;
    private static Stack<Integer> s;
    public static int z;
   public static int[] a;
 public static List c = new ArrayList<int[]>();
    public TSPNearestNeighbour()
    {
        s = new Stack<>();
    }
 //to evaluate a path
    public static void tsp(double adjacencyMatrix[][])
    {
        try{
        numberOfNodes = adjacencyMatrix[1].length ;
        int[] visited = new int[numberOfNodes];	
        for(int i=0;i<numberOfNodes;i++)
        {
            visited[i]=0;
        }
        visited[z]=1;
        s.push(z);
        int element, dst = 0, i;
        Double min = Double.MAX_VALUE;
        int[] a=new int[numberOfNodes];
        a[0]=z;
        String[]n = null;
        boolean minFlag = false;
       // System.out.print(z + "\t");
       int k=1;
 
        while (!s.isEmpty())
        {
            element = s.peek();
            i = 0;
            min = Double.MAX_VALUE;
            while (i <numberOfNodes)
            {
                if (adjacencyMatrix[element][i] > 0 && i!=z && visited[i] == 0)
                {
                    if (min > adjacencyMatrix[element][i])
                    {
                        min = adjacencyMatrix[element][i];
                        dst = i;
                        
                        minFlag = true;
                    }
                }
                i++;
            }
            if (minFlag&&(s.contains(dst)==false))
            {
                visited[dst] = 1;
                s.push(dst);
                if(dst!=z)
                {
                a[k]=dst;}k++;
               // System.out.print(dst + "\t");
                minFlag = false;
                continue;
            }
            s.pop();
        }
       c.add(z,a);
       //System.out.print(c.size() + "\t");
             TourManager.distance(a,z);
    
        }
        catch(Exception e){}
    }
}
