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
public class Plateau {
    private ArrayList<Joueur> joueurs;
    private ArrayList<TourJoueur> historique;
    private ArrayList<CarteEffet> pileCartes;
    
    public Plateau(int nbJoueurs, int nbIA, int nivIA) throws Exception
    {
        historique = new ArrayList();
        joueurs = new ArrayList();
        
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
        randomPileCartes();
    }
    
    private void randomPileCartes()
    {
        pileCartes = new ArrayList();
        for(int i=1; i<=10; i++)
        {
            pileCartes.add(new CarteEffet(i, TypeCarte.Souris));
        }
        for(int i=-5; i<=-1; i++)
        {
            pileCartes.add(new CarteEffet(i, TypeCarte.Vautour));
        }
    }
  
    public boolean jouerUnTour()
    {
        if(pileCartes.isEmpty())
        {
            return false;
        }

        ArrayList<TourJoueur> tourActuel = new ArrayList();
        for (Joueur joueur : joueurs) {
            tourActuel.add(joueur.jeu());
        }
        System.out.println("Fin du tour !");
        
        CarteEffet carteTour = pileCartes.remove(0);
        if(carteTour.getTypeCarte().equals(TypeCarte.Souris))
        {
            joueurs.get(joueurGagnantTour(tourActuel)).ramasserCarte(carteTour);
        }
        else
        {
            joueurs.get(joueurPerdantTour(tourActuel)).ramasserCarte(carteTour);
        }
        
        for (TourJoueur tour : tourActuel)
        {
            historique.add(tour);
        }
        return true;
    }

    private int joueurGagnantTour(ArrayList<TourJoueur> tourActuel) {
        ArrayList<TourJoueur> tourCartesValides = new ArrayList();
        for(TourJoueur tour : tourActuel) //recopie
        {
            tourCartesValides.add(tour);
        }
        boolean continuer = true;
        int max=0, numJoueurMax = 0;
        while(continuer)
        {
            max = 0; numJoueurMax = 0;
            continuer = false;
            for(int i=0; i<tourCartesValides.size(); i++)
            {
                if(tourCartesValides.get(i).getNumCarteJouee()==max)
                {
                    tourCartesValides.remove(i);
                    tourCartesValides.remove(new TourJoueur(numJoueurMax, max));
                    continuer = true;
                    break;
                }
                if(tourCartesValides.get(i).getNumCarteJouee()>max)
                {
                    max = tourCartesValides.get(i).getNumCarteJouee();
                    numJoueurMax = tourCartesValides.get(i).getNumJoueur();
                }
                
            }
        }
        return numJoueurMax;
    }

    private int joueurPerdantTour(ArrayList<TourJoueur> tourActuel) {
        ArrayList<TourJoueur> tourCartesValides = new ArrayList();
        for(TourJoueur tour : tourActuel) //recopie
        {
            tourCartesValides.add(tour);
        }
        boolean continuer = true;
        int min=16, numJoueurMax = 0;
        while(continuer)
        {
            min = 16; numJoueurMax = 0;
            continuer = false;
            for(int i=0; i<tourCartesValides.size(); i++)
            {
                if(tourCartesValides.get(i).getNumCarteJouee()==min)
                {
                    tourCartesValides.remove(i);
                    tourCartesValides.remove(new TourJoueur(numJoueurMax, min));
                    continuer = true;
                    break;
                }
                if(tourCartesValides.get(i).getNumCarteJouee()<min)
                {
                    min = tourCartesValides.get(i).getNumCarteJouee();
                    numJoueurMax = tourCartesValides.get(i).getNumJoueur();
                }
                
            }
        }
        return numJoueurMax;
    }
}
