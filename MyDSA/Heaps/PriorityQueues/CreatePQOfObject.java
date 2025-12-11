package MyDSA.Heaps.PriorityQueues;
/*
Comparable is an interface and has abstract method compareTo so the one
who implement Comaparable interfase has a responsibility to define the compareTo()
*/
import java.util.*;
public class CreatePQOfObject {
    static class Student implements Comparable<Student>{
        String name;
        int rank;
        Student(String name,int rank){
            this.name = name;
            this.rank = rank;
        }

        public int compareTo(Student s2){
            return this.rank - s2.rank;
        }
        @Override
        public String toString(){
            return "Student{"+name+" , "+rank+"}";
        }
    }
    public static void main(String[] args) {
        PriorityQueue<Student> pq = new PriorityQueue<>();
        pq.add(new Student("Mohit",38));
        pq.add(new Student("Rohit",51));
        pq.add(new Student("Rishav",50));
        pq.add(new Student("Ajeet",4));
        System.out.println("Printing student on basis of there rank");
        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }

    }

}
