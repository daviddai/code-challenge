class Solution {
    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        nums.sort()

        val n = nums.size
        for (i in 0 until n - 3) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue
            }

            for (j in i + 1 until n - 2) {
                if (j > i + 1 && nums[j - 1] == nums[j]) {
                    continue
                }

                var left = j + 1
                var right = n - 1

                while (left < right) {
                    val sum = nums[i].toLong() + nums[j].toLong() + nums[left].toLong() + nums[right].toLong()

                    if (sum == target.toLong()) {
                        result.add(listOf(nums[i], nums[j], nums[left], nums[right]))
                        ++left
                        --right

                        while (left < right) {
                            if (nums[left] == nums[left - 1]) {
                                ++left
                            } else {
                                break
                            }
                        }

                        while (left < right) {
                            if (nums[right] == nums[right + 1]) {
                                --right
                            } else {
                                break
                            }
                        }
                    } else if (sum < target.toLong()) {
                        ++left
                    } else {
                        --right
                    }
                }
            }
        }

        return result
    }
}
