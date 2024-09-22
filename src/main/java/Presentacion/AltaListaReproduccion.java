package Presentacion;

import Excepciones.ListaYaExisteException;
import Excepciones.UsuarioNoExisteException;
import Logica.*;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class AltaListaReproduccion extends javax.swing.JFrame {
    private JFrame principal;
    private IControllerMusica controlMus;
    private String rutadestino = CARPETA_IMAGEN;
    private IControllerUsuario ctrlU;
    public AltaListaReproduccion(IControllerUsuario icu,IControllerMusica icm, JFrame principal) {
         controlMus = icm;
         ctrlU = icu;
        this.principal = principal;
        initComponents();
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }
        
    public AltaListaReproduccion() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jToggleButtonAceptar = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldNombreLista = new javax.swing.JTextField();
        jCheckBoxPrivada = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldGenero = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldDuenio = new javax.swing.JTextField();
        jButtonAniadirImagen = new javax.swing.JButton();
        jLabelImagen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Alta de Lista de Reproduccion"));

        jToggleButtonAceptar.setText("Aceptar");
        jToggleButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonAceptarActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre:");

        jCheckBoxPrivada.setText("Particular");
        jCheckBoxPrivada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxPrivadaActionPerformed(evt);
            }
        });

        jLabel2.setText("Genero:");

        jLabel3.setText("Nickname Dueño:");

        jTextFieldDuenio.setEnabled(false);

        jButtonAniadirImagen.setText("Añadir Imagen");
        jButtonAniadirImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAniadirImagenActionPerformed(evt);
            }
        });

        jLabelImagen.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabelImagen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBoxPrivada)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldGenero)
                                    .addComponent(jTextFieldNombreLista, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                    .addComponent(jTextFieldDuenio))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jToggleButtonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                        .addComponent(jButtonAniadirImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jCheckBoxPrivada)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextFieldNombreLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldDuenio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButtonAceptar)
                    .addComponent(jButtonAniadirImagen))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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

    private void jCheckBoxPrivadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxPrivadaActionPerformed
       if(jCheckBoxPrivada.isSelected()){
        jTextFieldDuenio.setEnabled(true);
        jTextFieldGenero.setEnabled(false);
        jTextFieldGenero.setText("");
       }else{
        jTextFieldDuenio.setEnabled(false);
        jTextFieldGenero.setEnabled(true);
        jTextFieldDuenio.setText("");
       }
    }//GEN-LAST:event_jCheckBoxPrivadaActionPerformed

    private void jToggleButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonAceptarActionPerformed
        if (checkFormulario()) {
    try {
        String nombre = jTextFieldNombreLista.getText();
        String genero = jTextFieldGenero.getText();
        String duenio = jTextFieldDuenio.getText();
        boolean esPrivada = jCheckBoxPrivada.isSelected();

        // Verificamos si la lista es privada y si el dueño existe
        if (esPrivada) {
            Cliente c = ctrlU.ObtenerCliente(duenio);
            if (c == null || c.getNombre() == null) {
                JOptionPane.showMessageDialog(null, "El cliente especificado no existe");
                return;
            }
        }

        controlMus.altaListaReproduccion(nombre, genero, duenio, rutadestino, esPrivada);
        limpiarFormulario();
        
    } catch (ListaYaExisteException e) {
        JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } catch (UsuarioNoExisteException ex) {
        Logger.getLogger(AltaListaReproduccion.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    }//GEN-LAST:event_jToggleButtonAceptarActionPerformed

    private void jButtonAniadirImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAniadirImagenActionPerformed
     JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccionar Imagen");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Imágenes", "jpg", "png", "jpeg");
        fileChooser.setFileFilter(filter);
        int seleccion = fileChooser.showOpenDialog(null);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = fileChooser.getSelectedFile();
            String ruta = "D:/Netbeans/EspotifyBD/" + archivoSeleccionado.getName();
            File destino = new File(ruta);
            try{
            Files.copy(archivoSeleccionado.toPath(), destino.toPath(),StandardCopyOption.REPLACE_EXISTING);
            ImageIcon icon = new ImageIcon(destino.getAbsolutePath());
            Image image = icon.getImage().getScaledInstance(jLabelImagen.getWidth(), jLabelImagen.getHeight(), Image.SCALE_SMOOTH);
            jLabelImagen.setIcon(new ImageIcon(image));
            rutadestino = destino.getAbsolutePath();
            } catch (IOException ex) {
                Logger.getLogger(AltaUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jButtonAniadirImagenActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.setVisible(false);
        principal.setVisible(true);
    }//GEN-LAST:event_formWindowClosing
 
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AltaListaReproduccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AltaListaReproduccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AltaListaReproduccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AltaListaReproduccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AltaListaReproduccion().setVisible(true);
            }
        });
    }
     private boolean checkFormulario() {
        String nombre = this.jTextFieldNombreLista.getText();
        String genero = this.jTextFieldGenero.getText();
        String duenio = this.jTextFieldDuenio.getText();

        if (nombre.isEmpty() || (genero.isEmpty() && duenio.isEmpty())) {
            JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Alta Lista",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }

    // Permite borrar el contenido de un formulario antes de cerrarlo.
    // Recordar que las ventanas no se destruyen, sino que simplemente 
    // se ocultan, por lo que conviene borrar la información para que 
    // no aparezca al mostrarlas nuevamente.
    private void limpiarFormulario() {
        jTextFieldNombreLista.setText("");
        jTextFieldGenero.setText("");
       jTextFieldDuenio.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonAniadirImagen;
    private javax.swing.JCheckBox jCheckBoxPrivada;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelImagen;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JTextField jTextFieldDuenio;
    private javax.swing.JTextField jTextFieldGenero;
    private javax.swing.JTextField jTextFieldNombreLista;
    private javax.swing.JToggleButton jToggleButtonAceptar;
    // End of variables declaration//GEN-END:variables
}
