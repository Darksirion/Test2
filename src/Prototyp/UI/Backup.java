/*
 * Copyright (c) 16.05.2015
 * Team Turing
 */

package Prototyp.UI;

import javafx.application.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import Prototyp.Controll.AlertBox;
import Prototyp.Controll.ConfirmBox;


public class Backup extends Application {

    Stage window;
    Scene main, option, java, newJava, javafx, c;





    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;

        double maxheight = window.getMaxHeight();
        double maxwidth = window.getMaxWidth();

        double centerHeight= maxheight/2;
        double centerWidth= maxwidth/2;




        double h = 700; /* 700 */
        double w = 675; /* 675 */

        window.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });

        //Label

        Label labelM = new Label("Welcome");
        Label labelO = new Label("Option");
        Label labelj = new Label("Java");
        Label labelNewJava = new Label ("NewJava");
        Label labeljfx = new Label("JavaFx");
        Label labelc = new Label("C");

        // Button Save

        Button btnSave = new Button("Save");

        // Button SaveO

        Button btnSaveOption = new Button("Save");
        btnSaveOption.setOnAction(e -> {
            boolean result = ConfirmBox.display("Save", "Sollen die Änderungen gespeichert werden ?");
            if (result)
                window.setScene(main);
        });

        // Button VerwerfenO

        Button btnVerwerfenO = new Button("Verwerfen");

        // Button VerwerfenJ

        Button btnVerwerfenJ = new Button("Verwerfen");
        btnVerwerfenO.setOnAction(e -> window.setScene(main));

        // Button New

        Button btnNew = new Button ("New");

        //  Button M1


        Button btnM1 = new Button("Option");
        btnM1.setOnAction(e -> window.setScene(option));


        // Button M2

        Button btnM2 = new Button("Alert");
        btnM2.setOnAction(e -> AlertBox.display("Fehler", "Fehlerbericht"));

        //Button M3

        Button btnM3 = new Button("Close");
        btnM3.setOnAction(e -> closeProgram());

        Button btnMJ = new Button("Java");
        btnMJ.setOnAction(e -> window.setScene(java));

        Button btnMJFX = new Button("JavaFX");
        btnMJFX.setOnAction(e -> window.setScene(javafx));

        Button btnMC = new Button("C");
        btnMC.setOnAction(e -> window.setScene(c));



        // Layout Main

        HBox topmenuMain = new HBox();
        topmenuMain.getChildren().addAll(btnMJ,btnMJFX,btnMC);

        VBox leftmenuMain = new VBox(20);
        leftmenuMain.getChildren().addAll(labelM);

        HBox bottommenuMain = new HBox(20);
        bottommenuMain.getChildren().addAll(btnM1,btnM2);

        BorderPane borderMain = new BorderPane();
        borderMain.setTop(topmenuMain);
        borderMain.setLeft(leftmenuMain);
        borderMain.setBottom(bottommenuMain);


        main = new Scene(borderMain, h , w );

        // Button O1
/*
        Button btnO1 = new Button("Back to Main");
        btnO1.setOnAction(e -> {
                    boolean result = ConfirmBox.display("Save", "Sollen die Änderungen gespeichert ?");
                    if (result)
                        window.setScene(main);

        });
*/
        // Button O2
        //Button btnO2 = new Button("Verwerfern");
        //btnVerwerfen.setOnAction(e -> window.setScene(main));





        // Layout Option



        HBox topmenuOption = new HBox();
        topmenuOption.getChildren().addAll(btnSaveOption,btnVerwerfenO);

        VBox leftmenuOption = new VBox(20);
        leftmenuOption.getChildren().addAll(labelO);

        HBox bottommenuOption = new HBox(20);
        bottommenuOption.getChildren().addAll();

        BorderPane borderOption = new BorderPane();
        borderOption.setTop(topmenuOption);
        borderOption.setLeft(leftmenuOption);
        borderOption.setBottom(bottommenuOption);


        option = new Scene(borderOption, h, w);


        // Button J1
        btnNew.setOnAction(e -> window.setScene(newJava));

        // Button J2
        Button btnJ2 = new Button("Home");
        btnJ2.setOnAction(e -> window.setScene(main));


        // Layout Java

        VBox layoutj = new VBox(20);
        layoutj.getChildren().addAll(labelj,btnNew, btnJ2);
        java = new Scene(layoutj, h, w);

        // Layout newJava

        VBox layoutnJ = new VBox(20);
        btnVerwerfenJ.setOnAction(e -> window.setScene(java));
        layoutnJ.getChildren().addAll(labelNewJava,btnSave, btnVerwerfenJ);
        newJava = new Scene(layoutnJ, h, w);

/*
        // Layout JavaFX

        VBox layoutj = new VBox(20);
        layoutj.getChildren().addAll(btnJFX1, btnJFX2);
        java = new Scene(layoutj, h, w);

        // Layout C

        VBox layoutj = new VBox(20);
        layoutj.getChildren().addAll(btnC1, btnC2);
        java = new Scene(layoutj, h, w);

*/
       /* btnM1.setOnAction(e -> System.out.println("Test"));


        StackPane layout = new StackPane();
       layout.getChildren().add(btnM1);
        primaryStage.setScene(new Scene(layout, h, w));
       primaryStage.show(); */

        // Display Main Scene

        window.setScene(main);
        window.setTitle("Codeschnipselverwaltung");
        window.show();
    }

    private void closeProgram() {
        boolean answer = ConfirmBox.display("Exit","Wollen sie wirklich das Programm beenden");
        if (answer)
            window.close();
    }
}