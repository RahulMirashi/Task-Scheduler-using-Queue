/**
 * Represents a task in the scheduler
 */
public class Task {

    private String name;
    private long arrivalTime;

    public Task(String name) {
        this.name = name;
        this.arrivalTime = System.currentTimeMillis();
    }

    public String getName() {
        return name;
    }

    public long getArrivalTime() {
        return arrivalTime;
    }

    @Override
    public String toString() {
        return name + " (arrived at " + arrivalTime + ")";
    }
}