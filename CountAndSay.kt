class Solution {
    fun countAndSay(n: Int): String {
        var result = "1"

        if (n == 1) {
            return result
        }

        for (i in 2..n) {
            val sb = StringBuilder()
            var count = 1

            for (j in 1 until result.length) {
                if (result[j] == result[j - 1]) {
                    ++count
                } else {
                    sb.append(count).append(result[j - 1])
                    count = 1
                }
            }

            sb.append(count).append(result.last())
            result = sb.toString()
        }

        return result
    }
}
