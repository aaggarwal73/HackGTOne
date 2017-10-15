package com.hackgtone;

import com.hackgtone.model.*;

/**
 * Created by Aman on 10/14/17.
 */

class Main {

    private static final Main ourInstance = new Main();
    private static String currentTrip; //change to type Trip later
    private static String chosenLeg; //change to type Itinerary later
    private static Service services;
    private static Trip trips;
    private Main() {

    }
    static Main getInstance() {
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

    public static void setCurrentTrip(String trip) {
        currentTrip=trip;
    }
    public static String getCurrentTrip() {
        return currentTrip;
    }

}
