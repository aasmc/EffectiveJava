# Prefer side-effect-free functions in streams

```java
// don't do this
Map<String, Long> freq = new HashMap<>();
try(Stream<String> words = new Scanner(file).tokens()) {
    words.forEach(word -> {
        freq.merge(word.toLowerCase(), 1L, Long::sum);    
    })    
}
```

Proper use of streams:

```java
Map<String, Long> freq;
try(Stream<String> words = new Scanner(file).tokens()) {
    freq = words
        .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));    
}
```