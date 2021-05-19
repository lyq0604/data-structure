package 链表;

/**
 * @author lyq on 2021-04-08 下午10:49
 * @desc 删除链表中等于给定值 val 的所有节点。
 */
public class 移除链表元素 {

    public ListNode removeElements(ListNode head, int val) {
        ListNode pre = new ListNode();
        pre.next = head;
        ListNode cur = pre;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return pre.next;
    }

}
