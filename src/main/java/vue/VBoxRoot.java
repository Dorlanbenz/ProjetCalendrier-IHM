package vue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import modele.CalendrierDuMois;
import modele.ConstantesCalendrier;
import modele.Date;
import modele.DateCalendrier;

import java.util.List;

public class VBoxRoot extends VBox implements ConstantesCalendrier {
    public VBoxRoot() {
        Date today = new Date();
        CalendrierDuMois calendrier = new CalendrierDuMois(4, 2025);
        Label labelTitle = new Label( MOIS[calendrier.getMois()-1]  + calendrier.getAnnee());

        StackPane stackPaneMois = new StackPane();

        for(int i = 1; i <= 12; i++) {
            VBox boiteVBox = new VBox();
            CalendrierDuMois cal = new CalendrierDuMois(i, calendrier.getAnnee());
            Label labelStackPane = new Label("Mois : " + cal.getMois() + ", Année : " + cal.getAnnee());
            VBox.setMargin(labelStackPane, new Insets(14));

            ScrollPane scrollPaneDates = new ScrollPane();
            scrollPaneDates.setContent(boiteVBox);
            scrollPaneDates.setAccessibleText(MOIS[i-1]);

            for (DateCalendrier date : cal.getDates()) {
                Label dateLabel = new Label(date.toString());
                if (date.getMois() != cal.getMois()) {
                    dateLabel.setId("dateHorsMois");
                }
                if (date.isToday()) {
                    dateLabel.setId("today");
                }
                VBox.setMargin(dateLabel, new Insets(8));
                boiteVBox.getChildren().add(dateLabel);
            }
            stackPaneMois.getChildren().add(scrollPaneDates);
        }

        String moisCourant = MOIS[calendrier.getMois()-1];
        List<Node> listeNode = stackPaneMois.getChildren();
        while(!listeNode.get(listeNode.size()-1).getAccessibleText().equals(moisCourant)) {
            listeNode.get(0).toFront();
        }

        HBox boutonHBox = new HBox();
        Button boutonGauche = new Button("<");
        Button boutonDroit = new Button(">");
        Button boutonFinGauche = new Button("<<");
        Button boutonFinDroit = new Button(">>");
        boutonHBox.getChildren().addAll(boutonGauche, boutonDroit);

        HBox boutonFinHBox = new HBox();

        boutonFinHBox.getChildren().addAll(boutonFinGauche, boutonFinDroit);

        HBox labelHBox = new HBox();
        labelHBox.getChildren().addAll(labelTitle, boutonFinHBox, boutonHBox);
        labelHBox.setAlignment(Pos.CENTER_LEFT);
        boutonHBox.setAlignment(Pos.CENTER_RIGHT);
        boutonFinHBox.setAlignment(Pos.CENTER);
        HBox.setHgrow(boutonHBox, Priority.ALWAYS);

        this.getChildren().addAll(labelHBox,stackPaneMois);

        boutonDroit.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                System.out.println("bouton next");
                listeNode.get(0).toFront();
                labelTitle.setText(listeNode.get(listeNode.size()-1).getAccessibleText() + " 2025");
            }


        });

        boutonGauche.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                System.out.println("bouton before");
                listeNode.get(listeNode.size()-1).toBack();
                labelTitle.setText(listeNode.get(listeNode.size()-1).getAccessibleText() + " 2025");

            }
        });

        boutonFinDroit.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                while(listeNode.get(listeNode.size()-1).getAccessibleText().compareTo("décembre")!= 0)
                    listeNode.get(0).toFront();
                labelTitle.setText(listeNode.get(listeNode.size()-1).getAccessibleText() + " 2025");

            }

        });

        boutonFinGauche.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                while(listeNode.get(listeNode.size()-1).getAccessibleText().compareTo("janvier")!= 0)
                    listeNode.get(listeNode.size()-1).toBack();
                labelTitle.setText(listeNode.get(listeNode.size()-1).getAccessibleText() + " 2025");
            }

        });

    }
}
