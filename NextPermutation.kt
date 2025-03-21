class Solution {
    // The next permutation of an array is the smallest possible
    // arrangement of numbers that is larger than the current arrangement
    // (in lexicographic order).
    fun nextPermutation(nums: IntArray): Unit {
        if (nums.size <= 1) {
            return
        }

        var i = nums.size - 2
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            --i
        }

        if (i >= 0) {
            var j = nums.size - 1
            while (i < j && nums[j] <= nums[i]) {
                --j
            }

            swap(nums, i, j)
        }

        reverse(nums, i + 1, nums.size - 1)
    }

    private fun reverse(nums: IntArray, start: Int, end: Int) {
        var left = start
        var right = end
        while (left < right) {
            swap(nums, left, right)
            ++left
            --right
        }
    }

    private fun swap(nums: IntArray, i: Int, j: Int) {
        val tmp = nums[j]
        nums[j] = nums[i]
        nums[i] = tmp
    }
}
