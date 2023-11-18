public class Plane {

    private int planeTime;
    private int planeDate;
    private int planeSeats;

    public Plane(int date, int time)
    {
        planeDate = date;
        planeTime = time;
        planeSeats = 20;
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
