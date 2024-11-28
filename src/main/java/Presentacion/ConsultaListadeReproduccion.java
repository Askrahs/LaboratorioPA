package Presentacion;
//lolo
import Logica.IControllerMusica;
import Logica.IControllerUsuario;
import LogicaDTO.DtoLista;
import LogicaDTO.DtoTema;
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButtonGeneros1 = new javax.swing.JButton();
        jButtonClientes2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListclientes = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTreeGeneros = new javax.swing.JTree();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Consultar Lista de Reproduccion"));

        jLabel1.setText("Buscar Segun:");

        jButtonGeneros1.setText("Generos");
        jButtonGeneros1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGeneros1ActionPerformed(evt);
            }
        });

        jButtonClientes2.setText("Clientes");
        jButtonClientes2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClientes2ActionPerformed(evt);
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

        jListListas.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista"));
        jListListas.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListListasValueChanged(evt);
            }
        });
        jScrollPane4.setViewportView(jListListas);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Información de la Lista"));

        jLabel2.setText("Nombre:");

        jLabel4.setText("Géneros:");

        jTextFieldNombreL.setEditable(false);

        jTextFieldGeneroL.setEditable(false);

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabelImagen.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

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
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldGeneroL, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldNombreL, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(jLabelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 23, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextFieldNombreL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jTextFieldGeneroL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3)
                            .addComponent(jButtonGeneros1, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jButtonClientes2, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonGeneros1)
                            .addComponent(jButtonClientes2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                DefaultListModel<String> listaListModel = (DefaultListModel<String>) jListListas.getModel();
                listaListModel.clear();
                jListListas.clearSelection();
                for (String lista : listaL) {
                    listaListModel.addElement(lista);
                }
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
    DtoLista listDTO;;

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

        DefaultListModel<String> temaListModel = (DefaultListModel<String>) jListTemasLista.getModel();
        temaListModel.clear();

        // Añadir cada tema a la lista
        if (listDTO.getTemas() != null && !listDTO.getTemas().isEmpty()) {
            for (DtoTema tema : listDTO.getTemas()) {
                String st = String.format("%s | %s | %s | %s", tema.getNombre(), tema.getDuracion(), tema.getEnlace(), tema.getPosicion());
                temaListModel.addElement(st);
            }
        } else {
            temaListModel.addElement("No hay temas en esta lista.");
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
        DefaultListModel<String> listModel = (DefaultListModel<String>) jListclientes.getModel();
        listModel.clear();
        for (String s : clientes) {
            listModel.addElement(s);
        }
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
        principal.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelImagen;
    private javax.swing.JList<String> jListListas;
    private javax.swing.JList<String> jListTemasLista;
    private javax.swing.JList<String> jListclientes;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
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
