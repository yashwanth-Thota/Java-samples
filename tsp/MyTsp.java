/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
* TSP_GA.java
* Create a tour and evolve a solution
*/


import java.awt.Label;
import mytsp.City;

import mytsp.Tour;
import mytsp.TourManager;
/**
 *
 * @author YASHWANTH
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import static java.lang.System.exit;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MyTsp {

    public static void main(String[] args) throws FileNotFoundException, IOException{

PrintStream out;        


        // Initialize population
        int i1=1;
        start:
        while(i1==1){
        try{
       FileOutputStream f=new FileOutputStream("Location File to read inputs ");
       
       System.out.println("Enter the no of cities");
       Scanner s1 =new Scanner(System.in); 
       int n=s1.nextInt();
       System.out.println("Enter the coordinates[pattern:(decimaldegree format)Lat,long\\n]");
       int s=System.in.read();
        while(s!=-1)
        {
        f.write((char)s);
        s=System.in.read();
        }f.close();
        Scanner sc = null;String x[] = null;int k = 0;String y[] = null;
        
            File f0=new File("Location of inoput file");
            sc=new Scanner(f0);
        sc.useDelimiter(",|\\n");int i=0;
        
            x = new String [n]; y= new String [n];
int l=0;
        while(sc.hasNext())
        {
           
            
            Scanner sd=new Scanner(sc.nextLine());
       sd.useDelimiter(",");
       x[l]=sd.next();
            l++;
       y[k]=sd.next();
              k++;
             i++;
              
          }
        
        int x1,y1;
        for(int o=0;o<n;o++)
        {
            x1=0;
            y1=0;
            x1=Integer.parseInt(x[o]);
            y1=Integer.parseInt(y[o]);
            //check latitude and longitude limits
            if(x1>-90 && x1<90 && y1 > -180 && y1<180)
            {
            City c;
                
             c = new City(x1,y1);
            //Add city to the tour
                TourManager.addCity(c);
            }
            else
            {
                System.out.println("Enter the correct lattitudes and longitudes:PRESS\n1)For latitudes and longitude \n2)To exit ");
                Scanner sd=new Scanner(System.in);
                int x2=sd.nextInt();
                switch (x2) {
                    case 1:
                        
                        System.out.println("Latitudes :Between -90 and 90");
                        System.out.println("Latitudes :Between -180 and 1800");
                        continue start;
                    case 2:
                       exit(0);
                    
                }
            }
        }
        
        System.out.println("Check output.txt for optimized tour");
            //set output to a file
       out =new PrintStream(new FileOutputStream("\\output.txt"));
       System.setOut(out);
        TourManager.intialise();
        i1++;
            for(int i2=0;i2<n;i2++)
        {
            Swarm.population(i2);
        }
         TourManager.optimize();
        exit(0);
        }
         catch(IOException |InputMismatchException e){}
        
        
       
        
        
        
    }
    }
}
