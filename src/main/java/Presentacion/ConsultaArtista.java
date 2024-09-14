package Presentacion;

import Excepciones.ArtistaSinAlbums;
import Excepciones.NoHayUsuariosEnElSistemaException;
import Excepciones.NoSigueANadie;
import Excepciones.SinSeguidores;
import Excepciones.UsuarioNoExisteException;
import Logica.Artista;
import Logica.Cliente;
import Logica.IControllerUsuario;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ConsultaArtista extends javax.swing.JFrame {
    
    private JFrame principal;
    private IControllerUsuario ctrlU;
    

    public ConsultaArtista(IControllerUsuario Control, JFrame principal) {
        initComponents();
        this.ctrlU = Control;
        this.principal = principal;
        cargarNicknames();
    }

    public ConsultaArtista() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaArtista = new javax.swing.JList<>();
        JLCuenta = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaAlbums = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNickname = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtFechaNac = new javax.swing.JTextField();
        txtBio = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtWeb = new javax.swing.JTextField();
        JLImagen = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        listaSeguidores = new javax.swing.JList<>();
        jLabel10 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jScrollPane3.setViewportView(jTree1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Consulta Artista");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Consulta Artista"));
        jPanel1.setLayout(null);

        jLabel1.setText("Artistas del sistema:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 20, 150, 16);

        listaArtista.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaArtistaValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listaArtista);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(20, 40, 150, 200);

        JLCuenta.setText("Seguidores del Artista: 0");
        jPanel1.add(JLCuenta);
        JLCuenta.setBounds(20, 280, 150, 16);

        listaAlbums.setEnabled(false);
        jScrollPane2.setViewportView(listaAlbums);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(180, 300, 150, 130);

        jLabel3.setText("Nickname:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(180, 40, 135, 16);

        jLabel4.setText("Nombre:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(180, 70, 135, 16);

        jLabel5.setText("Apellido:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(180, 100, 135, 16);

        jLabel6.setText("Email:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(180, 130, 135, 16);

        jLabel7.setText("Fecha de nacimiento:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(180, 160, 135, 16);

        jLabel8.setText("Biografia:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(180, 190, 135, 16);

        txtNickname.setEditable(false);
        jPanel1.add(txtNickname);
        txtNickname.setBounds(320, 30, 170, 26);

        txtNombre.setEditable(false);
        jPanel1.add(txtNombre);
        txtNombre.setBounds(320, 60, 170, 26);

        txtApellido.setEditable(false);
        txtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoActionPerformed(evt);
            }
        });
        jPanel1.add(txtApellido);
        txtApellido.setBounds(320, 90, 170, 26);

        txtEmail.setEditable(false);
        jPanel1.add(txtEmail);
        txtEmail.setBounds(320, 120, 170, 26);

        txtFechaNac.setEditable(false);
        jPanel1.add(txtFechaNac);
        txtFechaNac.setBounds(320, 150, 170, 26);

        txtBio.setEditable(false);
        jPanel1.add(txtBio);
        txtBio.setBounds(320, 180, 170, 26);

        jLabel9.setText("Webgrafia");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(180, 220, 135, 16);

        txtWeb.setEditable(false);
        jPanel1.add(txtWeb);
        txtWeb.setBounds(320, 210, 170, 26);

        JLImagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLImagen.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(JLImagen);
        JLImagen.setBounds(500, 30, 200, 200);

        listaSeguidores.setEnabled(false);
        jScrollPane4.setViewportView(listaSeguidores);

        jPanel1.add(jScrollPane4);
        jScrollPane4.setBounds(20, 300, 150, 130);

        jLabel10.setText("Albums publicados:");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(180, 280, 130, 16);

        jButton1.setText("Atras");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(510, 400, 190, 27);

        jButton2.setText("Cargar Artistas");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(510, 370, 190, 27);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 717, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        setVisible(false);
        principal.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void listaArtistaValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaArtistaValueChanged
        // TODO add your handling code here:
        //SELECCIONA UN TIEM DE LA JLIST THE USUARIOS DEL SISTEMA
        if (!evt.getValueIsAdjusting()) { // Solo reaccionar al cambio final
            String nicknameSeleccionado = listaArtista.getSelectedValue();
            try {
                cargarDatosArtista(nicknameSeleccionado);
            } catch (IOException ex) {

            }
        }
    }//GEN-LAST:event_listaArtistaValueChanged


    private void txtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        limpiar();
        principal.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        cargarNicknames();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultaArtista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaArtista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaArtista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaArtista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaArtista().setVisible(true);
            }
        });
    }

    private void cargarNicknames() {
        List<String> nicknames = null;
        nicknames = ctrlU.obtenerArtistas();
        if (nicknames != null && !nicknames.isEmpty()) {
            DefaultListModel<String> model = new DefaultListModel<>();
            // Agregamos cada nickname al modelo.
            for (String nickname : nicknames) {
                model.addElement(nickname);
            }
            // Establecemos el modelo al JList.
            listaArtista.setModel(model);
        }
    }

    private void cargarDatosArtista(String nickname) throws IOException {
        if (nickname != null && !nickname.isEmpty()) {
            try {
                limpiar(); //limpiar txtfiles imagen y listas
                cargarNicknames();
                Artista a = ctrlU.ObtenerArtista(nickname);
                txtNickname.setText(a.getNickname());
                txtNombre.setText(a.getNombre());
                txtApellido.setText(a.getApellido());
                txtEmail.setText(a.getEmail());
                txtFechaNac.setText(a.getFechaNac());
                txtBio.setText(a.getBiografia());
                txtWeb.setText(a.getWebSite());

                //IMAGEN
                byte[] imagenBytes = a.getImagen(); // Asegúrate de que el método getImagen() retorne el byte[]
                if (imagenBytes != null) {
                    // Convertir los bytes en una imagen
                    InputStream is = new ByteArrayInputStream(imagenBytes);
                    BufferedImage bufferedImage = ImageIO.read(is);

                    // Escalar la imagen para ajustarse al tamaño del JLabel
                    Image scaledImage = bufferedImage.getScaledInstance(JLImagen.getWidth(), JLImagen.getHeight(), Image.SCALE_SMOOTH);

                    // Establecer la imagen en el JLabel
                    JLImagen.setIcon(new ImageIcon(scaledImage));
                } else {
                    JLImagen.setIcon(null); // Si no hay imagen, limpia el JLabel
                }

                //SEGUIDORES 
                try {

                    List<String> seguidores = ctrlU.ObtenerSeguidoresArtista(nickname);
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

                //CONTADOR SEGUIDORES:
                
                Long seguidoresCuenta;
                seguidoresCuenta = ctrlU.ObtenerCuentaSeguidores(nickname);
                String cuenta= "Seguidores del Artista: " + seguidoresCuenta;
                
                JLCuenta.setText(cuenta);
                
                
                //ALBUMS
                try {
                    List<String> albums = ctrlU.ObtenerAlbumsArtista(nickname);
                    //control
                    if (albums != null && !albums.isEmpty()) {
                        DefaultListModel<String> model = new DefaultListModel<>();
                        // Agregamos cada nombre de los albums al modelo.
                        for (String s : albums) {
                            model.addElement(s);
                        }
                        // Establecemos el modelo al JList.
                        listaAlbums.setModel(model);
                    }
                } catch (ArtistaSinAlbums ex) {
                }

            } catch (UsuarioNoExisteException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Consulta Cliente", JOptionPane.ERROR_MESSAGE);
            }

        }
    }

    private void limpiar() {
        txtNickname.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtEmail.setText("");
        txtFechaNac.setText("");
        txtBio.setText("");
        txtWeb.setText("");
        //LIMPIAR IMAGEN
        //selectedFile = null;
        JLImagen.setIcon(null);
        JLImagen.setText("");

        //LIMPIAR LISTA CLIENTES
        cargarNicknames();

        //LAS OTRAS LISTAS SIGUIEDNO/SEGUIDORES
        DefaultListModel<String> model = new DefaultListModel<>();
        model.addElement("");
        listaArtista.setModel(model);
        listaSeguidores.setModel(model);
        listaAlbums.setModel(model);
        JLCuenta.setText("Seguidores del Artista: 0");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLCuenta;
    private javax.swing.JLabel JLImagen;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTree jTree1;
    private javax.swing.JList<String> listaAlbums;
    private javax.swing.JList<String> listaArtista;
    private javax.swing.JList<String> listaSeguidores;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtBio;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFechaNac;
    private javax.swing.JTextField txtNickname;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtWeb;
    // End of variables declaration//GEN-END:variables
}
