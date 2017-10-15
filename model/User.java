import java.util.*;

public class User {
    private List<Trip> trips;
    private String name;

    public User(String name) {
        this(name, new ArrayList<Trip>());
    }

    public User(String name, List<Trip> trips) {
        this.name = name;
        this.trips = trips;
    }
    public void addTrip(Trip trip) {
        this.trips.add(trip);
    }
    public void addTrips(List<Trip> trips) {
        this.trips.addAll(trips);
    }

    @Override
    public boolean equals(Object user) {
        return this.name.equals(((User)user).getName());
    }

    public String getName() {
        return this.name;
    }
    public List<Trip> getTrips() {
        return this.trips;
    }

}