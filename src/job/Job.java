package job;

import java.time.Instant;

/**
 * Job Entity class
 */
public class Job {
  private Long jobId;
  private Long executionTime;
  private JobStatus jobStatus;
  private String jobName;
  private Instant createdAt;
  private Instant updatedAt;

  public Job(Long jobId, String jobName) {
    this.jobId = jobId;
    this.jobName = jobName;
    this.jobStatus = JobStatus.INITIATED;
    this.updatedAt = Instant.now();
  }

  public Long getJobId() {
    return jobId;
  }

  public Long getExecutionTime() {
    return executionTime;
  }

  public JobStatus getJobStatus() {
    return jobStatus;
  }

  public void setJobStatus(JobStatus jobStatus) {
    this.jobStatus = jobStatus;
    this.updatedAt = Instant.now();
  }

  public void setExecutionTime(Long executionTime) {
    this.executionTime = executionTime;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public Instant getUpdatedAt() {
    return updatedAt;
  }

  public String getJobName() {
    return jobName;
  }

}
