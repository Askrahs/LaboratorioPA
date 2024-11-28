
package Presentacion;

import Excepciones.NoExisteLista;
import Logica.IControllerMusica;
import LogicaDTO.DtoAlbum;
import LogicaDTO.DtoLista;
import LogicaDTO.DtoTema;
import LogicaDTO.DtoUsuario;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class AgregarTemaListaPublica extends javax.swing.JFrame {
    
private JFrame principal;
    private boolean primeraseleccion = true;
    private int contador = 0;
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
        CargarAlbumes();
        todonulo();
    }


    public void cleartodo(){
        this.txtListaDelTema.setText("");
        this.txtNombreAlbum.setText("");
        this.txtNombreLista.setText("");
        this.txtNombreTema.setText("");
        this.txtNombreUsr.setText("");
        this.txtNombreDuenio.setText("");
    }


    public void todonulo(){
        this.txtListaDelTema.setEditable(false);
        this.txtNombreAlbum.setEditable(false);
        this.txtNombreLista.setEditable(false);
        this.txtNombreTema.setEditable(false);
        this.txtNombreUsr.setEditable(false);
        this.txtNombreDuenio.setEditable(false);
    }
    
    public void CargarListasconduenios() throws NoExisteLista{
         List <DtoLista> listass = ctrlM.Obtengolistasconduenio();
         ListaListas.clearSelection();
        if (!(ListaListas.getModel() instanceof DefaultListModel)) {
                        ListaListas.setModel(new DefaultListModel<>());
                    }
                    DefaultListModel<String> temaLista = (DefaultListModel<String>) ListaListas.getModel();
                    temaLista.clear();
                    ListaListas.clearSelection();
                    for(DtoLista lis : listass){
                        String loquemuestro = lis.getNombre();
                        temaLista.addElement(loquemuestro);
                    }
                    ListaListas.clearSelection();
    }
    
    
    public void CargarListas() throws NoExisteLista{
        List <DtoLista> listass = ctrlM.Obtengolistassinduenio();
        ListaListas.clearSelection();
        if (!(ListaListas.getModel() instanceof DefaultListModel)) {
                        ListaListas.setModel(new DefaultListModel<>());
                    }
                    DefaultListModel<String> temaLista = (DefaultListModel<String>) ListaListas.getModel();
                    temaLista.clear();
                    ListaListas.clearSelection();
                    for(DtoLista lis : listass){
                        String loquemuestro = lis.getNombre();
                        temaLista.addElement(loquemuestro);
                    }
                    ListaListas.clearSelection();
    }
    
    public void CargarAlbumes(){
        
        
            List<DtoAlbum> albDTO = ctrlM.ObtengoAlbums();
            
                if (!(AlbumList.getModel() instanceof DefaultListModel)) {
                       AlbumList.setModel(new DefaultListModel<>());
                }
                
                
                DefaultListModel<String> temaListModel = (DefaultListModel<String>) AlbumList.getModel();
                temaListModel.clear();
                AlbumList.clearSelection();
                for (DtoAlbum albun : albDTO) {
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
        txtNombreAlbum = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtListaDelTema = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        AlbumList = new javax.swing.JList<>();
        jScrollPane6 = new javax.swing.JScrollPane();
        ListTemasAlbum = new javax.swing.JList<>();
        cboListas = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListaListas = new javax.swing.JList<>();
        txtNombreDuenio = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cboComoAniado = new javax.swing.JComboBox<>();

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

        txtNombreTema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreTemaActionPerformed(evt);
            }
        });

        txtNombreLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreListaActionPerformed(evt);
            }
        });

        jLabel3.setText("Nombre Usuario:");

        jLabel4.setText("Nombre Album:");

        txtListaDelTema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtListaDelTemaActionPerformed(evt);
            }
        });

        jLabel5.setText("Lista del Tema");

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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombreAlbum)
                    .addComponent(txtNombreUsr)
                    .addComponent(txtNombreTema)
                    .addComponent(txtNombreLista)
                    .addComponent(txtListaDelTema))
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreUsr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreTema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtListaDelTema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones"));
        jPanel2.setForeground(new java.awt.Color(102, 102, 102));

        btnAceptar.setText("Aceptar");
        btnAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAceptarMouseClicked(evt);
            }
        });
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
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
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancelar)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnAceptar)
                        .addComponent(btnEliminar)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAceptar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar))
        );

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

        ListTemasAlbum.setBorder(javax.swing.BorderFactory.createTitledBorder("Temas "));
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

        cboListas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Listas Default", "Listas con Dueños" }));
        cboListas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboListasActionPerformed(evt);
            }
        });

        ListaListas.setBorder(javax.swing.BorderFactory.createTitledBorder("Listas "));
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

        txtNombreDuenio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreDuenioActionPerformed(evt);
            }
        });

        jLabel6.setText("Dueño de la Lista:");

        cboComoAniado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Añadir de Album a lista", "Añadir de Lista a Lista" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                    .addComponent(jScrollPane6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtNombreDuenio, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboListas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cboComoAniado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombreDuenio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboListas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cboComoAniado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(21, Short.MAX_VALUE))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreUsrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreUsrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreUsrActionPerformed

    private void btnAceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseClicked
        //AHORA HAY QUE CHEQUEAR QUE CAMPOS ESTAN RELLENOS, DEPENDIENDO DE LO QUE ESTE RELLENO PARA DONDE VA YA NO VA LAS BOX
            String nameusu = this.txtNombreDuenio.getText();
        this.txtNombreUsr.setText(nameusu);
            JOptionPane.showMessageDialog(null,"El cliente es ["+nameusu+"]");
            String nombreteam = this.txtNombreTema.getText();
            String nombrealb = this.txtNombreAlbum.getText();
             String nombrelista = this.txtNombreLista.getText();
             String nombreUsuario = this.txtNombreUsr.getText();
             String nombredelalistadeltema = this.txtListaDelTema.getText();
            if(nombredelalistadeltema.isEmpty()){
             if(nombreUsuario.isEmpty()){
                 
                  ctrlM.aniadoTemaListaPublica(nombrelista, nombreteam,nombrealb);
              }else{
                  ctrlM.aniadoTemaListaConduenio(nombreUsuario,nombrelista,nombreteam,nombrealb);
              }
            }else{
                String nicknameUsuario = this.txtNombreUsr.getText();
                String nombrelistadelteam = this.txtListaDelTema.getText();
                 if(nicknameUsuario.isEmpty()){
                    
                  ctrlM.aniadoTemaListaPublicaLista(nombrelista, nombreteam,nombrelistadelteam);
              }else{
                    
                  ctrlM.aniadoTemaListaConduenioLista(nicknameUsuario,nombrelista,nombreteam,nombrelistadelteam);
              }
            
            }
        
       cleartodo();
      
                
    }//GEN-LAST:event_btnAceptarMouseClicked

    private void ListaListasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ListaListasValueChanged
        
        String como = cboComoAniado.getSelectedItem().toString();
        if(como.equalsIgnoreCase("Añadir de Album a lista")){
            if(cboListas.getSelectedItem().toString().equalsIgnoreCase("Listas Default")){
      
                DefaultListModel<String> modeloLista = new DefaultListModel<>();
                
                String nombrelista = ListaListas.getSelectedValue();
                if (nombrelista==null||nombrelista.isEmpty()) {
                    
                    return;
                }
                List <DtoTema> temas = ctrlM.TemasdeListas(nombrelista);
                
                for(DtoTema tema : temas){
                    modeloLista.addElement(tema.getNombre());
                    
                }
                ListTemasAlbum.clearSelection();
                ListTemasAlbum.setModel(modeloLista);
                txtNombreLista.setText(nombrelista);
                
               
            }
            
            if(cboListas.getSelectedItem().toString().equalsIgnoreCase("Listas con Dueños")){
                
                
                try {
            
                    
                    DefaultListModel<String> modeloLista = new DefaultListModel<>();
                    DefaultListModel<String> modeloLista2 = new DefaultListModel<>();
                    List <DtoLista> laslistas;
                    
                    
                    laslistas = ctrlM.Obtengolistasconduenio();
                    
                    
                    DtoLista lis;
                    DtoUsuario duenio;
                    
                    String nombrelisto = ListaListas.getSelectedValue();
                    
                    if (nombrelisto == null||nombrelisto.isEmpty()) {
                        
                        return;
                    }
                    
                    
                    txtNombreLista.setText(nombrelisto);
                    List <DtoTema> temas = ctrlM.TemasdeListas(nombrelisto);
                    for(DtoTema tema : temas){
                        
                        modeloLista.addElement(tema.getNombre());
                    }
                    
                    ListTemasAlbum.clearSelection();
                    ListTemasAlbum.setModel(modeloLista);
                    
                    
                    for (int i = 0 ; i<laslistas.size();i++){
                        lis = laslistas.get(i);
                        if(lis.getNombre().equalsIgnoreCase(nombrelisto)){
                            duenio = lis.getDuenio();
                            txtNombreDuenio.setText(duenio.getNombre());
                            this.txtNombreUsr.setText(this.txtNombreDuenio.getText());
                        }
                        
                    }
                } catch (NoExisteLista ex) {
                    Logger.getLogger(AgregarTemaListaPublica.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }else{
            if(cboListas.getSelectedItem().toString().equalsIgnoreCase("Listas con Dueños")){
                
                
                try {
                
                    
                    DefaultListModel<String> modeloLista = new DefaultListModel<>();
                    DefaultListModel<String> modeloLista2 = new DefaultListModel<>();
                    List <DtoLista> laslistas;
                    
                    
                    laslistas = ctrlM.Obtengolistasconduenio();
                    
                    
                    DtoLista lis;
                    DtoUsuario duenio;
                    
                    String nombrelisto = ListaListas.getSelectedValue();
                    
                    if (nombrelisto == null||nombrelisto.isEmpty()) {
                        
                        return;
                    }
                    if(primeraseleccion==true){
                        
                        txtNombreLista.setText(nombrelisto);
                        List <DtoTema> temas = ctrlM.TemasdeListas(nombrelisto);
                        for(DtoTema tema : temas){
                            
                            modeloLista.addElement(tema.getNombre());
                        }
                        
                        ListTemasAlbum.clearSelection();
                        ListTemasAlbum.setModel(modeloLista);
                        
                        primeraseleccion = false;
                        contador++;
                    }else{
                        //JOptionPane.showMessageDialog(null,"Entre al dos pa");
                        txtListaDelTema.setText(nombrelisto);
                        List <DtoTema> temas = ctrlM.TemasdeListas(nombrelisto);
                        for(DtoTema tema : temas){
                            modeloLista2.addElement(tema.getNombre());
                        }
                        ListTemasAlbum.clearSelection();
                        ListTemasAlbum.setModel(modeloLista2);
                        contador++;
                        
                    }
                    
                    if(contador == 2){
                        primeraseleccion=true;
                        contador = 0;
                    }
                    if(contador == 1){
                    for (int i = 0 ; i<laslistas.size();i++){
                        lis = laslistas.get(i);
                        if(lis.getNombre().equalsIgnoreCase(nombrelisto)){
                            duenio = lis.getDuenio();
                            txtNombreDuenio.setText(duenio.getNombre());
                            this.txtNombreUsr.setText(this.txtNombreDuenio.getText());
                        }
                        
                    }
                    }
                    
                } catch (NoExisteLista ex) {
                    Logger.getLogger(AgregarTemaListaPublica.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
            }

        }
        

    }//GEN-LAST:event_ListaListasValueChanged

    private void txtNombreListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreListaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreListaActionPerformed

    private void AlbumListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_AlbumListValueChanged
        if (!evt.getValueIsAdjusting()) {
            ListTemasAlbum.clearSelection();
            DefaultListModel<String> modeloLista = new DefaultListModel<>();
                String nombreAlbum = AlbumList.getSelectedValue();
               // JOptionPane.showMessageDialog(null,"LLEGUE 3");
 
                if (nombreAlbum == null) {
                 JOptionPane.showMessageDialog(null,"Elija un album");
                return;                
                }
                List <DtoTema> temas = ctrlM.ObtengoTemasdeAlbum(nombreAlbum);
                for(DtoTema tema : temas){
                    modeloLista.addElement(tema.getNombre());
                }
                ListTemasAlbum.setModel(modeloLista);
                txtNombreAlbum.setText(nombreAlbum);
                
        }
    }//GEN-LAST:event_AlbumListValueChanged

    private void ListTemasAlbumValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ListTemasAlbumValueChanged
        txtNombreTema.setText("");
            String nombretema = ListTemasAlbum.getSelectedValue();
            txtNombreTema.setText(nombretema);
          
    }//GEN-LAST:event_ListTemasAlbumValueChanged
    
    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked
        
        String nombreUsuario=this.txtNombreUsr.getText();
        String nombrelista = this.txtNombreLista.getText();
        String nombreteam = this.txtNombreTema.getText();
        String nombreAlbum = this.txtNombreAlbum.getText();
        if(nombrelista.isEmpty()||nombreteam.isEmpty()){
         JOptionPane.showMessageDialog(null,"Uno de los campos esta vacio, Porfavor llene ambos");
        }else{
              if(nombreUsuario.isEmpty()){
                  
                  ctrlM.EliminotemaLista(nombrelista, nombreteam, nombreAlbum);
              }else{
                  
                  ctrlM.EliminoTemaListaConduenio(nombreUsuario,nombrelista,nombreteam, nombreAlbum);
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

    private void txtNombreTemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreTemaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreTemaActionPerformed

    private void txtListaDelTemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtListaDelTemaActionPerformed
    
    }//GEN-LAST:event_txtListaDelTemaActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void txtNombreDuenioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreDuenioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreDuenioActionPerformed

    private void cboListasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboListasActionPerformed
        String tipolista = cboListas.getSelectedItem().toString();
        if(tipolista.equalsIgnoreCase("Listas Default")){
            try {
                CargarListas();
            } catch (NoExisteLista ex) {
                Logger.getLogger(AgregarTemaListaPublica.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(tipolista.equalsIgnoreCase("Listas con Dueños")){
            try {
                CargarListasconduenios();
            } catch (NoExisteLista ex) {
                Logger.getLogger(AgregarTemaListaPublica.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_cboListasActionPerformed

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
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JComboBox<String> cboComoAniado;
    private javax.swing.JComboBox<String> cboListas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    public javax.swing.JTextField txtListaDelTema;
    public javax.swing.JTextField txtNombreAlbum;
    private javax.swing.JTextField txtNombreDuenio;
    public javax.swing.JTextField txtNombreLista;
    public javax.swing.JTextField txtNombreTema;
    public javax.swing.JTextField txtNombreUsr;
    // End of variables declaration//GEN-END:variables
}
