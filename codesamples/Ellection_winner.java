import java.util.*;
 
public class Ellection_winner
{
    public static void findWinner(String votes[])
    {
        
        Map<String,Integer> map =
                    new HashMap<String, Integer>();
        for (String str : votes)
        {
            if (map.keySet().contains(str))
                map.put(str, map.get(str) + 1);
            else
                map.put(str, 1);
        }
        int maxValueInMap = 0;
        String winner = "";
        
        for (Map.Entry<String,Integer> entry : map.entrySet())
        {
            String key  = entry.getKey();
            Integer val = entry.getValue();
            if (val > maxValueInMap)
            {
                maxValueInMap = val;
                winner = key;
            }
            else if (val == maxValueInMap &&
                winner.compareTo(key) > 0)
                winner = key;
        }
        System.out.println(winner);
    }
 
    // Driver code
    public static void main(String[] args)
    {
       String[] votes = { "john", "johnny", "jackie",
                         "johnny", "john", "jackie",
                         "jamie","johnny", "jamie", "john",
                         "johnny", "jamie","johnny", "johnny",
                         "john" };
 
       findWinner(votes);
    }
}