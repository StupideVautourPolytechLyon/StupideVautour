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
public class IADifficile extends Joueur{

    public IADifficile(int numero, Color couleur, ArrayList<CarteNumero> cartesJeu, Plateau plateau) {
        super(numero, couleur, cartesJeu, plateau);
    }

    @Override
    public TourJoueur jeu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
