package MyDSA.Heaps.PriorityQueues;
import java.util.Comparator;
import java.util.PriorityQueue;
public class CreatePriorityQueue {
    public static void main(String[] args) {
        //Create Min Heap using PriorityQueue
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(3);
        minHeap.add(7);
        minHeap.add(1);
        minHeap.add(11);
        System.out.println("Min Heap\n");

        while (!minHeap.isEmpty()){
            System.out.print(minHeap.remove()+" ");
        }
        System.out.println("\nMax Heap");


        // create max heap using PriorityQueue
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        maxHeap.offer(3);
        maxHeap.offer(11);
        maxHeap.offer(1);
        maxHeap.offer(7);
        while(!maxHeap.isEmpty()){
            System.out.println(maxHeap.poll());
        }


    }

}
