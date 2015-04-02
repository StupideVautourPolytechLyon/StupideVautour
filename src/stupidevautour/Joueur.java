/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stupidevautour;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Bertrand
 */
public abstract class Joueur {
    protected int numero;
    protected Plateau plateau;
    protected Color couleur;
    protected ArrayList<CarteEffet> cartesEffet;
    protected ArrayList<CarteNumero> cartesJeu;
    
    public Joueur(int numero,Color couleur, ArrayList<CarteNumero> cartesJeu, Plateau plateau)
    {
        this.numero = numero;
        this.plateau = plateau;
        this.couleur= couleur;
        this.cartesJeu = cartesJeu;
        cartesEffet = new ArrayList();
    }
    
    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param plateau the plateau to set
     */
    public void setPlateau(Plateau plateau) {
        this.plateau = plateau;
    }   

    /**
     * @return the cartesEffet
     */
    public ArrayList<CarteEffet> getCartesEffet() {
        return cartesEffet;
    }

    /**
     * @return the cartesJeu
     */
    public ArrayList<CarteNumero> getCartesJeu() {
        return cartesJeu;
    }
    
    public void setCartesJeu(ArrayList<CarteNumero> cartesJeu) {
        this.cartesJeu=cartesJeu;
    }
    
    public abstract TourJoueur jeu() throws IOException;
    
    public void ramasserCarte(CarteEffet carte){
       cartesEffet.add(carte);
    }

    public int getScore() {
        int res = 0;
        for(CarteEffet carte : cartesEffet)
        {
            res += carte.getValEffet();
        }
        
        return res;
    }
}
