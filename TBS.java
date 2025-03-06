// Hard Level: Ticket Booking System with Multithreading
class TicketBooking implements Runnable {
    private static int availableSeats = 10;
    private static final Object lock = new Object();
    private String name;
    private boolean isVIP;

    public TicketBooking(String name, boolean isVIP) {
        this.name = name;
        this.isVIP = isVIP;
    }

    @Override
    public void run() {
        synchronized (lock) {
            if (availableSeats > 0) {
                System.out.println(name + " booked a seat.");
                availableSeats--;
            } else {
                System.out.println(name + " could not book a seat.");
            }
        }
    }
}

public class TicketBookingSystem {
    public static void main(String[] args) {
        Thread vip1 = new Thread(new TicketBooking("VIP_1", true));
        Thread vip2 = new Thread(new TicketBooking("VIP_2", true));
        Thread normal1 = new Thread(new TicketBooking("User_1", false));
        Thread normal2 = new Thread(new TicketBooking("User_2", false));
        
        vip1.setPriority(Thread.MAX_PRIORITY);
        vip2.setPriority(Thread.MAX_PRIORITY);
        normal1.setPriority(Thread.MIN_PRIORITY);
        normal2.setPriority(Thread.MIN_PRIORITY);
        
        vip1.start();
        vip2.start();
        normal1.start();
        normal2.start();
    }
}
