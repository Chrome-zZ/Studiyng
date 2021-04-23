import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;

import java.time.Duration;
import java.util.Date;


public class Main {
    private static Date todayFutureTwoHours;
    private static Date today;


    public static void main(String[] args) {
        today = new Date();
        todayFutureTwoHours = Date.from(today.toInstant().plus(Duration.ofHours(2)));

        Airport airport = Airport.getInstance();
        airport.getTerminals().stream()
                .flatMap(t -> t.getFlights().stream())
                .filter(f -> f.getDate().after(today) && f.getDate().before(todayFutureTwoHours))
                .filter(f -> f.getType() == Flight.Type.DEPARTURE)
                .forEach(System.out::println);
    }
}
