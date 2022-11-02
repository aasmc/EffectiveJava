# Synchronize access to shared mutable data

Synchronization is required for reliable communication between threads as well as for mutual exclusion.

Synchronization is not guaranteed to work unless both read and write operations are synchronized.

The best way to avoid synchronization problems is not to share mutable data, but to share immutable data. In other words, confine mutable data to a single thread. 