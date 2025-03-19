class Solution {
    fun reverse(x: Int): Int {
        var originalX = x
        var reversedX = 0

        while (originalX != 0) {
            if (reversedX > Int.MAX_VALUE / 10 || reversedX < Int.MIN_VALUE / 10) {
                return 0
            }
            reversedX = reversedX * 10 + originalX % 10
            originalX = originalX / 10
        }

        return reversedX
    }
}
