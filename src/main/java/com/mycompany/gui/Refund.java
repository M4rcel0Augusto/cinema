/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.gui;

import com.mycompany.model.RefundService;
import com.mycompany.persistence.ItemSale;
import javax.swing.JOptionPane;
/*
Falha: Ver ReportDAO
*/

public class Refund extends javax.swing.JFrame {

    private History parent;

    public Refund(History parent) {
        this.parent= parent;
        initComponents();
    }

    
    
    
    
    
    
        
    private ItemSale itemRefund = null;  
    public void fillItem(ItemSale item){
        jLRefund.setText("Reembolsar: "+ item.getProduct().getProductName());
        itemRefund= item;
        }
    
        
        
        
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTFQuantity = new javax.swing.JTextField();
        jLRefund = new javax.swing.JLabel();
        jBExecute = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Quantidade:");

        jLRefund.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLRefund.setText("Reembolsar: ");

        jBExecute.setText("Ir");
        jBExecute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBExecuteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLRefund, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTFQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBExecute)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLRefund)
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTFQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                .addComponent(jBExecute)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBExecuteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExecuteActionPerformed
        if(jTFQuantity.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Defina uma quantifade");
            return;
        }
try {
        int quantity = Integer.parseInt(jTFQuantity.getText());

        RefundService service = new RefundService();
        service.refundItem(itemRefund.getId(), quantity);

        JOptionPane.showMessageDialog(this, "Reembolso realizado com sucesso");

        parent.loadTable(); 
        dispose();          

    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "Quantidade inválida");

    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, ex.getMessage());
    }
    }//GEN-LAST:event_jBExecuteActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBExecute;
    private javax.swing.JLabel jLRefund;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTFQuantity;
    // End of variables declaration//GEN-END:variables
}
