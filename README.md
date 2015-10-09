# Data Structures and Algorithms in Java (useful in interview process)

## Simple Sorting

### Bubble Sort

The bubble sort is notoriously slow, but it’s conceptually the simplest of the sorting algorithms.

Sorting process:

1. Compare two items.
2. If the one on the left is bigger, swap them.
3. Move one position right.

[Implementation](https://github.com/donbeave/interview/blob/master/src/main/java/com/zhokhov/interview/sorting/BubbleSort.java)

##### Efficiency

For 10 data items, this is 45 comparisons (9 + 8 + 7 + 6 + 5 + 4 + 3 + 2 + 1).

In general, where N is the number of items in the array, there are N-1 comparisons on the first pass, N-2 on the second, and so on. The formula for the sum of such a series is
(N–1) + (N–2) + (N–3) + ... + 1 = N*(N–1)/2 N*(N–1)/2 is 45 (10*9/2) when N is 10.
