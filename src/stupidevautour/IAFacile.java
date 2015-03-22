/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stupidevautour;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import static java.lang.Math.random;
import java.util.ArrayList;

/**
 *
 * @author Bertrand
 */
public class IAFacile extends Joueur {

    public IAFacile(int numero, Color couleur, ArrayList<CarteNumero> cartesJeu, Plateau plateau) {
        super(numero, couleur, cartesJeu, plateau);
    }
    
    @Override
    public TourJoueur jeu(){
            int carteJouee=(int) Math.round((Math.random()*cartesJeu.size()-1));
            TourJoueur tour_envoye = new TourJoueur(numero,cartesJeu.get(carteJouee).getValeur());
            cartesJeu.remove(new CarteNumero(carteJouee,couleur));
            return tour_envoye;
    }
    
}
