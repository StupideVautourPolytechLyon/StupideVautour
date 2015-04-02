/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stupidevautour;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SpinnerListModel;

/**
 *
 * @author Bertrand
 */
public class PanelAvtPartie extends javax.swing.JPanel {
    FenetrePrincipale fen;
    SpinnerListModel nbIAmodel;
    SpinnerListModel nbJoueursmodel;
    SpinnerListModel nivIAmodel;
    boolean equilibreEnCours = false;
    
    
    /**
     * Creates new form PanelAvtPartie
     * @param fen
     */
    public PanelAvtPartie(FenetrePrincipale fen) {
        initComponents();
        this.fen = fen;
        initialiser();
    }
    
    private void initialiser()
    {
        String[] nivIAStrings = new String[3];
        nivIAStrings[0] = "Facile";
        nivIAStrings[1] = "Moyenne";
        nivIAStrings[2] = "Difficile";
        nivIAmodel = new SpinnerListModel(nivIAStrings);
        diffIA.setModel(nivIAmodel);
        
        String[] nbJoueursStrings = new String[6];
        for(int i=0; i<6; i++)
            nbJoueursStrings[i] = Integer.toString(i);
        nbJoueursmodel = new SpinnerListModel(nbJoueursStrings);
        nbIAmodel = new SpinnerListModel(nbJoueursStrings);
        nbJoueurs.setModel(nbJoueursmodel);
        nbIA.setModel(nbIAmodel);
    }
    
    private void equilibrerSpinners(String type)
    {
        if(Integer.parseInt(nbIA.getModel().getValue().toString()) + 
                Integer.parseInt(nbJoueurs.getModel().getValue().toString())<=5)
            return;
        equilibreEnCours = true;
        if(type.equals("ia"))
        {
            nbJoueurs.setValue(nbJoueursmodel.getList().get(5-Integer.parseInt(nbIA.getModel().getValue().toString())));
        }
        else
        {
            nbIA.setValue(nbIAmodel.getList().get(5-Integer.parseInt(nbJoueurs.getModel().getValue().toString())));
        }
        equilibreEnCours = false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titreLab = new javax.swing.JLabel();
        buttonLancer = new javax.swing.JButton();
        nbJoueurs = new javax.swing.JSpinner();
        labNbJoueurs = new javax.swing.JLabel();
        nbIA = new javax.swing.JSpinner();
        labNbIa = new javax.swing.JLabel();
        diffIA = new javax.swing.JSpinner();
        labDiff = new javax.swing.JLabel();
        buttonRetour = new javax.swing.JButton();

        setBackground(new java.awt.Color(51, 102, 0));

        titreLab.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        titreLab.setForeground(new java.awt.Color(255, 255, 255));
        titreLab.setText("Créer une nouvelle partie");

        buttonLancer.setBackground(new java.awt.Color(51, 102, 0));
        buttonLancer.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        buttonLancer.setText("Lancer la partie !");
        buttonLancer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLancerActionPerformed(evt);
            }
        });

        nbJoueurs.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        nbJoueurs.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                nbJoueursStateChanged(evt);
            }
        });

        labNbJoueurs.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labNbJoueurs.setForeground(new java.awt.Color(255, 255, 255));
        labNbJoueurs.setText("Nombre de joueurs (sans IA) :");

        nbIA.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        nbIA.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                nbIAStateChanged(evt);
            }
        });

        labNbIa.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labNbIa.setForeground(new java.awt.Color(255, 255, 255));
        labNbIa.setText("Nombre d'IA :");

        diffIA.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        labDiff.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labDiff.setForeground(new java.awt.Color(255, 255, 255));
        labDiff.setText("Difficulté des IA :");

        buttonRetour.setBackground(new java.awt.Color(51, 102, 0));
        buttonRetour.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        buttonRetour.setText("Retour");
        buttonRetour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRetourActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(titreLab))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(buttonLancer)
                                .addGap(18, 18, 18)
                                .addComponent(buttonRetour))
                            .addComponent(labDiff)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labNbIa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nbIA, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labNbJoueurs)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nbJoueurs, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(diffIA, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(titreLab)
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nbJoueurs, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(labNbJoueurs)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nbIA, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(labNbIa)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(diffIA, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labDiff))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonLancer)
                    .addComponent(buttonRetour))
                .addContainerGap(84, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nbJoueursStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_nbJoueursStateChanged
        if(!equilibreEnCours)
        {
            equilibrerSpinners("joueurs");
        }
    }//GEN-LAST:event_nbJoueursStateChanged

    private void nbIAStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_nbIAStateChanged
        if(Integer.parseInt(nbIA.getModel().getValue().toString()) == 0)
        {
            labDiff.setVisible(false);
            diffIA.setVisible(false);
        }
        else
        {
            labDiff.setVisible(true);
            diffIA.setVisible(true);
        }
        if(!equilibreEnCours)
        {
            equilibrerSpinners("ia");
        }
    }//GEN-LAST:event_nbIAStateChanged

    private void buttonRetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRetourActionPerformed
        PanelStart pan = new PanelStart(fen);
        fen.setContentPane(pan);
        pan.revalidate(); 
        pan.repaint();
    }//GEN-LAST:event_buttonRetourActionPerformed

    private void buttonLancerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLancerActionPerformed
        int diffIA = 0;
        switch(nbJoueurs.getModel().getValue().toString())
        {
            case "Facile" : diffIA = 0; break;
            case "Moyenne" : diffIA = 1; break;
            case "Difficile" : diffIA = 2; break;
        }
        Plateau p = null;
        try {
            p = new Plateau(fen, Integer.parseInt(nbJoueurs.getModel().getValue().toString()), Integer.parseInt(nbIA.getModel().getValue().toString()), diffIA);
        } catch (Exception ex) {
            Logger.getLogger(PanelAvtPartie.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(p != null)
        {
            try {
                while(p.jouerUnTour());
            } catch (IOException ex) {
                Logger.getLogger(PanelAvtPartie.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }//GEN-LAST:event_buttonLancerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonLancer;
    private javax.swing.JButton buttonRetour;
    private javax.swing.JSpinner diffIA;
    private javax.swing.JLabel labDiff;
    private javax.swing.JLabel labNbIa;
    private javax.swing.JLabel labNbJoueurs;
    private javax.swing.JSpinner nbIA;
    private javax.swing.JSpinner nbJoueurs;
    private javax.swing.JLabel titreLab;
    // End of variables declaration//GEN-END:variables
}
