package com.bddp1.vista;

import java.sql.ResultSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import com.bddp1.dao.ClienteDAO;
import com.bddp1.dao.OrdenDAO;
import com.bddp1.dao.ProductoDAO;
import com.bddp1.dao.VentaDAO;
import com.bddp1.dao.sql.SQLClienteDAO;
import com.bddp1.dao.sql.SQLOrdenDAO;
import com.bddp1.dao.sql.SQLProductoDAO;
import com.bddp1.dao.sql.SQLVentaDAO;
import com.bddp1.model.OrdenTerritorio;
import com.bddp1.model.ProductoVendido;
import com.bddp1.model.Venta;

import java.sql.SQLException;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.List;

/**
 *
 * @author Anahí
 */
public class BDD extends javax.swing.JFrame {
    /*
     * Creamos las variables que van a recibir los parámtros de la BDD
     * F (flag)
     */
    static int IDCat, IDOrder, Cantidad, method, F;
    String territory, category, emailA, emailN;
    EntityManagerFactory mf = null;
    EntityManager em = null;

    /**
     * Creates new form BDD
     */
    public BDD() {
        initComponents();
        this.setTitle("Equipo 10");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListaConsultas = new javax.swing.JList<>();
        Ins1 = new javax.swing.JLabel();
        Ins2 = new javax.swing.JLabel();
        TiVar1 = new javax.swing.JLabel();
        TiVar2 = new javax.swing.JLabel();
        Var1 = new javax.swing.JTextField();
        Var2 = new javax.swing.JTextField();
        Titulo = new javax.swing.JLabel();
        Consultar = new javax.swing.JButton();
        Descripcion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 51, 0));

        ListaConsultas.setBackground(new java.awt.Color(153, 204, 255));
        ListaConsultas.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "A", "B", "C", "D", "E", "F", "G" };

            public int getSize() {
                return strings.length;
            }

            public String getElementAt(int i) {
                return strings[i];
            }
        });
        ListaConsultas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListaConsultasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ListaConsultas);

        Ins1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Ins1.setForeground(new java.awt.Color(255, 255, 255));
        Ins1.setText("1. Escoja una consulta a realizar:");

        Ins2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Ins2.setForeground(new java.awt.Color(255, 255, 255));
        Ins2.setText("2. Llene los campos solicitados");

        TiVar1.setForeground(new java.awt.Color(153, 204, 255));
        TiVar1.setText("---");

        TiVar2.setForeground(new java.awt.Color(153, 204, 255));
        TiVar2.setText("---");

        Var1.setBackground(new java.awt.Color(153, 204, 255));
        Var1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        Var2.setBackground(new java.awt.Color(153, 204, 255));
        Var2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        Titulo.setBackground(new java.awt.Color(255, 255, 255));
        Titulo.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Titulo.setForeground(new java.awt.Color(255, 153, 153));
        Titulo.setText("Fragmentación Horizontal");

        Consultar.setBackground(new java.awt.Color(255, 204, 204));
        Consultar.setText("Consultar");
        Consultar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ConsultarMouseClicked(evt);
            }
        });

        Descripcion.setForeground(new java.awt.Color(255, 255, 255));
        Descripcion.setText("Descripción");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(Ins1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane1)
                                        .addComponent(Descripcion, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 209,
                                        Short.MAX_VALUE)
                                .addGroup(jPanel1Layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(TiVar1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Ins2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Var1)
                                        .addComponent(TiVar2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Var2))
                                .addGap(42, 42, 42))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(191, 191, 191)
                                                .addComponent(Titulo))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(260, 260, 260)
                                                .addComponent(Consultar)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(Titulo)
                                .addGap(37, 37, 37)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Ins1)
                                        .addComponent(Ins2))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout
                                                .createSequentialGroup()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 87,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11,
                                                        Short.MAX_VALUE)
                                                .addComponent(Descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 76,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(126, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(TiVar1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(Var1, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(28, 28, 28)
                                                .addComponent(TiVar2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(Var2, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(Consultar)
                                                .addGap(24, 24, 24)))));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ListaConsultasMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_ListaConsultasMouseClicked
        /*
         * Usamos un switch para asignar los campos a pedir al usuario,
         * para deshabilita los campos que no se requieren
         * y mostrar la descripción de cada consulta
         */
        Var1.enable(true);
        Var2.enable(true);
        switch (ListaConsultas.getSelectedIndex()) {
            case 0:
                TiVar1.setText("ID Categoría (dígito):");
                TiVar2.setText("");
                Var1.setText("1");
                Descripcion.setText(
                        "<html>Determina el total de ventas de los productos para cada<br> territorio de acuerdo a la categoría solicitada</html>");
                Var2.enable(false);
                F = 0;
                break;
            case 1:
                TiVar1.setText("Territorio (texto):");
                TiVar2.setText("");
                Var1.setText("");
                Descripcion.setText(
                        "<html>Determinar el producto más solicitado para la región<br> (atributo group de salesterritory)“Noth America”y en<br> que territorio de la región tiene mayor demanda.</html>");
                Var2.enable(false);
                F = 1;
                break;
            case 2:
                TiVar1.setText("ID Categoría (dígito):");
                TiVar2.setText("");
                Var1.setText("1");
                Descripcion.setText(
                        "<html>Actualizar el stock disponibleen un 5%delos productos de la <br>categoría que se provea como argumento de entradaen una<br> localidad que se provea como entrada en la instrucción de actualización</html>");
                Var2.enable(false);
                F = 2;
                break;
            case 3:
                TiVar1.setText("");
                TiVar2.setText("");
                Descripcion.setText(
                        "<html>Determinar si hay clientes que realizan ordenes en territorios<br> diferentes al que se encuentran. ");
                Var1.enable(false);
                Var2.enable(false);
                F = 3;
                break;
            case 4:
                TiVar1.setText("ID Orden (dígito):");
                TiVar2.setText("Cantidad de productos (dígito):");
                Var1.setText("1");
                Var2.setText("1");
                Descripcion.setText(
                        "<html>Actualizar  la  cantidad  de  productos  de  una  ordenque<br>  seprovea  como argumento en la instrucción de actualización.</html>");
                F = 4;
                break;
            case 5:
                TiVar1.setText("ID Orden (dígito):");
                TiVar2.setText("Método (dígito):");
                Var1.setText("1");
                Var2.setText("1");
                Descripcion.setText(
                        "<html>Actualizar el métodode envío de una orden que se<br> reciba como argumento en la instrucción de actualización.</html>");
                F = 5;
                break;
            case 6:
                TiVar1.setText("");
                TiVar2.setText("Email nuevo:");
                Var1.enable(false);
                // Var1.setText("");
                Var2.setText("");
                Descripcion.setText(
                        "<html>Actualizar el correo electrónico de una cliente que se reciba como<br>  argumento en la instrucción de actualización.</html>");
                F = 6;
                break;
        }
    }// GEN-LAST:event_ListaConsultasMouseClicked

    private void ConsultarMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_ConsultarMouseClicked
        /*
         * Dependiendo la consulta, guarda los datos insertados en el
         * campo en su correspondiente variable para enviar a la BDD
         * Habilita el JFrame con los resultados de la consulta
         */
        Resultados verResultados = new Resultados();
        switch (F) {
            case 0: {
                IDCat = Integer.parseInt(Var1.getText());

                try {
                    mf = Persistence.createEntityManagerFactory("persistencia");
                    em = mf.createEntityManager();
                    VentaDAO ventaDAO = new SQLVentaDAO(em);
                    List<Venta> ventas = ventaDAO.getTotalVentasProducto(IDCat);
                    verResultados.Charge(ventas, null, null, 0);
                } catch (Exception e) {

                    // TODO: handle exception
                } finally {
                    try {
                        if (em != null) {
                            em.close();
                        }

                    } catch (Exception e) {

                    }

                    try {
                        if (mf != null) {
                            mf.close();
                        }

                    } catch (Exception e) {

                    }
                }

                verResultados.setVisible(true);
                break;
            }
            case 1: {
                territory = Var1.getText();

                try {
                    mf = Persistence.createEntityManagerFactory("persistencia");
                    em = mf.createEntityManager();

                    ProductoDAO sqlVentaDAO = new SQLProductoDAO(em);

                    ProductoVendido productoVendido = sqlVentaDAO.getProdMoreRequested(territory);
                    verResultados.Charge(null, productoVendido, null, 1);
                    // System.out.println("Conexión realizada con exito");
                } catch (Exception e) {

                    // TODO: handle exception
                } finally {
                    try {
                        if (em != null) {
                            em.close();
                        }

                    } catch (Exception e) {

                    }

                    try {
                        if (mf != null) {
                            mf.close();
                        }

                    } catch (Exception e) {

                    }
                }

                verResultados.setVisible(true);
                break;
            }
            case 2: {
                EntityManagerFactory mf = null;
                EntityManager em = null;
                category = Var1.getText();

                ProductoVendido productoVendido = null;
                int pId = 0;

                try {
                    mf = Persistence.createEntityManagerFactory("persistencia");
                    em = mf.createEntityManager();

                    ProductoDAO sqlVentaDAO = new SQLProductoDAO(em);

                    sqlVentaDAO.getProductIdtoUpdate(Integer.parseInt(category));

                    System.out.println("Conexión realizada con exito");
                    JOptionPane.showMessageDialog(rootPane, "Actualización realizada con éxito", "Confirmación",
                            JOptionPane.CLOSED_OPTION);
                } catch (Exception e) {
                    System.out.println("No se pudo realizar la conexion");
                    // System.out.println(e.toString());
                    JOptionPane.showMessageDialog(rootPane, "Error", "Confirmación",
                            JOptionPane.CLOSED_OPTION);
                    
                } finally {

                    try {
                        if (em != null) {
                            em.close();
                        }

                    } catch (Exception e) {

                    }

                    try {
                        if (mf != null) {
                            mf.close();
                        }

                    } catch (Exception e) {

                    }

                }
                break;
            }
            case 3: {

                try {
                    mf = Persistence.createEntityManagerFactory("persistencia");
                    em = mf.createEntityManager();
                    List<OrdenTerritorio> ordenes = null;
                    OrdenDAO ordenDAo = new SQLOrdenDAO(em);

                    ordenes = ordenDAo.getCustomerDiffTerritory();
                    verResultados.Charge(null, null, ordenes, 2);
                } catch (Exception e) {

                } finally {

                    try {
                        if (em != null) {
                            em.close();
                        }

                    } catch (Exception e) {

                    }

                    try {
                        if (mf != null) {
                            mf.close();
                        }

                    } catch (Exception e) {

                    }

                }

                JOptionPane.showMessageDialog(rootPane, "Actualización realizada con éxito", "Confirmación",
                        JOptionPane.CLOSED_OPTION);
                verResultados.setVisible(true);
                break;
            }
            case 4: {
                IDOrder = Integer.parseInt(Var1.getText());
                Cantidad = Integer.parseInt(Var2.getText());
                try {
                    mf = Persistence.createEntityManagerFactory("persistencia");
                    em = mf.createEntityManager();
                    OrdenDAO ordenDAo = new SQLOrdenDAO(em);

                    ordenDAo.updateProductsOrder(IDOrder, Cantidad);
                    verResultados.setVisible(true);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(rootPane, "No se actualizó", "Confirmación",
                            JOptionPane.CLOSED_OPTION);
                } finally {

                    try {
                        if (em != null) {
                            em.close();
                        }

                    } catch (Exception e) {

                    }

                    try {
                        if (mf != null) {
                            mf.close();
                        }

                    } catch (Exception e) {

                    }

                }

                break;
            }
            case 5: {
                IDOrder = Integer.parseInt(Var1.getText());
                method = Integer.parseInt(Var2.getText());
                try {
                    mf = Persistence.createEntityManagerFactory("persistencia");
                    em = mf.createEntityManager();
                    OrdenDAO ordenDAo = new SQLOrdenDAO(em);
                    ordenDAo.updateOrdenDeliver(IDOrder, method);
                    JOptionPane.showMessageDialog(rootPane, "Actualización realizada con éxito", "Confirmación",
                            JOptionPane.CLOSED_OPTION);
                    verResultados.setVisible(false);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(rootPane, "No se actualizó", "Confirmación",
                            JOptionPane.CLOSED_OPTION);
                } finally {

                    try {
                        if (em != null) {
                            em.close();
                        }

                    } catch (Exception e) {

                    }

                    try {
                        if (mf != null) {
                            mf.close();
                        }

                    } catch (Exception e) {

                    }

                }
                break;
            }
            case 6: {
                 emailA = Var1.getText();
                emailN = Var2.getText();

                int idEmail = 0;
                try {
                    mf = Persistence.createEntityManagerFactory("persistencia");
                    em = mf.createEntityManager();
                    ClienteDAO personDAO = new SQLClienteDAO(em);
                    personDAO.updateEmail(emailA, emailN);
                    JOptionPane.showMessageDialog(rootPane, "Actualización realizada con éxito", "Confirmación",
                            JOptionPane.CLOSED_OPTION);
                    verResultados.setVisible(false);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(rootPane, "No existe ese correo", "Confirmación",
                            JOptionPane.CLOSED_OPTION);
                } finally {

                    try {
                        if (em != null) {
                            em.close();
                        }

                    } catch (Exception e) {

                    }

                    try {
                        if (mf != null) {
                            mf.close();
                        }

                    } catch (Exception e) {

                    }

                }

                if (idEmail == 0) {
                    
                } else {
                    
                }
                break;
            }
        }
        System.out.println(Var1.getText());
        System.out.println(Var2.getText());
    }// GEN-LAST:event_ConsultarMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BDD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BDD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BDD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BDD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BDD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Consultar;
    private javax.swing.JLabel Descripcion;
    private javax.swing.JLabel Ins1;
    private javax.swing.JLabel Ins2;
    private javax.swing.JList<String> ListaConsultas;
    private javax.swing.JLabel TiVar1;
    private javax.swing.JLabel TiVar2;
    private javax.swing.JLabel Titulo;
    private javax.swing.JTextField Var1;
    private javax.swing.JTextField Var2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
