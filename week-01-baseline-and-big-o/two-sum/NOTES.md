# Two Sum — LeetCode #1
Date: 2026-11-15 | Time: __ | First try: __ | Pattern: Hashing

## Approach
Complement check in one pass. For each num: look up target-num
in map before inserting (this order matters — handles duplicates).

## Complexity
Time: O(n) | Space: O(n)

## What I got wrong (red pen section)
- 

## Interview follow-ups
- Sorted input? → two pointers, O(1) space
- Memory constrained? → sort first, O(1) space, O(n log n) time