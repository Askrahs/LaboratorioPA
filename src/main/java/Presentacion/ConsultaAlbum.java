package Presentacion;

import Logica.IControllerMusica;
import Logica.IControllerUsuario;
import LogicaDTO.DTOAlbum;
import LogicaDTO.DTOTema;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

public class ConsultaAlbum extends javax.swing.JFrame {
    private JFrame principal;
    private IControllerMusica controlMus;
    private IControllerUsuario controlUsr;
    private DefaultTreeModel modelo;
    private DefaultListModel<String> listModel;
    private List<String> artistas;
    
    public ConsultaAlbum(IControllerUsuario iusr, IControllerMusica icm, JFrame principal){
        controlUsr = iusr;
        controlMus = icm;
        this.principal = principal;
        initComponents();
        listModel = new DefaultListModel<>();
        jListArtistas.setModel(listModel);
        this.setBounds(100, 100, 660, 500);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }
    public ConsultaAlbum() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButtonGenero = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldNombreA = new javax.swing.JTextField();
        jTextFieldAnioA = new javax.swing.JTextField();
        jTextFieldGenerosA = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListTemasAlbum = new javax.swing.JList<>();
        jPanelImagenAlbum = new javax.swing.JPanel();
        jLabelBuscar = new javax.swing.JLabel();
        jButtonArista = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTreeGeneros = new javax.swing.JTree();
        jScrollPane4 = new javax.swing.JScrollPane();
        jListAlbums = new javax.swing.JList<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListArtistas = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Consulta de Album");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Consulta de Álbum"));

        jButtonGenero.setText("Genero");
        jButtonGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGeneroActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Información del Álbum"));

        jLabel1.setText("Nombre:");

        jLabel2.setText("Año:");

        jLabel4.setText("Géneros:");

        jTextFieldNombreA.setEditable(false);

        jTextFieldAnioA.setEditable(false);

        jTextFieldGenerosA.setEditable(false);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Temas del Álbum"));

        jScrollPane2.setViewportView(jListTemasAlbum);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanelImagenAlbum.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanelImagenAlbumLayout = new javax.swing.GroupLayout(jPanelImagenAlbum);
        jPanelImagenAlbum.setLayout(jPanelImagenAlbumLayout);
        jPanelImagenAlbumLayout.setHorizontalGroup(
            jPanelImagenAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 126, Short.MAX_VALUE)
        );
        jPanelImagenAlbumLayout.setVerticalGroup(
            jPanelImagenAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 126, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldGenerosA, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldAnioA, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldNombreA, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanelImagenAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 54, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextFieldNombreA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextFieldAnioA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldGenerosA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addComponent(jPanelImagenAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabelBuscar.setText("Buscar según:");

        jButtonArista.setText("Artista");
        jButtonArista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAristaActionPerformed(evt);
            }
        });

        jTreeGeneros.setBorder(javax.swing.BorderFactory.createTitledBorder("Generos"));
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Generos");
        jTreeGeneros.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jTreeGeneros.setToolTipText("");
        jTreeGeneros.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                jTreeGenerosValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(jTreeGeneros);

        jListAlbums.setBorder(javax.swing.BorderFactory.createTitledBorder("Album"));
        jListAlbums.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListAlbumsValueChanged(evt);
            }
        });
        jScrollPane4.setViewportView(jListAlbums);

        jListArtistas.setBorder(javax.swing.BorderFactory.createTitledBorder("Artistas"));
        jListArtistas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListArtistas.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListArtistasValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jListArtistas);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                        .addGap(24, 24, 24))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane3)
                                .addComponent(jButtonGenero, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButtonArista, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonGenero)
                            .addComponent(jButtonArista))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4)))
                .addContainerGap())
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

        jPanel1.getAccessibleContext().setAccessibleName("Consulta de Album");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.setVisible(false);
        principal.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void jListArtistasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListArtistasValueChanged
        if (!evt.getValueIsAdjusting()) {
                String artistaSeleccionado = jListArtistas.getSelectedValue();
                if (artistaSeleccionado != null) {
                    List<String> albumsA = controlMus.obtenerAlbumsPorArtista(artistaSeleccionado);
                    if (!(jListAlbums.getModel() instanceof DefaultListModel)) {
                        jListAlbums.setModel(new DefaultListModel<>());
                    }
                    DefaultListModel<String> albumListModel = (DefaultListModel<String>) jListAlbums.getModel();
                    albumListModel.clear();
                    jListAlbums.clearSelection();
                    for (String album : albumsA) {
                        albumListModel.addElement(album);
                    }
                    jListAlbums.clearSelection();
                }
        }
    }//GEN-LAST:event_jListArtistasValueChanged

    private void jTreeGenerosValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_jTreeGenerosValueChanged
        DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) jTreeGeneros.getLastSelectedPathComponent();
        if (nodo != null) {
            String generoSeleccionado = nodo.toString();
            List<String> albumsG = controlMus.obtenerAlbumsPorGenero(generoSeleccionado);
            if (!(jListAlbums.getModel() instanceof DefaultListModel)) {
                jListAlbums.setModel(new DefaultListModel<>());
            }
            DefaultListModel<String> albumListModel = (DefaultListModel<String>) jListAlbums.getModel();
            albumListModel.clear();
            for (String album : albumsG) {
                albumListModel.addElement(album);
            }
        }
    }//GEN-LAST:event_jTreeGenerosValueChanged

    private void jButtonAristaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAristaActionPerformed
        artistas = controlUsr.obtenerArtistas();
        DefaultListModel<String> listModel = (DefaultListModel<String>) jListArtistas.getModel();
        listModel.clear();
        for (String s : artistas) {
            listModel.addElement(s);
        }
    }//GEN-LAST:event_jButtonAristaActionPerformed

    private void jButtonGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGeneroActionPerformed
        modelo= new DefaultTreeModel((TreeNode) controlMus.DameTodoslosgeneros());
        if(modelo==null){
            JOptionPane.showMessageDialog(null,"No existe ningun genero, porfavor cree alguno");
        }else{
            jTreeGeneros.setModel(modelo);
        }
    }//GEN-LAST:event_jButtonGeneroActionPerformed

    private void jListAlbumsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListAlbumsValueChanged
        String albumSeleccionado = jListAlbums.getSelectedValue();
        if(albumSeleccionado != null){
            DTOAlbum albDTO = controlMus.consultaAlbumPorTitulo(albumSeleccionado);
            if(albDTO != null){
                jTextFieldNombreA.setText(albDTO.getTitulo());
                jTextFieldGenerosA.setText(String.join(", ", albDTO.getGeneros()));
                jTextFieldAnioA.setText(String.valueOf(albDTO.getAnio()));

                if (!(jListTemasAlbum.getModel() instanceof DefaultListModel)) {
                       jListTemasAlbum.setModel(new DefaultListModel<>());
                }
                DefaultListModel<String> temaListModel = (DefaultListModel<String>) jListTemasAlbum.getModel();
                temaListModel.clear();
                for (DTOTema tema : albDTO.getTemas()) {
                    String st = tema.getNombre()+" | "+tema.getDuracion()+" | "+tema.getEnlace()+" | "+tema.getPosicion();
                    temaListModel.addElement(st);
                }
            }
        }else{
                jTextFieldNombreA.setText("");
                jTextFieldGenerosA.setText("");
                jTextFieldAnioA.setText("");
                DefaultListModel<String> temaListModel = (DefaultListModel<String>) jListTemasAlbum.getModel();
                temaListModel.clear();
        }
    }//GEN-LAST:event_jListAlbumsValueChanged

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
            java.util.logging.Logger.getLogger(ConsultaAlbum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaAlbum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaAlbum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaAlbum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaAlbum().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonArista;
    private javax.swing.JButton jButtonGenero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelBuscar;
    private javax.swing.JList<String> jListAlbums;
    private javax.swing.JList<String> jListArtistas;
    private javax.swing.JList<String> jListTemasAlbum;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelImagenAlbum;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTextFieldAnioA;
    private javax.swing.JTextField jTextFieldGenerosA;
    private javax.swing.JTextField jTextFieldNombreA;
    private javax.swing.JTree jTreeGeneros;
    // End of variables declaration//GEN-END:variables
}