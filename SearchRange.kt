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


class Solution {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        if (nums.size == 0) {
            return intArrayOf(-1, -1)
        }

        var left = 0
        var right = nums.size - 1
        var pt = -1

        while (left <= right) {
            pt = (left + right) / 2
            if (nums[pt] == target) {
                break
            } else if (nums[pt] < target) {
                left = pt + 1
            } else {
                right = pt - 1
            }
        }

        if (nums[pt] != target) {
            return intArrayOf(-1, -1)
        } else {
            left = pt
            while (left > 0 && nums[left - 1] == target) {
                --left
            }

            right = pt
            while (right < nums.size - 1 && nums[right + 1] == target) {
                ++right
            }

            return intArrayOf(left, right)
        }
    }
}
