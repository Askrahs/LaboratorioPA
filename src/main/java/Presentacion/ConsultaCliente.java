package Presentacion;

import Excepciones.*;
import Logica.Cliente;
import Logica.IControllerUsuario;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ConsultaCliente extends javax.swing.JFrame {

    private JFrame principal;
    private IControllerUsuario ctrlU;

    public ConsultaCliente(IControllerUsuario Control, JFrame principal) {
        this.ctrlU = Control;
        this.principal = principal;

        initComponents();
        cargarNicknames();
    }

    public ConsultaCliente() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaCliente = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNick = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaSiguiendo = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaSeguidores = new javax.swing.JList<>();
        JLImagen = new javax.swing.JLabel();
        btnLista = new javax.swing.JButton();
        btnAlbum = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnTema = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        ListaP = new javax.swing.JList<>();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Consulta Cliente");
        setBounds(new java.awt.Rectangle(0, 0, 600, 600));
        setResizable(false);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Consulta Cliente"));
        jPanel1.setLayout(null);

        listaCliente.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaClienteValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listaCliente);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 40, 150, 190);

        jLabel1.setText("Clientes del sistema:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 20, 150, 20);

        jLabel2.setText("Nickname:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(170, 40, 110, 30);

        txtNick.setEditable(false);
        txtNick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNickActionPerformed(evt);
            }
        });
        jPanel1.add(txtNick);
        txtNick.setBounds(290, 40, 190, 30);

        jLabel3.setText("Nombre:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(170, 80, 110, 30);

        txtNombre.setEditable(false);
        jPanel1.add(txtNombre);
        txtNombre.setBounds(290, 80, 190, 30);

        jLabel4.setText("Apellido:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(170, 120, 110, 30);

        txtApellido.setEditable(false);
        txtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoActionPerformed(evt);
            }
        });
        jPanel1.add(txtApellido);
        txtApellido.setBounds(290, 120, 190, 30);

        jLabel5.setText("Email:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(170, 160, 110, 30);

        txtFecha.setEditable(false);
        jPanel1.add(txtFecha);
        txtFecha.setBounds(290, 200, 190, 30);

        jLabel6.setText("Fecha nacimiento:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(170, 200, 110, 30);

        txtEmail.setEditable(false);
        jPanel1.add(txtEmail);
        txtEmail.setBounds(290, 160, 190, 30);

        jLabel9.setText("Seguidores del Cliente:");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(10, 250, 175, 16);

        jLabel10.setText("Usuarios que sigue:");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(290, 250, 190, 16);

        listaSiguiendo.setEnabled(false);
        jScrollPane2.setViewportView(listaSiguiendo);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(290, 270, 190, 110);

        listaSeguidores.setEnabled(false);
        jScrollPane3.setViewportView(listaSeguidores);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(10, 270, 150, 110);

        JLImagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLImagen.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(JLImagen);
        JLImagen.setBounds(500, 40, 180, 190);

        btnLista.setText("Ver Listas");
        btnLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaActionPerformed(evt);
            }
        });
        jPanel1.add(btnLista);
        btnLista.setBounds(500, 270, 180, 20);

        btnAlbum.setText("Ver Albums");
        btnAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlbumActionPerformed(evt);
            }
        });
        jPanel1.add(btnAlbum);
        btnAlbum.setBounds(500, 300, 180, 20);

        jButton3.setText("Cargar Clientes");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(500, 360, 180, 20);

        btnTema.setText("Ver Temas");
        btnTema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTemaActionPerformed(evt);
            }
        });
        jPanel1.add(btnTema);
        btnTema.setBounds(500, 330, 180, 20);

        ListaP.setEnabled(false);
        jScrollPane4.setViewportView(ListaP);

        jPanel1.add(jScrollPane4);
        jScrollPane4.setBounds(690, 40, 130, 340);

        jLabel7.setText("Preferencias:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(690, 20, 130, 16);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 834, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        //Cerrar ventana 
        limpiar();
        setVisible(false);
        principal.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void txtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoActionPerformed

    private void txtNickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNickActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNickActionPerformed

    private void listaClienteValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaClienteValueChanged
        // TODO add your handling code here:
        //SELECCIONA UN TIEM DE LA JLIST THE USUARIOS DEL SISTEMA
        if (!evt.getValueIsAdjusting()) { // Solo reaccionar al cambio final
            String nicknameSeleccionado = listaCliente.getSelectedValue();
            try {
                cargarDatosCliente(nicknameSeleccionado);
            } catch (IOException ex) {

            }
        }
    }//GEN-LAST:event_listaClienteValueChanged

    private void btnAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlbumActionPerformed
        //BOTON ALBUMS
        DefaultListModel<String> model1 = new DefaultListModel<>();
        model1.addElement("");
        ListaP.setModel(model1);

        //CONTROLES
        if (txtNick.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se ha seleccionado un Cliente.", "Consulta Cliente", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //cargar
        String nickname1 = txtNick.getText();

        
        try {
            Cliente c = ctrlU.ObtenerCliente(nickname1);
            //cargo la lista con las listas del cliente:

            List<String> albums = ctrlU.ObtenerAlbumsCliente(nickname1);
            //control
            if (albums != null && !albums.isEmpty()) {
                DefaultListModel<String> model = new DefaultListModel<>();
                // Agregamos cada nickname al modelo.
                for (String a : albums) {
                    model.addElement(a);
                }
                // Establecemos el modelo al JList.
                ListaP.setModel(model);
            }
        } catch (UsuarioNoExisteException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Consulta Cliente", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnAlbumActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        cargarNicknames();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        // TODO add your handling code here:
        cargarNicknames();
    }//GEN-LAST:event_formFocusGained

    private void btnTemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTemaActionPerformed
        //BOTON TEMAS
        //LIMPIO ANTES
        DefaultListModel<String> model1 = new DefaultListModel<>();
        model1.addElement("");
        ListaP.setModel(model1);

        //CONTROLES
        if (txtNick.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se ha seleccionado un Cliente.", "Consulta Cliente", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //cargar
        String nickname1 = txtNick.getText();
        
        try {
            Cliente c = ctrlU.ObtenerCliente(nickname1);
            //cargo la lista con las listas del cliente:

            List<String> temas = ctrlU.ObtenerTemasCliente(nickname1);
            //control
            if (temas != null && !temas.isEmpty()) {
                DefaultListModel<String> model = new DefaultListModel<>();
                // Agregamos cada nickname al modelo.
                for (String s : temas) {
                    model.addElement(s);
                }
                // Establecemos el modelo al JList.
                ListaP.setModel(model);
            }
        } catch (UsuarioNoExisteException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Consulta Cliente", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnTemaActionPerformed

    private void btnListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaActionPerformed
        //LIMPIO ANTES
        DefaultListModel<String> model1 = new DefaultListModel<>();
        model1.addElement("");
        ListaP.setModel(model1);

        //CONTROLES
        if (txtNick.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se ha seleccionado un Cliente.", "Consulta Cliente", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //cargar
        String nickname1 = txtNick.getText();

        try {
            Cliente c = ctrlU.ObtenerCliente(nickname1);
            //cargo la lista con las listas del cliente:

            List<String> listas = ctrlU.ObtenerListasCliente(nickname1);
            //control
            if (listas != null && !listas.isEmpty()) {
                DefaultListModel<String> model = new DefaultListModel<>();
                // Agregamos cada nickname al modelo.
                for (String s : listas) {
                    model.addElement(s);
                }
                // Establecemos el modelo al JList.
                ListaP.setModel(model);
            }
        } catch (UsuarioNoExisteException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Consulta Cliente", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnListaActionPerformed

    private void cargarDatosCliente(String nickname) throws IOException {
        if (nickname != null && !nickname.isEmpty()) {
            try {
                limpiar(); //limpiar txtfiles imagen y listas
                Cliente c = ctrlU.ObtenerCliente(nickname);
                txtNick.setText(c.getNickname());
                txtNombre.setText(c.getNombre());
                txtApellido.setText(c.getApellido());
                txtEmail.setText(c.getEmail());
                txtFecha.setText(c.getFechaNac());

                //IMAGEN
                cargarImagen(c.getRutaImagen());

                //SEGUIDORES
                try {

                    List<String> seguidores = ctrlU.ObtenerSeguidoresCliente(nickname);
                    //control
                    if (seguidores != null && !seguidores.isEmpty()) {
                        DefaultListModel<String> model = new DefaultListModel<>();
                        // Agregamos cada nickname al modelo.
                        for (String s : seguidores) {
                            model.addElement(s);
                        }
                        // Establecemos el modelo al JList.
                        listaSeguidores.setModel(model);
                    }
                } catch (SinSeguidores ex) {
                }

                //SIGUIENDO
                try {
                    List<String> siguiendo = ctrlU.ObtenerSiguiendoCliente(nickname);
                    //control
                    if (siguiendo != null && !siguiendo.isEmpty()) {
                        DefaultListModel<String> model = new DefaultListModel<>();
                        // Agregamos cada nickname al modelo.
                        for (String s : siguiendo) {
                            model.addElement(s);
                        }
                        // Establecemos el modelo al JList.
                        listaSiguiendo.setModel(model);
                    }
                } catch (NoSigueANadie ex) {
                }

            } catch (UsuarioNoExisteException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Consulta Cliente", JOptionPane.ERROR_MESSAGE);
            }

        }
    }

    private void cargarNicknames() {
        List<String> nicknames = null;
        try {
            nicknames = ctrlU.ObtenerNicknamesClientes();

            if (nicknames != null && !nicknames.isEmpty()) {
                DefaultListModel<String> model = new DefaultListModel<>();
                // Agregamos cada nickname al modelo.
                for (String nickname : nicknames) {
                    model.addElement(nickname);
                }
                // Establecemos el modelo al JList.
                listaCliente.setModel(model);
            }
        } catch (NoHayUsuariosEnElSistemaException ex) {

        }
    }

    private void limpiar() {
        txtNick.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtEmail.setText("");
        txtFecha.setText("");

        //LIMPIAR IMAGEN
        //selectedFile = null;
        JLImagen.setIcon(null);
        JLImagen.setText("");

        //LIMPIAR LISTA CLIENTES
        cargarNicknames();

        //LAS OTRAS LISTAS SIGUIEDNO/SEGUIDORES
        DefaultListModel<String> model = new DefaultListModel<>();
        model.addElement("");
        listaSeguidores.setModel(model);
        listaSiguiendo.setModel(model);
        ListaP.setModel(model);
    }

    public void cargarImagen(String ruta) {
        if (ruta != null) {
            ImageIcon icon = new ImageIcon(ruta);
            Image image = icon.getImage().getScaledInstance(JLImagen.getWidth(), JLImagen.getHeight(), Image.SCALE_SMOOTH);
            JLImagen.setIcon(new ImageIcon(image));
        }
    }

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
            java.util.logging.Logger.getLogger(ConsultaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLImagen;
    private javax.swing.JList<String> ListaP;
    private javax.swing.JButton btnAlbum;
    private javax.swing.JButton btnLista;
    private javax.swing.JButton btnTema;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JList<String> listaCliente;
    private javax.swing.JList<String> listaSeguidores;
    private javax.swing.JList<String> listaSiguiendo;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtNick;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
