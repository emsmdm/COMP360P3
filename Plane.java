import java.util.Scanner;

class AllTicketsSoldException extends Exception {
    private static final String ALL_TICKETS_SOLD_MESSAGE = "All tickets for the %s/%s departure at %s are sold out.";
    
    public AllTicketsSoldException(int departureDate, int departureTime) {
            super(String.format(ALL_TICKETS_SOLD_MESSAGE, departureDate/100, departureDate%100, departureTime));
        }
}

class TicketMethods {}
public class Plane {

    private int planeTime;
    private int planeDate;
    private int planeSeats;
    private int seatNumber;

    public Plane(int date, int time)
    {
        planeDate = date;
        planeTime = time;
        planeSeats = 20;
        seatNumber = 0;
    }

    public static void purchaseTicket(int date, int time, Plane planes[]) throws AllTicketsSoldException{
        boolean unavailablePlane = true;
        for(int i = 0; i < planes.length; i++){
            if(planes[i].planeDate == date && planes[i].planeTime == time){
                if(planes[i].planeSeats > 0){
                    planes[i].planeSeats -= 1;
                    planes[i].seatNumber += 1;
                    System.out.println(toString(date, time, planes[i].seatNumber));
                    unavailablePlane = false;
                }
                else
                {
                    throw new AllTicketsSoldException(date, time);
                }
            }
        }
        if(unavailablePlane == true)
        {
            System.out.println("There are no available planes for your selected date and time.");
        }
    }

    public static String toString(int date, int time, int seatNumber){
        int month = date/100;
        int day = date % 100;
        String ticketDetails = String.format("Departure date: %d/%d\nDeparture time: %d:00pm\nSeat number: %d", month, day, time, seatNumber);
        return ticketDetails;
    }

    public static void returnTicket(int date, int time, Plane planes[])
    {
        for(int i = 0; i < planes.length; i++)
        {
            if(planes[i].planeDate == date && planes[i].planeTime == time)
            {
                planes[i].planeSeats += 1;
                planes[i].seatNumber -= 1;
                System.out.println("Ticket returned!");
            }
        }
    }

    public static void main(String[] args){
        boolean keepRunning = true;
        Scanner in = new Scanner(System.in);
		Plane plane1 = new Plane(1224, 3);
        Plane plane2 = new Plane(1224, 5);
        Plane plane3 = new Plane(1224, 4);
        Plane plane4 = new Plane(1224, 6);

        Plane airline[] = new Plane[] {plane1, plane2, plane3, plane4};
        while(keepRunning)
        {
            System.out.println("Welcome to Aggie Airlines. Press '1' to book a flight, or press '2' to cancel a flight. Press 3 to exit.");
            int selection = in.nextInt();
            if(selection == 1)
            {
                boolean buyMore = true;
                while(buyMore)
                {
                    System.out.println("Please enter the desired date and time for your flight.\nEnter date in the format mmdd (Ex. December 4th is 1204) and enter time by the hour.");
                    int date = in.nextInt();
                    int time = in.nextInt();
                    try
                    {
                        purchaseTicket(date, time, airline);
                    }
                    catch(AllTicketsSoldException e){
                        
                        System.out.println(e.getMessage());
                    }

                    System.out.println("Would you like to purchase another ticket? Press 'y' for yes or 'n' for no.");
                    String ans = in.nextLine();
                    ans = in.nextLine();

                    if(ans.equals("n"))
                    {
                        buyMore = false;
                        System.out.println("Thank you for choosing Aggie Airlines. Have a nice day!");
                    }
                }
            }
            if(selection == 2)
            {
                if(plane1.planeSeats == 20 && plane2.planeSeats == 20 && plane3.planeSeats == 20 && plane4.planeSeats == 20)
                {
                    System.out.println("There are no reservations to cancel.");
                }
                else
                {
                    System.out.println("Enter the date and time for the reservation you would like to cancel.");
                    int date = in.nextInt();
                    int time = in.nextInt();
                    returnTicket(date, time, airline);
                    System.out.println("Your ticket has been returned and your reservation has been canceled. Have a nice day!");
                }
            }
            if(selection == 3)
            {
                keepRunning = false;
                System.out.println("Goodbye!");
            }
        }
        
	}
}
