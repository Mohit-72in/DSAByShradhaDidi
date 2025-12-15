package MyDSA.Heaps.Mislaneous;
import java.util.*;
public class BuildMaxHeap {
    static class Heap{
        ArrayList<Integer> arr;
        public Heap(){
            arr = new ArrayList<>();
        }

        public void add(int data){
            if(isEmpty()){
                arr.add(data);
                return;
            }
            arr.add(data);
            int x = arr.size()-1;
            int p = (x-1)/2;
            while(arr.get(p) < arr.get(x)){
                swap(p,x);
                x = p;
                p = (x-1)/2;
            }
        }
        public void swap(int p,int x){
            int temp = arr.get(p);
            arr.set(p,arr.get(x));
            arr.set(x,temp);
        }
        public boolean isEmpty(){
            return arr.size()==0;
        }
        public int peek(){
            return arr.get(0);
        }

        public int poll(){
            if(isEmpty()) return -1;
            int x = arr.size()-1;
            int data = arr.get(0);
            swap(x,0);
            arr.remove(x);
            heapify(0);
            return data;
        }
        private void heapify(int i){
            int left = 2*i+1;
            int right = 2*i+2;
            int max = i;
            int n = arr.size()-1;
            if(left <= n && arr.get(left) > arr.get(i) ) max = left;
            if(right <= n && arr.get(right) > arr.get(max)) max = right;
            if(i != max){
                swap(i,max);
                heapify(max);
            }
        }
    }

    public static void main(String[] args) {
        Heap maxHeap = new Heap();
        maxHeap.add(3);
        maxHeap.add(1);
        maxHeap.add(7);
        maxHeap.add(4);
        System.out.println("Elements of maxHeap are:");
        while (!maxHeap.isEmpty()){
            System.out.print(maxHeap.peek() + " ");
            maxHeap.poll();
        }
        System.out.println();

    }
}
