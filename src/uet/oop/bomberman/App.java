package uet.oop.bomberman;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        try {
            MenuManeger menuManeger = new MenuManeger();
            stage = menuManeger.getMainStage();
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        launch(args);
    }
}
