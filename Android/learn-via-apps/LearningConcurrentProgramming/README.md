## Concurrent Programming
- Concurrency means 2 or more operations are happening at the same time.
- Android's user interface runs on a single main thread.
- Operations that must run in background threads:
  - Network requests
  - Database operations
  - Reading and writing to local storage
  
Simplest way to start a background thread is Thread (see MainActivity)

- AsyncTask: Legacy (now deprecated)
Earlier we used to have AsyncTask API, which wrapped up everything that needed to be done in background threads, including both running thread and communicating with the UI and exposing them in a simple interface.
  - It included methods like ```doInBackground```. ```onProgressUpdate```.
  - It is prone to static resource leaks.

- Coroutines (❤)
  - Create a scope:
  ```kotlin
    CoroutineScope(Dispatchers.IO).launch{
    doSomething()
  }
    ```
    - Easy switching between threads without callbacks
    - Coroutine Context (Dispatchers.Main(UI Thread, short tasks ), Dispatchers.IO (bg thread, storage and network access), Dispatchers.Default (bg thread, cpu intensive tasks))

- JobIntentService
  - This service supersedes IntentService.
  - Running a code in JobIntentService automatically runs it in a background thread.
  - These are good for running shorter, finite tasks with no constraints

- WorkManager API
  - Works for deferrable tasks that are longer, and have constraints (like execute only when have network availability) or are repeated periodically
  - We can define a task to be repeated periodically.

- Background Service

- Foreground Service

- Difference between a Job and Deferred
  - 'job' is an object that represents a coroutine's execution and is related to structured concurrency (we can cancel the job, and all the children of this job will also be cancelled)
  > Job is a cancellable thing with a life-cycle that culminates in its completion.
  - 'deferred' is analog of 'Future' in Java, which encapsulates an operation that will be finished at some point in future after it's initialization, but it is related to coroutines.
  > Deferred value is a non-blocking cancellable future — it is a Job that has a result
  - async builder gets us a deferred, launch builder gives us a job.