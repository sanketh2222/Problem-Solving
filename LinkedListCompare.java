/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class LinkedListCompare {
    public int solve(ListNode A, ListNode B) {
        ListNode temp = A;
        ListNode tempA = B;
        if (getLength(A) != getLength(B))
            return 0;
        
        while(temp != null){
            if (temp.val != tempA.val){
                return 1;
            }
            temp = temp.next;
            tempA = tempA.next;
        }

        return 0;
            
        }
    

    private int getLength(ListNode node){
        ListNode temp = node;
        int count = 0;
        while (temp != null){
            temp = temp.next;
            count+=1;
        }

        return count;
    }

 
}
