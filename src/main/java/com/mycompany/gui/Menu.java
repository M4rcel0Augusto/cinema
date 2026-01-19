/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.gui;

/**
 *
 * @author conve
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
    }
    private String access;
    public void validateAccess(String permission){
        this.access = permission;
        if("user".equals(access)){
            // jBCart true
           //jBHistory true
           jBMovie.setVisible(false);
           jBScreening.setVisible(false);
           jBProduct.setVisible(false);
           jBCombo.setVisible(false);
           jBSearch.setVisible(false);
        
        }
    
    
    }
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jBCart = new javax.swing.JButton();
        jBMovie = new javax.swing.JButton();
        jBScreening = new javax.swing.JButton();
        jBProduct = new javax.swing.JButton();
        jBCombo = new javax.swing.JButton();
        jBHistory = new javax.swing.JButton();
        jBSearch = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jBExit = new javax.swing.JButton();
        jBUsser = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Menu");

        jBCart.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jBCart.setText("Carrinho");
        jBCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCartActionPerformed(evt);
            }
        });

        jBMovie.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jBMovie.setText("Filme");
        jBMovie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBMovieActionPerformed(evt);
            }
        });

        jBScreening.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jBScreening.setText("Sessão");
        jBScreening.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBScreeningActionPerformed(evt);
            }
        });

        jBProduct.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jBProduct.setText("Produto");
        jBProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBProductActionPerformed(evt);
            }
        });

        jBCombo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jBCombo.setText("Combo");
        jBCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBComboActionPerformed(evt);
            }
        });

        jBHistory.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jBHistory.setText("Histórico");
        jBHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBHistoryActionPerformed(evt);
            }
        });

        jBSearch.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jBSearch.setText("Pesquisa");
        jBSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(175, 175, 175))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBCart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBHistory, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(jBMovie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBScreening, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBCombo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(133, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jBSearch)
                .addGap(18, 18, 18)
                .addComponent(jBCart)
                .addGap(18, 18, 18)
                .addComponent(jBHistory)
                .addGap(18, 18, 18)
                .addComponent(jBMovie, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBScreening)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBProduct)
                .addGap(18, 18, 18)
                .addComponent(jBCombo)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jBExit.setText("Sair");
        jBExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBExitActionPerformed(evt);
            }
        });

        jBUsser.setText("Mudar Usuário");
        jBUsser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBUsserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBExit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBUsser)
                .addGap(14, 14, 14))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBExit)
                    .addComponent(jBUsser))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCartActionPerformed
        Sale sale = new Sale();
        sale.setVisible(true);
    }//GEN-LAST:event_jBCartActionPerformed

    private void jBMovieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBMovieActionPerformed
        //Criar MovieMain
        MovieRegistration movie = new MovieRegistration();
        movie.setVisible(true);
    }//GEN-LAST:event_jBMovieActionPerformed

    private void jBScreeningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBScreeningActionPerformed
        ScreeningMain screening = new ScreeningMain();
        screening.setVisible(true);
    }//GEN-LAST:event_jBScreeningActionPerformed

    private void jBProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBProductActionPerformed
        ProductMain product = new ProductMain();
        product.setVisible(true);
    }//GEN-LAST:event_jBProductActionPerformed

    private void jBComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBComboActionPerformed
        ComboMain combo = new ComboMain();
        combo.setVisible(true);
    }//GEN-LAST:event_jBComboActionPerformed

    private void jBHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBHistoryActionPerformed
        History history = new History();
        history.setVisible(true);
    }//GEN-LAST:event_jBHistoryActionPerformed

    private void jBSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSearchActionPerformed
        Search search = new Search();
        search.setVisible(true);
    }//GEN-LAST:event_jBSearchActionPerformed

    private void jBUsserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBUsserActionPerformed
        Login login = new Login();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_jBUsserActionPerformed

    private void jBExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jBExitActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBCart;
    private javax.swing.JButton jBCombo;
    private javax.swing.JButton jBExit;
    private javax.swing.JButton jBHistory;
    private javax.swing.JButton jBMovie;
    private javax.swing.JButton jBProduct;
    private javax.swing.JButton jBScreening;
    private javax.swing.JButton jBSearch;
    private javax.swing.JButton jBUsser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
