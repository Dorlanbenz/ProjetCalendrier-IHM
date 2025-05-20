package modele;

public class ExceptionReservation extends RuntimeException {
    private int chCodeErreurRes;

    public ExceptionReservation(int parCodeErreurRes) {

        chCodeErreurRes = parCodeErreurRes;
    }

    public int getChCodeErreurRes() {

        return chCodeErreurRes;
    }
}
