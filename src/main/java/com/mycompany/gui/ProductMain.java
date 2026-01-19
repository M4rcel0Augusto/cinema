package com.mycompany.gui;

import com.mycompany.persistence.Product;
import com.mycompany.persistence.ProductDAO;
import com.mycompany.persistence.ProductStockAlert;
import com.mycompany.persistence.ProductStockAlertDAO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author conve
 */
public class ProductMain extends javax.swing.JFrame {

    /**
     * Creates new form ProductMain
     */
    public ProductMain() {
        initComponents();
        loadTable();
    }

        //Criar filtro por type
    public void loadTable(){
    
        ProductDAO productDAO = new ProductDAO();
        List<Product> products = productDAO.list();
        fillTable(products);
        
    }
    
    
    private void fillTable(List<Product> products){
    
        String columns[] ={ "Id", "Nome","Tipo", "Tamanho","Qt em estoque", "Preço un", "Custo un"};
        String data[][] = new String[products.size()][columns.length];
        
        int i = 0;
        
        for(Product p : products){
            data[i] = new String[]{
            String.valueOf(p.getId()),
            p.getProductName(),
            String.valueOf(p.getProductType()),
            p.getSize(),
            String.valueOf(p.getQuantityInStock()),
            String.valueOf(p.getUnitPrice()),
            String.valueOf(p.getUnitCost())
        
        };
        i++;
        
        }
        
        DefaultTableModel model = new DefaultTableModel(data,columns);
        jTProduct.setModel(model);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTProduct = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jBDelete = new javax.swing.JButton();
        jBUpdate = new javax.swing.JButton();
        jBRegistration = new javax.swing.JButton();
        jBAlddAlert = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Produtos");

        jTProduct.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTProduct);

        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jBDelete.setText("Excluir");
        jBDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDeleteActionPerformed(evt);
            }
        });

        jBUpdate.setText("Editar");
        jBUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBUpdateActionPerformed(evt);
            }
        });

        jBRegistration.setText("Cadastrar");
        jBRegistration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRegistrationActionPerformed(evt);
            }
        });

        jBAlddAlert.setText("Adicionar alerta");
        jBAlddAlert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAlddAlertActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(232, 232, 232)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBDelete)
                        .addGap(18, 18, 18)
                        .addComponent(jBUpdate)
                        .addGap(18, 18, 18)
                        .addComponent(jBRegistration)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jBAlddAlert)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addComponent(jBAlddAlert)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jBDelete)
                    .addComponent(jBRegistration)
                    .addComponent(jBUpdate))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jBDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDeleteActionPerformed
        
        try{
            int selectedRow = jTProduct.getSelectedRow();
            if(selectedRow>=0){
                int id = Integer.parseInt(String.valueOf(jTProduct.getValueAt(selectedRow, 0)));
            
            String name = String.valueOf(jTProduct.getValueAt(selectedRow, 1));
            
            int response = JOptionPane.showConfirmDialog(this, "Deseja mesmo excluir o item "+name+"?");
            //yes=0, no =1, cancel=2
            if(response == JOptionPane.YES_OPTION){//0
                ProductDAO productDAO = new ProductDAO();
                
                Product product = productDAO.select(id);

                if (product == null) {
                    JOptionPane.showMessageDialog(this, "Produto não encontrado.");
                    return;
                }
                
                productDAO.delete(product);
                    JOptionPane.showMessageDialog(this, "Produto deletado com sucesso");
                }
                }else{
                JOptionPane.showMessageDialog(this, "Produto não encontrado");
                }
            
            loadTable();
            
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Erro.\nNão foi possível deletar o item");
        
        }
            
            
       
    }//GEN-LAST:event_jBDeleteActionPerformed

    private void jBRegistrationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRegistrationActionPerformed
        ProductRegistration productRegistration = new ProductRegistration(this);
        productRegistration.setVisible(true);
    }//GEN-LAST:event_jBRegistrationActionPerformed

    private void jBUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBUpdateActionPerformed
        
        try{
            ProductRegistration productRegistration = new ProductRegistration(this);
            String id =(String)jTProduct.getValueAt(jTProduct.getSelectedRow(),0);
            
            ProductDAO productDAO = new ProductDAO();
            
            Product selectedProduct = productDAO.select(Integer.parseInt(id));
            
            productRegistration.fillUpdate(selectedProduct);
            productRegistration.setVisible(true);
            
        
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Ocorreu uma falha.");
           
        }
        
    }//GEN-LAST:event_jBUpdateActionPerformed

    private void jBAlddAlertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAlddAlertActionPerformed
        
        try{
            StockAlert stockAlert = new StockAlert();
            String id =(String) jTProduct.getValueAt(jTProduct.getSelectedRow(), 0);
            
            ProductDAO productDAO = new ProductDAO();
            
            Product selectedProduct = productDAO.select(Integer.parseInt(id));
            
            stockAlert.fillAlert(selectedProduct);
            stockAlert.setVisible(true);
        
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Erro.");
        }
        
    }//GEN-LAST:event_jBAlddAlertActionPerformed

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
            java.util.logging.Logger.getLogger(ProductMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAlddAlert;
    private javax.swing.JButton jBDelete;
    private javax.swing.JButton jBRegistration;
    private javax.swing.JButton jBUpdate;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTProduct;
    // End of variables declaration//GEN-END:variables
}
