class AllTicketsSoldException extends Exception {
    private static final String ALL_TICKETS_SOLD_MESSAGE = "All tickets for the %s departure at %s are sold out.";
    
    public AllTicketsSoldException(String departureDate, String departureTime) {
            super(String.format(ALL_TICKETS_SOLD_MESSAGE, departureDate, departureTime));
        }
}

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

    public purchaseTicket(int date, int time, Plane planes[]){
        for(int i = 0; i < planes.length; i++){
            if(planes[i].planeDate == date && planes[i].planeTime == time){
                if(planes[i].planeSeats > 0){
                    planes[i].planeSeats -= 1;
                    planes[i].seatNumber += 1;
                    toString(date, time, planes[i]);
                }
            }
        }
    }

    public String toString(int date, int time, Plane planes[]){
        String ticketDetails = String.format("Departure date: %d\nDeparture time: %d\nSeat number: %d", date, time, seatNumber);
        return ticketDetails;
    }

    void returnTicket(int date, int time, Plane planes[])
    {
        for(int i = 0; i < planes.length; i++)
        {
            if(planes[i].planeDate == date && planes[i].planeSeats == time)
            {
                planes[i].planeSeats +=1;
            }
        }
    }
}
