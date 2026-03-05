package comp47500.advds;

public class Task {

    private String name;
    private long arrivalTime;
    private long duration;

    public Task(String name, long duration) {
        this.name = name;
        this.arrivalTime = System.currentTimeMillis();
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public long getArrivalTime() {
        return arrivalTime;
    }

    public long getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return name + " (duration: " + duration + "ms)";
    }
}