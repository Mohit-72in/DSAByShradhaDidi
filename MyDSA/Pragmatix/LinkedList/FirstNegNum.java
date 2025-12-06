package MyDSA.Pragmatix.LinkedList;

public class FirstNegNum {
    public static void main(String[] args) {
        List list = new List();

        list.addList(1);
        list.addList(1);
        list.addList(-3);
        list.addList(2);
        list.addList(2);

        list.printList();

//        int firstNeg = list.FirstNegNum();
//        if (firstNeg != 0) {
//            System.out.println("First negative number: " + firstNeg);
//        } else {
//            System.out.println("No negative numbers found.");
//        }
        int lastidx = list.lastOccurances(1);
        if(lastidx == -1){
            System.out.println("Element not Present");
        }else {
            System.out.println("Last Index Of Element in list is: "+lastidx);
        }
    }
}

class ListNode {
    int data;
    ListNode next;

    ListNode(int val) {
        data = val;
        next = null;
    }
}

class List {
    ListNode head;

    // Add node to end of list
    public int lastOccurances(int target){
        ListNode temp = head;
        int lastIdx = -1;
        int count = 0;
        while (temp != null){
            if(temp.data == target){
                lastIdx = count+1;
            }
            count++;
            temp = temp.next;
        }
        return lastIdx;
    }

    public void addList(int data) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            head = newNode;
        } else {
            ListNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Print the list
    public void printList() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("Null");
    }

    // Find first negative number
    public int FirstNegNum() {
        ListNode temp = head;
        while (temp != null) {
            if (temp.data < 0) {
                return temp.data;
            }
            temp = temp.next;
        }
        return 0;
    }
}
