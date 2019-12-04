import java.util.*;
public class subString_n1{
public static void main (String []args) {
	String text="indiabahfjdsahldfhasljdhfjsdhajfvbsbvdhbsadhviasfduhasidfbhasbfyuhvashbcnbcnzmCbavuyfvaushyvfbafjbsjfhasuifdgbashfbhabfkshhajsgfsadljhalsjdvjsabndvjbsajihusiadvhjcasdvbasdvkajsbdvksandcjnadsljdcnjsbvdhgauyerigfabsfjvasfyewtfiuafbhasdbjvszcuvusaygfiasuofibshdavhjabsiuvygsahvbdjsnvoasutfryasgfhjasjfgashdvgjadszbcuhgadsiyfuashdfhaskfaisufygaufhbdsvasiuyfguaewifyuhbasdvjsafiuaygbhvdjdsvuiagyfdashbhcsdcyuadfhbvhjaieufgyadhsbcbdh";
    Set<String> set = new HashSet<String>();
	for(int length=0;length<text.length();length++){
    for(int i=0; i < text.length() - length + 1; i++) {
        String sub = text.substring(i,length+i);
        set.add(sub);
    }
    }
    System.out.print(set.size());
}
}