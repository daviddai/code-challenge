class Solution {
    fun minOperations(nums: IntArray): Int {
        var opsCount = 0
        var numsSize = nums.size

        for (i in 0 until numsSize - 2) {
            if (nums[i] == 0) {
                nums[i] = 1
                nums[i + 1] = nus[i + 1] xor 1
                nums[i + 2] = nus[i + 2] xor 1
                ++opsCount
            }
        }

        if (nums[numsSize - 2] == 0 || nums[numsSize - 1] == 0) {
            return -1
        } else {
            return opsCount
        }
    }
}
