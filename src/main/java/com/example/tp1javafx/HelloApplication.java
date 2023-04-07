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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.text.Text;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {

        //Creation des Labels
        Label souscription = new Label("Souscrivez à notre newsletter");
        Label bienvenu = new Label("Bienvenue sur notre newsletter , inscrivez vous pour recevoir des nouvelles");
        Label civilite = new Label("Civilité");

        //Creation de la combobox et de la checkbox
        CheckBox checkbox = new CheckBox("J'accepte les conditions d'utilisation de la newsletter");
        ComboBox civiliteBox = new ComboBox();


        //Creation des labels
        Label nom = new Label("Nom");
        Label prenom = new Label("Prénom");
        Label email = new Label("Email");
        Label Confimation = new Label("Confirmer votre email");
        Label souscriptionreussie = new Label("Utilisateur  non inscrit");

        // creation des labels d'erreur
        Label erreurNom = new Label("Le nom est obligatoire");
        Label erreurPrenom = new Label("Le prénom est obligatoire");
        Label erreurEmail = new Label("L'email est obligatoire");
        Label erreurConfirmation = new Label("La verification du mail est obligatoire");
        Label erreurCheckbox = new Label("Il faut accepter les conditions d'utilisation");
        Label erreurvalidite = new Label("L'email n'est pas valide");
        Label erreuridentique = new Label("Les deux emails ne sont pas identiques");


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

        grilleDesInfos.add(erreurvalidite, 0, 10);
        grilleDesInfos.add(erreuridentique, 0, 11);

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
        erreurvalidite.setVisible(false);
        erreuridentique.setVisible(false);

        //attacher un eventHAdler et eventFilter au bouton souscrire
        souscrire.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> System.out.println("Vous avez cliqué sur le bouton souscrire"));

        //afficher le label souscrire uniquement si les champs sont remplis , et que les emails sont identiques et valides et que la checkbox est cochée
        souscrire.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {
            if (nomField.getText().isEmpty() || prenomField.getText().isEmpty() || emailField.getText().isEmpty() || confirmationField.getText().isEmpty() || !checkbox.isSelected() || !emailField.getText().matches("^[A-Za-z0-9+_.-]+@(.+)$") || !emailField.getText().equals(confirmationField.getText())) {
                souscriptionreussie.setVisible(false);
            } else {
                //faire un message souscription reussie avec tous les champs remplis et la date d'aujourd'hui
                souscriptionreussie.setText(  civiliteBox.getValue() + " " + nomField.getText() + " " + prenomField.getText() + " " + emailField.getText() +   "  s'est inscrit(e) le " + LocalDate.now() + " à " + LocalTime.now());
                souscriptionreussie.setVisible(true);
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
            }if (!emailField.getText().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                erreurvalidite.setVisible(true);
            } else {
                erreurvalidite.setVisible(false);
            }    if (!emailField.getText().equals(confirmationField.getText())) {
                erreuridentique.setVisible(true);
            } else {
                erreuridentique.setVisible(false);
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