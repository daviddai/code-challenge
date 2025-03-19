class Solution {
    fun maxArea(height: IntArray): Int {
        var maxArea = 0
        var left = 0
        var right = height.size - 1

        while (left < right) {
            val height = minOf(height[left], height[right])
            val width = right - left
            val area = width * height

            maxArea = maxOf(maxArea, area)

            if (height[left] < height[right]) {
                ++left
            } else {
                --right
            }
        }

        return maxArea
    }
}
