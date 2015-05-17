/*
 * Copyright (c) 16.05.2015
 * Team Turing
 */

package Prototyp.Controll;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;



public class ConfirmBox {

    static boolean answer;

    public static boolean display(String title, String message){
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);

        Label label = new Label();
        label.setText(message);

        Button yesButton = new Button("yes");
        Button noButton = new Button("no");

        yesButton.setOnAction(e -> {
            answer = true;
            window.close();
        });

        noButton.setOnAction(e  -> {
            answer = false;
            window.close();
        });



        HBox layout = new HBox();
        layout.getChildren().addAll(yesButton, noButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene= new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

    return answer;
    }

}
