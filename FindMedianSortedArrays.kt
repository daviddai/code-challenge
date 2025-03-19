class Solution1 {
    fun findMedianSortedArrays(
        nums1: IntArray,
        nums2: IntArray
    ): Double {
        if (nums1.size > nums2.size) {
            return findMedianSortedArrays(nums2, nums1)
        }

        val nums1Size = nums1.size
        val nums2Size = nums2.size
        var left = 0
        var right = nums1Size
        val totalSize = nums1Size + nums2Size

        while (left <= right) {
            val i = (left + right) / 2
            val j = (totalSize + 1) / 2 - i

            val leftMax1 = if (i > 0) nums1[i - 1] else Int.MIN_VALUE
            val rightMin1 = if (i < nums1Size) nums1[i] else Int.MAX_VALUE
            val leftMax2 = if (j > 0) nums2[j - 1] else Int.MIN_VALUE
            val rightMin2 = if (j < nums2Size) nums2[j] else Int.MAX_VALUE

            if (leftMax1 <= rightMin2 && leftMax2 <= rightMin1) {
                return if (totalSize % 2 == 0) {
                    (Math.max(leftMax1, leftMax2) + Math.min(rightMin1, rightMin2)) / 2.0
                } else {
                    Math.max(leftMax1, leftMax2).toDouble()
                }
            } else if (leftMax1 > rightMin2) {
                right = i - 1
            } else {
                left = i + 1
            }
        }

        throw Exception("Illegal Input")
    }
}

class Solution2 {
   fun findMedianSortedArrays(
       nums1: IntArray,
       nums2: IntArray
   ): Double {
       val pq = PriorityQueue<Int>()

       for (n1 in nums1) {
           pq.add(n1)
       }

       for (n2 in nums2) {
           pq.add(n2)
       }

       val combinedNums = mutableListOf<Int>()
       while (pq.isNotEmpty()) {
           combinedNums.add(pq.poll())
       }

       return if (combinedNums.size % 2 == 0) {
           (combinedNums[combinedNums.size / 2].toDouble() + combinedNums[combinedNums.size / 2 - 1].toDouble()) / 2
       } else {
           combinedNums[combinedNums.size / 2].toDouble()
       }
   }
}
