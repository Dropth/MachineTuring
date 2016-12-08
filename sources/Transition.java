/**
 * Alline Florian
 * Informatique théorique
 * Machine de Turing
 * M1 Informatique
 * Université du Havre
 */

public class Transition {
	
	private int mouvement;
    private int nombre;
    private int noeudSuiv;
    private int valeur;

    public Transition(int nombre, int noeudSuiv, int valeur,int mouvement) {
    	this.nombre = nombre;
        this.noeudSuiv = noeudSuiv;
        this.valeur = valeur;
        this.mouvement = mouvement;
    }

	public int getMouvement() {
		return mouvement;
	}

	public void setMouvement(int mouvement) {
		this.mouvement = mouvement;
	}

	public int getNombre() {
		return nombre;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}

	public int getNoeudSuiv() {
		return noeudSuiv;
	}

	public void setNoeudSuiv(int noeudSuiv) {
		this.noeudSuiv = noeudSuiv;
	}

	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}
}
