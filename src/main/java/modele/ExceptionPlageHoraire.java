package modele;

public class ExceptionPlageHoraire extends RuntimeException {
    private int chCodeErreurPlage;

    public ExceptionPlageHoraire(int parCodeErreurPlage) {
      chCodeErreurPlage = parCodeErreurPlage;

    }

    public int getChCodeErreurPlage() {
        return chCodeErreurPlage;
    }
}
