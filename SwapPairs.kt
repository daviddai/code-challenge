class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun swapPairs(head: ListNode?): ListNode? {
        val dummy = ListNode(0)
        dummy.next = head
        var pt = dummy

        while (pt.next != null && pt.next.next != null) {
            val first = pt.next
            val second = pt.next.next

            first.next = second.next
            pt.next = second
            second.next = first

            pt = pt.next.next
        }

        return dummy.next
    }
}
