class Solution {
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        nums.sort()
        var closestSum = Int.MAX_VALUE

        for (i in nums.indices) {
            var left = i + 1
            var right = nums.size - 1

            while (left < right) {
                val sum = nums[i] + nums[left] + nums[right]

                if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                    closestSum = sum
                }

                if (sum < target) {
                    ++left
                } else if (sum > target) {
                    --right
                } else {
                    return sum
                }
            }
        }

        return closestSum
    }
}
