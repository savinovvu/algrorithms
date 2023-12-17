function lengthOfLongestSubstring(s) {
  let set = new Set();
  let i = 0, j = 0, max = 0;
  while (j < s.length) {
    if (!set.has(s.charAt(j))) {
      set.add(s.charAt(j));
      max = Math.max(max, set.size);
      j++;
    } else {
      set.delete(s.charAt(i));
      i++;
    }
  }
  return max;
}

let number = lengthOfLongestSubstring("abcabcbb");
console.log(number)

