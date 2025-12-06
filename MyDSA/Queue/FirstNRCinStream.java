package MyDSA.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNRCinStream {
    public static void main(String[] args) {
        String str = "aabccxb";
        printNonRepeating(str);
    }

    private static void printNonRepeating(String str) {
        Queue<Character> q = new LinkedList<>();
        int[] freq = new int[26];
        int n = str.length();
        for(int i = 0;i<n;i++){
            char ch = str.charAt(i);
            freq[ch-'a']++;
            q.add(ch);

            while(!q.isEmpty() && freq[q.peek()-'a']>1){
                q.remove();
            }
            //case 1
            if(q.isEmpty()){
                System.out.print(-1+" ");
            }else{
                System.out.print(q.peek()+" ");
            }
        }
        System.out.println();
    }
}
