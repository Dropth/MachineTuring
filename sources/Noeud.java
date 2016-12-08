import java.util.ArrayList;
import java.util.List;

/**
 * Alline Florian
 * Informatique th�orique
 * Machine de Turing
 * M1 Informatique
 * Universit� du Havre
 */

public class Noeud {
    private ArrayList<Transition> listeTransitions;

    public Noeud(){
    	listeTransitions = new ArrayList<Transition>();
    }
    
    public List<Transition> getTransitions(){
        return listeTransitions;
    }

    public void addTransition(int nombre, int noeudSuivant, int valeur, int mouvement){
        Transition t = new Transition(nombre,noeudSuivant,valeur, mouvement);
        listeTransitions.add(t);
    }

    

}
