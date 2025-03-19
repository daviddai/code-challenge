// Sorting the strings lexicographically places the most similar ones close together.
// We only need to compare the first and last strings, as the LCP for them will be the same for all.
class Solution {
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
