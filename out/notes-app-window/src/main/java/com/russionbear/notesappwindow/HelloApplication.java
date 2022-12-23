package com.russionbear.notesappwindow;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException, InterruptedException {
        startApps();

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 800);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public void startApps() throws IOException, InterruptedException {
        String tmpPath = this.getClass().getProtectionDomain().getCodeSource().getLocation().getFile();
        if(tmpPath.endsWith("!/")){
            int tmpIndex = tmpPath.indexOf("!/");
            tmpPath = tmpPath.substring(0, tmpIndex);
            tmpIndex = tmpPath.lastIndexOf("/");
            tmpPath = tmpPath.substring(0, tmpIndex);
        }else{
            System.out.println(tmpPath);
            int tmpIndex = tmpPath.lastIndexOf("/");
            tmpPath = tmpPath.substring(0, tmpIndex-1);
            tmpIndex = tmpPath.lastIndexOf("/");
            tmpPath = tmpPath.substring(0, tmpIndex);
        }
        tmpPath = tmpPath.substring(1);

        System.out.println(tmpPath);

        Properties prop = new Properties();
        FileInputStream fis =
                new FileInputStream(tmpPath+"/conf/setting.properties");
        prop.load(fis);
        prop.list(System.out);

        System.out.println("\nThe foo property: " +
                prop.getProperty("nacos"));

        System.out.println("\"E:/Program Files (x86)/openjdk-19.0.1/bin/java.exe\"" +
                " -jar "+tmpPath+"/packages/notesapp.backend.resource-0.0.1-SNAPSHOT.jar --server.port="+prop.getProperty("resource"));
        var processBuilder = new ProcessBuilder();
        processBuilder.command("E:\\workspace\\notes-app\\notes-app-window\\target\\bin\\run.cmd");
        var process = processBuilder.start();
        var ret = process.waitFor();

    }

    public static void main(String[] args) {
//        Application.launch(HelloApplication.class);
        launch();
    }
}