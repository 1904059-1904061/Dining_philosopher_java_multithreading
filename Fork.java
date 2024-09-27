public class Fork {
    private boolean isPickedUp = false;

    public synchronized void pickUp() throws InterruptedException {
        while (isPickedUp) {
            wait();
        }
        isPickedUp = true;
    }

    public synchronized void putDown() {
        isPickedUp = false;
        notifyAll();
    }
}
