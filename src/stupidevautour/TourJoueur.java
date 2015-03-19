/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stupidevautour;

/**
 *
 * @author Bertrand
 */
public class TourJoueur {
    private int numJoueur;
    private int numCarteJouee;
    
    public TourJoueur(int numJoueur, int numCarteJouee)
    {
        this.numJoueur = numJoueur;
        this.numCarteJouee = numCarteJouee;
    }

    /**
     * @return the numJoueur
     */
    public int getNumJoueur() {
        return numJoueur;
    }

    /**
     * @return the numCarteJouee
     */
    public int getNumCarteJouee() {
        return numCarteJouee;
    }
}
