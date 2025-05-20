package modele;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;

public class PlanningCollections {
    private ArrayList <Reservation> chArrayList;
    private TreeSet <Reservation> chTreeSet;
    private TreeMap <Integer, TreeSet <Reservation>> chTreeMap;

    public PlanningCollections() {
        chArrayList = new ArrayList <>();
        chTreeSet = new TreeSet <>();
        chTreeMap = new TreeMap <>();
    }

    /**
     * La méthode ajout() ajoute la Reservation passé en paramètre dans les champs chArrayList et chTreeSet de l'objet appelant (this)
     * si cela n'est pas en conflit avec une reservation déjà enregistré sinon une exception est levée. Elle ajoute aussi la Reservation dans le champ TreeMap,
     * avec la semaine correspondant à la réservation dans l'année.
     * @param  parRes
     */
    public void ajout(Reservation parRes)throws ExceptionPlanning{
        for(int i = 0; i < chArrayList.size(); i++){
            if(chArrayList.get(i).compareTo(parRes) == 0)
                throw new ExceptionPlanning(3);
        }
        this.chArrayList.add(parRes);
        this.chTreeSet.add(parRes);

        int numSemaine = parRes.getDate().getJourSemaine();
        TreeSet <Reservation> setReservation = chTreeMap.get(numSemaine);

        if(setReservation == null){
            setReservation = new TreeSet <>();
            chTreeMap.put(numSemaine, setReservation);
        }
        setReservation.add(parRes);
    }

    /**
     * La méthode getReservations() renvoie l'ensemble des réservations du planning à la date passé en paramètre
     * @return res
     * @param parDate
     */
    public TreeSet <Reservation> getReservations(DateCalendrier parDate){
        TreeSet <Reservation> res = new TreeSet <>();
        Iterator<Reservation> itr = chTreeSet.iterator();
        while(itr.hasNext()){
            Reservation reserv = itr.next();
            if(reserv.getDate().compareTo(parDate) == 0)
                res.add(reserv);
        }
        if(res.isEmpty())
            return null;
        return res;
    }


    /**
     * La méthode getReservations() renvoie l'ensemble des réservations du planning à l'intitulé passé en paramètre
     * @return res
     * @param parString
     */
    public TreeSet <Reservation> getReservations(String parString){
        TreeSet <Reservation> res = new TreeSet <>();
        Iterator<Reservation> itr = chTreeSet.iterator();
        while(itr.hasNext()){
            Reservation reserv = itr.next();
            if(reserv.getIntitule().equals(parString))
                res.add(reserv);
        }
        if(res.isEmpty())
            return null;
        return res;
    }


    public String toString(){
        return "ArrayList: Taille = " + chArrayList.size() + ", contenu = " + chArrayList.toString() + "\n" + "TreeSet: Taille = "
                + chTreeSet.size() + ", contenu = " + chTreeSet.toString() + "\n" + "TreeMap: " + chTreeMap.toString();
    }


}
