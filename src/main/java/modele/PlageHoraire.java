package modele;

public class PlageHoraire {
    private Horaire chHoraireDebut;
    private Horaire chHoraireFin;
    private final static int DUREE_MINIMUM = 30;

    public PlageHoraire(Horaire parHoraireDebut, Horaire parHoraireFin) throws ExceptionPlageHoraire {
        if (parHoraireFin.toMinutes() - parHoraireDebut.toMinutes() < DUREE_MINIMUM)
            throw new ExceptionPlageHoraire(1);
        else
            chHoraireDebut = parHoraireDebut;
            chHoraireFin = parHoraireFin;
    }

    /**
     * elle retourne un entier, this, la durée de this
     * @return int
     */
    public int duree() {
        return chHoraireFin.toMinutes() - chHoraireDebut.toMinutes();

    }


    public boolean estValide() {
        if (chHoraireDebut.getHeure() > chHoraireFin.getHeure())
            return false;
        if (chHoraireFin.toMinutes() - chHoraireDebut.toMinutes() < DUREE_MINIMUM)
            return false;
        return true;
    }

    /**
     * elle retourne int négatif quand l'objet this précède la plage horaire reçue en paramètre
     * sinon si la plage horaire reçue an parmètre précède l'objet this, elle retoune int positif
     * sinon dans les autres cas, elle retourne 0
     * @param plageHoraire
     * @return int
     */

    public int compareTo(PlageHoraire plageHoraire) {
        if (chHoraireDebut.toMinutes() <= plageHoraire.chHoraireFin.toMinutes() && chHoraireFin.toMinutes() <= plageHoraire.chHoraireDebut.toMinutes())
            return -1;
        if (chHoraireDebut.toMinutes() >= plageHoraire.chHoraireFin.toMinutes() && chHoraireFin.toMinutes() >= plageHoraire.chHoraireDebut.toMinutes())
            return 1;
        else
            return 0;
    }

    public String toString() {
        if (chHoraireFin.getHeure() - chHoraireDebut.getHeure() == 0){
            return chHoraireDebut + " - " + chHoraireFin + ", durée:" + duree() + "mn";
        }
        return chHoraireDebut + " - " + chHoraireFin + ", durée:" + duree()/60 + "h" + duree()%60 + "mn";
    }



}
