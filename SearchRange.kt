// find first and last elements in the array
class Solution {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        var start = -1
        var end = -1

        for (i in nums.indices) {
            if (nums[i] == target) {
                if (start == -1) {
                    start = i
                }

                end = i
            }
        }

        return intArrayOf(start, end)
    }
}
