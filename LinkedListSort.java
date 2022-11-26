public class LinkedListSort {

    public static int solve(ListNode A) {
        int prev = 0;
        ListNode temp = A;
        prev = temp.val;
        while (temp != null && temp.next != null) {
            temp = temp.next;
            int curr = temp.val;
            if ((curr - prev) < 0)
                return 0;
            prev = curr;

        }

        return 1;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(9);

        ListNode next = new ListNode(13);
        head.next = next;
        ListNode nextToNexNode = new ListNode(14);
        next.next = nextToNexNode;

        int ans = LinkedListSort.solve(head);
        System.out.println(ans);

        String str = "sanketh";
        // StringBuffer sb = new StringBuffer();
        // sb.append(str.charAt(0));
        // sb.append(str.charAt(1));
        // sb.append(str.charAt(1));
    }
}
