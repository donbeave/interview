# Data Structures and Algorithms in Java
Very useful in interview process for Java Software Development Engineer (SDE).

## Simple Sorting

### Bubble Sort

[Implementation](https://github.com/donbeave/interview/blob/master/src/main/java/com/zhokhov/interview/sorting/BubbleSort.java)

The bubble sort is notoriously slow, but it’s conceptually the simplest of the sorting algorithms.

Sorting process:

1. Compare two items.
2. If the one on the left is bigger, swap them.
3. Move one position right.

##### Efficiency

For `10` data items, this is `45` comparisons (`9 + 8 + 7 + 6 + 5 + 4 + 3 + 2 + 1`).

In general, where `N` is the number of items in the array, there are `N-1` comparisons on the first pass, `N-2` on the second, and so on. The formula for the sum of such a series is
`(N–1) + (N–2) + (N–3) + ... + 1 = N*(N–1)/2 N*(N–1)/2 is 45 (10*9/2)` when `N` is `10`.


### Selection Sort

[Implementation](https://github.com/donbeave/interview/blob/master/src/main/java/com/zhokhov/interview/sorting/SelectionSort.java)

[Simple explanation](http://www.codenlearn.com/2011/07/simple-selection-sort.html)

The selection sort improves on the bubble sort by reducing the number of swaps necessary from `O(N2)` to `O(N)`. Unfortunately, the number of comparisons remains `O(N2)`. However, the selection sort can still offer a significant improvement for large records that must be physically moved around in memory, causing the swap time to be much more important than the comparison time.

##### Efficiency

The selection sort performs the same number of comparisons as the bubble sort: `N*(N-1)/2`. For `10` data items, this is `45` comparisons. However, `10` items require fewer than `10` swaps. With `100` items, `4,950` comparisons are required, but fewer than `100` swaps. For large values of `N`, the comparison times will dominate, so we would have to say that the selection sort runs in `O(N2)` time, just as the bubble sort did.

### Insertion Sort

[Implementation](https://github.com/donbeave/interview/blob/master/src/main/java/com/zhokhov/interview/sorting/InsertionSort.java)

[Simple explanation](http://www.codenlearn.com/2011/07/simple-insertion-sort.html)

In most cases the insertion sort is the best of the elementary sorts described in this chapter. It still executes in `O(N2)` time, but it’s about twice as fast as the bubble sort and somewhat faster than the selection sort in normal situations. It’s also not too complex, although it’s slightly more involved than the bubble and selection sorts. It’s often used as the final stage of more sophisticated sorts, such as quicksort.

##### Efficiency

How many comparisons and copies does this algorithm require? On the first pass, it compares a maximum of one item. On the second pass, it’s a maximum of two items, and so on, up to a maximum of N-1 comparisons on the last pass. This is `1 + 2 + 3 + ... + N-1 = N*(N-1)/2`

However, because on each pass an average of only half of the maximum number of items are actually compared before the insertion point is found, we can divide by 2, which gives `N*(N-1)/4`

The number of copies is approximately the same as the number of comparisons. However, a copy isn’t as time-consuming as a swap, so for random data this algorithm runs twice as fast as the bubble sort and faster than the selection sort.

In any case, like the other sort routines in this chapter, the insertion sort runs in `O(N2)` time for random data.

For data that is already sorted or almost sorted, the insertion sort does much better. When data is in order, the condition in the while loop is never true, so it becomes a simple statement in the outer loop, which executes `N-1` times. In this case the algorithm runs in `O(N)` time. If the data is almost sorted, insertion sort runs in almost `O(N)` time, which makes it a simple and efficient way to order a file that is only slightly out of order.

## Advanced Sorting

### Merge Sort

[Implementation](https://github.com/donbeave/interview/blob/master/src/main/java/com/zhokhov/interview/sorting/MergeSort.java)

[Simple explanation](http://www.codenlearn.com/2011/10/simple-merge-sort.html)

mergesort is a much more efficient sorting technique than those we saw in "Simple Sorting", at least in terms of speed. While the bubble, insertion, and selection sorts take `O(N2)` time, the mergesort is `O(N*logN)`.

For example, if `N` (the number of items to be sorted) is `10,000`, then `N2` is `100,000,000`, while `N*logN` is only `40,000`. If sorting this many items required `40` seconds with the mergesort, it would take almost `28` hours for the insertion sort.

The mergesort is also fairly easy to implement. It’s conceptually easier than quicksort and the Shell short.

The heart of the mergesort algorithm is the merging of two already-sorted arrays. Merging two sorted arrays `A` and `B` creates a third array, `C`, that contains all the elements of `A` and `B`, also arranged in sorted order.

The idea in the mergesort is to divide an array in half, sort each half, and then use the merge() method to merge the two halves into a single sorted array.
You divide the half into two quarters, sort each of the quarters, and merge them to make a sorted half.

##### Efficiency

As we noted, the mergesort runs in `O(N*logN)` time. There are `24` copies necessary to sort `8` items. `Log28` is `3`, so `8*log28` equals `24`. This shows that, for the case of `8` items, the number of copies is proportional to `N*log2N`.

In the mergesort algorithm, the number of comparisons is always somewhat less than the number of copies.

### Quick Sort

[Implementation](https://github.com/donbeave/interview/blob/master/src/main/java/com/zhokhov/interview/sorting/QuickSort.java)

[Simple explanation](http://me.dt.in.th/page/Quicksort/)
[Simple explanation 2](http://www.mycstutorials.com/articles/sorting/quicksort)

Quicksort is undoubtedly the most popular sorting algorithm, and for good reason: In the majority of situations, it’s the fastest, operating in `O(N*logN)` time. (This is only true for internal or in-memory sorting; for sorting data in disk files, other algorithms may be better.)

To understand quicksort, you should be familiar with the partitioning algorithm.

Quicksort algorithm operates by partitioning an array into two sub-arrays and then calling itself recursively to quicksort each of these subarrays

##### Efficiency

Quicksort operates in `O(N*logN)` time. This is generally true of the divide-and-conquer algorithms, in which a recursive method divides a range of items into two groups and then calls itself to handle each group. In this situation the logarithm actually has a base of `2`: The running time is proportional to `N*log2N`.

# Top 10 Object Oriented Design Principles

1. *DRY (Don't repeat yourself)* - avoids duplication in code.
2. *Encapsulate what changes* - hides implementation detail, helps in maintenance
3. *Open Closed design principle* - open for extension, closed for modification
4. *SRP (Single Responsibility Principle)* - one class should do one thing and do it well
5. *DIP (Dependency Inversion Principle)* - don't ask, let framework give to you
6. *Favor Composition over Inheritance* - code reuse without cost of inflexibility
7. *LSP (Liskov Substitution Principle)* - sub type must be substitutable for super type
8. *ISP (Interface Segregation Pricinciple)* - avoid monilithic interface, reduce pain on client side
9. *Programming for Interface* - helps in maintenance, improves flexibility
10. *Delegation principle* - don't do all things by yourself, delegate it

### TODO

1. triangular numbers
2. heap sort, binary search (BST)
3. OBJECT ORIENTED DESIGN. Major concepts, are the use of patterns necessary?
4. How does dynamic recompilation work in Resin (or any other Java servlet container)
5. write a O(log(n)) function

### Sources

1. [Data Structures and Algorithms in Java, second edition by Robert Lafore](http://rineshpk.weebly.com/uploads/1/8/2/0/1820991/data_structures_and_algorithms_in_javatqw_darksiderg.pdf)
2. [10 Object Oriented Design Principles Java Programmer should know](http://javarevisited.blogspot.com/2012/03/10-object-oriented-design-principles.html)

```
You are free to use this code anywhere, copy, modify and redistribute at your own risk.
Your are solely responsibly for any damage that may occur by using this code.

This code is not tested for all boundary conditions. Use it at your own risk.
```
