package 链表;

/**
 * @author lyq on 2021-04-09 下午10:12
 * @desc 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *      为了表示给定链表中的环，使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 *      如果 pos 是 -1，则在该链表中没有环。
 *      「说明」：不允许修改给定的链表。
 */
public class 环形链表II {

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // 快慢节点相遇
            if (fast == slow) {
                ListNode idx1 = head;
                ListNode idx2 = fast;
                while (idx1 != idx2) {
                    idx1 = idx1.next;
                    idx2 = idx2.next;
                }
                return idx1;
            }
        }
        return null;
    }

}
