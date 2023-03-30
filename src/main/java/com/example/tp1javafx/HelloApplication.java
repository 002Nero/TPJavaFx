package com.example.tp1javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.text.Text;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {

        //Creation des Labels
        Label souscription = new Label("Souscrivez à notre newsletter");
        Label bienvenu = new Label("Bienvenue sur notre newsletter , inscrivez vous pour recevoir des nouvelles");
        Label civilite = new Label("Civilité");

        //Creation de la combobox
        ComboBox civiliteBox = new ComboBox();

        //Creation des labels
        Label nom = new Label("Nom");
        Label prenom = new Label("Prénom");
        Label email = new Label("Email");
        Label Confimation = new Label("Confirmer votre email");

        //Creation des textfield
        TextField nomField = new TextField();
        TextField prenomField = new TextField();
        TextField emailField = new TextField();
        TextField confirmationField = new TextField();
        Button souscrire = new Button("Souscrire");


        //Creation des layout
        BorderPane layout = new BorderPane();
        VBox vboxLabel = new VBox();
        GridPane grilleDesInfos = new GridPane();

        //Mise en forme des elements
        souscription.setUnderline(true);
        vboxLabel.getChildren().addAll(souscription, bienvenu);
        layout.setCenter(grilleDesInfos);
        layout.setTop(vboxLabel);
        layout.setBottom(souscrire);

        //Alignement des elements
        vboxLabel.setAlignment(Pos.CENTER);
        layout.setAlignment(souscrire, Pos.CENTER);
        layout.setPadding( new Insets(10, 10, 10, 10));


        //Ajout des elements dans la grille
        grilleDesInfos.add(civilite, 0, 0);
        grilleDesInfos.add(civiliteBox, 0, 1);
        grilleDesInfos.add(nom,0 , 2);
        grilleDesInfos.add(nomField, 0, 3);
        grilleDesInfos.add(email, 0, 4);
        grilleDesInfos.add(emailField, 0, 5);

        grilleDesInfos.add(prenom, 1, 2);
        grilleDesInfos.add(prenomField, 1, 3);
        grilleDesInfos.add(Confimation, 1, 4);
        grilleDesInfos.add(confirmationField, 1, 5);


        //Ajout des elements dans la combobox
        civiliteBox.getItems().addAll("M", "F", "X");
        //Mettre un element par defaut
        civiliteBox.setValue("M");

        //espace les elements de la grille
        grilleDesInfos.setHgap(10);
        grilleDesInfos.setVgap(10);






        //Creation de la scene
        Scene scene = new Scene(layout, 600, 450);


        //Affichage de la scene
        stage.setTitle("Application Newsletter");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        Application.launch(args);
    }


}