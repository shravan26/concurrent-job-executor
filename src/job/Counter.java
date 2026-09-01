package job;

import java.util.concurrent.TimeUnit;

public class Counter {
  private int value;

  public Counter(int value) {
    this.value = value;
  }

  public Counter() {
    this.value = 0;
  }

  protected synchronized void increment() {

    int current = this.value;
    Double timeout = Math.random() * 10;
    try {
      TimeUnit.MILLISECONDS.sleep(timeout.longValue());
    } catch (Exception e) {
      e.printStackTrace();
    }
    this.value = current + 1;
  }

  public int getValue() {
    return value;
  }
}
