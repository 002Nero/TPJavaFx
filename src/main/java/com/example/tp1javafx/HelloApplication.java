package com.example.tp1javafx;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws FileNotFoundException {

        //Labels creation for the orchad
        Label appleTree = new Label("Apple Tree");
        Label cherryTree = new Label("Cherry Tree");
        Label pearTree = new Label("Pear Tree");
        Label plumTree = new Label("Plum Tree");

        Label appleTreeFruitNumber = new Label("0");
        Label cherryTreeFruitNumber = new Label("0");
        Label pearTreeFruitNumber = new Label("0");
        Label plumTreeFruitNumber = new Label("0");

        Label diceResult = new Label("0");



        //buttons for the dice roll and the end turn
        Button diceRoll = new Button("Dice Roll");
        Button endTurn = new Button("End Turn");


        //layout creation
        BorderPane gameBoard = new BorderPane();


        //creating and putting a gridpane in the center of the borderpane
        GridPane gamegrid = new GridPane();
        gamegrid.setPadding(new Insets(10, 10, 10, 10));
        gamegrid.setVgap(5);
        gamegrid.setHgap(5);
        gamegrid.setAlignment(Pos.CENTER);


        //putting the trees in the corners of the gridpane
        gamegrid.add(appleTree, 0, 0);
        gamegrid.add(cherryTree, 0, 4);
        gamegrid.add(pearTree, 4, 0);
        gamegrid.add(plumTree, 4, 4);

        //putting the number of fruits in the sides of the gridpane
        gamegrid.add(appleTreeFruitNumber, 0, 1);
        gamegrid.add(cherryTreeFruitNumber, 0, 3);
        gamegrid.add(pearTreeFruitNumber, 4, 1);
        gamegrid.add(plumTreeFruitNumber, 4, 3);


        //put the gridpane in the center of the borderpane
        gameBoard.setCenter(gamegrid);

        //put images in the background on the 4 corners of the gridpane
        /*BackgroundImage appleTreeImage = new BackgroundImage(new javafx.scene.image.Image("appleTree.png", 100, 100, false, true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        BackgroundImage cherryTreeImage = new BackgroundImage(new javafx.scene.image.Image("cherryTree.png", 100, 100, false, true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        BackgroundImage pearTreeImage = new BackgroundImage(new javafx.scene.image.Image("pearTree.png", 100, 100, false, true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        BackgroundImage plumTreeImage = new BackgroundImage(new javafx.scene.image.Image("plumTree.png", 100, 100, false, true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
*/


        //creating and putting the buttons in the bottom of the layout
        HBox bottomButtons = new HBox();
        bottomButtons.getChildren().addAll(diceRoll, endTurn);
        bottomButtons.setSpacing(10);
        bottomButtons.setAlignment(Pos.CENTER);
        gameBoard.setBottom(bottomButtons);

        //creating and putting the dice result in the top of the layout
        HBox topDiceResult = new HBox();
        topDiceResult.getChildren().addAll(diceResult);

        //putting images with imageview where the trees are
        ImageView appleTreeImageView = new ImageView(new Image("file:apple.jpg"));
        ImageView cherryTreeImageView = new ImageView(new Image("file:cherry.png"));
        ImageView pearTreeImageView = new ImageView(new Image("file:pear.png"));
        ImageView plumTreeImageView = new ImageView(new Image("file:plum.png"));


        gamegrid.add(appleTreeImageView, 0, 0);
        gamegrid.add(cherryTreeImageView, 0, 4);
        gamegrid.add(pearTreeImageView, 4, 0);
        gamegrid.add(plumTreeImageView, 4, 4);

        //putting the dice result in the top of the layout
        gameBoard.setTop(topDiceResult);




        //scene creation
        Scene scene = new Scene(gameBoard, 600, 450);



        //showing the stage
        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args) {

        launch();
    }


}