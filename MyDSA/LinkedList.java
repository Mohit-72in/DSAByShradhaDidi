package MyDSA;


public class LinkedList {
    public static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    public  void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail =newNode;
        }else{
            newNode.next = head;
            head = newNode;
        }
    }
    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
        }
        tail.next = newNode;
        tail = tail.next;
    }

    public void add(int idx, int data){
        if(idx == 0){
            addFirst(data);
            return;
        }
        Node temp=head;
        int i = 0;
        Node newNode = new Node(data);
        size++;
        while (i<idx-1){
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }
    public int removeFirst(){
        if(head == null){
            System.out.println("LL is Empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int value = head.data;
        head = head.next;
        size--;
        return value;
    }
    public int removeLast(){
        if(head == null){
            System.out.println("LL is Empty!");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int value = head.data;
            head = tail = null;
            size = 0;
            return value;
        }
        Node temp = head;
        while (temp.next != tail){
            temp = temp.next;
        }
        temp.next = null;
        int value = tail.data;
        tail = temp;
        size--;
        return value;

    }

    public void printList(){
        if(head == null){
            System.out.println("List is Empty");
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println();
    }
    public int itrSearch(int key){
        int i = 0;
        for(Node temp = head;temp != null;temp = temp.next){
            if(temp.data == key ){
                return i;
            }
            i++;
        }
        return -1;
    }
    public int helper(Node head, int key){
        if(head == null){
            return -1;
        }
        if(head.data == key){
            return 0;
        }
        int idx = helper(head.next,key);
        if(idx == -1){
            return -1;
        }
        return idx+1;
    }
    public int recSearch(int key){
        return helper(head,key);
    }

    public void reverse(){
        Node prev = null;
        Node curr = tail = head;

        Node next ;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev= curr;
            curr = next;
        }
        head = prev;
    }
    public Node findMid(){
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public boolean checkPalindrom(){
        //Base case
        if(head == null || head.next == null){
            return true;
        }
        //step 1: find middle node
        Node mid = findMid();
        // reverse half part
        Node prev = null;
        Node curr = mid;
        Node next;
        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // check opposite end's value
        Node left = head;
        Node right = prev;
        while (right != null){
            if(left.data  != right.data){
                return false;
            }
            right = right.next;
            left = left.next;
        }
        return true;
    }


    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
//        ll.addFirst(1);
//        ll.addFirst(2);
//        ll.printList();
//        ll.addLast(4);
//        ll.addLast(5);
//        ll.printList();
//        ll.add(3,3);
//        ll.printList();
//        ll.removeFirst();
//        ll.printList();
//        System.out.println(ll.size);
//        ll.removeLast();
//        ll.printList();
//        System.out.println(ll.itrSearch(3));
//        System.out.println(ll.itrSearch(10));
//        System.out.println(ll.recSearch(3));
//        System.out.println(ll.recSearch(10));
//        ll.reverse();
//        ll.printList();

        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(1);
        
        ll.addLast(1);
        System.out.println(ll.checkPalindrom());



    }

}
