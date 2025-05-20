package vue;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import modele.*;
import javafx.scene.control.ToggleGroup;

public class GridPaneFormulaireReservation extends GridPane implements ConstantesCalendrier {
    private Label labelTitle;
    private TextField textFieldCours;
    private ToggleGroup niveauBoutons;
    private ComboBox<String> comboBox1;
    private ComboBox<String> comboBox2;
    private ComboBox<String> comboBox3;
    private ComboBox<String> comboBox4;
    private DateCalendrier dateCalendrier;
    public GridPaneFormulaireReservation() {
        DateCalendrier today = new DateCalendrier();
        dateCalendrier = today;
        CalendrierDuMois moisActuel = new CalendrierDuMois(today.getMois(), today.getAnnee());

        labelTitle = new Label( MOIS[moisActuel.getMois()-1]  + " " + moisActuel.getAnnee());
        this.add(labelTitle, 1, 0, 5, 1);

        Separator separator = new Separator();
        this.add(separator, 0, 1, 6, 1);

        Label labelCours = new Label("_"+"Cours");
        Label labelNiv = new Label("Niveaux");
        Label labelHoraire = new Label("Horaire");

        this.add(labelCours, 0, 2, 1, 1);
        this.add(labelNiv, 0, 3, 1, 1);
        this.add(labelHoraire, 0, 5, 1, 1);

        textFieldCours = new TextField();
        this.add(textFieldCours, 1, 2, 5, 1);

        RadioButton button1 = new RadioButton("_"+"debutant");
        RadioButton button2 = new RadioButton("_"+"moyen");
        RadioButton button3 = new RadioButton("_"+"avancé");
        RadioButton button4 = new RadioButton("_"+"expert");

        button1.setUserData("debutant");
        button2.setUserData("moyen");
        button3.setUserData("avancé");
        button4.setUserData("expert");

        niveauBoutons = new ToggleGroup();
        button1.setToggleGroup(niveauBoutons);
        button2.setToggleGroup(niveauBoutons);
        button3.setToggleGroup(niveauBoutons);
        button4.setToggleGroup(niveauBoutons);

        //Ligne 3
        this.add((Node)niveauBoutons.getToggles().get(0),1,3,2,1); //Bouton débutant
        this.add((Node)niveauBoutons.getToggles().get(1),3,3,2,1); //Bouton moyen

        //Ligne 4
        this.add((Node)niveauBoutons.getToggles().get(2),1,4,2,1); //Bouton avancé
        this.add((Node)niveauBoutons.getToggles().get(3),3,4,2,1); //Bouton expert


        Label labelDe = new Label("de");
        this.add(labelDe, 1, 5, 1, 1);

        Label labelH = new Label("h");
        Label labelH1= new Label("h");
        Label labelMin= new Label("mn");
        Label labelMin2= new Label("mn");
        Label labelA= new Label("à");

        comboBox1 = peupleComboBox(HEURES);
        comboBox2 = peupleComboBox(MINUTES);
        comboBox3 = peupleComboBox(HEURES);
        comboBox4 = peupleComboBox(MINUTES);

        this.add(comboBox1,2, 5, 1,1);
        this.add(labelH,3, 5,1,1);
        this.add(comboBox2, 4, 5,1,1);
        this.add(labelMin,5, 5,1,1);
        this.add(labelA,1, 6,1,1);
        this.add(comboBox3,2, 6,1,1);
        this.add(labelH1,3, 6,1,1);
        this.add(comboBox4,4, 6,1,1);
        this.add(labelMin2,5, 6,1,1);

        Separator separator1 = new Separator();
        this.add(separator1, 0, 7, 6, 1);

        this.setHgap(10);
        this.setVgap(10);

        Button annuler = new Button("_"+"Annuler");
        Button enregistrer = new Button("_"+"Enregistrer");

        enregistrer.setOnAction(HBoxRoot.getControleur());

        this.add(annuler, 3, 8, 1, 1);
        this.add(enregistrer, 5, 8, 1, 1);

    }

    private ComboBox<String> peupleComboBox(String[]strings){
        ComboBox<String> comboBox = new ComboBox<>();
        for(String string : strings){
            comboBox.getItems().add(string);
        }
        return comboBox;
    }

    public void majTitle(DateCalendrier date){
        labelTitle.setText(date.toString());
        dateCalendrier = date;
    }

    public String getTextFieldCours() {
        String texteReserv = textFieldCours.getText();
        return texteReserv;
    }

    public String getNiveauBoutons() {
        String texteRadioBouton = niveauBoutons.getSelectedToggle().getUserData().toString();
        return texteRadioBouton;
    }

    public int getComboBox1() {
        int heureDebutPlage = Integer.parseInt(comboBox1.getValue());
        return heureDebutPlage;
    }

    public int getComboBox2() {
        int minuteDebutPlage = Integer.parseInt(comboBox2.getValue());
        return minuteDebutPlage;
    }

    public int getComboBox3() {
        int heureFinPlage = Integer.parseInt(comboBox3.getValue());
        return heureFinPlage;
    }

    public int getComboBox4() {
        int minuteFinPlage = Integer.parseInt(comboBox4.getValue());
        return minuteFinPlage;
    }

    public DateCalendrier getDateCalendrier() {
        return dateCalendrier;
    }
}
