package modele;

public class Reservation implements Comparable<Reservation> {
    private DateCalendrier chDate;
    private PlageHoraire chPlageHoraire;
    private String chIntitule;
    private String chNiveaux;



    public Reservation(DateCalendrier parDate,PlageHoraire parPlageHoraire, String parIntitule, String parNiveaux ) throws ExceptionReservation {
        if (!parDate.estValide() )
            throw new ExceptionReservation(1);

        if (!parPlageHoraire.estValide())
            throw new ExceptionReservation(2);

        if (parIntitule == null || parIntitule == "")
            throw new ExceptionReservation(0);
        else
            chIntitule = parIntitule;
            chDate = parDate;
            chPlageHoraire = parPlageHoraire;
            chNiveaux = parNiveaux;
    }

    /**elle retourne int neg si l'objet this précède la réservation passé en paramètre
     * sinon elle retourne positif si la réservation passée en paramètre précède l'objet this
     * sinon elle retounre 0 dans les autres cas
     * @param reservation
     * @return int
     */
    public int compareTo(Reservation reservation) {
        if (chDate.compareTo(reservation.chDate) == 1) {
            return 1;
        }
        else if (chDate.compareTo(reservation.chDate) == -1) {
            return -1;
        }
        else if (chDate.compareTo(reservation.chDate) == 0) {
            if (chPlageHoraire.compareTo(reservation.chPlageHoraire) == 1) {
                return 1;
            }
            else if (chPlageHoraire.compareTo(reservation.chPlageHoraire) == -1) {
                return -1;
            };
        }
        return 0;
    }

    public DateCalendrier getDate() {
        return chDate;
    }

    public String getIntitule() {
        return chIntitule;
    }

    public PlageHoraire getPlageHoraire() {
        return chPlageHoraire;
    }

    public String toString() {
        return chIntitule + ", " + chDate + ", " + chPlageHoraire + ", " + chNiveaux;
    }

    public String getNiveaux() {
        return chNiveaux;
    }
}
