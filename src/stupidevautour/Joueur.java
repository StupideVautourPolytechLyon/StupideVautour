/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stupidevautour;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author Bertrand
 */
public class Joueur {
    private int numero;
    private Plateau plateau;
    private ArrayList<CarteEffet> cartesEffet;
    private ArrayList<CarteNumero> cartesJeu;
    
    public Joueur(int numero, ArrayList<CarteNumero> cartesJeu)
    {
        this.numero = numero;
        this.cartesJeu = cartesJeu;
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
}
