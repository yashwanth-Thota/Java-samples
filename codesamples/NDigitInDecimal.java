import java.util.Scanner;
public class NDigitInDecimal {
    public static void main(String args[] ) throws Exception {
        Scanner sc=new Scanner(System.in);
        int t,n,d,r;
        // read no of testcases(t)
        t=Integer.parseInt(sc.nextLine());
        String inps[];
        while(t>0){
            // read Numerator(n),Denominator(d) Fraction and Digit(r) number
            inps=sc.nextLine().split(" ");
            n=Integer.parseInt(inps[0]);
            d=Integer.parseInt(inps[1]);
            r=Integer.parseInt(inps[2]);
            System.out.println(nDigit(n,d,r));
            t--;
        }
    }
    private static int nDigit(int x,int y,int n){
        while(n>0){
            x=10*(x%y);
            n--;
        }
        return (x/y)%10;
    }
}
