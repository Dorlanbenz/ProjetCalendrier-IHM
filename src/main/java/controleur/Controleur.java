package controleur;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import modele.*;
import vue.GridPaneFormulaireReservation;
import vue.HBoxRoot;
import vue.VBoxCalendrier;

public class Controleur implements EventHandler {
    @Override
    public void handle(Event event) {
        PlanningCollections planning = HBoxRoot.getPlannings();
        GridPaneFormulaireReservation reservationPane = HBoxRoot.getReservationPane();

        //la source de event est un ToggleButton du calendrier
        if (event.getSource()instanceof ToggleButton) {
            DateCalendrier dateCalendrier = (DateCalendrier) ((ToggleButton) event.getSource()).getUserData();
            reservationPane.majTitle(dateCalendrier);


        }

        // la source de event est le bouton "Enregistrer" du formulaire de réservation
        if (event.getSource() instanceof Button) {
            DateCalendrier dateCalendrier = reservationPane.getDateCalendrier();
            Horaire horaire1 = new Horaire(reservationPane.getComboBox1(), reservationPane.getComboBox2());
            Horaire horaire2 = new Horaire(reservationPane.getComboBox3(), reservationPane.getComboBox4());
            PlageHoraire plageHoraire = new PlageHoraire(horaire1, horaire2);
            Reservation reservation = new Reservation(dateCalendrier, plageHoraire, reservationPane.getTextFieldCours(), reservationPane.getNiveauBoutons());

            planning.ajout(reservation);
            System.out.println(reservation);

        }
    }



}
