public class Train{
	private int trainId;
    private String name;
    private String source;
    private String destination;
    private int availableSeats;
	public Train(int trainId,String name,String source,String destination,int availableSeats){
		this.trainId = trainId;
		this.name = name;
		this.source = source;
		this.destination = destination;
		this.availableSeats = availableSeats;
	}
	public int getTrainId(){
		return trainId;
	}
	public int getAvailableSeats(){
		return availableSeats;
	}
	public void setAvailableSeats(int availableSeats){
		this.availableSeats = availableSeats;
	}
	@Override
	public String toString() {
        return trainId + " | " + name + " | " + source + " -> " + destination + " | Seats: " + availableSeats;
    }
}