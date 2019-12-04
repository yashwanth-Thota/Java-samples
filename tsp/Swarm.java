/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytsp;

/**
 *
 * @author YASHWANTH
 */
public class Swarm {
    
    public static void population(int n)
    {
        TSPNearestNeighbour.z=n;
       // TourManager.z=n;
        TourManager.solve();
       
    }
}
