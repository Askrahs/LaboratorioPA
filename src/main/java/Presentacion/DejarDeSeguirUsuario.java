package Presentacion;

import Excepciones.NoHayUsuariosEnElSistemaException;
import Excepciones.NoSigueANadie;
import Excepciones.UsuariosNoExisten;
import Logica.IControllerUsuario;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DejarDeSeguirUsuario extends javax.swing.JFrame {

    private JFrame principal;
    private IControllerUsuario ctrlU;

    public DejarDeSeguirUsuario(IControllerUsuario Control, JFrame principal) {
        this.ctrlU = Control;
        this.principal = principal;
        initComponents();
        cargarNicknames();
    }

    public DejarDeSeguirUsuario() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        btnConfirmar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtSeguidor = new javax.swing.JTextField();
        txtASiguiendo = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        ListaSiguiendo = new javax.swing.JList<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListaSeguidor = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dejar de seguir Usuario"));
        jPanel1.setLayout(null);

        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });
        jPanel1.add(btnConfirmar);
        btnConfirmar.setBounds(340, 130, 150, 27);

        jLabel1.setText("Selecciones el Cliente el cual desea cancelar el seguimiento:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 30, 314, 16);

        jLabel2.setText("Seleccione el Usuario que desea dejar de seguir:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(10, 190, 365, 16);

        txtSeguidor.setEnabled(false);
        jPanel1.add(txtSeguidor);
        txtSeguidor.setBounds(340, 50, 150, 26);

        txtASiguiendo.setEnabled(false);
        jPanel1.add(txtASiguiendo);
        txtASiguiendo.setBounds(340, 100, 150, 26);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar);
        btnCancelar.setBounds(340, 160, 150, 27);

        ListaSiguiendo.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ListaSiguiendoValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(ListaSiguiendo);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(10, 210, 320, 140);

        ListaSeguidor.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ListaSeguidorValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(ListaSeguidor);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 50, 320, 140);

        jLabel3.setText("Seguidor:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(340, 30, 110, 16);

        jLabel4.setText("Siguiendo:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(340, 80, 130, 16);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        // TODO add your handling code here:
        //BOTON CONFIRMAR
        String nickname1 = txtSeguidor.getText();
        String nickname2 = txtASiguiendo.getText();
        
        if (nickname1.isEmpty() || nickname2.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Los campos no pueden estar vacios . ", "Dejar de seguir Usuario", JOptionPane.ERROR_MESSAGE);
        } else {
            //Verificar que existan
            try {
                ctrlU.DejarDeSeguirUsuario(nickname1, nickname2);
                
                JOptionPane.showMessageDialog(this, "Se dejo de seguir con exito!", "Dejar de seguir Usuario", JOptionPane.INFORMATION_MESSAGE);
            } catch (UsuariosNoExisten ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Dejar de seguir Usuario", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        //Limpiar();
    }//GEN-LAST:event_btnConfirmarActionPerformed

    
    
    
    
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        
        principal.setVisible(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        //CERRAR VENTANA
        setVisible(false);
        
        principal.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void ListaSeguidorValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ListaSeguidorValueChanged
        // TODO add your handling code here:
        if (!evt.getValueIsAdjusting()) { // Solo reaccionar al cambio final
            String nicknameSeleccionado = ListaSeguidor.getSelectedValue();
            txtSeguidor.setText(nicknameSeleccionado);
        //CARGAR SIGUIENDO
            List<String> siguiendo = null;
            try {
                siguiendo = ctrlU.ObtenerSiguiendoCliente(nicknameSeleccionado);
                //control
                if (siguiendo != null) {
                    DefaultListModel<String> model = new DefaultListModel<>();
                    // Agregamos cada nickname al modelo.
                    for (String s : siguiendo) {
                        model.addElement(s);
                    }
                    // Establecemos el modelo al JList.
                    ListaSiguiendo.setModel(model);
                }
            } catch (NoSigueANadie ex) {
                Logger.getLogger(SeguirUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_ListaSeguidorValueChanged

    private void ListaSiguiendoValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ListaSiguiendoValueChanged
        // TODO add your handling code here:
        if (!evt.getValueIsAdjusting()) { // Solo reaccionar al cambio final
            String nicknameSeleccionado = ListaSiguiendo.getSelectedValue();
            txtASiguiendo.setText(nicknameSeleccionado);
        }
    }//GEN-LAST:event_ListaSiguiendoValueChanged

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
            java.util.logging.Logger.getLogger(DejarDeSeguirUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DejarDeSeguirUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DejarDeSeguirUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DejarDeSeguirUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DejarDeSeguirUsuario().setVisible(true);
            }
        });
    }

    public void Limpiar() {
        txtSeguidor.setText("");
        txtASiguiendo.setText("");
    }
    
    public void cargarNicknames() {
        
        List<String> nicknames;
        try {
            nicknames = ctrlU.ObtenerNicknamesClientes();

            if (nicknames != null) {
                DefaultListModel<String> modelS = new DefaultListModel<>();
                // Agregamos cada nickname al modelo.
                for (String nickname : nicknames) {
                    modelS.addElement(nickname);
                }
                // Establecemos el modelo al JList.
                ListaSeguidor.setModel(modelS);
            }
        } catch (NoHayUsuariosEnElSistemaException ex) {
        }
        
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> ListaSeguidor;
    private javax.swing.JList<String> ListaSiguiendo;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField txtASiguiendo;
    private javax.swing.JTextField txtSeguidor;
    // End of variables declaration//GEN-END:variables
}
