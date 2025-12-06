package MyDSA.Queue;
import java.util.*;
public class QueueInterleave2Halves {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);

        interLeave(q);
        while(!q.isEmpty()){
            System.out.println(q.remove());
        }
    }

    private static void interLeave(Queue<Integer> q) {
        int size = q.size();
        Queue<Integer> q1 = new LinkedList<>();
        int i = 0;
        while(i<size/2){
            q1.add(q.remove());
            i++;
        }
        for(int j = 0;j<size/2;j++){
            q.add(q1.remove());
            q.add(q.remove());
        }
        return;
    }
}
