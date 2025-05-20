package vue;

import controleur.Controleur;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modele.DateCalendrier;
import modele.PlanningCollections;

public class HBoxRoot extends HBox{
    private static PlanningCollections planningCollections;
    private static Controleur controleur;
    private static VBoxCalendrier calendrierPane;
    private static GridPaneFormulaireReservation reservationPane;
    public HBoxRoot() {
        super(40);
        planningCollections = new PlanningCollections();
        controleur = new Controleur();
        calendrierPane = new VBoxCalendrier();
        reservationPane = new GridPaneFormulaireReservation();

        this.getChildren().addAll(calendrierPane, reservationPane);

    }

    public static PlanningCollections getPlannings() {
        return planningCollections;
    }

    public static GridPaneFormulaireReservation getReservationPane() {
        return reservationPane;
    }

    public static VBoxCalendrier getCalendrier() {
        return calendrierPane;
    }

    public static Controleur getControleur() {
        return controleur;
    }

}
