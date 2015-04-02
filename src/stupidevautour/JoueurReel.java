/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package stupidevautour;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author Bertrand
 */
public class JoueurReel extends Joueur{

    public JoueurReel(int numero, Color couleur, ArrayList<CarteNumero> cartesJeu, Plateau plateau) {
        super(numero, couleur, cartesJeu, plateau);
    }

    @Override
    public TourJoueur jeu() throws IOException{
        
        System.out.println("Voici la liste de vos cartes : ");
        for (CarteNumero cartesJeu1 : cartesJeu) {
            System.out.print(" " + cartesJeu1.getValeur() + " ");
        }
        boolean continuer = true;
        while(continuer){
            int carteJouee = 1;
            BufferedReader entree = new BufferedReader(new InputStreamReader(System.in));
            boolean entreeJuste = true;
            while(entreeJuste)
            {
                entreeJuste = false;
                try {
                    System.out.println("\n Choisissez une carte à jouer pour ce tour :");
                    carteJouee = Integer.parseInt(entree.readLine());
                }catch(Exception e){
                    System.out.println("Attention : il faut rentrer un chiffre.");
                    entreeJuste = true;
                }
            }
            
            int posCarteExiste = -1;
            for(int i=0; i<cartesJeu.size(); i++)
            {
                if(cartesJeu.get(i).getValeur() == carteJouee)
                {
                    posCarteExiste = i;
                }
            }
            
            if (posCarteExiste != -1){
                cartesJeu.remove(posCarteExiste);
                return new TourJoueur(numero,carteJouee);
            }
            else System.out.print("Cette carte n'est pas dans votre jeu.");
        } 
       return new TourJoueur(numero,0);
    }
}