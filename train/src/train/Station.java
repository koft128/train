package train;

public class Station {

    int stations = 5;
    int currentStation = 1;
    int npassengers = 0;
    int passengers = 5;
    public synchronized void arriveAtStation() {
        while (currentStation != stations) {
            System.out.println("The train has arrived at station " + currentStation);
            currentStation++;
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (currentStation == stations) {
            System.out.println("The train has reached the final station");
        }
    }
    public synchronized void waitForPassengers() {
        while(npassengers != passengers) {
            System.out.println("Passenger has arrived at the station");
            try {
                Thread.sleep(1000);
            }
            catch (Exception e) {}
            System.out.println("Passenger is boarding the train");
            npassengers++;
        }


        System.out.println("The train will now be leaving the station");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("The train will now be arriving at the next station");
        notify();

    }
}