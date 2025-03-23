class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val rowsSet = Array(9) { mutableSetOf<Char>() }
        val columnsSet = Array(9) { mutableSetOf<Char>() }
        val boxSets = Array(9) { mutableSetOf<Char>() }

        for (x in board.indices) {
            for (y in board[x].indices) {
                var char = board[x][y]
                if (char == '.') { continue }
                val boxIndex = (x / 3) * 3 + y / 3

                if (char in rowsSet[x] || char in columnsSet[y] || char in boxSets[boxIndex]) {
                    return false
                }

                rowsSet[x].add(char)
                columnsSet[y].add(char)
                boxSets[boxIndex].add(char)
            }
        }

        return true
     }
}
