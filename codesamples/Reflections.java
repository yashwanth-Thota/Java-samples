public class Reflections {
    public static void main(String args[]) {
        System.out.println(checkMatch("abcabc","abcabc"));
    }
    private static int checkMatch(String w1,String w2)
    {
        int [] indexes=getIndexes(w1,w2.charAt(0));
        if(w1.length()==w2.length()) {
            System.out.println(indexes.length);
            for(int i :indexes)
            {
                if(w2.equals(getReflection(w1,i))) return 1;
            }
        }
        return -1;
    }
    private static int[] getIndexes(String str,char c){
        int[] a=new int[str.length()];
        int ind=0;
        for(int i=0;i<str.length();i++)
            if(str.charAt(i)==c) a[ind++]=i;
        return a;
    }
    public static String getReflection(String s,int pos){
        return s.substring(pos)+s.substring(0,pos);
    }
}
