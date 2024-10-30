package Presentacion;

import Excepciones.*;
import Logica.*;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AltaUsuario extends javax.swing.JFrame {

    //referencia a la ventana principal:
    private JFrame principal;
    private IControllerUsuario ctrlU;
    private File archivoSeleccionado = null;
    private String rutaDestino = "";
    

    public AltaUsuario(IControllerUsuario Control, JFrame principal) {
        this.ctrlU = Control;
        this.principal = principal;
        initComponents();
        controlNumerico();
    }

    private AltaUsuario() {
        initComponents();
        controlNumerico();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jFileChooser1 = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbArtista = new javax.swing.JCheckBox();
        txtNickname = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtBiografia = new javax.swing.JTextField();
        txtWebsite = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtDia = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        JLImagen = new javax.swing.JLabel();
        txtMes = new javax.swing.JTextField();
        txtAño = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnLimpiar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtContraseña = new javax.swing.JPasswordField();
        txtConfirmar = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Registrar Usuario.");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Usuario"));
        jPanel1.setLayout(null);

        jLabel1.setText("Nickname :");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(11, 29, 80, 16);

        jLabel2.setText("Nombre:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(11, 73, 80, 16);

        jLabel3.setText("Apellido:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 110, 80, 16);

        jLabel4.setText("Email:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(10, 150, 70, 16);

        jLabel5.setText("Biografia:");
        jLabel5.setEnabled(false);
        jPanel1.add(jLabel5);
        jLabel5.setBounds(10, 330, 90, 16);

        jLabel6.setText("Website:");
        jLabel6.setEnabled(false);
        jPanel1.add(jLabel6);
        jLabel6.setBounds(10, 370, 100, 16);

        cbArtista.setText("Artista");
        cbArtista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cbArtistaMousePressed(evt);
            }
        });
        jPanel1.add(cbArtista);
        cbArtista.setBounds(10, 300, 90, 20);
        jPanel1.add(txtNickname);
        txtNickname.setBounds(90, 30, 257, 26);

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        jPanel1.add(txtNombre);
        txtNombre.setBounds(90, 70, 257, 26);
        jPanel1.add(txtApellido);
        txtApellido.setBounds(90, 110, 257, 26);
        jPanel1.add(txtEmail);
        txtEmail.setBounds(90, 150, 257, 26);

        txtBiografia.setEnabled(false);
        jPanel1.add(txtBiografia);
        txtBiografia.setBounds(90, 330, 260, 26);

        txtWebsite.setEnabled(false);
        txtWebsite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtWebsiteActionPerformed(evt);
            }
        });
        jPanel1.add(txtWebsite);
        txtWebsite.setBounds(90, 370, 260, 26);

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar);
        btnAgregar.setBounds(10, 410, 100, 27);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar);
        btnCancelar.setBounds(250, 410, 100, 27);

        jLabel8.setText("Fecha de nacimiento: ");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(10, 190, 160, 16);

        txtDia.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        txtDia.setToolTipText("");
        txtDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiaActionPerformed(evt);
            }
        });
        jPanel1.add(txtDia);
        txtDia.setBounds(140, 190, 41, 24);

        jButton1.setText("Añadir imagen");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(370, 200, 164, 26);

        JLImagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLImagen.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(JLImagen);
        JLImagen.setBounds(370, 30, 164, 164);

        txtMes.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        txtMes.setToolTipText("");
        txtMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMesActionPerformed(evt);
            }
        });
        jPanel1.add(txtMes);
        txtMes.setBounds(220, 190, 41, 24);

        txtAño.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        txtAño.setToolTipText("");
        txtAño.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAñoActionPerformed(evt);
            }
        });
        jPanel1.add(txtAño);
        txtAño.setBounds(310, 190, 40, 24);

        jLabel7.setText("/");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(200, 190, 10, 20);

        jLabel9.setText("/");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(280, 190, 10, 20);

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpiar);
        btnLimpiar.setBounds(130, 410, 100, 27);

        jLabel10.setText("Contraseña:");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(10, 230, 100, 16);

        jLabel11.setText("Confirmar");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(10, 270, 90, 10);

        jLabel12.setText("contraseña:");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(10, 280, 90, 16);
        jPanel1.add(txtContraseña);
        txtContraseña.setBounds(90, 230, 260, 26);

        txtConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtConfirmarActionPerformed(evt);
            }
        });
        jPanel1.add(txtConfirmar);
        txtConfirmar.setBounds(90, 270, 260, 26);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtWebsiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtWebsiteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtWebsiteActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

        //AGREGAR USUARIO BOTON
        String nick = txtNickname.getText();
        //nickname vacio.
        if (nick.isEmpty()) {
            
            JOptionPane.showMessageDialog(this, "El campo Nickname no puede estar vacio. ", "Registrar Cliente", JOptionPane.ERROR_MESSAGE);
        } else {
            String nombre = txtNombre.getText();
            String apellido = txtApellido.getText();
            String email = txtEmail.getText();
            String contraseña = txtContraseña.getText();
            String confirmacion = txtConfirmar.getText();
            
            //control confirmacion de contraseña
            
            if (contraseña.isEmpty() || confirmacion.isEmpty()){
                JOptionPane.showMessageDialog(this, "El campo de contraseña o confirmar contraseña no puede ser vacio", "Registrar Cliente", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (!confirmacion.equals(contraseña)){
                JOptionPane.showMessageDialog(this, "La confirmacion no es igual a la contraseña. ", "Registrar Cliente", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            

            String dia = txtDia.getText();
            String mes = txtMes.getText();
            String año = txtAño.getText();

            if (dia.isEmpty() || mes.isEmpty() || año.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Los campos de la fecha no pueden estar vacíos.", "Registrar Cliente", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Validación de la fecha de nacimiento
            try {
                int diaInt = Integer.parseInt(dia);
                int mesInt = Integer.parseInt(mes);
                int añoInt = Integer.parseInt(año);

                // Validar el rango del mes (1-12)
                if (mesInt < 1 || mesInt > 12) {
                    JOptionPane.showMessageDialog(this, "Mes inválido. Debe estar entre 1 y 12.", "Registrar Cliente", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Validar el rango del día (1-31) según el mes
                if (diaInt < 1 || diaInt > 31) {
                    JOptionPane.showMessageDialog(this, "Día inválido. Debe estar entre 1 y 31.", "Registrar Cliente", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                LocalDate fechaIngresada = LocalDate.of(añoInt, mesInt, diaInt);
                LocalDate fechaActual = LocalDate.now();
                LocalDate fechaLimite = fechaActual.minusYears(200);

                if (fechaIngresada.isAfter(fechaActual)) {
                    JOptionPane.showMessageDialog(this, "La fecha de nacimiento no puede ser en el futuro.", "Registrar Cliente", JOptionPane.ERROR_MESSAGE);
                    return;
                } else if (fechaIngresada.isBefore(fechaLimite)) {
                    JOptionPane.showMessageDialog(this, "La fecha de nacimiento no puede ser mayor a 200 años atrás.", "Registrar Cliente", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (DateTimeParseException | NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Fecha inválida. Verifica los campos.", "Registrar Cliente", JOptionPane.ERROR_MESSAGE);
                return;
            }

            //Al ingresar un usuario la lista de seguidores y siguiendo estara vacia.
            Collection<Usuario> siguiendo = null;
            Collection<Usuario> seguidores = null;

            String fecha = "";
            fecha = fecha.concat(dia + "/" + mes + "/" + año);

            String carpetaDestino = null;
            //RUTA IMAGEN 
            if (archivoSeleccionado != null) {
                carpetaDestino = "src/recursos/imagenes/";
                rutaDestino = carpetaDestino + "FotoUsr_" + nick + ".jpg";
                File destino = new File(rutaDestino);
                File directorio = new File(carpetaDestino);
                if (!directorio.exists()) {
                    directorio.mkdirs();
                }       
                try {
                    Files.copy(archivoSeleccionado.toPath(), destino.toPath(), StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException ex) {
                    Logger.getLogger(AltaUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            
            if (cbArtista.isSelected()) {
                //datos artistas
                String bio = txtBiografia.getText();
                String web = txtWebsite.getText();
                
                try {
                    ctrlU.registrarArtista(nick, nombre, apellido, email, rutaDestino, fecha, siguiendo, seguidores, bio, web, contraseña);
                    limpiar();
                    JOptionPane.showMessageDialog(this, "El Artista se ha creado con éxito", "Registrar Artista", JOptionPane.INFORMATION_MESSAGE);
                } catch (UsuarioYaExisteException ex) { //MENSAJE DE ERROR
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Registrar Artista", JOptionPane.ERROR_MESSAGE);
                } catch (EmailYaExiste ex) { //MENSAJE DE ERROR
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Registrar Artista", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                //datos clientes
                
                try {
                    ctrlU.registrarCliente(nick, nombre, apellido, email, rutaDestino, fecha, siguiendo, seguidores, contraseña);
                    limpiar();
                    JOptionPane.showMessageDialog(this, "El Cliente se ha creado con éxito", "Registrar Cliente", JOptionPane.INFORMATION_MESSAGE);
                } catch (UsuarioYaExisteException ex) { //MENSAJE DE ERROR
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Registrar Cliente", JOptionPane.ERROR_MESSAGE);
                } catch (EmailYaExiste ex) { //MENSAJE DE ERROR
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Registrar Cliente", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void cbArtistaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbArtistaMousePressed
        //CHECKBOX ARTISTA
        if (cbArtista.isSelected()) {
            jLabel5.setEnabled(false);
            jLabel6.setEnabled(false);
            txtBiografia.setEnabled(false);
            txtBiografia.setText("");
            txtWebsite.setEnabled(false);
            txtWebsite.setText("");
        } else {
            jLabel5.setEnabled(true);
            jLabel6.setEnabled(true);
            txtBiografia.setEnabled(true);
            txtWebsite.setEnabled(true);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_cbArtistaMousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccionar Imagen");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Imágenes", "jpg", "png", "jpeg");
        fileChooser.setFileFilter(filter);
        int seleccion = fileChooser.showOpenDialog(null);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            archivoSeleccionado = fileChooser.getSelectedFile();
            //String ruta = "FotoUsr " + archivoSeleccionado.getName();
            
            ImageIcon icon = new ImageIcon(archivoSeleccionado.getAbsolutePath());
            Image image = icon.getImage().getScaledInstance(JLImagen.getWidth(), JLImagen.getHeight(), Image.SCALE_SMOOTH);
            JLImagen.setIcon(new ImageIcon(image));

        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiaActionPerformed

    private void txtMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMesActionPerformed

    private void txtAñoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAñoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAñoActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        //BOTON LIMPIAR
        limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        AltaUsuario.this.setVisible(false);  // Ocultar AltaUsuario
        principal.setVisible(true);  // Mostrar la ventana principal
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        //Cerrar ventana 
        setVisible(false);
        principal.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void txtConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConfirmarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtConfirmarActionPerformed

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
            java.util.logging.Logger.getLogger(AltaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AltaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AltaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AltaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AltaUsuario().setVisible(true);
            }
        });
    }

    private void controlNumerico() { //para que no ingrese valores no numeros a la fecha nacimiento.

        KeyAdapter n = new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();  // Si no es un número no toma el valor ingresado
                }
            }
        };
        txtDia.addKeyListener(n);
        txtMes.addKeyListener(n);
        txtAño.addKeyListener(n);

        txtDia.setDocument(new PlainDocument() {
            @Override
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
                if ((getLength() + str.length()) <= 2) {
                    super.insertString(offs, str, a);
                }
            }
        });

        txtMes.setDocument(new PlainDocument() {
            @Override
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
                if ((getLength() + str.length()) <= 2) {
                    super.insertString(offs, str, a);
                }
            }
        });

        txtAño.setDocument(new PlainDocument() {
            @Override
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
                if ((getLength() + str.length()) <= 4) {
                    super.insertString(offs, str, a);
                }
            }
        });
    }

    private void limpiar() {
        txtNickname.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtEmail.setText("");
        txtDia.setText("");
        txtMes.setText("");
        txtAño.setText("");
        txtBiografia.setText("");
        txtWebsite.setText("");
        txtContraseña.setText("");
        txtConfirmar.setText("");
        
        //IMAGEN
        archivoSeleccionado = null;
        JLImagen.setIcon(null);
        JLImagen.setText("");
    }

    //cerrar ventana para que simplemente la oculte.

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLImagen;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox cbArtista;
    private javax.swing.JButton jButton1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtAño;
    private javax.swing.JTextField txtBiografia;
    private javax.swing.JPasswordField txtConfirmar;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtDia;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMes;
    private javax.swing.JTextField txtNickname;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtWebsite;
    // End of variables declaration//GEN-END:variables
}
