/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stupidevautour;

import java.awt.Color;

/**
 *
 * @author Bertrand
 */
public class CarteNumero {
    private int valeur;
    private Color couleur;
    
    public CarteNumero(int valeur, Color couleur)
    {
        this.valeur = valeur;
        this.couleur = couleur;
    }
    
    /**
     * @return the valeur
     */
    public int getValeur() {
        return valeur;
    }
    
    /**
     * @return the couleur
     */
    public Color getCouleur() {
        return couleur;
    }

    /**
     * @param couleur the couleur to set
     */
    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }
    
    
}
