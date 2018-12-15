/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frame;

import Model.ClienteModel;
import Model.CompraVendaModel;
import Model.DAO.ConexaoBD;
import Model.PvendaModel;
import Model.VendedorModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author innanplinio
 */
public class VenderVeiculoFrame extends javax.swing.JFrame {

    /**
     * Creates new form ComprarVeiculoFrame
     */
    public VenderVeiculoFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        clienteBox = new javax.swing.JComboBox<>();
        funcionarioBox = new javax.swing.JComboBox<>();
        carroBox = new javax.swing.JComboBox<>();
        data = new javax.swing.JTextField();
        valor = new javax.swing.JTextField();
        Finalizar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        troca = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Vender Veiculo");

        clienteBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cliente" }));

        funcionarioBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Funcionario" }));

        carroBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Carro" }));
        this.populaComboBox();
        carroBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carroBoxActionPerformed(evt);
            }
        });

        data.setText("Data");
        data.setPreferredSize(new java.awt.Dimension(150, 20));

        valor.setText("Valor");
        valor.setPreferredSize(new java.awt.Dimension(150, 20));

        Finalizar.setText("Finalizar");
        Finalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FinalizarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel1.setText("Vender Veiculo");

        troca.setText("Troca");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(data, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(Finalizar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(valor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(carroBox, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53)
                                .addComponent(troca)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(clienteBox, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(funcionarioBox, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(funcionarioBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clienteBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addComponent(carroBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(troca)
                        .addGap(2, 2, 2)))
                .addComponent(data, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(valor, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(Finalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FinalizarActionPerformed

        try {
            onClickFinalizarVenda();
        } catch (SQLException ex) {
        }
        
    }//GEN-LAST:event_FinalizarActionPerformed

    private void carroBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carroBoxActionPerformed
        valor.setText(""+PvendaModel.get(Integer.parseInt(carroBox.getSelectedItem().toString())).getPrecoVenda());
    }//GEN-LAST:event_carroBoxActionPerformed

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
        } catch (InstantiationException ex) {
        } catch (IllegalAccessException ex) {
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VenderVeiculoFrame().setVisible(true);
            }
        });
    }
    
    private void populaComboBox() {

        try {

            PreparedStatement ps1 = ConexaoBD.getConexaoBD().prepareStatement("SELECT IdCliente FROM Cliente ");
            ResultSet rs1 = ps1.executeQuery();
            PreparedStatement ps2 = ConexaoBD.getConexaoBD().prepareStatement("SELECT CpfFuncionario FROM Vendedor ");
            ResultSet rs2 = ps2.executeQuery();
            PreparedStatement ps3 = ConexaoBD.getConexaoBD().prepareStatement("SELECT idVeiculo FROM Veiculo WHERE Situacao =1");
            ResultSet rs3 = ps3.executeQuery();

            while (rs2.next()) {
                funcionarioBox.addItem(rs2.getString("CpfFuncionario"));
            }
            while (rs1.next()) {
                clienteBox.addItem(rs1.getString("IdCliente"));
            }
            while (rs3.next()) {
                carroBox.addItem(rs3.getString("IdVeiculo"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

    private void onClickFinalizarVenda() throws SQLException {
        CompraVendaModel c = new CompraVendaModel();
        c.setCliente(ClienteModel.get(Integer.parseInt(clienteBox.getSelectedItem().toString())));
        c.setVendedor(VendedorModel.get(funcionarioBox.getSelectedItem().toString()));
        c.getVendedor().setCpfFuncionario(funcionarioBox.getSelectedItem().toString());
        c.setVeiculo(PvendaModel.get(Integer.parseInt(carroBox.getSelectedItem().toString())));
        if(troca.isSelected()){
            c.setTroca(true);
        }else{
            c.setTroca(false);
        }
        c.setDataCompraVenda(data.getText());
        PreparedStatement ps1 = ConexaoBD.getConexaoBD().prepareStatement("UPDATE Veiculo SET situacao = 3 WHERE idVeiculo = ?");
        ps1.setString(1, carroBox.getSelectedItem().toString());
        ps1.execute();
        c.save();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Finalizar;
    private javax.swing.JComboBox<String> carroBox;
    private javax.swing.JComboBox<String> clienteBox;
    private javax.swing.JTextField data;
    private javax.swing.JComboBox<String> funcionarioBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton troca;
    private javax.swing.JTextField valor;
    // End of variables declaration//GEN-END:variables
}