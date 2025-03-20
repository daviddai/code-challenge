class Solution {
    fun isValid(s: String): Boolean {
        val stack = ArrayDeque<Char>()
        val openingParentheses = setOf('(', '[', '{')
        val parenthesesMappings = mapOf(
            '(' to ')',
            '[' to ']',
            '{' to '}'
        )

        for (char in s) {
            if (char in openingParentheses) {
                stack.addLast(char)
            } else {
                if (stack.isEmpty()) {
                    return false
                }

                val openingParenthese = stack.removeLast()
                if (parenthesesMappings[openingParenthese] != char) {
                    return false
                }
            }
        }

        return stack.isEmpty()
    }
}
