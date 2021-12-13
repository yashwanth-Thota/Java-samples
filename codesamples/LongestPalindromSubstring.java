public class Solution {
    public String longestPalindrome(String A) {
		int cur=0;
		int end=A.length();
        int off=end;
		while(off!=0){
			String res=A.substring(cur,cur+off);
			if(isPalindrome(res)){
			    return res;
			}
			if((cur+off)!=end) cur++;
			else{
				cur=0;
				off--;
			}
		}
        return "";
    }
    boolean isPalindrome(String str){
	    char[] chars=str.toCharArray();
	    for(int i=0;i<chars.length/2;i++){
	        if(chars[i]!=chars[chars.length-1-i]) return false;
	    }
	    return true;
	}
}
