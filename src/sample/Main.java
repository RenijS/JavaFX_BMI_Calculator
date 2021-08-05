package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    Scene scene1;
    Scene scene2;

    @Override
    public void start(Stage primaryStage){
        build(primaryStage);
        primaryStage.setTitle("BMI");
        primaryStage.show();
    }

    public void build(Stage stage){
        //Initializing scene1 & scene 2
        //For scene 2 instead of here we can also initialize in button onAction
        setVersion1Scene(stage);
        setVersion2Scene(stage);

        //Initially setting version 1
        stage.setScene(scene1);
    }

    //Using FlowPane
    public void setVersion1Scene(Stage stage){
        //Defining controls
        Label header = new Label("BMI Calculator");
        header.setStyle("-fx-font: 40 Arial");

        Label heightLB = new Label("Enter your height(in cm): ");
        TextField heightTF = new TextField();

        Label weightLB = new Label("Enter your weight(in kg): ");
        TextField weightTF = new TextField();

        Button calculateBt = new Button("Calculate");

        Label bmiLB = new Label("Your BMI result will be displayed here");

        calculateBt.setOnAction(event -> {
            double height = Double.parseDouble(heightTF.getText().trim())/100;
            int weight = Integer.parseInt(weightTF.getText().trim());
            double bmi = weight/(height*height);
            bmiLB.setText("Your bmi is: " + String.format("%.2f", bmi));
        });

        TextArea infoTA = new TextArea();
        infoTA.appendText(
                "A BMI of 18.5 to 25 may indicate optimal weight\n" +
                        "A BMI lower than 18.5 may indicate underweight\n" +
                        "A BMI above 25 to 25 may indicate the person is overweight\n" +
                        "A BMI above 30 may indicate the person is obese"
        );

        Button version2BT = new Button("Check version 2");
        version2BT.setStyle("-fx-border-style: solid;" + "-fx-background-color: yellow;");
        version2BT.setOnAction(event -> {
            //setting another scene
            stage.setScene(scene2);
        });

        //version 1
        //Defining layout
        FlowPane root1 = new FlowPane();
        root1.getChildren().addAll(header, heightLB, heightTF, weightLB, weightTF, calculateBt, bmiLB, infoTA, version2BT);

        //setting scene and stage
        scene1 = new Scene(root1 ,400, 330);
        stage.setScene(scene1);
    }

    //Using VBox and HBox
    public void setVersion2Scene(Stage stage){
        //Defining controls
        Label header = new Label("BMI Calculator");
        header.setStyle("-fx-font: 40 Arial");

        Label heightLB = new Label("Enter your height(in cm): ");
        TextField heightTF = new TextField();

        Label weightLB = new Label("Enter your weight(in kg): ");
        TextField weightTF = new TextField();

        Button calculateBt = new Button("Calculate");

        Label bmiLB = new Label("Your BMI result will be displayed here");

        calculateBt.setOnAction(event -> {
            double height = Double.parseDouble(heightTF.getText().trim())/100;
            int weight = Integer.parseInt(weightTF.getText().trim());
            double bmi = weight/(height*height);
            bmiLB.setText("Your bmi is: " + String.format("%.2f", bmi));
        });

        TextArea infoTA = new TextArea();
        infoTA.appendText(
                "A BMI of 18.5 to 25 may indicate optimal weight\n" +
                        "A BMI lower than 18.5 may indicate underweight\n" +
                        "A BMI above 25 to 25 may indicate the person is overweight\n" +
                        "A BMI above 30 may indicate the person is obese"
        );

        Button version1BT = new Button("Check version 1");
        version1BT.setStyle("-fx-border-style: solid;" + "-fx-background-color: yellow;");
        version1BT.setOnAction(event -> {
            //setting another scene
            stage.setScene(scene1);
        });

        //version 2
        //Defining layouts
        HBox h1 = new HBox();
        HBox h2 = new HBox();
        HBox h3 = new HBox();
        HBox h4 = new HBox();
        HBox h5 = new HBox();
        HBox h6 = new HBox();
        HBox h7 = new HBox();
        h1.getChildren().addAll(header);
        h2.getChildren().addAll(heightLB, heightTF);
        h3.getChildren().addAll(weightLB, weightTF);
        h4.getChildren().addAll(calculateBt);
        h5.getChildren().addAll(bmiLB);
        h6.getChildren().addAll(infoTA);
        h7.getChildren().addAll(version1BT);

        VBox root2 = new VBox();
        root2.getChildren().addAll(h1,h2,h3,h4,h5,h6, h7);

        //setting scene
        scene2 = new Scene(root2 ,400, 330);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
