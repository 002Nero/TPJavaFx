package com.example.tp1javafx;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
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

        //Creation de la combobox et de la checkbox
        CheckBox checkbox = new CheckBox("Je souhaite recevoir des offres commerciales");
        ComboBox civiliteBox = new ComboBox();


        //Creation des labels
        Label nom = new Label("Nom");
        Label prenom = new Label("Prénom");
        Label email = new Label("Email");
        Label Confimation = new Label("Confirmer votre email");
        Label souscriptionreussie = new Label("Souscrivez à notre newsletter");

        // creation des labels d'erreur
        Label erreurNom = new Label("Veuillez remplir le champ nom");
        Label erreurPrenom = new Label("Veuillez remplir le champ prenom");
        Label erreurEmail = new Label("Veuillez remplir le champ email");
        Label erreurConfirmation = new Label("Veuillez remplir le champ confirmation");
        Label erreurCheckbox = new Label("Veuillez cocher la case");

        //Creation des textfield
        TextField nomField = new TextField();
        TextField prenomField = new TextField();
        TextField emailField = new TextField();
        TextField confirmationField = new TextField();
        Button souscrire = new Button("Souscrire");

        //afficher un message dans la console quand on clique sur le bouton souscrire
        souscrire.setOnMouseClicked(e -> System.out.println("Vous avez cliqué sur le bouton souscrire"));

        //Creation des layout
        BorderPane layout = new BorderPane();
        VBox vboxLabel = new VBox();
        GridPane grilleDesInfos = new GridPane();
        VBox vboxDessous = new VBox();

        //ajout du bouton et du label souscriptionreussie dans le vboxDessous
        vboxDessous.getChildren().addAll(souscrire, souscriptionreussie);

        //Mise en forme des elements
        souscription.setUnderline(true);
        vboxLabel.getChildren().addAll(souscription, bienvenu);
        layout.setCenter(grilleDesInfos);
        layout.setTop(vboxLabel);
        layout.setBottom(vboxDessous);

        //Alignement des elements
        vboxLabel.setAlignment(Pos.CENTER);
        vboxDessous.setAlignment(Pos.CENTER);
        layout.setPadding( new Insets(10, 10, 10, 10));

        // changer la couleur des labels d'erreur
        erreurNom.setStyle("-fx-text-fill: red");
        erreurPrenom.setStyle("-fx-text-fill: red");
        erreurEmail.setStyle("-fx-text-fill: red");
        erreurConfirmation.setStyle("-fx-text-fill: red");
        erreurCheckbox.setStyle("-fx-text-fill: red");

        //changer le label souscription avec les informations saisies dans les textfield quand on clique sur le bouton souscrire et que tous les champs sont remplis
        souscrire.setOnMouseClicked(e -> {
            if (!nomField.getText().isEmpty() && !prenomField.getText().isEmpty() && !emailField.getText().isEmpty() && !confirmationField.getText().isEmpty() && checkbox.isSelected()) {
                souscriptionreussie.setText("Vous vous êtes souscrit avec les informations suivantes : " + civiliteBox.getValue() + " " + nomField.getText() + " " + prenomField.getText() + " " + emailField.getText());
            }
        });

        //Ajout des elements dans la grille
        grilleDesInfos.add(civilite, 0, 0);
        grilleDesInfos.add(civiliteBox, 0, 1);
        grilleDesInfos.add(nom,0 , 2);
        grilleDesInfos.add(prenom, 1, 2);
        grilleDesInfos.add(email, 0, 5);
        grilleDesInfos.add(Confimation, 1, 5);

        //ajout des textfield et des labels d'erreur sous les textfield correspondant dans la grille
        grilleDesInfos.add(nomField, 0, 3);
        grilleDesInfos.add(prenomField, 1, 3);
        grilleDesInfos.add(emailField, 0, 6);
        grilleDesInfos.add(confirmationField, 1, 6);

        grilleDesInfos.add(erreurNom, 0, 4);
        grilleDesInfos.add(erreurPrenom, 1, 4);
        grilleDesInfos.add(erreurEmail, 0, 7);
        grilleDesInfos.add(erreurConfirmation, 1, 7);
        grilleDesInfos.add(erreurCheckbox, 0, 9);

        grilleDesInfos.add(checkbox, 0, 8);

        //Ajout des elements dans la combobox
        civiliteBox.getItems().addAll("M", "F", "X");
        //Mettre un element par defaut
        civiliteBox.setValue("M");


        //espace les elements de la grille
        grilleDesInfos.setHgap(10);
        grilleDesInfos.setVgap(10);

        //mettre une taille max aux textfield
        nomField.setMaxWidth(200);
        emailField.setMaxWidth(200);

        //faire disparaitre les labels d'erreur quand on clique sur le textfield
        erreurNom.setVisible(false);
        erreurPrenom.setVisible(false);
        erreurEmail.setVisible(false);
        erreurConfirmation.setVisible(false);
        erreurCheckbox.setVisible(false);



        //afficher le label souscriptionreussie en dessous du bouton souscrire quand on clique sur le bouton souscrire et que tous les champs sont remplis
        souscrire.setOnAction(e -> {
            if (!nomField.getText().isEmpty() && !prenomField.getText().isEmpty() && !emailField.getText().isEmpty() && !confirmationField.getText().isEmpty()) {
                layout.setBottom(souscriptionreussie);
            }
        });


        //afficher les labels d'erreur en fonction des champs remplis
        souscrire.setOnAction(e -> {
            if (nomField.getText().isEmpty()) {
                erreurNom.setVisible(true);
            } else {
                erreurNom.setVisible(false);
            }
            if (prenomField.getText().isEmpty()) {
                erreurPrenom.setVisible(true);
            } else {
                erreurPrenom.setVisible(false);
            }
            if (emailField.getText().isEmpty()) {
                erreurEmail.setVisible(true);
            } else {
                erreurEmail.setVisible(false);
            }
            if (confirmationField.getText().isEmpty()) {
                erreurConfirmation.setVisible(true);
            } else {
                erreurConfirmation.setVisible(false);
            } if (!checkbox.isSelected()) {
                erreurCheckbox.setVisible(true);
            } else {
                erreurCheckbox.setVisible(false);
            }

        });


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