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
public class StupideVautour {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        //Plateau jeu = new Plateau(1, 1, 0);
        FenetrePrincipale fp = new FenetrePrincipale();
        //fp.setContentPane(new PanelStart(fp));
        fp.setContentPane(new PanelStart(fp));
        fp.setVisible(true);
        
        /*while(jeu.jouerUnTour())
        {
            
        }
        */
    }
    
}
