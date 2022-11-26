public class LinkedListInsert {
   

    public static ListNode solve(ListNode A, int B, int C) {
        ListNode temp = A;
        int count = 0;
        while (count < C - 1) {
            temp = temp.next;
            count += 1;
        }

        ListNode ele = new ListNode(B);
        ele.next = temp.next;
        temp.next = ele;

        return A;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(7);
        ListNode ans =LinkedListInsert.solve(head, 5, 7);
        System.out.println(ans);
    }
}
