package vue;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import modele.CalendrierDuMois;
import modele.ConstantesCalendrier;
import modele.Date;
import modele.DateCalendrier;

import java.util.List;

public class VBoxCalendrier extends VBox implements ConstantesCalendrier{

    public VBoxCalendrier() {
        Date today = new Date();
        CalendrierDuMois moisActuel = new CalendrierDuMois(today.getMois(), today.getAnnee());

        Label labelTitle = new Label( MOIS[moisActuel.getMois()-1]  + " " + moisActuel.getAnnee());
        StackPane stackPaneMois = new StackPane();

        ToggleGroup buttongroup = new ToggleGroup();
        for(int numMois = 1; numMois <= 12; numMois++) {
            CalendrierDuMois monthCalendar = new CalendrierDuMois(numMois, today.getAnnee());

            TilePane tilePane = new TilePane();
            tilePane.setPrefColumns(7);
            tilePane.setPrefRows(monthCalendar.getDates().size()% 7 + 1 );

            tilePane.setId("opaque");
            for(String jourAb : JOURS_SEMAINE_ABR){
                Label labelJour = new Label(jourAb);
                tilePane.getChildren().add(labelJour);
            }

            for (DateCalendrier date : monthCalendar.getDates()) {
                ToggleButton boutonDate = new ToggleButton(Integer.toString(date.getJour()));

                boutonDate.setToggleGroup(buttongroup);
                tilePane.getChildren().add(boutonDate);

                boutonDate.setUserData(date);
                boutonDate.setOnAction(HBoxRoot.getControleur());
                if(date.getMois() != monthCalendar.getMois()){
                    boutonDate.setId("dateHorsMois");
                }
                if(date.isToday()){
                    boutonDate.setId("dateToday");
                }
            }
            tilePane.setAccessibleText(MOIS[numMois-1]);
            stackPaneMois.getChildren().add(tilePane);
        }

        List<Node> listeNode = stackPaneMois.getChildren();
        String moisCourant = MOIS[moisActuel.getMois()-1];
        while(!listeNode.get(listeNode.size()-1).getAccessibleText().equals(moisCourant)) {
            listeNode.get(0).toFront();
        }

        HBox boutonHBox = new HBox();
        Button boutonGauche = new Button("<");
        Button boutonDroit = new Button(">");
        Button boutonFinGauche = new Button("<<");
        Button boutonFinDroit = new Button(">>");
        boutonHBox.getChildren().addAll(boutonFinGauche, boutonGauche, boutonDroit, boutonFinDroit);

        HBox labelHBox = new HBox();
        labelHBox.getChildren().add(labelTitle);
        labelHBox.setAlignment(Pos.CENTER_LEFT);
        boutonHBox.setAlignment(Pos.CENTER_LEFT);

        HBox.setHgrow(boutonHBox, Priority.ALWAYS);

        this.getChildren().addAll(labelHBox,stackPaneMois, boutonHBox);

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
