# 11. Container With Most Water

## Problem Statement

You are given an integer array `height` of length `n`. There are `n` vertical lines drawn such that the two endpoints of the $i^{\text{th}}$ line are `(i, 0)` and `(i, height[i])`.

Find two lines that, together with the x-axis, form a container such that the container holds the most water.

Return *the maximum amount of water a container can store*.

**Notice** that you may not slant the container.

---

### Examples

**Example 1:**
```
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water the container can contain is 49.
```

**Example 2:**
```
Input: height = [1,1]
Output: 1
```

---

### Constraints

- `n == height.length`
- $2 \le n \le 10^5$
- $0 \le \text{height}[i] \le 10^4$

---

## Solution Explanation

### Intuition (Two-Pointer Approach)

The area formed by two lines at indices `left` and `right` is determined by:
$$\text{Area} = \min(\text{height}[\text{left}], \text{height}[\text{right}]) \times (\text{right} - \text{left})$$

To maximize the container's area, we start with the widest container possible:
- Place `left` pointer at index `0` and `right` pointer at index `n - 1`.

At each step, the width $(\text{right} - \text{left})$ decreases by 1. To potentially find a larger area, we must try to increase the limiting height $\min(\text{height}[\text{left}], \text{height}[\text{right}])$:
- Moving the pointer pointing to the **taller** line will only keep the height limited by the shorter line or make it even smaller while reducing the width. Thus, it can never yield a larger area.
- Therefore, we always move the pointer pointing to the **shorter** line inwards (`left++` if `height[left] < height[right]`, else `right--`).

### Algorithm

1. Initialize `left = 0`, `right = height.length - 1`, and `maxArea = 0`.
2. While `left < right`:
   - Calculate the `currentArea = Math.min(height[left], height[right]) * (right - left)`.
   - Update `maxArea = Math.max(maxArea, currentArea)`.
   - If `height[left] < height[right]`, increment `left`.
   - Else, decrement `right`.
3. Return `maxArea`.

### Java Implementation

```java
class Solution {
    public int maxArea(int[] height) {
        int m = 0;
        int n = height.length - 1;
        int maxArea = 0;
        while (m < n) {
            int area = Math.min(height[m], height[n]) * (n - m);
            maxArea = Math.max(maxArea, area);
            if (height[m] < height[n]) {
                m++;
            } else {
                n--;
            }
        }
        return maxArea;
    }
}
```

### Complexity Analysis

- **Time Complexity:** $\mathcal{O}(n)$ — The two pointers traverse the array from opposite ends meeting in the middle, performing at most $n - 1$ steps.
- **Space Complexity:** $\mathcal{O}(1)$ — Only a constant amount of extra memory (`m`, `n`, `maxArea`, `area`) is used.

