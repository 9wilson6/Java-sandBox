package sample;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Main extends Application implements EventHandler {
private CheckBox mango, banana,apple,grape;
private Label response, question;
    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Best FruitsApp");
        FlowPane pane = new FlowPane(Orientation.VERTICAL, 10,5);
        //initialize controls
        question= new Label("What are you favourite fruits");
        response = new Label("");
        mango= new CheckBox("Mango");
        banana= new CheckBox("Banana");
        apple= new CheckBox("Apple");
        grape= new CheckBox("Grape");
        //
        pane.setAlignment(Pos.CENTER);
        pane.getChildren().addAll(question, mango,banana,apple,grape,response);
        //set stage and scene
        Scene scene = new Scene(pane, 500,300);
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void handle(Event event) {
        Object buttonClicked= event.getSource();
        if (banana.equals(buttonClicked)){
            System.out.println("hello");
        }
    }
}
