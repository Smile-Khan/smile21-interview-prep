# Container With Most Water — LeetCode #11
Date: 2026-11-15 | Time: __ | First try: __ | Pattern: Two Pointers

## Approach
Two pointers at both ends. Area = min(h[l], h[r]) * (r-l).
Move the shorter wall inward — moving the taller one can never increase area.

## Complexity
Time: O(n) | Space: O(1)

## What I got wrong (red pen section)
- 

## Interview follow-ups
- Trapping Rain Water → different problem, prefix max / stack