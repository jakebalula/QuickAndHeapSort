Based on the experimental results, both of the sorting algorithms performed
similarly for smaller input sizes, but as the input size increased to 10,000,
quick sort was roughly twice as fast. Although both have time complexity of 
O(n log n). The small discrepancies between theoretical and observed runtimes
are most likely due to implementation details, system timing, and memory behavior.

Size       Heap sort (ms)       Quick Sort (ms)     
100        0                    0                   
1000       0                    0                   
10000      2                    2                   
100000     29                   14  

