import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * Alline Florian
 * Informatique théorique
 * Machine de Turing
 * M1 Informatique
 * Université du Havre
 */

public class Turing {
	
	private int index;
    private int positionNoeud;
	
    private String etatInitial;
    
    private ArrayList<String> bande;
    private Noeud[] noeuds;

    public Turing(String transitions,String etatInitial,String bande){
        
        this.etatInitial=etatInitial;
        this.bande=new ArrayList<String>();
        this.bande.add(bande);
        this.noeuds = new Noeud[5];
        
        initialiserTransitions(transitions);
        positionNoeud = Integer.parseInt(etatInitial,2);
        
        for(int i=0;i<200;i++) 
        	this.bande.add("3");
        
        for(int i=0;i<bande.length();i++) 
        	this.bande.set(i,""+bande.charAt(i));
    }
    
    private void initialiserTransitions(String transitions){
    	
        String[] tabTransi = transitions.split(Pattern.quote(",("));
        Integer noeudCourant,nombre,noeudSuivant,valeur,mouvement;
        String[] str;
        
        for(int i=0;i<tabTransi.length;i++){
        	tabTransi[i] = tabTransi[i].replace("(","").replace(")","");
        }
        
        for(String s : tabTransi){
        	
        	str = s.split(Pattern.quote(","));
        	
            noeudCourant = Integer.parseInt(str[0],2);
            noeudSuivant = Integer.parseInt(str[2],2);
            mouvement = Integer.parseInt(str[4],2);
            
            if(str[1].equals("3")) 
            	nombre = 3;
            else 
            	nombre = Integer.parseInt(str[1],2);
            
            if(str[3].equals("3")) 
            	valeur = 3;
            else 
            	valeur = Integer.parseInt(str[3], 2);
            
            if(noeudCourant>noeuds.length || noeuds[noeudCourant] == null){
                
            	noeuds[noeudCourant] = new Noeud();
                noeuds[noeudCourant].addTransition(nombre,noeudSuivant,valeur,mouvement);
            }
            else 
            	noeuds[noeudCourant].addTransition(nombre,noeudSuivant,valeur,mouvement);
        }
    }

    public ArrayList<String> calculer(){

    	int lecture;

    	boolean estBloque=false;
    	boolean verif=false;

    	while(!estBloque){

    	    if(index<0)
    	    	lecture=3;
    	    else 
    	    	if(bande.get(index).equals("3")) 
    	    		lecture=3;
    	    else 
    	    	lecture = Integer.parseInt(bande.get(index),2);
    	    
	    	    boucleInterne:
	    	    for(Transition transi : noeuds[positionNoeud].getTransitions()){
	
	    	        if(transi.getNombre() == lecture){
	    	            
	    	        	if(index==-1) 
	    	        		bande.add(0,""+transi.getValeur());
	    	            else 
	    	            	bande.set(index,""+transi.getValeur());
	    	        	
	    	            if(transi.getMouvement()==0) 
	    	            	index--;
	    	            else 
	    	            	index++;
	
	    	            positionNoeud=transi.getNoeudSuiv();
	    	            verif=true;
	
	    	            break boucleInterne;
	    	        }
	    	    }
    	    
	    	    estBloque= !verif;
	    	    verif=false;
	    	    
	    	    System.out.print("Bande : \n");
	    	    
	    	    afficherBande(index);
	    	}
	
	    	System.out.print("Bande : \n");
	
	    	afficherBande(index);
	
	    	return this.bande;
    	}

    private void afficherBande(int index){
    	
        int cpt=0;
        
        System.out.println("---------------------------");
        
        for(String s : this.bande){
            
        	if(s.equals("3")){
            	cpt++;
                System.out.print("# ");
            }
            else{
            	cpt=0;
                System.out.print(s + " ");
            }
            if(cpt==2) break;
            
            
        }
        
        System.out.println("\nPosition de la tête : " + index);
        System.out.println("---------------------------");
        System.out.println();
    }
    
    public static void main(String[] args) {
        //String nb="(101,10,101,0,(100))";
        //String transitions = "(0,1,1,11,1),(0,100,11,100,1),(1,1,1,1,1),(1,10,10,100,0),(1,100,1,100,1),(10,1,10,1,0),(10,11,0,11,1),(10,100,10,100,0),(11,100,11,100,1),(11,0,100,0,1))";
        String transitions = "(0,0,0,1,1),(0,3,1,3,0),(1,1,10,0,0),(10,1,10,1,0),(10,0,10,0,0),(10,3,11,0,1),(11,0,11,0,1),(11,1,10,0,0)";
        String etatInitial = "0";
        String bande = "01";
        Turing machineTuring = new Turing(transitions,etatInitial,bande);
        
        System.out.println("Debut de l'execution\n");
        System.out.println("Bande Initiale :");
        machineTuring.afficherBande(0);
        machineTuring.calculer();
        System.out.println("Fin de l'execution");
    }
}
