package modele;

public class ExceptionPlanning extends RuntimeException {
    private int chCodeErreur;

    public ExceptionPlanning(int parCodeErreur) {
        chCodeErreur = parCodeErreur;
    }

    public int getChCodeErreur() {
        return chCodeErreur;
    }

}
