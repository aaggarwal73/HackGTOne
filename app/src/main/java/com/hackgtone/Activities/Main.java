package com.hackgtone.Activities;

import com.hackgtone.model.*;

import java.util.Arrays;

/**
 * Created by Aman on 10/14/17.
 */

public class Main {

    private static final Main ourInstance = new Main();
    private static Trip currentTrip; //change to type Trip later
    private static ServiceCenter chosenService; //change to type Itinerary later
    private static SkyClub[] clubs  = {new SkyClub(1, "ATL_Terminal1"), new SkyClub(2, "ATL_Terminal2"), new SkyClub(3, "BCN_Terminal"),
            new SkyClub(4, "BCN_Terminal"), new SkyClub(5, "JFK_Terminal1"), new SkyClub(6, "FL_Terminal"),
        new SkyClub(7, "LAX_Terminal")};
    private static Flight[] flights  = {new Flight(1, "JFK", "BCN", "12:00"), new Flight(2, "LAX", "FL", "8:00"),
            new Flight(3, "FL", "SFO", "18:00"), new Flight(4, "LAX", "JFK", "21:00"),
            new Flight(5, "DEN", "ATL", "1:00"), new Flight(1, "ATL", "JFK", "18:00")};
    private static ServiceCenter[] trip1 = {new Flight(2, "LAX", "FL", "8:00"), new SkyClub(6, "FL_Terminal"),
            new Flight(3, "FL", "SFO", "18:00")};

    public static ServiceCenter getChosenService() {
        return chosenService;
    }

    public static SkyClub[] getClubs() {
        return clubs;
    }

    public static Flight[] getFlights() {
        return flights;
    }

    public static ServiceCenter[] getTrip1() {
        return trip1;
    }

    public static ServiceCenter[] getTrip2() {
        return trip2;
    }

    public static Trip[] getTrips() {
        return trips;
    }

    private static ServiceCenter[] trip2 = {new Flight(1, "ATL", "JFK", "18:00"), new SkyClub(1, "ATL_Terminal1"),
            new SkyClub(2, "ATL_Terminal2"), new Flight(1, "JFK", "BCN", "12:00"),
            new Flight(3, "FL", "SFO", "18:00")};
    private static Trip[] trips = {new Trip(Arrays.asList(trip1), "Home"), new Trip(Arrays.asList(trip2), "Trip2")};
    private Main() {
    }
    public static Main getInstance() {
        return ourInstance;
    }


//    public static void changeScreen(String viewFile) {
//        try {
//            String fileName = "../view/" + getFilePath(viewFile) + ".fxml";
//
//            Pane pane = FXMLLoader.load(Main.class.getResource(fileName));
//            Scene changedScene = new Scene(pane);
//            SessionInfo.getInstance().updateManagerStatus();
//            SessionInfo.getInstance().setCurrentPage(viewFile);
//            mainStage.setScene(changedScene);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public static void setCurrentTrip(Trip trip) {
        currentTrip=trip;
    }
    public static Trip getCurrentTrip() {
        return currentTrip;
    }

}
