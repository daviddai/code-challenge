class Solution1 {
  fun isPalindrome(x: Int): Boolean {
     val digits = x.toString()
     var left = 0
     var right = digits.length - 1
     while (left < right) {
         if (digits[left] != digits[right]) {
             return false
         } else {
             left += 1
             right -=1
         } 
     }
     return true
  }
}

class Solution2 {
  fun isPalindrome(x: Int): Boolean {
     if (x < 0) {
         return false
     }
    
     var reversedX = 0
     var copiedX = x

     while (copiedX != 0) {
         reversedX = reversedX * 10 + copiedX % 10
         copiedX = copiedX / 10
     }

     return reversedX == x
  }
}
