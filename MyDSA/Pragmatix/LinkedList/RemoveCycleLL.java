package MyDSA.Pragmatix.LinkedList;

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
    }
}

public class RemoveCycleLL {
    static Node head = null;

    // Detect if cycle exists using Floyd's Cycle Detection
    public static boolean isCycleExist(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    // Remove cycle and return updated head
    public static Node removeCycle(Node head) {
        Node slow = head;
        Node fast = head;
        boolean isCycle = false;

        // Detect cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                isCycle = true;
                break;
            }
        }

        if (!isCycle) return head;

        // Reset slow to head to find the start of the cycle
        slow = head;

        if (slow == fast) {
            // Cycle starts at head
            while (fast.next != slow) {
                fast = fast.next;
            }
            fast.next = null;
        } else {
            Node prev = null;
            while (slow != fast) {
                prev = fast;
                slow = slow.next;
                fast = fast.next;
            }
            prev.next = null;
        }

        return head;
    }


    // Safe printList (limited traversal)
    public static void printList(Node head) {
        Node temp = head;
        int count = 0;
        while (temp != null && count < 100) { // just in case a cycle was not removed
            System.out.print(temp.data + " -> ");
            temp = temp.next;
            count++;
        }
        System.out.println("null");
    }

    public static void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node t = head;
            while (t.next != null) {
                t = t.next;
            }
            t.next = newNode;
        }
    }
    public static Node findMid(Node head){
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node mergeSort(Node head){
        if(head == null || head.next == null){
            return head;
        }
        //find mid
        Node mid = findMid(head);
        //break list into two halves
        Node rightHead = mid.next;
        mid.next = null;
        Node leftHead = head;
        Node sortedLeft = mergeSort(leftHead);
        Node sortedRight = mergeSort(rightHead);
        //merge both sorted list
        return merge(sortedLeft,sortedRight);


    }
    public static Node merge(Node list1,Node list2){
        Node dummy = new Node(0);
        Node tail = dummy;
        while (list1 != null && list2 != null){
            if(list1.data < list2.data){
                tail.next = list1;
                list1 = list1.next;
            }else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        if(list1 != null){
            tail.next  = list1;
        }
        if(list2  != null){
            tail.next = list2;
        }
        return dummy.next;
    }
    public static void zigZagll(Node head){
        //find mid
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null ){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;
        //reverse 2nd half
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;
        while(curr != null){
            next  = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // join zigZag manner
        Node left = head;
        Node right = prev;
        Node nextl;
        Node nextr;
        while(left != null && right != null){
            nextl = left.next;
            left.next = right;
            nextr = right.next;
            right.next = nextl;
            left = nextl;
            right = nextr;
        }   
    }

    public static void main(String[] args) {
//        // Manually creating a cycle
//        head = new Node(1);
//        head.next = new Node(2);
//        head.next.next = new Node(3);
//        head.next.next.next = head; // Cycle here
//
//        System.out.println("Cycle Exists Before Removal: " + isCycleExist(head));
//
//        removeCycle(head); // Remove it safely
//
//        System.out.println("After Cycle Removal:");
//        printList(head);
//
//        System.out.println("Cycle Exists After Removal: " + isCycleExist(head));
        add(5);
        add(4);
        add(3);
        add(2);
        add(1);
        add(0);
        printList(head);
        head = mergeSort(head);
        printList(head);
        zigZagll(head);
        printList(head);

    }
}
