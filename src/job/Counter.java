package job;

public class Counter {
  private int value;

  public Counter(int value) {
    this.value = value;
  }

  public Counter() {
    this.value = 0;
  }

  protected void increment() {
    this.value += 1;
  }

  public int getValue() {
    return value;
  }
}
