package vue;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.File;

public class PremiereApplication extends Application {

    public void start(Stage stage)   {
        HBoxRoot root = new HBoxRoot();
        Scene scene = new Scene(root, 800, 300);

        File [] fichiersCss = new File("FichierCSS").listFiles();
        for (File fichier : fichiersCss) {
            scene.getStylesheets().add(fichier.toURI().toString());
        }

        stage.setScene(scene);
        stage.setTitle("Calendrier du Mois");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
