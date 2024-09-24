package Presentacion;

import Main.LaboratorioPA;
import Excepciones.*;
import Logica.IControllerMusica;
import LogicaDTO.DTOAlbum;
import LogicaDTO.DTOTema;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

public class AltaAlbum extends javax.swing.JFrame {
    private JFrame principal;
    private IControllerMusica controlMus;
    private File selectedFile = null;
    private String rutaDestino = null;
    private int ubicacion = 1;
    private Set<DTOTema> temasDTO = new HashSet<>();
    private DefaultTreeModel modelo;
    private DefaultListModel<String> listModel;
    private DefaultListModel<String> modeloLT;
    private DTOAlbum albumDTO;
    
    public AltaAlbum(IControllerMusica icm, JFrame principal) {
        controlMus = icm;
        this.principal = principal;
        initComponents();
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        listModel = new DefaultListModel<>();
        modeloLT = new DefaultListModel<>();
        jGenerosSeleccionados.setModel(listModel);
        jListTemas.setModel(modeloLT);
        cargarArbol();
    }
    
    public AltaAlbum() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButtonEnviar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jGenerosSeleccionados = new javax.swing.JList<>();
        jLabelImagen = new javax.swing.JLabel();
        jButtonImagen = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTreeGeneros = new javax.swing.JTree();
        jLabelAnioAlbum = new javax.swing.JLabel();
        jLabelArtista = new javax.swing.JLabel();
        jLabelNombreAlbum = new javax.swing.JLabel();
        jTextFieldNombreAlbum = new javax.swing.JTextField();
        jTextFieldNombreArtista = new javax.swing.JTextField();
        jTextFieldAnio = new javax.swing.JTextField();
        jButtonUpdate = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButtonFinalizar = new javax.swing.JButton();
        jButtonAddTema = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListTemas = new javax.swing.JList<>();
        jTextFieldLinkT = new javax.swing.JTextField();
        jLabelEnlaceT = new javax.swing.JLabel();
        jLabelDuracionT = new javax.swing.JLabel();
        jTextFieldDuracionT = new javax.swing.JTextField();
        jLabelNombreTema = new javax.swing.JLabel();
        jTextFieldNombreT = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Alta Album");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Album"));

        jButtonEnviar.setText("Aceptar");
        jButtonEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEnviarActionPerformed(evt);
            }
        });

        jGenerosSeleccionados.setBorder(javax.swing.BorderFactory.createTitledBorder("Generos Album"));
        jGenerosSeleccionados.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jGenerosSeleccionados);

        jLabelImagen.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabelImagen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jButtonImagen.setText("Añadir Imagen");
        jButtonImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImagenActionPerformed(evt);
            }
        });

        jTreeGeneros.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista Generos"));
        jTreeGeneros.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                jTreeGenerosValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(jTreeGeneros);

        jLabelAnioAlbum.setText("Año");

        jLabelArtista.setText("Artista");

        jLabelNombreAlbum.setText("Nombre");

        jButtonUpdate.setText("Update");
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonEnviar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelArtista)
                                    .addComponent(jLabelNombreAlbum)
                                    .addComponent(jLabelAnioAlbum))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldAnio)
                                    .addComponent(jTextFieldNombreAlbum)
                                    .addComponent(jTextFieldNombreArtista, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelImagen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonImagen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldNombreArtista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelArtista))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldNombreAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelNombreAlbum))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelAnioAlbum))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonImagen)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonUpdate)
                    .addComponent(jButtonEnviar))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Alta Tema"));

        jButtonFinalizar.setText("Finalizar");
        jButtonFinalizar.setEnabled(false);
        jButtonFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFinalizarActionPerformed(evt);
            }
        });

        jButtonAddTema.setText("Añadir");
        jButtonAddTema.setEnabled(false);
        jButtonAddTema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddTemaActionPerformed(evt);
            }
        });

        jListTemas.setBorder(javax.swing.BorderFactory.createTitledBorder("Temas Album"));
        jListTemas.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jListTemas.setEnabled(false);
        jScrollPane1.setViewportView(jListTemas);

        jTextFieldLinkT.setEnabled(false);

        jLabelEnlaceT.setText("Link:");
        jLabelEnlaceT.setEnabled(false);

        jLabelDuracionT.setText("Duracion:");
        jLabelDuracionT.setEnabled(false);

        jTextFieldDuracionT.setEnabled(false);

        jLabelNombreTema.setText("Nombre:");
        jLabelNombreTema.setEnabled(false);

        jTextFieldNombreT.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabelDuracionT)
                                .addComponent(jLabelEnlaceT, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabelNombreTema, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldNombreT)
                            .addComponent(jTextFieldDuracionT)
                            .addComponent(jTextFieldLinkT, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAddTema, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonFinalizar)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNombreTema)
                    .addComponent(jTextFieldNombreT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDuracionT)
                    .addComponent(jTextFieldDuracionT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldLinkT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEnlaceT))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonAddTema)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonFinalizar)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEnviarActionPerformed
        String nicknameArtista = this.jTextFieldNombreArtista.getText();
        String titulo = this.jTextFieldNombreAlbum.getText();
        int anio = 0;
        try {
            anio = Integer.parseInt(jTextFieldAnio.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El texto no es un valor válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Set<String> generos = new HashSet();
        DefaultListModel<String> listModel = (DefaultListModel<String>) jGenerosSeleccionados.getModel();
        for(int i = 0; i < listModel.getSize();i++){
            generos.add(listModel.getElementAt(i));
        }
        
        if (checkFormulario()) {
            if(!controlMus.existeAlbum(nicknameArtista,titulo)){
                albumDTO = new DTOAlbum(titulo,anio, rutaDestino, nicknameArtista, generos, null);     
            habilitarFormTemas();
            }else{
                JOptionPane.showMessageDialog(this, "El artista ya tiene un album con ese titulo.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
    }//GEN-LAST:event_jButtonEnviarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        setVisible(false);
        principal.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void jButtonImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImagenActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccionar Imagen");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Imágenes", "jpg", "png", "jpeg");
        fileChooser.setFileFilter(filter);
        int seleccion = fileChooser.showOpenDialog(null);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = fileChooser.getSelectedFile();
            String ruta = LaboratorioPA.CARPETA_IMAGEN + archivoSeleccionado.getName();
            File destino = new File(ruta);
            try{
            Files.copy(archivoSeleccionado.toPath(), destino.toPath(),StandardCopyOption.REPLACE_EXISTING);
            ImageIcon icon = new ImageIcon(destino.getAbsolutePath());
            Image image = icon.getImage().getScaledInstance(jLabelImagen.getWidth(), jLabelImagen.getHeight(), Image.SCALE_SMOOTH);
            jLabelImagen.setIcon(new ImageIcon(image));
            rutaDestino = destino.getAbsolutePath();
            } catch (IOException ex) {
                Logger.getLogger(AltaUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jButtonImagenActionPerformed

    private void jTreeGenerosValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_jTreeGenerosValueChanged
        DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) jTreeGeneros.getLastSelectedPathComponent();
        if(nodo != null){
            String nuevoItem = nodo.toString();
            if(listModel.contains(nuevoItem)){
                listModel.removeElement(nuevoItem);
            }else{
                listModel.addElement(nuevoItem);
            }
        }
    }//GEN-LAST:event_jTreeGenerosValueChanged

    private void jButtonAddTemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddTemaActionPerformed
        String nombre = this.jTextFieldNombreT.getText();
        String duracion = this.jTextFieldDuracionT.getText();
        String enlace = this.jTextFieldLinkT.getText();
        if(checkFormularioTema()){
            DTOTema nuevoTema = new DTOTema(nombre,duracion,enlace,ubicacion);
            boolean existe = false;
            for(DTOTema tema : temasDTO){
                if(tema.getNombre().equalsIgnoreCase(nombre)){
                    existe = true;
                    break;
                }
            }
            if(!existe){
                temasDTO.add(nuevoTema);
                ubicacion++;
                modeloLT.addElement(nuevoTema.getNombre());
                limpiarFormTemas();
                jButtonFinalizar.setEnabled(true);
            }else{
                JOptionPane.showMessageDialog(this, "Ya existe un tema con ese nombre", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButtonAddTemaActionPerformed

    private void jButtonFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFinalizarActionPerformed
         try{
                controlMus.altaAlbum(albumDTO, temasDTO);
                JOptionPane.showMessageDialog(this, "El Album se ha creado exitosamente","Alta Album",JOptionPane.INFORMATION_MESSAGE);
                if (albumDTO != null && albumDTO.getTemas() != null) {
                    albumDTO.getTemas().clear();
                }
                if (temasDTO != null) {
                    temasDTO.clear();
                }
           }catch(AlbumYaExisteException e){
               JOptionPane.showMessageDialog(this, e.getMessage(), "Alta Album", JOptionPane.ERROR_MESSAGE);
            } catch (UsuarioNoExisteException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Alta Album", JOptionPane.ERROR_MESSAGE);
            }  
        JOptionPane.showMessageDialog(this, "Transaccion realizada exitosamente","Alta Album",JOptionPane.INFORMATION_MESSAGE);
        limpiarFormulario();
        limpiarFormTemas();
        deshabilitarFormTemas();
    }//GEN-LAST:event_jButtonFinalizarActionPerformed

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        cargarArbol();
    }//GEN-LAST:event_jButtonUpdateActionPerformed

    private boolean checkFormulario() {
        String artista = this.jTextFieldNombreArtista.getText();
        String album = this.jTextFieldNombreAlbum.getText();
        String anio = this.jTextFieldAnio.getText();
        if (artista.isEmpty() || album.isEmpty() || anio.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Alta Album",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            int anioInt =  Integer.parseInt(anio);
            if(anioInt < 1800 || anioInt > java.time.Year.now().getValue()){
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Año debe ser un numero valido", "Alta Album",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    private boolean checkFormularioTema() {
        String nombre = this.jTextFieldNombreT.getText();
        String duracion = this.jTextFieldDuracionT.getText();
        String enlace = this.jTextFieldLinkT.getText();

        if (nombre.isEmpty() || duracion.isEmpty() || enlace.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Alta Tema", JOptionPane.ERROR_MESSAGE);
            return false;
        }
//        if(!checkLink(enlace)){
//            JOptionPane.showMessageDialog(this, "Enlace no valido", "Alta Tema", JOptionPane.ERROR_MESSAGE);
//            return false;
//        }
        return true;
    }
    
//    private boolean checkLink(String enlace) {
//        String formato = "^(https?|ftp)?://[^\\s/$.?#]+\\.[^\\s/$.?#]+.*[^\\s]*$";
//        return enlace.matches(formato);
//    }

    private void limpiarFormulario() {
        jTextFieldNombreArtista.setText("");
        jTextFieldNombreAlbum.setText("");
        jTextFieldAnio.setText("");
        jTextFieldNombreT.setText("");
        jTextFieldDuracionT.setText("");
        jTextFieldLinkT.setText("");
        DefaultListModel<String> listModel = (DefaultListModel<String>) jGenerosSeleccionados.getModel();
        listModel.clear();
        rutaDestino = null;
    }
    
    private void limpiarFormTemas() {
        jTextFieldNombreT.setText("");
        jTextFieldDuracionT.setText("");
        jTextFieldLinkT.setText("");
    }
    
    private void cargarArbol(){
        modelo= new DefaultTreeModel((TreeNode) controlMus.DameTodoslosgeneros());       
        if(modelo==null){
            JOptionPane.showMessageDialog(null,"No existe ningun genero, porfavor cree alguno");
        }else{
            jTreeGeneros.setModel(modelo);
        }
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AltaAlbum().setVisible(true);
            }
        });
    }
    
    private void habilitarFormTemas() {
        jButtonAddTema.setEnabled(true); 
        jLabelDuracionT.setEnabled(true); 
        jLabelEnlaceT.setEnabled(true); 
        jLabelNombreTema.setEnabled(true); 
        jListTemas.setEnabled(true);  
        jTextFieldDuracionT.setEnabled(true); 
        jTextFieldLinkT.setEnabled(true); 
        jTextFieldNombreT.setEnabled(true);        
        jButtonEnviar.setEnabled(false);
        jButtonImagen.setEnabled(false);
        jGenerosSeleccionados.setEnabled(false);
        jLabelAnioAlbum.setEnabled(false);
        jLabelArtista.setEnabled(false);
        jLabelImagen.setEnabled(false);
        jLabelNombreAlbum.setEnabled(false);
        jTextFieldAnio.setEnabled(false);
        jTextFieldNombreAlbum.setEnabled(false);
        jTextFieldNombreArtista.setEnabled(false);
        jTreeGeneros.setEnabled(false);
        jButtonUpdate.setEnabled(false); 
    }
    
    private void deshabilitarFormTemas() {
        jButtonAddTema.setEnabled(false); 
        jLabelDuracionT.setEnabled(false); 
        jLabelEnlaceT.setEnabled(false); 
        jLabelNombreTema.setEnabled(false); 
        jListTemas.setEnabled(false);  
        jTextFieldDuracionT.setEnabled(false); 
        jTextFieldLinkT.setEnabled(false); 
        jTextFieldNombreT.setEnabled(false);        
        jButtonEnviar.setEnabled(true);
        jButtonImagen.setEnabled(true);
        jGenerosSeleccionados.setEnabled(true);
        jLabelAnioAlbum.setEnabled(true);
        jLabelArtista.setEnabled(true);
        jLabelImagen.setEnabled(true);
        jLabelNombreAlbum.setEnabled(true);
        jTextFieldAnio.setEnabled(true);
        jTextFieldNombreAlbum.setEnabled(true);
        jTextFieldNombreArtista.setEnabled(true);
        jTreeGeneros.setEnabled(true);
        jButtonUpdate.setEnabled(true); 
        jButtonFinalizar.setEnabled(false);
        jLabelImagen.setIcon(null);
        DefaultListModel<String> listModel = (DefaultListModel<String>) jListTemas.getModel();
        listModel.clear();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddTema;
    private javax.swing.JButton jButtonEnviar;
    private javax.swing.JButton jButtonFinalizar;
    private javax.swing.JButton jButtonImagen;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JList<String> jGenerosSeleccionados;
    private javax.swing.JLabel jLabelAnioAlbum;
    private javax.swing.JLabel jLabelArtista;
    private javax.swing.JLabel jLabelDuracionT;
    private javax.swing.JLabel jLabelEnlaceT;
    private javax.swing.JLabel jLabelImagen;
    private javax.swing.JLabel jLabelNombreAlbum;
    private javax.swing.JLabel jLabelNombreTema;
    private javax.swing.JList<String> jListTemas;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextFieldAnio;
    private javax.swing.JTextField jTextFieldDuracionT;
    private javax.swing.JTextField jTextFieldLinkT;
    private javax.swing.JTextField jTextFieldNombreAlbum;
    private javax.swing.JTextField jTextFieldNombreArtista;
    private javax.swing.JTextField jTextFieldNombreT;
    private javax.swing.JTree jTreeGeneros;
    // End of variables declaration//GEN-END:variables
}