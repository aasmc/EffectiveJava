# Use caution when making streams parallel

Even under the best of circumstances, parallelizing a pipeline is unlikely to increase its performance if the source is from <code>Stream.iterate</code>, or the intermediate operation <code>limit</code> is used.

As a rule performance gains from parallelism are best on streams over <code> ArrayList, HashMap, HashSet, ConcurrentHashMap </code> as well as arrays, int ranges and long ranges. 

The best terminal operations for parallelism are *reductions*, where all of the elements emerging from the pipeline are combined using one of <code>Stream</code>'s reduce methods, or prepackaged reductions such as <code>min, max, count, sum</code>. 

The short-circuiting operations such as <code>anyMatch, allMatch, noneMatch</code> are also amenable to parallelism. 

Not good for parallelism are Stream's collect methods, because the overhead of combining collections is costly. 

Normally all parallel stream pipelines in a program run in a common fork-join pool. A single misbehaving pipeline can harm the performance of others in unrelated parts of the system. 