/*
 * Copyright (c) 16.05.2015
 * Team Turing
 */

package Prototyp.UI;

import Prototyp.Controll.AlertBox;
import Prototyp.Controll.ConfirmBox;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {

    Stage window;
    Scene main, option, java, newSnippel, javaFx, c;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;

        double h = 700; /* 700 */
        double w = 675; /* 675 */

        window.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });

        //Label

        Label labelM = new Label("Welcome");
        Label labelO = new Label("Option");
        Label labelJava = new Label("Java");
        Label labelNew = new Label("NewJava");
        Label labelJavaFx = new Label("JavaFx");
        Label labelC = new Label("C");

        //Buttons

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


        //  Button M1


        Button btnM1 = new Button("Option");
        btnM1.setOnAction(e -> window.setScene(option));


        // Button M2

        Button btnM2 = new Button("Alert");
        btnM2.setOnAction(e -> AlertBox.display("Fehler", "Fehlerbericht"));

        //Button M3

        Button btnM3 = new Button("Close");
        btnM3.setOnAction(e -> closeProgram());


        //Menu

        //structure menu

        Menu fileMenu = new Menu("File");
        Menu langMenu = new Menu("Lang");
        Menu helpMenu = new Menu("Help");


        //Menu operation

        MenuItem newCode = new MenuItem("New");
        newCode.setOnAction(e -> window.setScene(newSnippel));

        MenuItem optionMenu = new MenuItem("Option");
        optionMenu.setOnAction(e -> window.setScene(option));

        MenuItem newExit = new MenuItem("Exit");
        newExit.setOnAction(e -> closeProgram());

        MenuItem javaMenu = new MenuItem("Java");
        javaMenu.setOnAction(e -> window.setScene(java));

        MenuItem javaFxMenu = new MenuItem("JavaFX");
        javaFxMenu.setOnAction(e -> window.setScene(javaFx));

        MenuItem cMenu = new MenuItem("C");
        cMenu.setOnAction(e -> window.setScene(c));

        MenuItem aboutMenu = new MenuItem("About");
        aboutMenu.setOnAction(e -> AlertBox.display("About", "Version: 0.1a"));

        MenuItem alertMenu = new MenuItem("Alert");
        alertMenu.setOnAction(e -> AlertBox.display("Fehler", "Fehlerbericht"));


        //Menu item

        fileMenu.getItems().add(newCode);
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(optionMenu);
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(newExit);

        langMenu.getItems().add(javaMenu);
        langMenu.getItems().add(javaFxMenu);
        langMenu.getItems().add(cMenu);

        helpMenu.getItems().add(aboutMenu);
        helpMenu.getItems().add(alertMenu);


        //Main menu bar
        MenuBar menubar = new MenuBar();
        menubar.getMenus().addAll(fileMenu, langMenu, helpMenu);


        // Layout Main


        VBox leftmenuMain = new VBox(20);
        leftmenuMain.getChildren().addAll(labelM);

        HBox bottommenuMain = new HBox();
        bottommenuMain.getChildren().addAll();

        BorderPane borderMain = new BorderPane();
        borderMain.setTop(menubar);
        borderMain.setLeft(leftmenuMain);
        borderMain.setBottom(bottommenuMain);


        main = new Scene(borderMain, h, w);


        // Layout Option

        VBox leftMenuOption = new VBox(20);
        leftMenuOption.getChildren().addAll(labelO);

        HBox bottomMenuOption = new HBox();
        bottomMenuOption.getChildren().addAll();

        BorderPane borderOption = new BorderPane();
        borderOption.setTop(menubar);
        borderOption.setLeft(leftMenuOption);
        borderOption.setBottom(bottomMenuOption);


        option = new Scene(borderOption, h, w);


        // Layout Java

        VBox leftMenuJava = new VBox(20);
        leftMenuJava.getChildren().addAll(labelJava);

        HBox bottomMenuJava = new HBox();
        bottomMenuJava.getChildren().addAll();

        BorderPane borderJava = new BorderPane();
        borderJava.setTop(menubar);
        borderJava.setLeft(leftMenuJava);
        borderJava.setBottom(bottomMenuJava);

        java = new Scene(borderJava, h, w);

        // Layout newJava

        VBox leftMenuNew = new VBox(20);
        leftMenuNew.getChildren().addAll(labelNew);

        HBox bottomMenuNew = new HBox();
        bottomMenuNew.getChildren().addAll();

        BorderPane borderNew = new BorderPane();
        borderNew.setTop(menubar);
        borderNew.setLeft(leftMenuNew);
        borderNew.setBottom(bottomMenuNew);

        newSnippel = new Scene(borderNew, h, w);


        // Layout JavaFX

        VBox leftMenuJavaFx = new VBox(20);
        leftMenuJavaFx.getChildren().addAll(labelJavaFx);

        HBox bottomMenuJavaFx = new HBox();
        bottomMenuJavaFx.getChildren().addAll();

        BorderPane borderSnippel = new BorderPane();
        borderSnippel.setTop(menubar);
        borderSnippel.setLeft(leftMenuJavaFx);
        borderSnippel.setBottom(bottomMenuJavaFx);

        javaFx = new Scene(borderSnippel, h, w);


        // Layout C


        VBox leftMenuC = new VBox(20);
        leftMenuC.getChildren().addAll(labelC);

        HBox bottomMenuC = new HBox();
        bottomMenuC.getChildren().addAll();

        BorderPane borderC = new BorderPane();
        borderC.setTop(menubar);
        borderC.setLeft(leftMenuC);
        borderC.setBottom(bottomMenuC);

        c = new Scene(borderC, h, w);


        // Display Main Scene

        window.setScene(main);
        window.setTitle("Codeschnipselverwaltung");
        window.show();
    }

    private void closeProgram() {
        boolean answer = ConfirmBox.display("Exit", "Wollen sie wirklich das Programm beenden");
        if (answer)
            window.close();
    }
}