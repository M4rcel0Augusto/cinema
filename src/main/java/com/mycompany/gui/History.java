/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.gui;

import com.mycompany.persistence.ItemSale;
import com.mycompany.persistence.ItemSaleDAO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * 
 */
public class History extends javax.swing.JFrame {

    /**
     * Creates new form HIstory
     */
    public History() {
        initComponents();
        loadTable();
    }
    
    public void loadTable(){
        ItemSaleDAO itemSaleDAO = new ItemSaleDAO();
        List<ItemSale> items = itemSaleDAO.list();
        fillTable(items);
        
    }
   
    
    private void fillTable(List<ItemSale> items){
        
        String columns[] = {"Id Sale", "Id ItemSale", "Combo", "Produto", "Qt", "Reembolso","Preço Un", "Subtotal", "Sessão"};
        String data[][] = new String[items.size()][columns.length];
        
        int i =0;
        for(ItemSale is: items){
            //Caso combo seja null
            String name;
            if(is.getCombo()!=null){
                name=is.getCombo().getName();
            
            }else{
            name ="-";
            }
            

            data[i] = new String[]{
            String.valueOf(is.getSale().getId()),
                String.valueOf(is.getId()),
            name,
            String.valueOf(is.getProduct().getProductName()),
            String.valueOf(is.getQuantity()),
            String.valueOf(is.getRefundQuantity()),
            String.valueOf(is.getUnitPrice()),
            String.valueOf(is.getSale().getTotalAmount()),
            String.valueOf(is.getSale().getScreening().getId())
                
            
            };
            i++;
        
        }
         DefaultTableModel model = new DefaultTableModel(data,columns);
         jTHistory.setModel(model);
    
    
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTHistory = new javax.swing.JTable();
        jBRefund = new javax.swing.JButton();
        jBReturn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Histórico de Venda");

        jTHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTHistory);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(274, 274, 274)
                .addComponent(jLabel1)
                .addContainerGap(275, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jBRefund.setText("Reembolsar");
        jBRefund.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRefundActionPerformed(evt);
            }
        });

        jBReturn.setText("Voltar");
        jBReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBReturnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBReturn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBRefund)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBRefund)
                    .addComponent(jBReturn))
                .addGap(0, 14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBRefundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRefundActionPerformed
        if(jTHistory.getSelectedRow()<0){
                JOptionPane.showMessageDialog(this, "Selecione o item que deseja reembolsar.");
                return;
        }
        try{
            String name = (String) jTHistory.getValueAt(jTHistory.getSelectedRow(), 3);//nome
            int response =JOptionPane.showConfirmDialog(this, "Tem certeza que deseja reembolsar o item\n"+name+"?");
            if(response !=0){
                return;
            }
            Refund refund = new Refund(this);
            String id = (String) jTHistory.getValueAt(jTHistory.getSelectedRow(), 1);//Id item sale
            ItemSaleDAO itemSaleDAO = new ItemSaleDAO();
            
            ItemSale selectedItem = itemSaleDAO.select(Integer.parseInt(id));
            
            refund.fillItem(selectedItem);
            refund.setLocationRelativeTo(this);
            refund.setVisible(true);
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Erro.");
        }
        
    }//GEN-LAST:event_jBRefundActionPerformed

    private void jBReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBReturnActionPerformed
        dispose();
    }//GEN-LAST:event_jBReturnActionPerformed

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
            java.util.logging.Logger.getLogger(History.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(History.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(History.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(History.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new History().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBRefund;
    private javax.swing.JButton jBReturn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTHistory;
    // End of variables declaration//GEN-END:variables
}
