package job;

import java.time.Duration;
import java.time.Instant;

/**
 * JobWorker
 */
public class JobWorker implements Runnable {
  private Job job;

  public JobWorker(Job job) {
    this.job = job;
  }

  public void run() {
    System.out.println("Job " + job.getJobId() + " has been created with status " + job.getJobStatus());
    Instant start = Instant.now();
    while (!(job.getJobStatus().equals(JobStatus.SUCCESS) || job.getJobStatus().equals(JobStatus.FAILED))) {
      if (job.getJobStatus().equals(JobStatus.INITIATED)) {
        job.setJobStatus(JobStatus.QUEUED);
        System.out.println("Job " + job.getJobId() + " has been updated with status " + job.getJobStatus());
      } else if (job.getJobStatus().equals(JobStatus.QUEUED)) {
        job.setJobStatus(JobStatus.PENDING);
        System.out.println("Job " + job.getJobId() + " has been updated with status " + job.getJobStatus());
      } else if (job.getJobStatus().equals(JobStatus.PENDING)) {
        Double chance = Math.random() * 10;
        job.setJobStatus(chance > 5 ? JobStatus.SUCCESS : JobStatus.FAILED);
        System.out.println("Job " + job.getJobId() + " has been updated with status " + job.getJobStatus());
      }
      try {
        Double duration = (Math.random() * 5000);
        Thread.sleep(duration.longValue());
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    Instant end = Instant.now();
    long executionTime = Duration.between(start, end).toMillis();
    job.setExecutionTime(executionTime);
    System.out.println(
        "Job " + job.getJobId() + " completed in " + job.getExecutionTime());
  }

}
