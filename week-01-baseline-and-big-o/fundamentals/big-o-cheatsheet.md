# Big-O Cheatsheet — 10-snippet drill

Answer first, verify after. All examples assume `n = arr.length`.

## The 10 snippets

### 1. Single loop
```java
for (int i = 0; i < n; i++) sum += arr[i];
```
**O(n)** — one pass.

### 2. Nested loop over same n
```java
for (int i = 0; i < n; i++)
    for (int j = 0; j < n; j++)
        sum += arr[i] * arr[j];
```
**O(n²)** — n × n.

### 3. Nested loop, inner runs to i
```java
for (int i = 0; i < n; i++)
    for (int j = 0; j < i; j++)
        sum += arr[j];
```
**O(n²)** — n(n-1)/2 still quadratic.

### 4. Halving loop
```java
for (int i = n; i > 0; i /= 2) sum += i;
```
**O(log n)** — n, n/2, n/4, … 1.

### 5. Loop with doubling
```java
for (int i = 1; i < n; i *= 2) sum += i;
```
**O(log n)** — same shape as #4.

### 6. Two sequential loops
```java
for (int i = 0; i < n; i++) sum += arr[i];
for (int j = 0; j < n; j++) sum += arr[j];
```
**O(n)** — O(n) + O(n) = O(n), not O(n²). Constants drop.

### 7. Nested loops, different inputs
```java
for (int i = 0; i < a; i++)
    for (int j = 0; j < b; j++)
        sum += i * j;
```
**O(a·b)** — don't assume same n. Two input sizes = two variables.

### 8. String concatenation in loop
```java
String s = "";
for (int i = 0; i < n; i++) s += "x";
```
**O(n²)** — each `+=` copies the whole string. Use `StringBuilder` → O(n).

### 9. Sort then scan
```java
Arrays.sort(arr);          // O(n log n)
for (int x : arr) if (x == target) return true;
```
**O(n log n)** — sort dominates.

### 10. Recursive halving (binary search)
```java
int bs(int[] a, int t, int lo, int hi) {
    if (lo > hi) return -1;
    int mid = lo + (hi - lo) / 2;
    if (a[mid] == t) return mid;
    if (a[mid] < t) return bs(a, t, mid + 1, hi);
    return bs(a, t, lo, mid - 1);
}
```
**O(log n)** — T(n) = T(n/2) + O(1).

---

## Rules of thumb
- Nested loops over the same `n` → O(n²). Halving each step → O(log n).
- Recursion: `T(n) = a·T(n/b) + f(n)` → Master Theorem.
- String concat in a loop → O(n²); use `StringBuilder`.
- `HashMap` get/put: O(1) average, O(n) worst (collisions).
- Two sequential loops don't multiply — they add. Constants drop.
- Different input sizes = different variables (O(a·b), not O(n²)).

## Space complexity shortcuts
- A few primitives → O(1).
- `int[]` or `HashMap` of size n → O(n).
- 2D `int[n][n]` → O(n²).
- Recursion depth d → O(d) stack (binary search: O(log n), naive fib: O(n)).