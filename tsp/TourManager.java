/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
* TourManager.java
* Holds the cities of a tour
*/

package mytsp;
/**
 *
 * @author YASHWANTH
 */
import java.util.ArrayList;

public class TourManager {

    // Holds our cities
    static final ArrayList destinationCities = new ArrayList<City>();
   private static Tour t=new Tour();
   private static double[] s;
   private static int z;//z holds the start position
   private static int[][]a;
    
    // Adds a destination city
    public static void addCity(City city) {
        destinationCities.add(city);
    }
    
    // Get a city
    public static City getCity(int index){
        return (City)destinationCities.get(index);
    }
    
    // Get the number of destination cities
    public static int numberOfCities(){
        return destinationCities.size();
    }
    public static void display()
    {
        t.tour=destinationCities;
        t.adj_matrix();
         
        for(int i=0;i<numberOfCities();i++)
        {
            for(int j=0;j<numberOfCities();j++)
            {
                System.out.print(t.adjacency_matrix[i][j]+"\t||\t");
            }
            System.out.println();
        }
        
    }
    public static void intialise()
    {
        a=new int[numberOfCities()][numberOfCities()];
        for(int i=0;i<a.length;i++)
        {
            a[z][i]=i;
        }
        for(int i=0;i<numberOfCities();i++)
         {
             City c=getCity(i);
             System.out.println("city"+i+"=\t"+c.getX()+","+c.getY()+"");
         }
        
        s=new double[numberOfCities()];
        System.out.println("Actual tour to be traveled is:");
        t.tour=destinationCities;
        System.out.println(City.toString(t, a[z]));
        System.out.println("Generated adjacency matrix is:");
        display();
        System.out.println("Actual Distance To be covered is:"+Tour.distance(a[z], t));
        
        
        
        
    }
    public static void solve()
    {
        t.tour=destinationCities;
        TSPNearestNeighbour n=new TSPNearestNeighbour ();
        n.tsp(t.adj_matrix());
    }
    public static void distance(int[] a1,int z)
    {   
        t.tour=destinationCities;
        a[z]=a1;
        System.out.println("========================================================================================\n");
        System.out.println("Optimized tour from city"+a1[0]+" is :\n");
        for(int y=0;y<a1.length;y++)
        {
            if(y!=a.length-1)
            System.out.print(a1[y]+"------>");
            else
                System.out.print(a1[y]+"\n");
        }
        
        System.out.println(City.toString(t, a1));
        s[z]=Tour.distance(a1,t);
       
        System.out.println( "\n\n\nOptimized Distance is: "+s[z]);
        
    }
    public static void optimize()
    {
        double min=Double.MAX_VALUE;
        int x=0;
        for(int i=0;i<s.length;i++)
        {
            if(min>s[i])
            {
                min=s[i];x=i;
            }
        }
        t.tour=destinationCities;
       int []b=a[x];
       
       System.out.println("========================================================================================\n");
       System.out.println("SOLUTION:");
       System.out.println("Final Optimized tour from city"+b[0]+" is :\n");
        for(int y=0;y<b.length;y++)
        {
            if(y!=b.length-1)
            System.out.print(b[y]+"------>");
           else
                System.out.print(b[y]+"\n");
        }
        
        System.out.println("\n"+City.toString(t, b));
 
        
        System.out.println( "\n\nOptimized Distance is: "+min);
    }
}
