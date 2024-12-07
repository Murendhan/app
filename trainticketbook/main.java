import java.util.ArrayList;
import java.util.Scanner;
public class main{
	static ArrayList<Train> trainList = new ArrayList<Train>();
	static ArrayList<Ticket> ticketList = new ArrayList<Ticket>();
	static int Ticketcounter = 1;
	public static void main (String args[]){
		preloadTrains();
		Scanner scanner = new Scanner(System.in);
		
		while (true){
			System.out.println("\n=== Train Ticket Booking System ===");
            System.out.println("1. View Trains");
            System.out.println("2. Book Ticket");
            System.out.println("3. View Tickets");
            System.out.println("4. Cancel Ticket");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
			int choice = scanner.nextInt();
			scanner.nextLine();
			switch(choice){
				case 1 -> viewTrains();
				case 2 -> bookTicket(scanner);
				case 3 -> viewTickets();
				case 4 -> cancelTicket(scanner);
				case 5 -> {
					System.out.println("Exiting , Thank you");
					return;
				}
				default -> System.out.println("Invalid option try again");
			}
		}
	}
	private static void preloadTrains(){
		trainList.add(new Train(101,"Express A","City A","City B",100));
		trainList.add(new Train(102,"Express B","City B","City c",50));
	}
	private static void viewTrains(){
		System.out.println("\nAvailable Trains");
		for(Train train : trainList){
			System.out.println(train);
		}
	}
	private static void bookTicket(Scanner scanner){
		System.out.println("\nEnter train ID");
		int trainId = scanner.nextInt();
		scanner.nextLine();
		Train train = findTrain(trainId);
		
		if(train == null || train.getAvailableSeats()<=0){
			System.out.println("\nNo train or seats available");
			return;
		}
		System.out.println("\nEnter your name");
		String passengerName = scanner.nextLine();
		ticketList.add(new Ticket("T" + Ticketcounter++, trainId, passengerName));
		train.setAvailableSeats(train.getAvailableSeats() - 1);
		System.out.println("Ticket booked successfully!");
	}
	 private static void viewTickets() {
        if (ticketList.isEmpty()) {
            System.out.println("\nNo tickets booked yet.");
            return;
        }
        System.out.println("\nBooked Tickets:");
        for (Ticket ticket : ticketList) {
            System.out.println(ticket);
        }
    }

    private static void cancelTicket(Scanner scanner) {
        System.out.print("\nEnter Ticket ID to cancel: ");
        String ticketId = scanner.nextLine();
        Ticket ticket = findTicket(ticketId);

        if (ticket == null) {
            System.out.println("Invalid Ticket ID.");
            return;
        }

        ticketList.remove(ticket);
        Train train = findTrain(ticket.getTrainId());
        if (train != null) {
            train.setAvailableSeats(train.getAvailableSeats() + 1);
        }
        System.out.println("Ticket canceled successfully!");
    }
	public static Train findTrain(int trainId){
		for(Train train : trainList){
			if(train.getTrainId()==trainId){
				return train;
			}
		}
		return null;
	}
	private static Ticket findTicket(String ticketId) {
        for (Ticket ticket : ticketList) {
            if (ticket.getTicketId().equals(ticketId)) {
                return ticket;
            }
        }
        return null;
    }
}