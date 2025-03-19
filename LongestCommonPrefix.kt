// Sorting the strings lexicographically places the most similar ones close together.
// We only need to compare the first and last strings, as the LCP for them will be the same for all.
class Solution1 {
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) {
            return ""
        }

        strs.sort()

        val first = strs[0]
        val last = strs[strs.size - 1]

        var i = 0
        while (i < first.length && i < last.length && first[i] == last[i]) {
            ++i
        }

        return first.substring(0, i)
    }
}


class Solution2 {
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) {
            return ""
        }

        var low = 0
        var high = strs.minOf { it.length }

        while (low < high) {
            val mid = (low + high + 1) / 2
            if (isCommonPrefix(strs, mid)) {
                low = mid
            } else {
                high = mid - 1
            }
        }

        return strs[0].substring(0, low)
    }

    private fun isCommonPrefix(strs: Array<String>, length: Int): Boolean {
        val prefix = strs[0].substring(0, length)
        return strs.all { it.startsWith(prefix) }
    }
}
