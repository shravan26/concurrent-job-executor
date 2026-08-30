import job.Job;
import job.JobWorker;

public class Main {
  public static void main(String[] args) {

    System.out.print("Initiating Job threads");
    for (long i = 0; i < 10; i++) {
      Job runningJob = new Job(i, "%dthRunner".formatted(i));
      JobWorker runningJobWorker = new JobWorker(runningJob);
      Thread jobWorkerThread = new Thread(runningJobWorker);
      jobWorkerThread.start();
    }
    try {
      Thread.currentThread().join();
    } catch (Exception e) {
      e.printStackTrace();
    }

    System.out.println("All jobs are completed, closing main thread");

  }
}
