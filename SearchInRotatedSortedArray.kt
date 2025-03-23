class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1

        while (left <= right) {
            val pt = (left + right) / 2


            if (nums[pt] == target) {
                return pt
            } else if (nums[left] <= nums[pt]) {
                // means the left part is sorted
                if (target in nums[left]..nums[pt]) {
                    right = pt - 1
                } else {
                    left = pt + 1
                }
            } else {
                // means the right part is sorted
                if (target in nums[pt]..nums[right]) {
                    left = pt + 1
                } else {
                    right = pt - 1
                }
            }
        }

        return -1
    }
}
