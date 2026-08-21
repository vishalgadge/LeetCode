# 14. Longest Common Prefix

## Problem Statement

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string `""`.

---

### Examples

**Example 1:**
```
Input: strs = ["flower","flow","flight"]
Output: "fl"
```

**Example 2:**
```
Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
```

---

### Constraints

- `1 <= strs.length <= 200`
- `0 <= strs[i].length <= 200`
- `strs[i]` consists of only lowercase English letters.

---

## Solution Explanation

### Intuition & Approach (Horizontal Scanning)

The goal is to find the longest prefix common to all strings in the array. We can use a **Horizontal Scanning** approach:

1. **Initialize**: Assume the first string `strs[0]` is the candidate prefix (`prefix = strs[0]`).
2. **Iterate & Trim**: Loop through the rest of the strings in the array (`i` from `1` to `strs.length - 1`):
   - While the current string `strs[i]` does **not** start with `prefix` (`!strs[i].startsWith(prefix)`):
     - Trim `prefix` by removing its last character (`prefix = prefix.substring(0, prefix.length() - 1)`).
     - If `prefix` becomes empty (`prefix.isEmpty()`), return `""` immediately since no common prefix exists.
3. **Return**: Once all strings have been checked, return `prefix`.

### Java Implementation

```java
class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }
}
```

### Complexity Analysis

- **Time Complexity:** $\mathcal{O}(S)$ — where $S$ is the sum of characters in all strings. In the worst case, all $N$ strings are identical of length $M$, performing $S = N \cdot M$ character comparisons.
- **Space Complexity:** $\mathcal{O}(1)$ — Only constant auxiliary space is used for the `prefix` reference and loop counters.

