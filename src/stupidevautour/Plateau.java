/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stupidevautour;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Bertrand
 */
public class Plateau {
    private ArrayList<Joueur> joueurs;
    private ArrayList<TourJoueur> historique;
    private ArrayList<CarteEffet> pileCartes;
    
    public Plateau(int nbJoueurs, int nbIA, int nivIA) throws Exception
    {
        if((nbJoueurs + nbIA)<2 || (nbJoueurs + nbIA)>5)
        {
            throw new Exception("Le nombre de joueurs doit être compris entre 2 et 5");
        }
        
        
        ArrayList<Color> couleurs = new ArrayList();
        couleurs.add(Color.blue);
        couleurs.add(Color.red);
        couleurs.add(Color.pink);
        couleurs.add(Color.orange);
        couleurs.add(Color.magenta);
        
        
        for(int i=0; i<nbJoueurs; i++)
        {
            ArrayList<CarteNumero> cartesJeu = new ArrayList();
            for(int j=0; j<15; j++)
            {
                cartesJeu.add(new CarteNumero(j, couleurs.get(i)));
            }
            joueurs.add(new JoueurReel(i+1, cartesJeu, this));
        }
        
        for(int i=nbJoueurs; i<(nbIA+nbJoueurs); i++)
        {
            ArrayList<CarteNumero> cartesJeu = new ArrayList();
            for(int j=0; j<15; j++)
            {
                cartesJeu.add(new CarteNumero(j, couleurs.get(i)));
            }
            switch (nivIA)
            {
                case 0:
                    joueurs.add(new IAFacile(i+1, cartesJeu, this));
                    break;
                case 1:
                    joueurs.add(new IAMoyenne(i+1, cartesJeu, this));
                    break;
                case 2:
                    joueurs.add(new IADifficile(i+1, cartesJeu, this));
                    break;
            }
            
        }
    }
    
    
}
