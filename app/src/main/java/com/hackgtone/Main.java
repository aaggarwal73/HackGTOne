package com.hackgtone;

/**
 * Created by Aman on 10/14/17.
 */

class Main {
    private static final Main ourInstance = new Main();

    static Main getInstance() {
        return ourInstance;
    }
    private static String currentTrip; //change to type Trip later
    private static String chosenLeg; //change to type Itinerary later

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
    private Main() {
    }
}
