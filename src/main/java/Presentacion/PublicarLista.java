package Presentacion;

import Excepciones.*;
import Logica.*;
import javax.swing.JOptionPane;
import Logica.IControllerMusica;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class PublicarLista extends javax.swing.JFrame {
    private IControllerMusica ctrlM;
    private IControllerUsuario ctrlU;
    private JFrame principal;
    private boolean listener = true;
    
    public PublicarLista(IControllerMusica ctrl, IControllerUsuario ctrlu) {
        ctrlM= ctrl;
        ctrlU= ctrlu;
        initComponents();
    }
    
    public PublicarLista(IControllerMusica ctrlM, JFrame principal,IControllerUsuario ctrlU ) {
        this.ctrlM = ctrlM;
        this.ctrlU = ctrlU;
        this.principal = principal;
        initComponents();
        cargarClientes();
        
    }
    
    public PublicarLista() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxcliente1 = new javax.swing.JComboBox<>();
        jComboBoxListasC1 = new javax.swing.JComboBox<>();
        jButtonSalir3 = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Publicar Lista"));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel1.setText("Seleccione el nombre de un cliente");

        jButton2.setText("Aceptar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel2.setText("Seleccione el nombre de la lista del cliente");

        jComboBoxcliente1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cliente" }));
        jComboBoxcliente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxcliente1ActionPerformed(evt);
            }
        });

        jComboBoxListasC1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lista" }));
        jComboBoxListasC1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxListasC1ActionPerformed(evt);
            }
        });

        jButtonSalir3.setText("Salir");
        jButtonSalir3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalir3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxListasC1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxcliente1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jButtonSalir3, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 12, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxcliente1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxListasC1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonSalir3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    private void cargarClientes() {
        listener = false;
        try {
        List<String> nicknames = ctrlU.ObtenerNicknamesClientes();
        jComboBoxcliente1.removeAllItems(); // Limpiar el combo box antes de agregar nuevos clientes
        for (String cliente : nicknames) {
            jComboBoxcliente1.addItem(cliente);
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al cargar los clientes.", "Error", JOptionPane.ERROR_MESSAGE);
    }
        listener = true;
    }
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
          String nombreUsuario = (String) jComboBoxcliente1.getSelectedItem();
        String nombreLista = (String) jComboBoxListasC1.getSelectedItem();
        if (nombreUsuario == null || nombreLista == null) {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona ambos campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            ctrlM.publicarLista(nombreUsuario, nombreLista);
            JOptionPane.showMessageDialog(this, "La lista " + nombreLista + " ha sido publicada con éxito.");
        } catch (UsuarioNoExisteException ex) {
            JOptionPane.showMessageDialog(this, "Error: El usuario no existe.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ListaNoexisteException ex) {
            JOptionPane.showMessageDialog(this, "Error: La lista no existe.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ListaYaEsPublicaException ex) {
            JOptionPane.showMessageDialog(this, "Error: La lista ya es pública.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (OperacionNoPermitidaException ex) {
            Logger.getLogger(PublicarLista.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        setVisible(false);
        principal.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void jComboBoxListasC1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxListasC1ActionPerformed

    }//GEN-LAST:event_jComboBoxListasC1ActionPerformed

    private void jButtonSalir3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalir3ActionPerformed
        setVisible(false);
        principal.setVisible(true);
    }//GEN-LAST:event_jButtonSalir3ActionPerformed

    private void jComboBoxcliente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxcliente1ActionPerformed
       if(listener){
           String clienteSeleccionado = (String) jComboBoxcliente1.getSelectedItem();
    if (clienteSeleccionado != null && !clienteSeleccionado.equals("Cliente")) {
        try {
            List<String> listasPrivadas = ctrlM.ObtengolistasClipriv(clienteSeleccionado);
            jComboBoxListasC1.removeAllItems(); // Limpiar el combo box antes de agregar nuevas listas
            if (listasPrivadas.isEmpty()) {
                JOptionPane.showMessageDialog(this, "El cliente seleccionado no tiene listas privadas.", "Información", JOptionPane.INFORMATION_MESSAGE);
            } else {
                for (String lista : listasPrivadas) {
                    jComboBoxListasC1.addItem(lista);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar las listas privadas del cliente.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
       }
    }//GEN-LAST:event_jComboBoxcliente1ActionPerformed
    
   public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PublicarLista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PublicarLista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PublicarLista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PublicarLista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PublicarLista().setVisible(true);
            }
        });
    }


    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonSalir3;
    private javax.swing.JComboBox<String> jComboBoxListasC1;
    private javax.swing.JComboBox<String> jComboBoxcliente1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
