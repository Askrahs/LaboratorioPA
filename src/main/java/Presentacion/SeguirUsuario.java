package Presentacion;

import Excepciones.NoHayUsuariosEnElSistemaException;
import Excepciones.NoSigueANadie;
import Excepciones.UsuariosNoExisten;
import Logica.IControllerUsuario;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SeguirUsuario extends javax.swing.JFrame {

    private JFrame principal;
    private IControllerUsuario ctrlU;

    public SeguirUsuario(IControllerUsuario Control, JFrame principal) {
        this.ctrlU = Control;
        this.principal = principal;
        initComponents();
        cargarNicknames();
    }

    public SeguirUsuario() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnConfirmar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtSeguir = new javax.swing.JTextField();
        txtASeguir = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListaSiguiendo = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        ListaSeguidos = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        ListaSeguidor = new javax.swing.JList<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Seguir Usuario"));
        jPanel1.setLayout(null);

        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });
        jPanel1.add(btnConfirmar);
        btnConfirmar.setBounds(350, 370, 290, 27);

        jLabel1.setText("Seleccione Cliente el cual desea realizar el seguimiento:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 20, 330, 16);

        jLabel2.setText("Seleccione el Usuario que desea seguir:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(10, 230, 300, 16);

        txtSeguir.setEnabled(false);
        jPanel1.add(txtSeguir);
        txtSeguir.setBounds(350, 270, 290, 26);

        txtASeguir.setEnabled(false);
        jPanel1.add(txtASeguir);
        txtASeguir.setBounds(350, 330, 290, 26);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar);
        btnCancelar.setBounds(350, 400, 290, 27);

        ListaSiguiendo.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ListaSiguiendoValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(ListaSiguiendo);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 250, 290, 180);

        ListaSeguidos.setEnabled(false);
        jScrollPane2.setViewportView(ListaSeguidos);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(350, 40, 290, 180);

        jLabel3.setText("Usuarios a los que ya sigue :");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(350, 20, 290, 16);

        ListaSeguidor.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ListaSeguidorValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(ListaSeguidor);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(10, 40, 290, 180);

        jLabel4.setText("Seguidor:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(350, 250, 260, 16);

        jLabel5.setText("Siguiendo:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(350, 310, 220, 16);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 652, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        setVisible(false);
        principal.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        principal.setVisible(true);
    }//GEN-LAST:event_btnCancelarActionPerformed


    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        // TODO add your handling code here:
        //BOTON CONFIRMAR
        String nickname1 = txtSeguir.getText();
        String nickname2 = txtASeguir.getText();
        Limpiar();
        if (nickname1.isEmpty() || nickname2.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Los campos no pueden estar vacios. ", "Seguir Usuario", JOptionPane.ERROR_MESSAGE);
        } else {
            //Verificar que existan
            try {
                ctrlU.SeguirUsuario(nickname1, nickname2);
                JOptionPane.showMessageDialog(this, "Seguido con exito!", "Seguir Usuario", JOptionPane.INFORMATION_MESSAGE);
            } catch (UsuariosNoExisten ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Seguir Usuario", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void ListaSeguidorValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ListaSeguidorValueChanged
        // TODO add your handling code here:
        if (!evt.getValueIsAdjusting()) { // Solo reaccionar al cambio final
            String nicknameSeleccionado = ListaSeguidor.getSelectedValue();
            txtSeguir.setText(nicknameSeleccionado);
            //CARGAR SIGUIENDO
            List<String> siguiendo;
            try {
                siguiendo = ctrlU.ObtenerSiguiendoCliente(nicknameSeleccionado);
                //control
                if (siguiendo != null && !siguiendo.isEmpty()) {
                    DefaultListModel<String> model = new DefaultListModel<>();
                    // Agregamos cada nickname al modelo.
                    for (String s : siguiendo) {
                        model.addElement(s);
                    }
                    // Establecemos el modelo al JList.
                    ListaSeguidos.setModel(model);
                }
            } catch (NoSigueANadie ex) {
                Logger.getLogger(SeguirUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }//GEN-LAST:event_ListaSeguidorValueChanged

    private void ListaSiguiendoValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ListaSiguiendoValueChanged
        // TODO add your handling code here:
        String nicknameSeleccionado = ListaSiguiendo.getSelectedValue();
        txtASeguir.setText(nicknameSeleccionado);
    }//GEN-LAST:event_ListaSiguiendoValueChanged

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
            java.util.logging.Logger.getLogger(SeguirUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SeguirUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SeguirUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SeguirUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SeguirUsuario().setVisible(true);
            }
        });
    }

    public void Limpiar() {
        
        txtASeguir.setText("");
    }

    public void cargarNicknames() {

        try {
            List<String> nicknamesCli = null; //CLIENTES
            nicknamesCli = ctrlU.ObtenerNicknamesClientes(); // solo clientes
            List<String> nicknamesArt = null; //CLIENTES Y ARTISTAS porque artistas no pueden seguir.
            nicknamesArt = ctrlU.obtenerArtistas();

            //lista Clientes
            if (nicknamesCli != null && !nicknamesCli.isEmpty()) {
                DefaultListModel<String> model = new DefaultListModel<>();
                // Agregamos cada nickname al modelo.
                for (String nickname : nicknamesCli) {
                    model.addElement(nickname);
                }
                // Establecemos el modelo al JList.
                ListaSeguidor.setModel(model);
            }

            //lista Usuarios
            if (nicknamesArt != null && !nicknamesArt.isEmpty()) {
                DefaultListModel<String> modelU = new DefaultListModel<>();

                // Agregamos cada nickname al modelo.
                for (String nickname : nicknamesArt) {
                    modelU.addElement(nickname);
                }
                for (String nickname : nicknamesCli) {
                    modelU.addElement(nickname);
                }
                // Establecemos el modelo al JList.
                ListaSiguiendo.setModel(modelU);
            }
        } catch (NoHayUsuariosEnElSistemaException ex) {
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> ListaSeguidor;
    private javax.swing.JList<String> ListaSeguidos;
    private javax.swing.JList<String> ListaSiguiendo;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField txtASeguir;
    private javax.swing.JTextField txtSeguir;
    // End of variables declaration//GEN-END:variables
}
