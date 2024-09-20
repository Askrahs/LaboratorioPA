package Presentacion;
//lop
import Excepciones.ElementoNoValidoException;
import Excepciones.NoHayUsuariosEnElSistemaException;
import Excepciones.UsuarioNoExisteException;
import Logica.*;
import LogicaDTO.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class EliminarTemaListaAlbum extends javax.swing.JFrame {
    
    private JFrame principal;
    private ControllerMusica ctrlM;
    private ControllerUsuario ctrlU; 
    private String nicknameCLI;
    private String elementoSeleccionado;
    
    
    public EliminarTemaListaAlbum(){
        initComponents();
    }
    
    
    public EliminarTemaListaAlbum(IControllerMusica conmu,IControllerUsuario usrct, JFrame princi) {
        initComponents();
        principal = princi;
        ctrlM = (ControllerMusica) conmu;
        ctrlU = (ControllerUsuario) usrct; 
        cargarNicknames();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jTema = new javax.swing.JButton();
        jLista = new javax.swing.JButton();
        jAlbum = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jListTemas = new javax.swing.JList<>();
        jScrollPane6 = new javax.swing.JScrollPane();
        jListAlbums = new javax.swing.JList<>();
        jScrollPane7 = new javax.swing.JScrollPane();
        jListListas = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        txtNick = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jIngresarFav1 = new javax.swing.JButton();
        txtNomfav = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaCliente = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Eliminar Tema/Lista/Album"));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Eliminar de favoritos"));

        jTema.setText("Tema");
        jTema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTemaActionPerformed(evt);
            }
        });

        jLista.setText("Lista");
        jLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jListaActionPerformed(evt);
            }
        });

        jAlbum.setText("Album");
        jAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAlbumActionPerformed(evt);
            }
        });

        jListTemas.setBorder(javax.swing.BorderFactory.createTitledBorder("Temas"));
        jListTemas.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListTemasValueChanged(evt);
            }
        });
        jScrollPane5.setViewportView(jListTemas);

        jListAlbums.setBorder(javax.swing.BorderFactory.createTitledBorder("Album"));
        jListAlbums.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListAlbumsValueChanged(evt);
            }
        });
        jScrollPane6.setViewportView(jListAlbums);

        jListListas.setBorder(javax.swing.BorderFactory.createTitledBorder("Listas"));
        jListListas.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListListasValueChanged(evt);
            }
        });
        jScrollPane7.setViewportView(jListListas);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jTema, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLista, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jAlbum, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTema)
                    .addComponent(jLista)
                    .addComponent(jAlbum))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(198, 198, 198))
        );

        jLabel1.setText("Clientes del Sistema:");

        txtNick.setEditable(false);
        txtNick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNickActionPerformed(evt);
            }
        });

        txtNombre.setEditable(false);
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        txtApellido.setEditable(false);
        txtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoActionPerformed(evt);
            }
        });

        txtEmail.setEditable(false);

        jLabel2.setText("Nickname:");

        jLabel3.setText("Nombre:");

        jLabel5.setText("Apellido:");

        jLabel7.setText("Email:");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Elemento favorito seleccionado"));

        jLabel8.setText("Nombre:");

        jIngresarFav1.setText("Eliminar");
        jIngresarFav1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jIngresarFav1ActionPerformed(evt);
            }
        });

        txtNomfav.setEditable(false);
        txtNomfav.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomfavActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNomfav, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(jIngresarFav1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtNomfav, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jIngresarFav1)
                .addContainerGap())
        );

        listaCliente.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaClienteValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listaCliente);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNick, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtNick, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTemaActionPerformed
        List<DTOTema> temitas = ctrlM.obtenerTemitasfavCliente(nicknameCLI);
        DefaultListModel<String> listModel;
        if (jListTemas.getModel() instanceof DefaultListModel) {
            listModel = (DefaultListModel<String>) jListTemas.getModel();
        } else {
            listModel = new DefaultListModel<>();
            jListTemas.setModel(listModel);
        }
        listModel.clear();
        for (DTOTema t : temitas) {
            listModel.addElement(t.getNombre());
        }
    }//GEN-LAST:event_jTemaActionPerformed

    private void jListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jListaActionPerformed
        List<DTOLista> listas = ctrlM.obtenerListitasfavCliente(nicknameCLI);
        DefaultListModel<String> listModel;
        if (jListListas.getModel() instanceof DefaultListModel) {
            listModel = (DefaultListModel<String>) jListListas.getModel();
        } else {
            listModel = new DefaultListModel<>();
            jListListas.setModel(listModel);
        }
        listModel.clear();
        for (DTOLista l : listas) {
            listModel.addElement(l.getNombre());
        }
    }//GEN-LAST:event_jListaActionPerformed

    private void jAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAlbumActionPerformed
        List<DTOAlbum> albums = ctrlM.obtenerAlbumsfavCliente(nicknameCLI);
        DefaultListModel<String> listModel;
        if (jListAlbums.getModel() instanceof DefaultListModel) {
            listModel = (DefaultListModel<String>) jListAlbums.getModel();
        } else {
            listModel = new DefaultListModel<>();
            jListAlbums.setModel(listModel);
        }
        listModel.clear();
        for (DTOAlbum a : albums) {
            listModel.addElement(a.getTitulo()); // Aquí agregas el título de cada álbum
        }
    }//GEN-LAST:event_jAlbumActionPerformed

    private void jListTemasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListTemasValueChanged
        String temaseleccionado = jListTemas.getSelectedValue();
        if(temaseleccionado != null){
            DTOTema tema = ctrlM.consultaTemaPorTitulo(temaseleccionado);
            if(tema != null){
                txtNomfav.setText(tema.getNombre());
                elementoSeleccionado = "tema";
            }
        }else{
            txtNomfav.setText("");
        }
    }//GEN-LAST:event_jListTemasValueChanged

    private void jListAlbumsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListAlbumsValueChanged
        String albumSeleccionado = jListAlbums.getSelectedValue();
    if (albumSeleccionado != null) {
        // Obtener el DTOAlbum por el título
        DTOAlbum albDTO = ctrlM.consultaAlbumPorTitulo(albumSeleccionado);
        if (albDTO != null) {
            txtNomfav.setText(albDTO.getTitulo());
            elementoSeleccionado = "album";
        }
    } else {
        txtNomfav.setText("");
    }
    }//GEN-LAST:event_jListAlbumsValueChanged

    private void jListListasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListListasValueChanged
        String listaselecccionada = jListListas.getSelectedValue();
        if(listaselecccionada != null){
            DTOLista lista = ctrlM.consultaListaPorTitulo(listaselecccionada);
            if(lista != null){
                txtNomfav.setText(lista.getNombre());
                elementoSeleccionado = "lista";
            }else{
                txtNomfav.setText("");
            }
        }
    }//GEN-LAST:event_jListListasValueChanged

    private void txtNickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNickActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNickActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoActionPerformed

    private void jIngresarFav1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jIngresarFav1ActionPerformed
        if (nicknameCLI == null || nicknameCLI.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Seleccione un cliente.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    String nombreElemento = txtNomfav.getText();
    if (nombreElemento == null || nombreElemento.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Seleccione un tema, lista o álbum.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    try {
        switch (elementoSeleccionado) {
            case "tema":
                DTOTema tema = ctrlM.consultaTemaPorTitulo(nombreElemento);
                if (tema != null) {
                    ctrlU.eliminarTemaDeFavoritos(nicknameCLI, tema);
                    JOptionPane.showMessageDialog(this, "Tema eliminado de los favoritos.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Tema no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;

            case "lista":
                DTOLista lista = ctrlM.consultaListaPorTitulo(nombreElemento);
                if (lista != null) {
                    ctrlU.eliminarListaDeFavoritos(nicknameCLI, lista);
                    JOptionPane.showMessageDialog(this, "Lista eliminada de los favoritos.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Lista no encontrada.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;

            case "album":
                // Obtener DTOAlbum por título
                DTOAlbum album = ctrlM.consultaAlbumPorTitulo(nombreElemento);
                if (album != null) {
                    // Verificar si el álbum realmente está en los favoritos del cliente
                    List<DTOAlbum> albumsFavoritos = ctrlM.obtenerAlbumsfavCliente(nicknameCLI);
                    boolean albumEncontrado = albumsFavoritos.stream().anyMatch(a -> a.getTitulo().equals(album.getTitulo()) && a.getArtista().equals(album.getArtista()));

                    if (albumEncontrado) {
                        ctrlU.eliminarAlbumDeFavoritos(nicknameCLI, album);
                        JOptionPane.showMessageDialog(this, "Álbum eliminado de los favoritos.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, "El álbum no está en los favoritos del cliente.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Álbum no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;

            default:
                JOptionPane.showMessageDialog(this, "Seleccione un tema, lista o álbum válido.", "Error", JOptionPane.ERROR_MESSAGE);
                break;
        }
    } catch (ElementoNoValidoException ex) {
        Logger.getLogger(EliminarTemaListaAlbum.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(this, "Error al eliminar el elemento de favoritos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } catch (Exception ex) {
        Logger.getLogger(EliminarTemaListaAlbum.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(this, "Ocurrió un error inesperado: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jIngresarFav1ActionPerformed

    private void txtNomfavActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomfavActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomfavActionPerformed

    private void listaClienteValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaClienteValueChanged
        if (!evt.getValueIsAdjusting()) { // Solo reaccionar al cambio final
            nicknameCLI = listaCliente.getSelectedValue();
            cargarDatosCliente(nicknameCLI);
        }
    }//GEN-LAST:event_listaClienteValueChanged

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       setVisible(false);
        principal.setVisible(true);
    }//GEN-LAST:event_formWindowClosing
    
    private void cargarDatosCliente(String nickname) {
    try {
        // Obtener el cliente usando el controlador
        Cliente cliente = ctrlU.ObtenerCliente(nickname);

        // Rellenar los campos con los datos obtenidos del cliente
        txtNick.setText(cliente.getNickname());
        txtNombre.setText(cliente.getNombre());
        txtApellido.setText(cliente.getApellido());
        txtEmail.setText(cliente.getEmail());

    } catch (UsuarioNoExisteException ex) {
        // Mostrar un mensaje si el cliente no existe
        JOptionPane.showMessageDialog(this, "El cliente seleccionado no existe.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }
    
    private void cargarNicknames() {
         List<String> nicknames = null;
        try {
            nicknames = ctrlU.ObtenerNicknamesClientes();

            if (nicknames != null && !nicknames.isEmpty()) {
                DefaultListModel<String> model = new DefaultListModel<>();
                for (String nickname : nicknames) {
                    model.addElement(nickname);
                }
                listaCliente.setModel(model);
            }
        } catch (NoHayUsuariosEnElSistemaException ex) {
            JOptionPane.showMessageDialog(this, "No hay usuarios en el sistema", "Error", JOptionPane.ERROR_MESSAGE);
        }
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
            java.util.logging.Logger.getLogger(EliminarTemaListaAlbum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EliminarTemaListaAlbum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EliminarTemaListaAlbum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EliminarTemaListaAlbum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EliminarTemaListaAlbum().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jAlbum;
    private javax.swing.JButton jIngresarFav1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JList<String> jListAlbums;
    private javax.swing.JList<String> jListListas;
    private javax.swing.JList<String> jListTemas;
    private javax.swing.JButton jLista;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JButton jTema;
    private javax.swing.JList<String> listaCliente;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNick;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNomfav;
    // End of variables declaration//GEN-END:variables
}
