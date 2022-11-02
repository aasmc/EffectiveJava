# Prefer executors, tasks, and streams to threads

With ExecutorService you can:

- wait for a particular task to complete with the <code>get</code> method.
- wait for any or all fo a collection of tasks to complete using <code>invokeAny</code> or <code>invokeAll</code> methods.
- wait for the executor service to terminate using <code>awaitTermination</code> method.
- retrieve the results of tasks one by one as they complete using <code>ExecutorCompletionService</code>.
- schedule tasks to run at a particular time or to run periodically using <code>ScheduledThreadPoolExecutor</code>.
- and many more

