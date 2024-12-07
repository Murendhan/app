public class Ticket{
	private String ticketId;
	private int trainId;
    private	String passengerName;
	public Ticket(String ticketId,int trainId,String passengerName){
		this.ticketId = ticketId;
		this.trainId = trainId;
		this.passengerName = passengerName;
	}
	public String getTicketId(){
		return ticketId;
	}
	public int getTrainId(){
		return trainId;
	}
	@Override
	public String toString(){
		return "Ticket ID: " + ticketId + " | Train ID: " + trainId + " | Passenger: " + passengerName;
	}
}