# Return empty collections or arrays, not nulls

Do not preallocate the array passed to <code>toArray</code> in hopes of improving performance. Studies have shown that it is counterproductive. 