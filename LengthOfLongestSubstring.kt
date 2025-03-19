class Solution {
   fun lengthOfLongestSubstring(s: String): Int {
       var maxLength = 0
       var occurredChars = mutableSetOf<Char>()
       var left = 0
       var right = 0
      
       while (right < s.length) {
           while (occurredChars.contains(s[right])) {
               occurredChars.remove(s[left])
               left = left + 1
           }
          
           occurredChars.add(s[right])
           maxLength = Math.max(maxLength, right - left + 1)
           right = right + 1
       }
  
       return maxLength
   }
}
