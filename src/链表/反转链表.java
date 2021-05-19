package 链表;

/**
 * @author lyq on 2021-04-08 下午11:21
 * @desc 反转一个单链表。
 */
public class 反转链表 {

    public ListNode reverseList(ListNode head) {
        ListNode pre = new ListNode();
        while (head.next != null) {
            ListNode tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        return head;
    }

}
