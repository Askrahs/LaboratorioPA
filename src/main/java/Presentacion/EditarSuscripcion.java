package Presentacion;

import Logica.IControllerUsuario;
import Logica.Suscripcion;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class EditarSuscripcion extends javax.swing.JFrame {

    private JFrame principal;
    private IControllerUsuario ctrlU;

    public EditarSuscripcion(IControllerUsuario Control, JFrame principal) {
        this.ctrlU = Control;
        this.principal = principal;
        initComponents();
        cargarSuscripciones(); //cargar nicks suscripciones
    }

    public EditarSuscripcion() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListaSuscripciones = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtNick = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        comboEstado = new javax.swing.JComboBox<>();
        comboTipo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Modificar Suscripcion"));

        ListaSuscripciones.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ListaSuscripcionesValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(ListaSuscripciones);

        jLabel1.setText("Suscripciones:");

        btnModificar.setText("Modificar");
        btnModificar.setEnabled(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtNick.setEnabled(false);
        txtNick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNickActionPerformed(evt);
            }
        });

        txtFecha.setEnabled(false);

        jLabel2.setText("Nickname del Cliente");

        jLabel3.setText("Estado de la Suscripcion:");

        jLabel6.setText("Tipo de Suscripcion:");

        jLabel7.setText("Fecha de la Suscripcion:");

        comboEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CANCELADA", "PENDIENTE", "VIGENTE", "VENCIDA" }));

        comboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SEMANAL", "MENSUAL", "ANUAL" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNick, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtFecha, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtNick, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel3)
                        .addGap(4, 4, 4)
                        .addComponent(comboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel6)
                        .addGap(4, 4, 4)
                        .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel7)
                        .addGap(4, 4, 4)
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addComponent(btnModificar))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNickActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNickActionPerformed

    private void ListaSuscripcionesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ListaSuscripcionesValueChanged
        // TODO add your handling code here:

        //SELECCIONA SUSCRIPCION CARGO SUS DATOS Y LE DOY ENABLE AL BOTON MODIFICAR
        if (!evt.getValueIsAdjusting()) { // Solo reaccionar al cambio final
            String nicknameSeleccionado = ListaSuscripciones.getSelectedValue();
            cargarDatosSuscripcion(nicknameSeleccionado);
            btnModificar.setEnabled(true);
        }
    }//GEN-LAST:event_ListaSuscripcionesValueChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        this.dispose();
        principal.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        this.dispose();
        principal.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        //BOTON MODIFICAR
        
        //controles NO PUEDE SELECCIONAR EL ESTADO VENCIDA
        if (comboEstado.getSelectedItem() == "VENCIDA" ){
            JOptionPane.showMessageDialog(this, "No puedes modificar una suscripcion al estado VENCIDA", "Actualizar Suscripcion", JOptionPane.ERROR_MESSAGE);
        }else{
            //obtengo los datos a cambiar.
            String Estado = comboEstado.getSelectedItem().toString();
            String Tipo = comboTipo.getSelectedItem().toString();
            //llamo al controlador para que cambie los datos de la suscripcion.
            //datos suscripcion = nickname, fecha actual y los campos.
            ctrlU.ModificarSuscripcion(txtNick.getText(), obtenerFechaActual(), Estado, Tipo );
            //LIMPIAR
            txtNick.setText("");
            txtFecha.setText("");
            //boton modificar deshabilitado
            btnModificar.setEnabled(false);
        }
    }//GEN-LAST:event_btnModificarActionPerformed

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
            java.util.logging.Logger.getLogger(EditarSuscripcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarSuscripcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarSuscripcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarSuscripcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarSuscripcion().setVisible(true);
            }
        });
    }

    public void cargarSuscripciones() {
        List<String> nicknames = null;
        nicknames = ctrlU.ObtenerNicknamesSuscripciones();
        if (nicknames != null && !nicknames.isEmpty()) {
            DefaultListModel<String> model = new DefaultListModel<>();
            // Agregamos cada nickname al modelo.
            for (String nickname : nicknames) {
                model.addElement(nickname);
            }
            // Establecemos el modelo al JList.
            ListaSuscripciones.setModel(model);
        }
    }
    
    //al tocar un nick cargar datos
    public void cargarDatosSuscripcion(String nickname){
        Suscripcion s = ctrlU.ObtenerSuscripcion(nickname);
        if (s != null){ //control
            txtNick.setText(s.getClienteNickname());
            txtFecha.setText(s.getFecha());
            comboEstado.setSelectedItem(s.getEstado().toString()); // Convertir EstadoSuscripcion a String
            comboTipo.setSelectedItem(s.getTipo().toString());     // Convertir TipoSuscripcion a String
        
        }
    }
    
    public String obtenerFechaActual() {
        // Obtener la fecha actual
        LocalDate fechaActual = LocalDate.now();
        
        // Definir el formato 
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        // Convertir la fecha al formato deseado y devolverla como String
        return fechaActual.format(formato);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> ListaSuscripciones;
    private javax.swing.JButton btnModificar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> comboEstado;
    private javax.swing.JComboBox<String> comboTipo;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtNick;
    // End of variables declaration//GEN-END:variables
}
