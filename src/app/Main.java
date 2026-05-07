package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(
                getClass().getResource("../views/EnrollmentView.fxml")
        );

        Scene scene = new Scene(root, 800, 500);

        scene.getStylesheets().add(
                getClass().getResource("../styles/style.css").toExternalForm()
        );

        stage.setTitle("Student Course Enrollment System");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}