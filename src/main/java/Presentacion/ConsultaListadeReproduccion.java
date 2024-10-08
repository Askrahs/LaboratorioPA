package Presentacion;

import Logica.IControllerMusica;
import Logica.IControllerUsuario;
import LogicaDTO.DTOLista;
import LogicaDTO.DTOTema;
import java.awt.Image;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

public class ConsultaListadeReproduccion extends javax.swing.JFrame {
    
    private JFrame principal;
    private IControllerMusica controlMus;
    private IControllerUsuario controlUsr;
    private DefaultTreeModel modelo;
    private DefaultListModel<String> listModel;
    private List<String> clientes;
    private String Busqueda;
    private String generoSeleccionado;

    public ConsultaListadeReproduccion(IControllerUsuario iusr, IControllerMusica icm, JFrame principal){
        controlUsr = iusr;
        controlMus = icm;
        this.principal = principal;
        initComponents();
        limpiarPantalla();
        listModel = new DefaultListModel<>();
        jListclientes.setModel(listModel);
        this.setBounds(100, 100, 660, 500);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }
    
    public ConsultaListadeReproduccion() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTreeGeneros = new javax.swing.JTree();
        jLabel1 = new javax.swing.JLabel();
        jButtonGeneros1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListclientes = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        jListListas = new javax.swing.JList<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldNombreL = new javax.swing.JTextField();
        jTextFieldGeneroL = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListTemasLista = new javax.swing.JList<>();
        jLabelImagen = new javax.swing.JLabel();
        jButtonSalir1 = new javax.swing.JButton();
        jButtonClientes2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Consulta Lista de Reproduccion");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Consultar Lista de Reproduccion"));

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

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel1.setText("Buscar Segun");

        jButtonGeneros1.setText("Generos");
        jButtonGeneros1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGeneros1ActionPerformed(evt);
            }
        });

        jListclientes.setBorder(javax.swing.BorderFactory.createTitledBorder("Clientes"));
        jListclientes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListclientes.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListclientesValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jListclientes);

        jListListas.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista"));
        jListListas.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListListasValueChanged(evt);
            }
        });
        jScrollPane4.setViewportView(jListListas);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Información de la Lista"));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel2.setText("Nombre de lista");

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel4.setText("Genero  de lista");

        jTextFieldNombreL.setEditable(false);
        jTextFieldNombreL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreLActionPerformed(evt);
            }
        });

        jTextFieldGeneroL.setEditable(false);
        jTextFieldGeneroL.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Temas de  la Lista"));

        jScrollPane2.setViewportView(jListTemasLista);

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
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabelImagen.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButtonSalir1.setText("Salir");
        jButtonSalir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalir1ActionPerformed(evt);
            }
        });

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
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldNombreL, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                                    .addComponent(jTextFieldGeneroL)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(jLabel4))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jLabel2)))
                        .addGap(42, 42, 42)
                        .addComponent(jLabelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 23, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonSalir1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNombreL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldGeneroL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addComponent(jLabelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonSalir1)
                .addContainerGap())
        );

        jButtonClientes2.setText("Clientes");
        jButtonClientes2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClientes2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jLabel1))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jButtonGeneros1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonClientes2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(31, 31, 31)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonGeneros1)
                    .addComponent(jButtonClientes2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                .addGap(22, 22, 22))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
  
    
    private void jButtonGeneros1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGeneros1ActionPerformed
        modelo= new DefaultTreeModel((TreeNode) controlMus.DameTodoslosgeneros());
        if(modelo==null){
            JOptionPane.showMessageDialog(null,"No existe ningun genero, porfavor cree alguno");
        }else{
            jTreeGeneros.setModel(modelo);
        }
        Busqueda = "Genero";
    }//GEN-LAST:event_jButtonGeneros1ActionPerformed

    
    private void jListclientesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListclientesValueChanged
        if (!evt.getValueIsAdjusting()) {
            String clienteSeleccionado = jListclientes.getSelectedValue();
            if (clienteSeleccionado != null) {
                List<String> listaL = controlMus.obtenerListaPorCliente(clienteSeleccionado);
                if (!(jListListas.getModel() instanceof DefaultListModel)) {
                    jListListas.setModel(new DefaultListModel<>());
                }
                DefaultListModel<String> Model = new DefaultListModel<>() ;
                jListListas.clearSelection();
                for (String lista : listaL) {
                    Model.addElement(lista);
                }
                jListListas.setModel(Model);
                jListListas.clearSelection();
            }
        }
    }//GEN-LAST:event_jListclientesValueChanged

    private void jTreeGenerosValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_jTreeGenerosValueChanged
        DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) jTreeGeneros.getLastSelectedPathComponent();
    if (nodo != null) {
        generoSeleccionado = nodo.toString(); // Guardar el género seleccionado en la variable de clase
        List<String> listasG = controlMus.obtenerListaPorGenero(generoSeleccionado);
        if (!(jListListas.getModel() instanceof DefaultListModel)) {
            jListListas.setModel(new DefaultListModel<>());
        }
        DefaultListModel<String> listaListModel = (DefaultListModel<String>) jListListas.getModel();
        listaListModel.clear();
        for (String lista : listasG) {
            listaListModel.addElement(lista);
        }
    }
    }//GEN-LAST:event_jTreeGenerosValueChanged

    private void jListListasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListListasValueChanged
    String listaSeleccionado = jListListas.getSelectedValue();
    DTOLista listDTO;

    if (listaSeleccionado != null) {
        // Obtener la lista seleccionada desde el controlador
        if ("Cliente".equals(Busqueda)) {
            listDTO = controlMus.consultaListaPorTitulo(listaSeleccionado);
            jTextFieldNombreL.setText(listDTO.getNombre());
            jTextFieldGeneroL.setText("Sin género asignado");
            cargarImagen(listDTO.getRutaImagen());
        } else {
            listDTO = controlMus.consultaListaPorTituloyGenero(listaSeleccionado, generoSeleccionado);
            jTextFieldNombreL.setText(listDTO.getNombre());
            String genero = generoSeleccionado;
            jTextFieldGeneroL.setText(genero);


            cargarImagen(listDTO.getRutaImagen());
        }

        // Revisa si el modelo es del tipo DefaultListModel antes de proceder
        if (!(jListTemasLista.getModel() instanceof DefaultListModel)) {
            jListTemasLista.setModel(new DefaultListModel<>());
        }

        DefaultListModel<String> temaModel = new DefaultListModel<String>() ;

        // Añadir cada tema a la lista
        if (listDTO.getTemas() != null && !listDTO.getTemas().isEmpty()) {
            for (DTOTema tema : listDTO.getTemas()) {
                String st = String.format("%s | %s | %s | %s", tema.getNombre(), tema.getDuracion(), tema.getEnlace(), tema.getPosicion());
                temaModel.addElement(st);
            }
            jListTemasLista.setModel(temaModel);
        } else {
            temaModel.addElement("No hay temas en esta lista.");
        }
    } else {
        // Limpiar los campos si no hay lista seleccionada
        jTextFieldNombreL.setText("");
        jTextFieldGeneroL.setText("");
        
        DefaultListModel<String> temaListModel = (DefaultListModel<String>) jListTemasLista.getModel();
        temaListModel.clear();
    }
    }//GEN-LAST:event_jListListasValueChanged

    private void jButtonClientes2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClientes2ActionPerformed
        clientes = controlUsr.obtenerClientes();
        DefaultListModel<String> Model = new DefaultListModel<>();
        for (String s : clientes) {
            Model.addElement(s);
        }
        jListclientes.setModel(Model);
        Busqueda = "Cliente";
    }//GEN-LAST:event_jButtonClientes2ActionPerformed

    private void cargarImagen(String ruta){
        if(ruta != null){
            ImageIcon icon = new ImageIcon(ruta);
            Image image = icon.getImage().getScaledInstance(jLabelImagen.getWidth(), jLabelImagen.getHeight(), Image.SCALE_SMOOTH);
            jLabelImagen.setIcon(new ImageIcon(image));
        }
    }
    
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        setVisible(false);
        limpiarPantalla();
        principal.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void jTextFieldNombreLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreLActionPerformed

    private void jButtonSalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalir1ActionPerformed

        setVisible(false);
        limpiarPantalla();
        principal.setVisible(true);
    }//GEN-LAST:event_jButtonSalir1ActionPerformed
    
    private void limpiarPantalla() {
    jTextFieldNombreL.setText("");
    jTextFieldGeneroL.setText("");
    jLabelImagen.setIcon(null);
    
    DefaultListModel<String> model = new DefaultListModel<>();
    model.addElement("");
    jListListas.setModel(model);
    jListTemasLista.setModel(model);
    jListclientes.setModel(model);
    DefaultTreeModel mod = new DefaultTreeModel(new DefaultMutableTreeNode(""));
    jTreeGeneros.setModel(mod);
    
    Busqueda = null;
    generoSeleccionado = null;
}
    
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
            java.util.logging.Logger.getLogger(ConsultaListadeReproduccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaListadeReproduccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaListadeReproduccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaListadeReproduccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaListadeReproduccion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonClientes2;
    private javax.swing.JButton jButtonGeneros1;
    private javax.swing.JButton jButtonSalir1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelImagen;
    private javax.swing.JList<String> jListListas;
    private javax.swing.JList<String> jListTemasLista;
    private javax.swing.JList<String> jListclientes;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTextFieldGeneroL;
    private javax.swing.JTextField jTextFieldNombreL;
    private javax.swing.JTree jTreeGeneros;
    // End of variables declaration//GEN-END:variables
}
