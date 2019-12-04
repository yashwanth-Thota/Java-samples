/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
* Tour.java
* Stores a candidate tour
*/

package mytsp;
import mytsp.City;
/**
 *
 * @author YASHWANTH
 */
import java.util.ArrayList;

public class Tour{

   
    public static ArrayList tour = new ArrayList<City>();
    private static double distance = 0;
     private static double distance2 = 0;
    double adjacency_matrix[][] = null;
   
    public Tour(){
        for (int i = 0; i < TourManager.numberOfCities(); i++) {
            tour.add(null);
        }
    }
    public City getCity(int tourPosition) {
        return (City)tour.get(tourPosition);
    }

    
    
    public double[][] adj_matrix(){
        adjacency_matrix= new double[tourSize()][tourSize()];
        for(int index=0;index<tourSize();index++)
        {
            for(int j=0;j<tourSize();j++)
            {
                if(j==index)
                {
                    adjacency_matrix[index][j]=0.00f;
                } 
                else {
                    City fromCity = getCity(index);
                    City destinationCity=getCity(j);
                    adjacency_matrix[index][j]=fromCity.distanceTo(destinationCity);
                    
                }
            }
        }
        return adjacency_matrix;
     }
    public static double distance(int[] a,Tour t){
        distance = 0;
        City fromCity = t.getCity(a[0]);
                    City destinationCity;
        for(int index=1;index<t.tourSize();index++)
        {
            destinationCity=t.getCity(a[index]);
            distance+=fromCity.distanceTo(destinationCity);
            fromCity=destinationCity;
        }
        
      
        return distance;
    }
    // Get number of cities on our tour
    public int tourSize() {
        return tour.size();
    }
    
   
    
}
