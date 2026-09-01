import job.Counter;
import job.Job;
import job.JobWorker;

public class Main {
  public static void main(String[] args) {
    Thread[] workers = new Thread[10];
    Counter counter = new Counter();
    System.out.print("Initiating Job threads");
    for (int i = 0; i < 10; i++) {
      Job runningJob = new Job((long) i, "%dthRunner".formatted(i));
      JobWorker runningJobWorker = new JobWorker(runningJob, counter);
      workers[i] = new Thread(runningJobWorker);
      workers[i].start();
    }
    try {
      for (Thread worker : workers) {
        worker.join();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    System.out
        .println("All jobs are completed, closing main thread and the counter ends at counter " + counter.getValue());

  }
}
