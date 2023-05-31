package com.example.Orchad;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
//import imageview
import javafx.scene.image.ImageView;
import com.example.Orchad.OrchadBoard;
import javafx.scene.shape.Rectangle;


public class HelloController {

    public static class dice extends Rectangle {
        //ajoute un attribut boolean
        private boolean selected;
        private  int nbFruitPicked = 0;


        //constructeur
        public dice() {
            super(150, 150);
            this.selected = false;
            this.nbFruitPicked = 0;


        }

        //getter
        public int getNbFruitPicked() {
            return this.nbFruitPicked;
        }
        //setter
        public void setNbFruitPicked(int nbFruitPicked) {
            this.nbFruitPicked = nbFruitPicked;
        }




        //getter
        public boolean getSelected() {
            return this.selected;
        }
        //setter
        public void setSelected(boolean selected) {
            this.selected = selected;
        }

    }

}



