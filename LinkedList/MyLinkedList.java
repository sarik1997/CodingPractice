package LinkedList;

class MyLinkedList {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    ListNode head;

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();

        // Insert operations
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtBeginning(5);
        list.insertAtEnd(30);
        list.insertAtBeginning(7);
        list.insertAtEnd(9);


        System.out.print("Linked List: ");
        list.printList();  // Output: 5 → 10 → 20 → 30 → null

        // Delete operation
        list.deleteNode(10);
        System.out.print("After Deletion: ");
        list.printList();  // Output: 5 → 20 → 30 → null

        // Search operation
        System.out.println("Search 20: " + list.search(20)); // true
        System.out.println("Search 50: " + list.search(50)); // false
        list.reverseList();
        System.out.println("ReverseLinkedList");
        list.printList();
        list.reverseBetween(2,4);
        System.out.println("ReverseLinkedList");
        list.printList();

    }

    // Insert at the beginning
    public void insertAtBeginning(int data) {
        ListNode newNode = new ListNode(data);
        newNode.next = head;
        head = newNode;
    }

    // Insert at the end
    public void insertAtEnd(int data) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            head = newNode;
            return;
        }
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Delete a node by value
    public void deleteNode(int key) {
        if (head == null) return;

        // If head needs to be removed
        if (head.val == key) {
            head = head.next;
            return;
        }

        ListNode temp = head;
        while (temp.next != null && temp.next.val != key) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    // Search for an element
    public boolean search(int key) {
        ListNode temp = head;
        while (temp != null) {
            if (temp.val == key) return true;
            temp = temp.next;
        }
        return false;
    }

    // Print the linked list
    public void printList() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " → ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void reverseList() {
        if (head == null) {
            return;
        }
        ListNode temp = head;
        ListNode prev = null;
        while (temp != null) {
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;

        }
        head = prev;
    }

    public void reverseBetween(int left, int right) {
        if (head == null || left == right)
            return; // Edge case: No need to reverse

        ListNode dummy = new ListNode(0); // Dummy node to handle edge cases
        dummy.next = head;
        ListNode prev = dummy;

        // Step 1: Move `prev` to just before `left`
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // Step 2: Reverse the sublist from `left` to `right`
        ListNode current = prev.next;
        ListNode next = null;
        ListNode beforeLeft = prev; // Node just before `left`
        ListNode leftNode = current; // First node in the reversed section

        for (int i = left; i <= right; i++) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        // Step 3: Reconnect the reversed part
        beforeLeft.next = prev; // Connect beforeLeft to new start of reversed section
        leftNode.next = current; // Connect end of reversed section to `right + 1`

        head = dummy.next;
    }

    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
    public ListNode findMiddle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


//Merge Two sorted LinkedList into sorted list (O(n+m))
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1), tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }
}
