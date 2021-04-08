package train;

public class Main {
    public static void main(String[] args) {
    Station s = new Station();  
    Train t = new Train(s);
    new Thread(t).start();
    passenger p = new passenger(t,s);
    new Thread(p).start();

    }


}
class Train implements Runnable {
    Station s;
    public Train (Station s) {
        this.s = s;
    }
    public void run() {
        s.arriveAtStation();

    }
}

class passenger implements Runnable {
    Train t;
    Station s;
    public passenger(Train t, Station s){
        this.t = t;
        this.s = s;
    }
    public void run() {
        s.waitForPassengers();


    }
 }