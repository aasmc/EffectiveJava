# Prefer for-each loops to traditional for loops

There are three common situations where you can't use for-each loop:
- Destructive filtering: if you need to traverse a collection removing selected elements, then you need to use an explicit iterator, so that you can call its remove method. You can often avoid explicit traversal by using Collection's <code>removeIf</code> method, added in Java 8.
- Transforming: If you need to traverse a list or array and replace some or all of the values of its elements
- Parallel iteration: if you need to traverse multiple collections in parallel, then you need explicit control over the iterator or index variable so that all iterators or index variables can be advanced in lockstep. 