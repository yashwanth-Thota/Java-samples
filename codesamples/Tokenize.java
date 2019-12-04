import java.io.*;
import java.util.*;

public class Tokenize {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        // Write your code here.
		
		
        String str[]=s.split("\\s+|,\\s*|\\?+\\s*|\\'+\\s*|\\!+\\s*|\\_+\\s*|\\@+\\s*|\\.+\\s*");
        System.out.println(str.length);
        for(int i=0;i<str.length;i++){
            System.out.println(str[i]);
        }
        scan.close();
    }
}