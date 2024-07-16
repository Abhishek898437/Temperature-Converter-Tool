package com.internshala.javafxapp;


import com.sun.java.swing.action.FileMenu;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class MyMain extends Application {

    public static void main(String[] args) {
        System.out.println("main");
        launch(args);
    }

    @Override
    public void init() throws Exception{
        System.out.println("init");
        super.init();
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("start");

        FXMLLoader loader = new
                FXMLLoader(getClass().getResource("My_layout.fxml"));
        VBox rootNode = loader.load();

        MenuBar menuBar = createMenu();
        rootNode.getChildren().add(0,menuBar);


        Scene scene = new Scene(rootNode);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Temperature converted tool");

        primaryStage.show();

    }
    private MenuBar createMenu(){
        // file menu
        Menu fileMenu = new Menu("File");
        MenuItem newMenuItem = new MenuItem("New");

        newMenuItem.setOnAction(event -> System.out.println("new menu item clicked"));

        SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();

        MenuItem quitMenuItem = new MenuItem("Quit");

        quitMenuItem.setOnAction(event ->{
            Platform.exit();
            System.exit(0);
        });

        fileMenu.getItems().addAll(newMenuItem,separatorMenuItem ,quitMenuItem);


        // help menu
        Menu helpMenu = new Menu("Help");
        MenuItem aboutApp = new MenuItem("About");
        aboutApp.setOnAction(event -> aboutApp());
        helpMenu.getItems().addAll(aboutApp);

        // menuBar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu,helpMenu);
        return menuBar;

    }

    public void aboutApp() {
        Alert alertDialog = new Alert(Alert.AlertType.CONFIRMATION);
        alertDialog.setTitle("My First Desktop Application");
        alertDialog.setHeaderText("Learning Javafx");
        alertDialog.setContentText("I am just a beginner but soon i will start developing awesome java game");

        ButtonType yesBtn = new ButtonType("YES");
        ButtonType noBtn = new ButtonType("NO");

        alertDialog.getButtonTypes().setAll(yesBtn, noBtn);

        Optional<ButtonType> clickedBtn = alertDialog.showAndWait();

        if (clickedBtn.isPresent() && clickedBtn.get() == yesBtn) {
            System.out.println("yes button clicked");
        }else {
            System.out.println("no button clicked");
        }
    }

    @Override
    public void stop() throws Exception {
        System.out.println("stop");
        super.stop();
    }
}
