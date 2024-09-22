/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentacion;

import Excepciones.NoExisteLista;
import Logica.IControllerMusica;
import LogicaDTO.DTOAlbum;
import LogicaDTO.DTOLista;
import LogicaDTO.DTOTema;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Santiago
 */
public class AgregarTemaListaPublica extends javax.swing.JFrame {
private JFrame principal;
    private IControllerMusica ctrlM;
    private DefaultListModel<String> listModel;
    public AgregarTemaListaPublica() {
        initComponents();
    }

    public AgregarTemaListaPublica(IControllerMusica conMUS, JFrame princi) throws NoExisteLista {
        initComponents(); 
        this.ctrlM = conMUS;
        
        listModel = new DefaultListModel<>();
        ListaListas.setModel(listModel);
      
        principal = princi;
        CargarListas();
        CargarListasconduenios();
        CargarAlbumes();
    }
    
    public void CargarListasconduenios() throws NoExisteLista{
         List <DTOLista> listass = ctrlM.Obtengolistasconduenio();
        if (!(ListasConDuenio.getModel() instanceof DefaultListModel)) {
                        ListasConDuenio.setModel(new DefaultListModel<>());
                    }
                    DefaultListModel<String> temaLista = (DefaultListModel<String>) ListasConDuenio.getModel();
                    temaLista.clear();
                    ListasConDuenio.clearSelection();
                    for(DTOLista lis : listass){
                        String loquemuestro = lis.getNombre();
                        temaLista.addElement(loquemuestro);
                    }
                    ListasConDuenio.clearSelection();
    }
    
    
    public void CargarListas() throws NoExisteLista{
        List <DTOLista> listass = ctrlM.Obtengolistassinduenio();
        if (!(ListaListas.getModel() instanceof DefaultListModel)) {
                        ListaListas.setModel(new DefaultListModel<>());
                    }
                    DefaultListModel<String> temaLista = (DefaultListModel<String>) ListaListas.getModel();
                    temaLista.clear();
                    ListaListas.clearSelection();
                    for(DTOLista lis : listass){
                        String loquemuestro = lis.getNombre();
                        temaLista.addElement(loquemuestro);
                    }
                    ListaListas.clearSelection();
    }
    
    public void CargarAlbumes(){
        
        
            List<DTOAlbum> albDTO = ctrlM.ObtengoAlbums();
            
                if (!(AlbumList.getModel() instanceof DefaultListModel)) {
                       AlbumList.setModel(new DefaultListModel<>());
                }
                
                
                DefaultListModel<String> temaListModel = (DefaultListModel<String>) AlbumList.getModel();
                temaListModel.clear();
                AlbumList.clearSelection();
                for (DTOAlbum albun : albDTO) {
                    String st = albun.getTitulo();
                    temaListModel.addElement(st);
                }
                AlbumList.clearSelection();
            }
    
    
        
       
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombreUsr = new javax.swing.JTextField();
        txtNombreTema = new javax.swing.JTextField();
        txtNombreLista = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListaListas = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        ListasTemas = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        ListasConDuenio = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        listatemaconsuenio = new javax.swing.JList<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        AlbumList = new javax.swing.JList<>();
        jScrollPane6 = new javax.swing.JScrollPane();
        ListTemasAlbum = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));
        jPanel1.setForeground(new java.awt.Color(102, 102, 102));

        jLabel1.setText("Nombre Lista:");

        jLabel2.setText("Nombre Tema:");

        txtNombreUsr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreUsrActionPerformed(evt);
            }
        });

        txtNombreLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreListaActionPerformed(evt);
            }
        });

        jLabel3.setText("Nombre Usuario:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(29, 29, 29))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(18, 18, 18)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombreUsr, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                    .addComponent(txtNombreTema)
                    .addComponent(txtNombreLista, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreUsr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombreTema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones"));
        jPanel2.setForeground(new java.awt.Color(102, 102, 102));

        btnAceptar.setText("Aceptar");
        btnAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAceptarMouseClicked(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEliminar)
                    .addComponent(btnCancelar)
                    .addComponent(btnAceptar))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(btnAceptar)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addGap(22, 22, 22))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Informacion"));
        jPanel3.setForeground(new java.awt.Color(255, 255, 102));

        ListaListas.setBorder(javax.swing.BorderFactory.createTitledBorder("Listas por Defecto"));
        ListaListas.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        ListaListas.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ListaListasValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(ListaListas);

        ListasTemas.setBorder(javax.swing.BorderFactory.createTitledBorder("Temas de Por Defecto"));
        ListasTemas.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        ListasTemas.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ListasTemasValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(ListasTemas);

        ListasConDuenio.setBorder(javax.swing.BorderFactory.createTitledBorder("Listas con dueños"));
        ListasConDuenio.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        ListasConDuenio.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ListasConDuenioValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(ListasConDuenio);

        listatemaconsuenio.setBorder(javax.swing.BorderFactory.createTitledBorder("Temas de Con dueño"));
        listatemaconsuenio.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listatemaconsuenio.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listatemaconsuenioValueChanged(evt);
            }
        });
        jScrollPane4.setViewportView(listatemaconsuenio);

        AlbumList.setBorder(javax.swing.BorderFactory.createTitledBorder("Albums"));
        AlbumList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        AlbumList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                AlbumListValueChanged(evt);
            }
        });
        jScrollPane5.setViewportView(AlbumList);

        ListTemasAlbum.setBorder(javax.swing.BorderFactory.createTitledBorder("Temas de albums"));
        ListTemasAlbum.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        ListTemasAlbum.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ListTemasAlbumValueChanged(evt);
            }
        });
        jScrollPane6.setViewportView(ListTemasAlbum);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreUsrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreUsrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreUsrActionPerformed

    private void btnAceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseClicked
        String nombreUsuario=this.txtNombreUsr.getText();
        String nombrelista = this.txtNombreLista.getText();
        String nombreteam = this.txtNombreTema.getText();
        if(nombrelista.isEmpty()||nombreteam.isEmpty()){
         JOptionPane.showMessageDialog(null,"Uno de los campos esta vacio, Porfavor llene ambos");
        }else{
              if(nombreUsuario.isEmpty()){
                  ctrlM.aniadoTemaListaPublica(nombrelista, nombreteam);
              }else{
                  ctrlM.aniadoTemaListaConduenio(nombreUsuario,nombrelista,nombreteam);
              }
        }
                
                
    }//GEN-LAST:event_btnAceptarMouseClicked

    private void ListaListasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ListaListasValueChanged
        txtNombreLista.setText("");       
        if (!evt.getValueIsAdjusting()) {
                String nombrelista = ListaListas.getSelectedValue();
                //JOptionPane.showMessageDialog(null,"LLEGUE 3");
                if (nombrelista != null) {
                   // JOptionPane.showMessageDialog(null,"LLEGUE 4");
                    List<DTOTema> temasA = ctrlM.TemasdeListas(nombrelista);
                   // JOptionPane.showMessageDialog(null,"LLEGUE 2");
                    if (!(ListasTemas.getModel() instanceof DefaultListModel)) {
                        ListasTemas.setModel(new DefaultListModel<>());
                    }
                   // JOptionPane.showMessageDialog(null,"LLEGUE 1");
                    DefaultListModel<String> temaLista = (DefaultListModel<String>) ListasTemas.getModel();
                    temaLista.clear();
                    ListasTemas.clearSelection();
                    for(DTOTema tem : temasA){
                        String loquemuestro = tem.getNombre();
                        temaLista.addElement(loquemuestro);
                    }
                    ListasTemas.clearSelection();
                }
        }
                
            ListasConDuenio.clearSelection();
            txtNombreLista.setText("");    
            String nombretema = ListaListas.getSelectedValue();
            txtNombreLista.setText(nombretema);
            
    }//GEN-LAST:event_ListaListasValueChanged

    private void txtNombreListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreListaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreListaActionPerformed

    private void ListasConDuenioValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ListasConDuenioValueChanged
           
        if (!evt.getValueIsAdjusting()) {
                String nombrelista = ListasConDuenio.getSelectedValue();
                //JOptionPane.showMessageDialog(null,"LLEGUE 3");
                if (nombrelista != null) {
                   // JOptionPane.showMessageDialog(null,"LLEGUE 4");
                    List<DTOTema> temasA = ctrlM.TemasdeListas(nombrelista);
                   // JOptionPane.showMessageDialog(null,"LLEGUE 2");
                    if (!(listatemaconsuenio.getModel() instanceof DefaultListModel)) {
                        listatemaconsuenio.setModel(new DefaultListModel<>());
                    }
                   // JOptionPane.showMessageDialog(null,"LLEGUE 1");
                    DefaultListModel<String> temaLista = (DefaultListModel<String>) listatemaconsuenio.getModel();
                    temaLista.clear();
                    listatemaconsuenio.clearSelection();
                    for(DTOTema tem : temasA){
                        String loquemuestro = tem.getNombre();
                        temaLista.addElement(loquemuestro);
                    }
                    listatemaconsuenio.clearSelection();
                }
        } 
              ListaListas.clearSelection();
              txtNombreLista.setText("");
            String nombretema = ListasConDuenio.getSelectedValue();
            txtNombreLista.setText(nombretema);
              
    }//GEN-LAST:event_ListasConDuenioValueChanged

    private void AlbumListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_AlbumListValueChanged
        if (!evt.getValueIsAdjusting()) {
                String nombreAlbum = AlbumList.getSelectedValue();
               // JOptionPane.showMessageDialog(null,"LLEGUE 3");
 
                if (nombreAlbum != null) {
                  //  JOptionPane.showMessageDialog(null,"LLEGUE 4");
                    List<DTOTema> temasA = ctrlM.ObtengoTemasdeAlbum(nombreAlbum);
                    //JOptionPane.showMessageDialog(null,"LLEGUE 2");
                    if (!(ListTemasAlbum.getModel() instanceof DefaultListModel)) {
                        ListTemasAlbum.setModel(new DefaultListModel<>());
                    }
                    //JOptionPane.showMessageDialog(null,"LLEGUE 1");
                    DefaultListModel<String> temaLista = (DefaultListModel<String>) ListTemasAlbum.getModel();
                    temaLista.clear();
                    ListTemasAlbum.clearSelection();
                    for(DTOTema tem : temasA){
                        String loquemuestro = tem.getNombre();
                        temaLista.addElement(loquemuestro);
                    }
                    ListTemasAlbum.clearSelection();
                }
        }
    }//GEN-LAST:event_AlbumListValueChanged

    private void ListasTemasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ListasTemasValueChanged
           
            String nombretema = ListasTemas.getSelectedValue();
            txtNombreTema.setText(nombretema);
            listatemaconsuenio.clearSelection();
            ListTemasAlbum.clearSelection();
    }//GEN-LAST:event_ListasTemasValueChanged

    private void listatemaconsuenioValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listatemaconsuenioValueChanged
          txtNombreTema.setText("");
            String nombretema = listatemaconsuenio.getSelectedValue();
            txtNombreTema.setText(nombretema);
            ListasTemas.clearSelection();
            ListTemasAlbum.clearSelection();
    }//GEN-LAST:event_listatemaconsuenioValueChanged

    private void ListTemasAlbumValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ListTemasAlbumValueChanged
        txtNombreTema.setText("");
            String nombretema = ListTemasAlbum.getSelectedValue();
            txtNombreTema.setText(nombretema);
            ListasTemas.clearSelection();
            listatemaconsuenio.clearSelection();
    }//GEN-LAST:event_ListTemasAlbumValueChanged

    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked
         String nombreUsuario=this.txtNombreUsr.getText();
        String nombrelista = this.txtNombreLista.getText();
        String nombreteam = this.txtNombreTema.getText();
        if(nombrelista.isEmpty()||nombreteam.isEmpty()){
         JOptionPane.showMessageDialog(null,"Uno de los campos esta vacio, Porfavor llene ambos");
        }else{
              if(nombreUsuario.isEmpty()){
                  ctrlM.EliminotemaLista(nombrelista, nombreteam);
              }else{
                  ctrlM.EliminoTemaListaConduenio(nombreUsuario,nombrelista,nombreteam);
              }
        }
                
    }//GEN-LAST:event_btnEliminarMouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        principal.setVisible(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        this.setVisible(false);
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
            java.util.logging.Logger.getLogger(AgregarTemaListaPublica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarTemaListaPublica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarTemaListaPublica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarTemaListaPublica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarTemaListaPublica().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> AlbumList;
    private javax.swing.JList<String> ListTemasAlbum;
    private javax.swing.JList<String> ListaListas;
    private javax.swing.JList<String> ListasConDuenio;
    private javax.swing.JList<String> ListasTemas;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JList<String> listatemaconsuenio;
    private javax.swing.JTextField txtNombreLista;
    private javax.swing.JTextField txtNombreTema;
    private javax.swing.JTextField txtNombreUsr;
    // End of variables declaration//GEN-END:variables
}
