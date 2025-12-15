package MyDSA.Heaps.Mislaneous;
import java.util.*;

public class BuildMinHeap {
    // Min Heap
    static class Heap {
        ArrayList<Integer> arr;

        public Heap() {
            arr = new ArrayList<>();
        }

        public void add(int data) {
            arr.add(data);  // IMPORTANT
            int i = arr.size() - 1;
            int par = (i - 1) / 2;

            while (i > 0 && arr.get(par) > arr.get(i)) {
                swap(par, i);
                i = par;
                par = (i - 1) / 2;
            }
        }

        public int peek() {
            if (!isEmpty()) return arr.get(0);
            return -1;
        }

        public void swap(int p, int x) {
            int temp = arr.get(p);
            arr.set(p, arr.get(x));
            arr.set(x, temp);
        }

        public boolean isEmpty() {
            return arr.size() == 0;
        }

        public int remove() {
            if (isEmpty()) return -1;

            int data = arr.get(0);
            int last = arr.size() - 1;

            swap(0, last);
            arr.remove(last);
            heapify(0);

            return data;
        }

        private void heapify(int i) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int min = i;
            int n = arr.size() - 1;

            if (left <= n && arr.get(left) < arr.get(min))
                min = left;

            if (right <= n && arr.get(right) < arr.get(min))
                min = right;

            if (min != i) {
                swap(i, min);
                heapify(min);
            }
        }
    }

    public static void main(String[] args) {
        Heap pq = new Heap();
        pq.add(3);
        pq.add(1);
        pq.add(7);
        pq.add(4);

        System.out.println("Elements of minHeap are:");
        while (!pq.isEmpty()) {
            System.out.print(pq.peek() + " ");
            pq.remove();
        }
        System.out.println();
    }
}
