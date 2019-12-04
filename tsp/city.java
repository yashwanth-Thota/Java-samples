/*
* City.java
* Models a city
*/
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mytsp;

import java.text.DecimalFormat;

/**
 *
 * @author YASHWANTH
 */
public class City {
    int x;
    int y;
   double dist;
    DecimalFormat df=new DecimalFormat("#.00");
    
   
    
    // Constructs a city at chosen x, y location
    public City(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    // Gets city's x coordinate
    public int getX(){
        return this.x;
    }
    
    // Gets city's y coordinate
    public int getY(){
        return this.y;
    }
    
    // Gets the distance to given city
    public double distanceTo(City c1){
        double lon1,lon2,lat1,lat2;
        lon1=this.y;
        lon2=c1.getY();
        lat1=this.x;
        lat2=c1.getX();
               double theta = lon1 - lon2;
      dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
      dist = Math.acos(dist);
      dist = rad2deg(dist);
      dist = dist * 60 * 1.1515;
      
        dist = dist * 1.609344;
      
      return (Double.parseDouble(String.format("%.2f", dist)));
        
      
    }
     private double deg2rad(double deg) {
      return (deg * Math.PI / 180.0);
    }
      private double rad2deg(double rad) {
      return (rad * 180.0 / Math.PI);
    }
   public static String toString(Tour t,int[] a) {
        String geneString = "";
        for (int i = 0; i < t.tourSize(); i++) {
            City c= t.getCity(a[i]);
            if(i!=t.tourSize()-1)
            {
            geneString+="("+c.getX()+","+c.getY()+")---->";
             }
            else
            {
                geneString+="("+c.getX()+","+c.getY()+")";
            }
        }
        return geneString;
    }
   
}
