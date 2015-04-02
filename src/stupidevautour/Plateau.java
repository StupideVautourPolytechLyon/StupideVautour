/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stupidevautour;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Bertrand
 */
public class Plateau {
    public ArrayList<Joueur> joueurs;
    private ArrayList<TourJoueur> historique;
    private ArrayList<CarteEffet> pileCartes;
    private FenetrePrincipale fen;
    
    public ArrayList<TourJoueur> tourActuel;
    
    public Plateau(FenetrePrincipale fen, int nbJoueurs, int nbIA, int nivIA) throws Exception
    {
        this.fen = fen;
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
            for(int j=1; j<16; j++)
            {
                cartesJeu.add(new CarteNumero(j, couleurs.get(i)));
            }
            joueurs.add(new JoueurReel(i+1, couleurs.get(i), cartesJeu, this));
        }
        
        for(int i=nbJoueurs; i<(nbIA+nbJoueurs); i++)
        {
            ArrayList<CarteNumero> cartesJeu = new ArrayList();
            for(int j=1; j<16; j++)
            {
                cartesJeu.add(new CarteNumero(j, couleurs.get(i)));
            }
            switch (nivIA)
            {
                case 0:
                    joueurs.add(new IAFacile(i+1, couleurs.get(i), cartesJeu, this));
                    break;
                case 1:
                    joueurs.add(new IAMoyenne(i+1, couleurs.get(i), cartesJeu, this));
                    break;
                case 2:
                    joueurs.add(new IADifficile(i+1, couleurs.get(i), cartesJeu, this));
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
        Collections.shuffle(pileCartes);
         
    }
  
    public boolean jouerUnTour() throws IOException, InterruptedException
    {
        if(joueurs.get(0).getCartesJeu().isEmpty())    //Fin du jeu : affichage de scores
        {
            String res = "\nFin de la partie !\nClassement des joueurs :";
            System.out.println("\nFin de la partie !\nClassement des joueurs :");
            int max=0; int numJoueurMax=0; ArrayList<Joueur> joueurs2 = joueurs;
            while (!joueurs2.isEmpty()){
                max=joueurs.get(0).getScore(); numJoueurMax=0;
                for (int i=0;i<joueurs.size();i++){
                    if (joueurs.get(i).getScore()>max){
                        max=joueurs.get(i).getScore();
                        numJoueurMax=i;
                    }
                }
                res += "Le joueur n°"+joueurs.get(numJoueurMax).getNumero()+" a "+max+" points.";
                System.out.println("Le joueur n°"+joueurs.get(numJoueurMax).getNumero()+" a "+max+" points.");
                joueurs2.remove(numJoueurMax);
            }
            fen.recapTour = res;
            return false;
        }
        
        
        
        
        System.out.println();
        CarteEffet carteTour = pileCartes.get(0);
        System.out.println("La carte tirée est une carte "+carteTour.getTypeCarte().toString()+" "+carteTour.getValEffet());
        fen.carteTiree = "La carte tirée est une carte "+carteTour.getTypeCarte().toString()+" "+carteTour.getValEffet();
        
        tourActuel = new ArrayList();
        for (Joueur joueur : joueurs) {
            if(joueur instanceof JoueurReel)
            {
                TourJoueurReel tjr = new TourJoueurReel(fen, joueur);
                fen.setContentPane(tjr);
                tjr.revalidate();
                tjr.repaint();
                while (tjr.choixJoueur == -1);
            }
            else
            {
                TourIA tia = new TourIA(fen, joueur);
                fen.setContentPane(tia);
                tia.revalidate();
                tia.repaint();
                while(tia.choixJoueur == -1);
                tourActuel.add(new TourJoueur(tia.joueur.getNumero(), tia.choixJoueur));
            }
            //tourActuel.add(joueur.jeu(carteTour));
        }
        System.out.println("Fin du tour !");
        System.out.println();
        
        
        
        String finTour = "";
        for(TourJoueur tour : tourActuel)
        {
            finTour += "Le joueur n°"+tour.getNumJoueur()+" a joué sa carte n°"+tour.getNumCarteJouee();
            System.out.println("Le joueur n°"+tour.getNumJoueur()+" a joué sa carte n°"+tour.getNumCarteJouee());
        }
        
        
        if(carteTour.getTypeCarte().equals(TypeCarte.Souris))
        {
            int joueurGagnantTour = joueurGagnantTour(tourActuel);
            if (joueurGagnantTour==-1){     //Egalite entre tous les joueurs
                System.out.println("Egalite entre tous les joueurs ! On recommence le tour.");
                finTour += "Egalite entre tous les joueurs ! On recommence le tour.";
                return jouerUnTour();
            }
            joueurs.get(joueurGagnantTour-1).ramasserCarte(carteTour);
            System.out.println("Le joueur ramassant la carte souris de ce tour est le joueur n°"+joueurGagnantTour+".");
            finTour += "Le joueur ramassant la carte souris de ce tour est le joueur n°"+joueurGagnantTour+".";
        }
        else
        {
            int joueurPerdantTour = joueurPerdantTour(tourActuel);
            if (joueurPerdantTour==-1){     //Egalite entre tous les joueurs
                System.out.println("Egalite entre tous les joueurs ! On recommence le tour.");
                finTour += "Egalite entre tous les joueurs ! On recommence le tour.";
                return jouerUnTour();
            }
            joueurs.get(joueurPerdantTour-1).ramasserCarte(carteTour);
            System.out.println("Le joueur ramassant la carte vautour de ce tour est le joueur n°"+joueurPerdantTour+".");
            finTour += "Le joueur ramassant la carte vautour de ce tour est le joueur n°"+joueurPerdantTour+".";
        }
        
        for (TourJoueur tour : tourActuel)
        {
            historique.add(tour);
        }
        pileCartes.remove(0);
        
        System.out.println();
        System.out.println("Récapitulatif des scores :");
        finTour += "Récapitulatif des scores :";
        for(Joueur j : joueurs)
        {
            System.out.println("Le joueur n°"+j.getNumero()+" a "+j.getScore()+" points.");
            finTour += "Le joueur n°"+j.getNumero()+" a "+j.getScore()+" points.";
        }
        fen.recapTour = finTour;
        RecapTour rec = new RecapTour(finTour);
        fen.setContentPane(rec);
        rec.revalidate();
        rec.repaint();
        return true;
    }

    private int joueurGagnantTour(ArrayList<TourJoueur> tourActuel) {
        ArrayList<TourJoueur> tourCartesValides = new ArrayList();
        for(TourJoueur tour : tourActuel) //recopie
        {
            tourCartesValides.add(tour);
        }
        boolean continuer = true; boolean egalite = false;
        int max=0, numJoueurMax = 0; int numTourMax=0;
        while(continuer)
        {
            max = 0; numJoueurMax = 0;
            continuer = false;
            for(int i=0; i<tourCartesValides.size(); i++)
            {
                if(tourCartesValides.get(i).getNumCarteJouee()==max)
                {
                    egalite=true;  //On signale l'egalite pour pouvoir supprimer le tour du joueur max
                    tourCartesValides.remove(i);
                    continuer = true;
                    break;
                }
                if(tourCartesValides.get(i).getNumCarteJouee()>max)
                {
                    max = tourCartesValides.get(i).getNumCarteJouee();
                    numJoueurMax = tourCartesValides.get(i).getNumJoueur();
                    numTourMax=i;
                }
            }
            
            if (egalite){   //Suppression du tour du joueur max
                    tourCartesValides.remove(numTourMax);
                    continuer = true;
                    break;
            }
        }
        if (tourCartesValides.isEmpty()) return -1;
        return numJoueurMax;
    }

    private int joueurPerdantTour(ArrayList<TourJoueur> tourActuel) {
        ArrayList<TourJoueur> tourCartesValides = new ArrayList();
        for(TourJoueur tour : tourActuel) //recopie
        {
            tourCartesValides.add(tour);
        }
        boolean continuer = true; boolean egalite=false;
        int min=16, numJoueurMax = 0; int numTourMin=0;
        while(continuer)
        {
            min = 16; numJoueurMax = 0;
            continuer = false;
            for(int i=0; i<tourCartesValides.size(); i++)
            {
                if(tourCartesValides.get(i).getNumCarteJouee()==min)
                {
                    egalite=true;  //On signale l'egalite pour pouvoir supprimer le tour du joueur max
                    tourCartesValides.remove(i);
                    continuer = true;
                    break;
                }
                if(tourCartesValides.get(i).getNumCarteJouee()<min)
                {
                    min = tourCartesValides.get(i).getNumCarteJouee();
                    numJoueurMax = tourCartesValides.get(i).getNumJoueur();
                    numTourMin=i;
                }
            }
            if (egalite){   //Suppression du tour du joueur max
                    tourCartesValides.remove(numTourMin);
                    continuer = true;
                    break;
            }
        }
        if (tourCartesValides.isEmpty()) return -1;
        return numJoueurMax;
    }
    
    
}
