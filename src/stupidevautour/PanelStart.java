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
public class PanelStart extends javax.swing.JPanel {
    FenetrePrincipale fen;
    
    /**
     * Creates new form PanelStart
     */
    public PanelStart(FenetrePrincipale fen) {
        initComponents();
        this.fen = fen;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titre = new javax.swing.JLabel();
        buttonJouer = new javax.swing.JButton();
        buttonQuitter = new javax.swing.JButton();

        setBackground(new java.awt.Color(51, 102, 0));

        titre.setBackground(new java.awt.Color(255, 255, 255));
        titre.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        titre.setForeground(new java.awt.Color(255, 255, 255));
        titre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titre.setText("Stupide Vautour !");

        buttonJouer.setBackground(new java.awt.Color(51, 102, 0));
        buttonJouer.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        buttonJouer.setText("Nouveau jeu !");
        buttonJouer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonJouerActionPerformed(evt);
            }
        });

        buttonQuitter.setBackground(new java.awt.Color(51, 102, 0));
        buttonQuitter.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        buttonQuitter.setText("Quitter");
        buttonQuitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonQuitterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonQuitter, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonJouer, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(343, 343, 343))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(titre, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(324, 324, 324))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(titre)
                .addGap(121, 121, 121)
                .addComponent(buttonJouer, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonQuitter, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(165, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonQuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonQuitterActionPerformed
        System.exit(0);
    }//GEN-LAST:event_buttonQuitterActionPerformed

    private void buttonJouerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonJouerActionPerformed
        PanelAvtPartie pan = new PanelAvtPartie(fen);
        fen.setContentPane(pan);
        pan.revalidate(); 
        pan.repaint();
    }//GEN-LAST:event_buttonJouerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonJouer;
    private javax.swing.JButton buttonQuitter;
    private javax.swing.JLabel titre;
    // End of variables declaration//GEN-END:variables
}
