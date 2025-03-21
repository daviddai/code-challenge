class Solution {
    fun findSubstring(s: String, words: Array<String>): List<Int> {
        if (words.isEmpty()) {
            return listOf()
        }

        val result = mutableListOf<Int>()
        val wordLength = words[0].length
        val totalLength = words.size * wordLength
        val wordCountMappings = mutableMapOf<String, Int>()

        for (word in words) {
            wordCountMappings[word] = wordCountMappings.getOrDefault(word, 0) + 1
        }

        for (i in 0..(s.length - totalLength)) {
            val seenWords = mutableMapOf<String, Int>()
            var j = 0
            while (j < words.size) {
                val wordStart = i + j * wordLength
                val word = s.substring(wordStart, wordStart + wordLength)

                if (wordCountMappings.contains(word)) {
                    seenWords[word] = seenWords.getOrDefault(word, 0) + 1

                    if (seenWords[word]!! > wordCountMappings[word]!!) {
                        break
                    }
                } else {
                    break
                }

                ++j
            }

            if (j == words.size) {
                result.add(i)
            }
        }

        return result
    }
}
