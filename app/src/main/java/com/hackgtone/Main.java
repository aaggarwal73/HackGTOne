package com.hackgtone;

/**
 * Created by Aman on 10/14/17.
 */

class Main {
    private static final Main ourInstance = new Main();

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

    private Main() {
    }
}
