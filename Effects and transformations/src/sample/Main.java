package sample;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.FlowPane;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;



public class Main extends Application implements EventHandler {
private Button blurButton, scaleButton, rotateButton;
private Rotate rotate;
private BoxBlur blur;
private double blurVal, angle, scaleFactor;
private Scale scale;
private Reflection reflection;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Effects and transformations");
        FlowPane pane = new FlowPane( 15,15);
        //initialize widgets
        blurButton = new Button("Blur");
        blurButton.setOnAction(this);
        scaleButton = new Button("scale");
        scaleButton.setOnAction(this);
        rotateButton = new Button("Rotate");
        rotateButton.setOnAction(this);
        rotate = new Rotate();
        blur= new BoxBlur(1.0,1.0,1);

        reflection= new Reflection();
        Label reflect = new Label("Reflection add visual sparkle");
        pane.getChildren().addAll(blurButton, rotateButton, scaleButton,reflect);
        pane.setAlignment(Pos.CENTER);

        Scene scene = new Scene(pane, 300,120);
        primaryStage.setScene(scene);
        primaryStage.show();
//initialize variables
        angle= 0.0;
        blurVal=1.0;
        scaleFactor= 0.4;
        reflection.setBottomOpacity(0.3);
        reflection.setTopOpacity(0.7);
        scale= new Scale(scaleFactor, scaleFactor);
//and transformation
        rotateButton.getTransforms().add(rotate);
        reflect.setEffect(reflection);
        scaleButton.getTransforms().add(scale);
    }


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void handle(Event event) {
if (event.getSource().equals(blurButton)){
    if (blurVal==10.0){
        blurVal=1.0;
        blurButton.setEffect(null);
        blurButton.setText("Blur off");
    }else{
        blurVal++;
        blurButton.setEffect(blur);
        blurButton.setText("Blur on");
    }
    blur.setHeight(blurVal);
    blur.setWidth(blurVal);
}else if(event.getSource().equals(rotateButton)){
    angle+=15.0;
    rotate.setAngle(angle);
    rotate.setPivotX(rotateButton.getWidth()/2);
    rotate.setPivotY(rotateButton.getHeight()/2);
}else if(event.getSource().equals(scaleButton)){
scaleFactor+=0.1;
if(scaleFactor>2.0){
    scaleFactor=0.4;
}
scale.setX(scaleFactor);
scale.setY(scaleFactor);
}
    }
}
