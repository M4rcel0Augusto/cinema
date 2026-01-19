/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.gui;

import com.mycompany.persistence.Product;
import com.mycompany.persistence.ProductDAO;
import com.mycompany.persistence.ProductType;
import javax.swing.JOptionPane;

/**
 *
 * @author conve
 */
public class ProductRegistration extends javax.swing.JFrame {

    private ProductMain parent;
    public ProductRegistration(ProductMain parent) {
        this.parent = parent;
        initComponents();
        fillCBType();
    }

    private Product productUpdate = null;
    public void fillUpdate(Product p){
        jTFName.setText(p.getProductName());
        jCBType.setSelectedItem(p.getProductType());
        jCBSize.setSelectedItem(p.getSize());
        jTFQuantity.setText(String.valueOf(p.getQuantityInStock()));
        jTFPrice.setText(String.valueOf(p.getUnitPrice()));
        jTFCost.setText(String.valueOf(p.getUnitCost()));
        productUpdate = p;
        
    }
    
    
    private void fillCBType(){
    for(ProductType type: ProductType.values()){
        jCBType.addItem(type);
    }
    
    
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTFName = new javax.swing.JTextField();
        jCBType = new javax.swing.JComboBox<>();
        jTFQuantity = new javax.swing.JTextField();
        jTFPrice = new javax.swing.JTextField();
        jTFCost = new javax.swing.JTextField();
        jCBSize = new javax.swing.JComboBox<>();
        jBSave = new javax.swing.JButton();
        jBReturn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Cadastro de produtos");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Nome:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Tipo:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Tamanho:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Qt em estoque:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Preço Unitário:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Custo unitário:");

        jCBType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBTypeActionPerformed(evt);
            }
        });

        jCBSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "  ", "XL", "L", "M", "S" }));
        jCBSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBSizeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTFName)
                            .addComponent(jCBType, 0, 145, Short.MAX_VALUE)
                            .addComponent(jTFQuantity)
                            .addComponent(jTFPrice)
                            .addComponent(jTFCost)
                            .addComponent(jCBSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTFName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jCBType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jCBSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTFQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTFPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTFCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        jBSave.setText("Salvar");
        jBSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSaveActionPerformed(evt);
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBReturn)
                .addGap(68, 68, 68)
                .addComponent(jBSave)
                .addGap(106, 106, 106))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBSave)
                    .addComponent(jBReturn))
                .addGap(0, 6, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBReturnActionPerformed
        dispose();
        
    }//GEN-LAST:event_jBReturnActionPerformed

    private void jBSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSaveActionPerformed
        if(jTFName.getText().isEmpty()||jTFPrice.getText().isEmpty()||jTFCost.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencha todos os campos para registrar os produtos");
            return;
        }
         
        try{
            double price, cost;
            price = Double.parseDouble(jTFPrice.getText().replace(",", "."));
            cost = Double.parseDouble(jTFCost.getText().replace(",", "."));
            if(price<0 || cost<0){
                JOptionPane.showMessageDialog(null, "Insira apenas valores positivos");
                return;
            }
            
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(this, "Insira o preço de forma numérica.");
            return;
        }
        
        try{
            Product product;
            if(productUpdate == null){
             product = new Product();
            }else{
                product= productUpdate;
            }

            product.setProductName(jTFName.getText());

            ProductType type = (ProductType) jCBType.getSelectedItem();
            product.setProductType(type);
            product.setSize(String.valueOf(jCBSize.getSelectedItem()));
            product.setUnitPrice(Double.parseDouble(jTFPrice.getText()));
            product.setUnitCost(Double.parseDouble(jTFCost.getText()));
            

            //No caso de ser cadastrado um item, antes de ser feito uma analise da quantidade em estoque
            if(jTFQuantity.getText().isEmpty()){

                jTFQuantity.setText("0");

            }
            product.setQuantityInStock(Integer.parseInt(jTFQuantity.getText()));

            ProductDAO productDAO = new ProductDAO();
            if(productUpdate ==null){
            productDAO.register(product);
            JOptionPane.showMessageDialog(this, "Produto salvo.");
            cleanForm();
            parent.loadTable();}
            else{
                productDAO.update(productUpdate);
                JOptionPane.showMessageDialog(this, "Edição salva com sucesso");
                parent.loadTable();
                
                dispose();
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar produto.");
            
        }
        
        
        
        
        
    }//GEN-LAST:event_jBSaveActionPerformed

    private void jCBTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBTypeActionPerformed

    private void jCBSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBSizeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBSizeActionPerformed
    
    private void cleanForm(){
    
        jTFName.setText("");
        jTFQuantity.setText("");
        jTFPrice.setText("");
        jTFCost.setText("");
    }
    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBReturn;
    private javax.swing.JButton jBSave;
    private javax.swing.JComboBox<String> jCBSize;
    private javax.swing.JComboBox<ProductType> jCBType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTFCost;
    private javax.swing.JTextField jTFName;
    private javax.swing.JTextField jTFPrice;
    private javax.swing.JTextField jTFQuantity;
    // End of variables declaration//GEN-END:variables
}
