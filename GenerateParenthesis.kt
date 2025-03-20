class Solution {
    fun generateParenthesis(n: Int): List<String> {
        val result = mutableListOf<String>()

        fun backTrack(current: String, open: Int, close: Int) {
            if (current.length == n * 2) {
                result.add(current)
                return
            }

            if (open < n) {
                backTrack(current + "(", open + 1, close)
            }

            if (close < open) {
                backTrack(current + ")", open, close + 1)
            }
        }

        backTrack("", 0, 0)
        return result
    }
}
