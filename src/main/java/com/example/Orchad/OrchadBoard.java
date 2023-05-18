package com.example.Orchad;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.util.Random;

public class OrchadBoard extends Application {
    @Override
    public void start(Stage stage) throws FileNotFoundException {

        //creating theHbox that will contain 2 vboxes
        HBox gameBoard = new HBox();
        VBox leftVbox = new VBox();
        VBox rightVbox = new VBox();

        //creating of the gridpanes for the orchad on the right
        GridPane orchad = new GridPane();


        //labels creation for the orchad
        Label apple = new Label("Apple");
        Label pear = new Label("Pear");
        Label plum = new Label("Plum");
        Label cherry = new Label("Cherry");
        Label turnNumber = new Label("Turn : 1");
        Label turnDescription = new Label("It's your turn !");


        //create an thing that display the number of fruit when your cursor is on it
        Label appleNbFruit = new Label("0");
        Label pearNbFruit = new Label("0");
        Label plumNbFruit = new Label("0");
        Label cherryNbFruit = new Label("0");


        //creation of the buttons
        Button start = new Button("Roll Dice");
        Button exit = new Button("End Turn");



        //adding the image in the bottom of the left vbox
        Image image = new Image("file:bookTurn.png", 300, 300, false, true);
        ImageView imageView = new ImageView(image);

        //make the image more higher
        imageView.setTranslateY(-100);


        //creating a square for the dice and putting it in the center of the vbox
        Rectangle dice = new Rectangle(150, 150);
        dice.setFill(Color.WHITE);

        //putting the label in the center of the vbox on the book image
        turnNumber.setAlignment(Pos.CENTER);
        turnNumber.setTranslateY(-380);
        turnNumber.setTranslateX(185);
        turnNumber.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        turnNumber.setTextFill(Color.BLACK);

        //putting the label turnDescription slightly under the turnNumber label on the left
        turnDescription.setAlignment(Pos.CENTER);
        turnDescription.setTranslateY(-310);
        turnDescription.setTranslateX(50);
        turnDescription.setFont(Font.font("Verdana", 20));
        turnDescription.setTextFill(Color.BLACK);


        //met un padding de 10 px sur la gauche et le dessous du livre
        leftVbox.setPadding(new Insets(0, 100, 10, 15));

        leftVbox.getChildren().add(imageView);
        leftVbox.getChildren().add(turnNumber);
        leftVbox.getChildren().add(turnDescription);

        //met le de au milieu de la vbox
        leftVbox.setAlignment(Pos.CENTER);
        leftVbox.getChildren().add(dice);


        //create hbox to put all the buttons in the left vbox
        HBox buttons = new HBox();
        buttons.getChildren().addAll(start, exit);



        leftVbox.getChildren().add(buttons);

        //put the hbox in the bottom of the screen
        leftVbox.setAlignment(Pos.BOTTOM_LEFT);





        //putting images to the labels
        apple.setGraphic(new ImageView(new Image("file:apple.png", 50, 50, false, true)));
        pear.setGraphic(new ImageView(new Image("file:pear.png", 50, 50, false, true)));
        plum.setGraphic(new ImageView(new Image("file:plum.png", 50, 50, false, true)));
        cherry.setGraphic(new ImageView(new Image("file:cherry.png", 50, 50, false, true)));



        //making the vboxes have a width and a height fixed
        leftVbox.setMaxWidth(450);
        rightVbox.setMaxWidth(750);
        leftVbox.setMaxHeight(750);
        rightVbox.setMaxHeight(750);
        leftVbox.setMinWidth(450);
        rightVbox.setMinWidth(750);
        leftVbox.setMinHeight(750);
        rightVbox.setMinHeight(750);
        leftVbox.setStyle("-fx-background-color: Transparent");
        rightVbox.setStyle("-fx-background-color: Transparent");


        //putting the gridpane in the center of the vbox
        orchad.setAlignment(Pos.CENTER);

//creating borders for each gridpane with a different color
        orchad.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));




        //i want to see the gridpanes borders
        orchad.setGridLinesVisible(true);


        //make the gridpanes fits the size of the vbox
        orchad.setMaxWidth(750);
        orchad.setMaxHeight(750);
        orchad.setMinWidth(750);
        orchad.setMinHeight(750);

        //make the gridpane 9x9 with a cell border visible
        orchad.setGridLinesVisible(true);
        orchad.setHgap(1);
        orchad.setVgap(1);

        //make the gridpane 9x9
        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setPercentWidth(100.0 / 3);
        RowConstraints rowConstraints = new RowConstraints();
        rowConstraints.setPercentHeight(100.0 / 3);
        for (int i = 0; i < 3; i++) {
            orchad.getColumnConstraints().add(columnConstraints);
            orchad.getRowConstraints().add(rowConstraints);

        }





        //create 4 gridpanes for the fruits and put them in the gridpane orchad on each side
        GridPane appleGrid = new GridPane();
        GridPane pearGrid = new GridPane();
        GridPane plumGrid = new GridPane();
        GridPane cherryGrid = new GridPane();
        orchad.add(appleGrid, 0, 1);
        orchad.add(pearGrid, 1, 0);
        orchad.add(plumGrid, 1, 2);
        orchad.add(cherryGrid, 2, 1);

        BorderPane appleShulker = new BorderPane();
        BorderPane pearShulker = new BorderPane();
        BorderPane plumShulker = new BorderPane();
        BorderPane cherryShulker = new BorderPane();
        orchad.add(appleShulker, 0, 0);
        orchad.add(pearShulker, 2, 0);
        orchad.add(plumShulker, 0, 2);
        orchad.add(cherryShulker, 2, 2);

        //make the gridpanes 3x3
        ColumnConstraints columnConstraints1 = new ColumnConstraints();
        columnConstraints1.setPercentWidth(100.0 / 5);
        RowConstraints rowConstraints1 = new RowConstraints();
        rowConstraints1.setPercentHeight(100.0 / 5);
        for (int i = 0; i < 5; i++) {
            appleGrid.getColumnConstraints().add(columnConstraints1);
            appleGrid.getRowConstraints().add(rowConstraints1);
            pearGrid.getColumnConstraints().add(columnConstraints1);
            pearGrid.getRowConstraints().add(rowConstraints1);
            plumGrid.getColumnConstraints().add(columnConstraints1);
            plumGrid.getRowConstraints().add(rowConstraints1);
            cherryGrid.getColumnConstraints().add(columnConstraints1);
            cherryGrid.getRowConstraints().add(rowConstraints1);
        }

        //put in the middle of the gridpanes for shulkers  the images of shulkers
        appleShulker.setCenter(new ImageView(new Image("file:shulkerfGreen.png", 170, 170, false, true)));
        pearShulker.setCenter(new ImageView(new Image("file:shulkerfYellow.png", 170, 170, false, true)));
        plumShulker.setCenter(new ImageView(new Image("file:shulkerfBlue.png", 170, 170, false, true)));
        cherryShulker.setCenter(new ImageView(new Image("file:shulkerfRed.png", 170, 170, false, true)));

        orchad.add(appleNbFruit, 0, 0);
        orchad.add(pearNbFruit, 2, 0);
        orchad.add(plumNbFruit, 0, 2);
        orchad.add(cherryNbFruit, 2, 2);

        //put the number of fruits in the  bottom corner of the gridpanes and make them bigger with an according color
        appleNbFruit.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
        appleNbFruit.setTextFill(Color.GREEN);
        plumNbFruit.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
        plumNbFruit.setTextFill(Color.BLUE);
        cherryNbFruit.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
        cherryNbFruit.setTextFill(Color.RED);
        pearNbFruit.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
        pearNbFruit.setTextFill(Color.YELLOW);




        //putting the images in the gridpanes in a pyramid shape with a for
        appleGrid.add(new ImageView(new Image("file:apple.png", 50, 50, false, true)),1 , 2);
        pearGrid.add(new ImageView(new Image("file:pear.png", 50, 50, false, true)), 2,1 );
        plumGrid.add(new ImageView(new Image("file:plum.png", 50, 50, false, true)), 2,3 );
        cherryGrid.add(new ImageView(new Image("file:cherry.png", 50, 50, false, true)), 3, 2);



        for (int ligne = 0; ligne < 5; ligne++) {
            for (int colonne = 0; colonne < 5 ; colonne++) {
                if (ligne % 2 != 0) {
                    if(colonne % 2 != 0){
                        InsertFruits(appleGrid, pearGrid, plumGrid, cherryGrid, ligne, colonne);

                    }
                    continue;
                }
//
                if (ligne == 2) {
                    if(colonne % 2 == 0){
                        InsertFruits(appleGrid, pearGrid, plumGrid, cherryGrid, ligne, colonne);
                    }
                    continue;
                }
//
                if (colonne == 2 ){
                    InsertFruits(appleGrid, pearGrid, plumGrid, cherryGrid, ligne, colonne);

                }

            }
        }


        //enum for the fruits witch attribuates a number to each fruit
        enum Fruit {
            APPLE(1), PLUM(2), PEAR(3), CHERRY(4);
            private int value;
            Fruit(int value) {
                this.value = value;
            }
            public int getValue() {
                return value;
            }
        }




        //putting the gridpanes in the vbox
        rightVbox.getChildren().addAll(orchad);


//change the color of the dice to a random color that match the fruits when pressing the start button
        start.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //creating a random number between 1 and 4
                int random = new Random().nextInt(4) + 1;
                switch (random) {
                    case 1 :
                        dice.setFill(new ImagePattern(new Image("file:apple.png")));
                        appleGrid.getChildren().remove(0);
                        //change the Label of the number of fruit to add +1 to the score
                        appleNbFruit.setText(String.valueOf(Integer.parseInt(appleNbFruit.getText()) + 1));
                        //si le label est superieur a 0 on change l'image de la shulker box
                        if (Integer.parseInt(appleNbFruit.getText()) > 0) {
                            appleShulker.getChildren().remove(0);
                            appleShulker.setCenter(new ImageView(new Image("file:shulker_open_Green2.png", 170, 170, false, true)));

                        }







                        break;
                    case 2 :
                        dice.setFill(new ImagePattern(new Image("file:plum.png")));
                        plumGrid.getChildren().remove(0);
                        plumNbFruit.setText(String.valueOf(Integer.parseInt(plumNbFruit.getText()) + 1));
                        if (Integer.parseInt(plumNbFruit.getText()) > 0) {
                            plumShulker.getChildren().remove(0);
                            plumShulker.setCenter(new ImageView(new Image("file:shulker_open_Blue2.png", 170, 170, false, true)));

                        }
                        break;

                    case 3 :
                        dice.setFill(new ImagePattern(new Image("file:pear.png")));
                        pearGrid.getChildren().remove(0);
                        pearNbFruit.setText(String.valueOf(Integer.parseInt(pearNbFruit.getText()) + 1));
                        if (Integer.parseInt(pearNbFruit.getText()) > 0) {
                            pearShulker.getChildren().remove(0);
                            pearShulker.setCenter(new ImageView(new Image("file:shulker_open_yellow2.png", 170, 170, false, true)));

                        }
                        break;
                    case 4 :
                        dice.setFill(new ImagePattern(new Image("file:cherry.png")));
                        cherryGrid.getChildren().remove(0);
                        cherryNbFruit.setText(String.valueOf(Integer.parseInt(cherryNbFruit.getText()) + 1));
                        if (Integer.parseInt(cherryNbFruit.getText()) > 0) {
                            cherryShulker.getChildren().remove(0);
                            cherryShulker.setCenter(new ImageView(new Image("file:shulker_open_red2.png", 170, 170, false, true)));

                        }
                        break;

                    default:
                        System.out.println("error");
                        break;

                }



                //if a fruit is already remove roll the dice until there is one
                if (appleGrid.getChildren().isEmpty() && plumGrid.getChildren().isEmpty() && pearGrid.getChildren().isEmpty() && cherryGrid.getChildren().isEmpty()) {
                    dice.setFill(Color.TRANSPARENT);
                }



            }



        });






        //putting the vboxes in the hbox
        gameBoard.getChildren().addAll(leftVbox, rightVbox);
        //put the background image named backgroundORchad.png in the background of the layout
        BackgroundImage orchadBackground = new BackgroundImage(new Image("file:orchadGameBOard.png", 1200, 750, false, true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        //put the borderpane and gridpane  in transparent so the background image can be seen
        gameBoard.setBackground(new Background(orchadBackground));





        //scene creation
        Scene scene = new Scene(gameBoard, 1200, 750);
        stage.setResizable(false);



        //showing the stage
        stage.setScene(scene);
        stage.show();


    }

    private static void InsertFruits(GridPane appleGrid, GridPane pearGrid, GridPane plumGrid, GridPane cherryGrid, int ligne, int colonne) {
        appleGrid.add(new ImageView(new Image("file:apple.png", 50, 50, false, true)), colonne, ligne);
        pearGrid.add(new ImageView(new Image("file:pear.png", 50, 50, false, true)), colonne, ligne);
        plumGrid.add(new ImageView(new Image("file:plum.png", 50, 50, false, true)), colonne, ligne);
        cherryGrid.add(new ImageView(new Image("file:cherry.png", 50, 50, false, true)), colonne, ligne);
    }

    public static void main(String[] args) {

        launch();
    }


}