package MyDSA.Pragmatix.general;
import java.util.*;
public class Kthlargest {
    public static int findKthLargest(int[] nums,int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num:nums){
            pq.add(num);
            if(pq.size()>k){
                pq.poll();
            }
        }
        return pq.peek();
    }
    public static int findKthLargest2(int[] nums,int k){
        TreeSet<Integer> set = new TreeSet<>();
        for(int num:nums){
            set.add(num);
        }
        ArrayList<Integer> arr = new ArrayList<>(set);
        return arr.get(arr.size()-k);
    }
    public static int[] countFrequency(int[] nums){
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i : nums){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        int len = hm.values().size();
        int arr[] = new int[len];
        int i = 0;
        for(int j: hm.values()){
            arr[i++] = j;
        }
        return arr;

    }
    public static String countFreq(String s){
        int i = 0,j = 0,len = s.length();
        StringBuilder sb = new StringBuilder();
        while(j<len){
            if(s.charAt(i)!=s.charAt(j)){
                sb.append(s.charAt(i));
                int n = j-i;
                sb.append(n);
                i=j;
            }
            j++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        int[] arr = {1,1,1,2,3,5,1,4,2,2,7,4,};
//        System.out.println(findKthLargest(countFrequency(arr), 3));
        String s = "aaaabbcccddbeee";
        System.out.println(countFreq(s));

    }
}
