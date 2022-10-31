# Know and use the libraries

As of Java 7, you should no longer use Random. For most uses, the random number generator of choice is not <code>ThreadLocalRandom</code>.

For fork join pools and parallel streams, use <code>SplittableRandom</code>.
