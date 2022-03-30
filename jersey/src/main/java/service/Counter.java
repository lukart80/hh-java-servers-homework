package service;

public class Counter {

    private static Counter counterInstance;

    private int counterValue;



    public static Counter getCounterInstance() {
        if (counterInstance == null) {
            Counter counter = new Counter();
            counterInstance = counter;
            return counter;
        }
        return counterInstance;
    }

    public void subtractCounter(int value) {
        this.counterValue -= value;
    }

    public void incrementCounter() {
        this.counterValue++;
    }

    public void clearCounter() {
        this.counterValue = 0;
    }

    public int getCounterValue() {
        return this.counterValue;
    }


}
