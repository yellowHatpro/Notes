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

- JobIntentService
  - This service supersedes IntentService.
  - Running a code in JobIntentService automatically runs it in a background thread.
  - These are good for running shorter, finite tasks with no constraints

- WorkManager API
  - Works for deferrable tasks that are longer, and have constraints (like execute only when have network availability) or are repeated periodically
  - We can define a task to be repeated periodically.

- Background Service

- Foreground Service