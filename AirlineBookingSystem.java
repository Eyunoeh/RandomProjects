import java.util.*;

class Airplane{
    protected HashMap <String,Integer> planes = new HashMap<>();
    public Airplane(){
        planes.put("Air_1",15);
        planes.put("Air_2",15);
        planes.put("Air_3",15);
        planes.put("Air_4",15);
    }
    public void PlaneList(){
        SortedMap<String, Integer> sorted_map = new TreeMap<>(planes);
        for (String plane: sorted_map.keySet()) {
            if (sorted_map.get(plane)!= 0){
                System.out.println(plane+" : "+ planes.get(plane) +" Available seats");
            }
            else {
                System.out.println(plane+" : Not Available");
            }
        }
    }
}
class Booking extends Airplane{
    public void book(HashMap<String,Integer>books) {
        for (String plane_name : books.keySet()) {
            int available_seat = planes.get(plane_name);
            if(books.get(plane_name) > 0) {
                if (books.get(plane_name) <= available_seat) {
                    int seat_capacity = available_seat - books.get(plane_name);
                    planes.put(plane_name, seat_capacity);
                    System.out.println("Booked\n");
                }
                else {
                    System.out.println("Cant accommodate that passenger try again\n");
                }
            }
            else{
                System.out.println("Must be greater than 0!");
            }
        }
    }
    public int Available_Seats(){
        int total_seats = 0;
        for(String items : planes.keySet()){
            total_seats+= planes.get(items);
        }
        return total_seats;
    }
}
public class AirlineBookingSystem {
    public static void main(String[] args) {
        Booking book = new Booking();
        Scanner sc = new Scanner(System.in);
        HashMap <String,Integer> bookingHash =new HashMap<>();

        System.out.println("Welcome to CVSU Flight Booking");
        System.out.println("\nHere are the list of Available Airlines today");
        book.PlaneList();
        int availableSeats = book.Available_Seats();
        while (availableSeats!=0){
            System.out.println("""
     
                    Type (book) to book flight
                    Type (flights) to see available flights""");
            String flight = sc.nextLine().toLowerCase();
            if (flight.equals("book")) {
                System.out.print("Please select Airplane to book: ");
                String airplane = sc.nextLine();

                System.out.print("How many passenger: ");
                int book_number = sc.nextInt();
                sc.nextLine();

                bookingHash.put(airplane, book_number);
                book.book(bookingHash);
            }
            else if (flight.equals("flights")) {
                book.PlaneList();
            }
            availableSeats = book.Available_Seats();
            bookingHash.clear();

        }
    }
}
