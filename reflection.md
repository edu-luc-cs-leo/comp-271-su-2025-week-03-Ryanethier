# Reflection on My `heapifyUp` Code

For this assignment, I wrote the `heapifyUp` method for the `MinHeap` class and then looked at your solution to compare.

### What I Did Right
My code works correctly. It starts at the last added element and moves up the heap, swapping it with its parent if the child is smaller. This keeps the min-heap property true. I also added comments to explain what the method does and how it works.

### What Was Close But Not Perfect
My code is longer and more complicated than your version. I used an `if-else` inside the loop, you put the condition right in the `while` loop, which makes your code shorter and cleaner. Also, some of my comments talked about fixing the heap after removing elements, which is a different method, so that could confuse people reading my code.

### Where I Made Mistakes
I repeated some calculations, like finding the parent index more times than needed. My loop could have been simpler. Plus, my comments weren’t focused just on `heapifyUp` and mixed things up a bit.

### What I Learned
From comparing the codes, I learned how to make the loop condition simpler and write cleaner code by putting the check directly in the `while` statement. I also saw that comments should be clear and only explain what the method really does.

### How I Will Improve Next Time
I did test my code, and it worked fine. But I spent too much time writing long comments and not enough time making the code simpler. Next time, I want to make sure the code works and then spend time cleaning it up.
