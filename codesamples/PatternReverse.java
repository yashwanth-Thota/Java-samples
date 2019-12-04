public class PatternReverse {
    private static int no=6;
    private static String pat="11111111111111111111111111111111111111111111111111111111111111111111";
    public static void main(String args[]) {
        printPattern(no);
    }
    private static String getString(int i)
    {
        String str=pat.substring(0,no);
        return str.replaceAll("1",Integer.toString(i));
    }
    private static void printPattern(int i){
        int j=1;
        while(j<=i){
        if(j%2==1)
        {
            System.out.println(getString(j)+(j+1));
        }
        else{
             System.out.println(j+1+getString(j));
        }
        j++;
        }
    }
 }
