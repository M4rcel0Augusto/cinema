/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.gui;

import com.mycompany.model.ItemSaleTemp;
import com.mycompany.model.SaleService;
import com.mycompany.model.SaleTemp;
import com.mycompany.persistence.Combo;
import com.mycompany.persistence.ComboDAO;
import com.mycompany.persistence.ComboItem;
import com.mycompany.persistence.ComboItemDAO;
import com.mycompany.persistence.Product;
import com.mycompany.persistence.ProductDAO;
import com.mycompany.persistence.ProductStockAlert;
import com.mycompany.persistence.ProductStockAlertDAO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author conve
 */

public class Sale extends javax.swing.JFrame {

    /**
     * Creates new form Sale
     */
    public Sale() {
        initComponents();
        loadProductTable();
    }
    private SaleTemp saleTemp = new SaleTemp();
    
    public void loadProductTable(){
        ProductDAO productDAO = new ProductDAO();
        List<Product> products = productDAO.list();
        fillProductTable(products);
    }
    
    private void fillProductTable(List<Product> products){
        String columns[]= {"Id", "Nome", "Tipo", "Tamanho", "Quantidade", "Preço un"};
        String data [][] = new String[products.size()][columns.length];
        
        int i =0;
        
        for(Product p : products){
            data[i] = new String[]{
                String.valueOf(p.getId()),
                p.getProductName(),
                String.valueOf(p.getProductType()),
                String.valueOf(p.getSize()),
                String.valueOf(p.getQuantityInStock()),
                String.valueOf(p.getUnitPrice()),
                


                
            };
            i++;
        }
        DefaultTableModel model = new DefaultTableModel(data,columns);
        jTProduct.setModel(model);
       
    }
    
    public void loadCartTable() {
    fillCartTable(saleTemp.getItems());
    updateTotalLabel();
    }
    
    private void fillCartTable(List<ItemSaleTemp> items) {

    String[] columns = {"Item", "Tipo", "Qt", "Preço un", "Subtotal"};
    String[][] data = new String[items.size()][columns.length];

    int i = 0;
    for (ItemSaleTemp item : items) {

        if (item.isProduct()) {
            data[i] = new String[]{
                item.getProduct().getProductName(),
                "Produto",
                String.valueOf(item.getQuantity()),
                String.valueOf(item.getProduct().getUnitPrice()),
                String.valueOf(item.getSubtotal())
            };
        }

        if (item.isCombo()) {
            data[i] = new String[]{
                item.getCombo().getName(),
                "Combo",
                String.valueOf(item.getQuantity()),
                String.valueOf(item.getCombo().getPrice()),
                String.valueOf(item.getSubtotal())
            };
        }

        i++;
    }

    jTCart.setModel(new DefaultTableModel(data, columns));
}
   
    private void updateTotalLabel() {
    jLTotal.setText(
        "Total: R$ " + String.format("%.2f", saleTemp.getTotalAmount()));
}
    
    private void fillComboTable(List<Combo> combos){
        String columns[] ={"Id", "Nome", "Preço"};
        String data[][] = new String[combos.size()][columns.length];
        
        int i =0;
        for(Combo c : combos){
            data[i] = new String[]{
                String.valueOf(c.getId()),
            c.getName(),
            String.valueOf(c.getPrice())
            };
            i++;
        }
        
        DefaultTableModel model = new DefaultTableModel(data,columns);
        jTProduct.setModel(model);
       
    }
  
    private void loadComboTable() {
        
    ComboDAO comboDAO = new ComboDAO();
        List<Combo> combos = comboDAO.list();
        fillComboTable(combos);

    }
    
    private void showStockAlerts() {
    ProductStockAlertDAO dao = new ProductStockAlertDAO();
    List<ProductStockAlert> alerts = dao.listBelowMinimum();

    if (alerts.isEmpty()) {
        return;
    }

    StringBuilder msg = new StringBuilder("⚠ Produtos com estoque baixo:\n\n");

    for (ProductStockAlert a : alerts) {
        msg.append("- ")
           .append(a.getProduct().getProductName())
           .append(" (Estoque: ")
           .append(a.getProduct().getQuantityInStock())
           .append(" / Mínimo: ")
           .append(a.getMinimumQuantity())
           .append(")\n");
    }

    JOptionPane.showMessageDialog(
        this,
        msg.toString(),
        "Alerta de Estoque",
        JOptionPane.WARNING_MESSAGE
    );
}

    
 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTCart = new javax.swing.JTable();
        jLTotal = new javax.swing.JLabel();
        jBRemove = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTProduct = new javax.swing.JTable();
        jBFinsh = new javax.swing.JButton();
        jBReturn = new javax.swing.JButton();
        jBAdd = new javax.swing.JButton();
        jCBList = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Carrinho");

        jTCart.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTCart);

        jLTotal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLTotal.setText("Total:");

        jBRemove.setText("Remover");
        jBRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRemoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(jLabel1)
                .addContainerGap(107, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jBRemove)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(65, 65, 65)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLTotal)
                    .addComponent(jBRemove))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Produtos");

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

        jBFinsh.setText("Finalizar");
        jBFinsh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBFinshActionPerformed(evt);
            }
        });

        jBReturn.setText("Voltar");
        jBReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBReturnActionPerformed(evt);
            }
        });

        jBAdd.setText("Adicionar ao Carrinho");
        jBAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAddActionPerformed(evt);
            }
        });

        jCBList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Produtos", "Combos", " " }));
        jCBList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBListActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jBReturn)
                                .addGap(18, 18, 18)
                                .addComponent(jBFinsh))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jCBList, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBAdd)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(240, 240, 240))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBFinsh)
                            .addComponent(jBReturn))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jCBList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBReturnActionPerformed
        dispose();
    }//GEN-LAST:event_jBReturnActionPerformed

    private void jBAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAddActionPerformed
        int selectedRow = jTProduct.getSelectedRow();
    if (selectedRow < 0) {
        JOptionPane.showMessageDialog(this, "Selecione um item.");
        return;
    }

    int id = Integer.parseInt(
        String.valueOf(jTProduct.getValueAt(selectedRow, 0))
    );

    try {
        if ("Produtos".equals(jCBList.getSelectedItem())) {

            ProductDAO productDAO = new ProductDAO();
            Product product = productDAO.select(id);
            saleTemp.addProduct(product);

        } else if ("Combos".equals(jCBList.getSelectedItem())) {

            ComboDAO comboDAO = new ComboDAO();
            Combo combo = comboDAO.select(id);
            saleTemp.addCombo(combo);
        }

        loadCartTable();

    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Erro ao adicionar ao carrinho.");
      
        
    }
    }//GEN-LAST:event_jBAddActionPerformed

    private void jBFinshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBFinshActionPerformed
        if(saleTemp.getItems().isEmpty()){
            JOptionPane.showMessageDialog(this, "Carrinho vazio.");
            return;
        }
        
        try{
            int response = JOptionPane.showConfirmDialog(this, "Deseja FInalizar a Venda?\nValor:"+saleTemp.getTotalAmount(),
                    "Finalizar venda",JOptionPane.YES_NO_OPTION);
        
            
            if(response==JOptionPane.YES_OPTION){
                SaleService service = new SaleService();
                service.finalizeSale(saleTemp);
                JOptionPane.showMessageDialog(this, "Venda concluida");
                
                //limpar carrinho
                saleTemp = new SaleTemp();
                loadCartTable();
                

                showStockAlerts();
            }
        
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Erro ao realizar a venda");
            
        }
    }//GEN-LAST:event_jBFinshActionPerformed

    private void jCBListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBListActionPerformed
        if("Produtos".equals(jCBList.getSelectedItem())){
            loadProductTable();
        
        }
        if("Combos".equals(jCBList.getSelectedItem())){
            loadComboTable();
        }
    }//GEN-LAST:event_jCBListActionPerformed

    private void jBRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRemoveActionPerformed
        
        int selectedRow = jTCart.getSelectedRow();
        
        if(selectedRow<0){
            JOptionPane.showMessageDialog(this, "Selecione um item");
            return;
        }
        try{
            ItemSaleTemp item = saleTemp.getItems().get(selectedRow);
            
            if(item.isProduct()){
            saleTemp.removeProduct(item.getProduct());
            }
            if(item.isCombo()){
            saleTemp.removeCombo(item.getCombo());
            }
            
            loadCartTable();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Erro ao remover item do carrinho");
        }
        
       
    }//GEN-LAST:event_jBRemoveActionPerformed

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
            java.util.logging.Logger.getLogger(Sale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sale().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAdd;
    private javax.swing.JButton jBFinsh;
    private javax.swing.JButton jBRemove;
    private javax.swing.JButton jBReturn;
    private javax.swing.JComboBox<String> jCBList;
    private javax.swing.JLabel jLTotal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTCart;
    private javax.swing.JTable jTProduct;
    // End of variables declaration//GEN-END:variables
}
