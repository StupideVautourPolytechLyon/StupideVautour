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
        boolean continuer = true;
        while(continuer){
            int carteJouee=Math.random();
            if (cartesJeu.contains(new CarteNumero(carteJouee,couleur))){
                cartesJeu.remove(new CarteNumero(carteJouee,couleur));
                return new TourJoueur(numero,carteJouee);
            }
            else System.out.print("Cette carte n'est pas dans votre jeu.");
        }
       return new TourJoueur(numero,0);
    }
    
}
