/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */


/*KATHIA*/
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

//////////////////////////////////////KATHIA/////////////////////////////////////////////////////////
public class main extends javax.swing.JFrame {
    private DefaultTableModel modelo;
    private JTable miTablaProcesos;

    public main() {
        initComponents();
        getContentPane().setBackground(Color.WHITE);
        this.setLocationRelativeTo(null);
        No_procesos.setEditable(false);
        configurarTabla();
        //mostrar_procesos();
    }

    private void configurarTabla() {
        modelo = new DefaultTableModel(new Object[][]{},
            new String[]{"Aplicaciones", "Nombre", "PID", "Tipo de sesión", "Número de sesión", "memoria"}) {
            Class[] types = new Class[]{
                ImageIcon.class, String.class, String.class, String.class, String.class, String.class
            };
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }

            public Class<?> getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        };

        jtabla_datos.setModel(modelo);

        DefaultTableCellRenderer Alinear = new DefaultTableCellRenderer();
        Alinear.setHorizontalAlignment(SwingConstants.RIGHT);
        for (int col = 2; col <= 5; col++) {
            jtabla_datos.getColumnModel().getColumn(col).setCellRenderer(Alinear);
        }
    }
////////////////////////////////////////PABLO///////////////////////////////////////////////////////////////////
    
/////////////////////////////MISHEL/////////////////////////////////////////////////
 public static ImageIcon obtenerIconoDeExe(String nombreProceso) {
    try {
        File f = new File("C:\\Windows\\System32\\" + nombreProceso);
        if (f.exists()) {
            javax.swing.Icon icon = FileSystemView.getFileSystemView().getSystemIcon(f);
            return escalarIcono(icon, 16, 16);
        }
    } catch (Exception e) {
        // ignorar
    }

// Ícono genérico: logo de Windows clásico sin fondo
int size = 16;
BufferedImage img = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
Graphics2D g2 = img.createGraphics();
g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

// No se dibuja fondo: transparencia

// Tamaño de cada panel
int gap = 1;
int w = (size - gap * 3) / 2;
int h = (size - gap * 3) / 2;

// Panel superior izquierdo (rojo)
g2.setColor(new Color(198, 0, 0));
g2.fillRect(gap, gap, w, h);

// Panel superior derecho (verde)
g2.setColor(new Color(0, 128, 0));
g2.fillRect(gap * 2 + w, gap, w, h);

// Panel inferior izquierdo (azul)
g2.setColor(new Color(0, 102, 204));
g2.fillRect(gap, gap * 2 + h, w, h);

// Panel inferior derecho (amarillo)
g2.setColor(new Color(255, 204, 0));
g2.fillRect(gap * 2 + w, gap * 2 + h, w, h);

g2.dispose();
return new ImageIcon(img);
}
// Método auxiliar para escalar íconos de Windows
private static ImageIcon escalarIcono(javax.swing.Icon icon, int w, int h) {
    BufferedImage img = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
    Graphics g = img.createGraphics();
    icon.paintIcon(null, g, 0, 0);
    g.dispose();
    return new ImageIcon(img.getScaledInstance(w, h, Image.SCALE_SMOOTH));
}

//////////////////////////////////ALISSON//////////////////////////////////////////////////////////////////////////////

////////////////////////////////PABLO//////////////////////////////////////////////////////////////
 
///////////////////////////KATHIA/////////////////////////////////////////////////////////
 public void Matar_proceso() {
        int fila = jtabla_datos.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "ERROR, No se ha seleccionado ningún proceso", "Error", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        String pid = String.valueOf(modelo.getValueAt(fila, 2));
        try {
            Process hijo = Runtime.getRuntime().exec("taskkill /F /PID " + pid);
            hijo.waitFor();
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtabla_datos = new javax.swing.JTable();
        jIniciar_procesos = new javax.swing.JButton();
        jterminar_procesos = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        No_procesos = new javax.swing.JTextField();
        GRAFIC = new javax.swing.JButton();
        nuevatarea = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        Configuracion = new javax.swing.JButton();
        Eficiencia = new javax.swing.JButton();
        Vista = new javax.swing.JButton();
        Historial = new javax.swing.JButton();
        arranque = new javax.swing.JButton();
        usuario = new javax.swing.JButton();
        detalles = new javax.swing.JButton();
        servicios = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusCycleRoot(false);

        jtabla_datos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtabla_datos.setFont(new java.awt.Font("Footlight MT Light", 1, 14)); // NOI18N
        jtabla_datos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "PID", "Tipo de sesión ", "Número de sesión", "Uso de memoria"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtabla_datos);

        jIniciar_procesos.setText("Actualizar");
        jIniciar_procesos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jIniciar_procesosActionPerformed(evt);
            }
        });

        jterminar_procesos.setText("⛔Finalizar Tarea");
        jterminar_procesos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jterminar_procesosActionPerformed(evt);
            }
        });

        jLabel2.setText("TOTAL DE PROCESOS: ");

        No_procesos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                No_procesosActionPerformed(evt);
            }
        });

        GRAFIC.setText("📈");
        GRAFIC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GRAFICActionPerformed(evt);
            }
        });

        nuevatarea.setText("➕Ejecutar Nueva Tarea ");
        nuevatarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevatareaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        jLabel1.setText("PROCESOS");

        jButton1.setForeground(new java.awt.Color(204, 204, 255));

        jButton2.setForeground(new java.awt.Color(204, 204, 255));

        Configuracion.setText("Config");
        Configuracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfiguracionActionPerformed(evt);
            }
        });

        Eficiencia.setText("🍃Modo de Eficiencia");

        Vista.setText(". . .");
        Vista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VistaActionPerformed(evt);
            }
        });

        Historial.setText("Historial de aplicaciones");
        Historial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HistorialActionPerformed(evt);
            }
        });

        arranque.setText("aplicaciones de arranque");
        arranque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arranqueActionPerformed(evt);
            }
        });

        usuario.setText("Usuarios");

        detalles.setText("Detalles");

        servicios.setText("Servicios");
        servicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serviciosActionPerformed(evt);
            }
        });

        jLabel3.setText("ALISSON");

        jLabel4.setText("KATHIA");

        jLabel5.setText("PABLO");

        jLabel6.setText("Alisson");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(No_procesos, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jIniciar_procesos)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(GRAFIC, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Historial)
                                            .addComponent(jLabel4)
                                            .addComponent(arranque)
                                            .addComponent(usuario)
                                            .addComponent(jLabel5)
                                            .addComponent(detalles)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(jLabel6))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(Configuracion)
                                                .addComponent(servicios)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 909, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(202, 202, 202)
                        .addComponent(nuevatarea)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jterminar_procesos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Eficiencia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Vista)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(129, 129, 129))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 920, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap()))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(No_procesos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jIniciar_procesos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nuevatarea)
                    .addComponent(jterminar_procesos)
                    .addComponent(Eficiencia)
                    .addComponent(Vista)
                    .addComponent(jLabel1))
                .addGap(20, 20, 20)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 9, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(GRAFIC)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Historial)
                        .addGap(18, 18, 18)
                        .addComponent(arranque)
                        .addGap(14, 14, 14)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(usuario)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(detalles)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(servicios)
                        .addGap(49, 49, 49)
                        .addComponent(Configuracion)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jIniciar_procesosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jIniciar_procesosActionPerformed
//////PABLO/////
      
    }//GEN-LAST:event_jIniciar_procesosActionPerformed

    private void jterminar_procesosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jterminar_procesosActionPerformed
//////KATHIA//////////
       
    }//GEN-LAST:event_jterminar_procesosActionPerformed

    private void No_procesosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_No_procesosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_No_procesosActionPerformed

    private void GRAFICActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GRAFICActionPerformed
///////////ALISSON//////////
    
    }//GEN-LAST:event_GRAFICActionPerformed

    private void nuevatareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevatareaActionPerformed
        // TODO add your handling code here:
////////////////////MISHEL///////////////////////////////////////////////////                              
     JDialog dialogo = new JDialog(this, "Crear nueva tarea", true);
    dialogo.setSize(420, 180);
    dialogo.setLayout(null);
    dialogo.setLocationRelativeTo(this);

    JLabel lblTexto = new JLabel("Escriba el nombre del programa, carpeta, documento o recurso de Internet:");
    lblTexto.setBounds(20, 10, 380, 20);
    dialogo.add(lblTexto);

    JLabel lblAbrir = new JLabel("Abrir:");
    lblAbrir.setBounds(20, 40, 50, 20);
    dialogo.add(lblAbrir);

    JTextField campo = new JTextField();
    campo.setBounds(70, 40, 320, 25);
    dialogo.add(campo);

    JCheckBox admin = new JCheckBox("Crear esta tarea con privilegios administrativos");
    admin.setBounds(20, 70, 360, 20);
    dialogo.add(admin);

    JButton ejecutar = new JButton("Aceptar");
    ejecutar.setBounds(300, 100, 90, 30);
    dialogo.add(ejecutar);

    ejecutar.addActionListener(ev -> {
        String comando = campo.getText().trim();
        if (!comando.isEmpty()) {
            try {
                String[] cmd = admin.isSelected()
                    ? new String[]{"cmd", "/c", "start", "cmd", "/k", comando}
                    : new String[]{"cmd", "/c", comando};
                Runtime.getRuntime().exec(cmd);
                dialogo.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(dialogo, "Error al ejecutar la tarea", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    });

    dialogo.setVisible(true);

    }//GEN-LAST:event_nuevatareaActionPerformed

    private void ConfiguracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfiguracionActionPerformed
      
       // TODO add your handling code here:       
      /////////// //MISHEL////////////////////////////////
 JDialog config = new JDialog(this, "Configuración", true);
    config.setSize(400, 220);
    config.setLayout(null);
    config.setLocationRelativeTo(this);

    JLabel lblTema = new JLabel("Tema de la aplicación:");
    lblTema.setBounds(20, 20, 150, 20);
    config.add(lblTema);

    String[] opcionesTema = {"Claro", "Oscuro", "Usar configuración del sistema"};
    JComboBox<String> comboTema = new JComboBox<>(opcionesTema);
    comboTema.setBounds(180, 20, 180, 25);
    config.add(comboTema);

    JLabel lblInicio = new JLabel("Página de inicio predeterminada:");
    lblInicio.setBounds(20, 60, 200, 20);
    config.add(lblInicio);

    String[] paginas = {"Procesos", "Rendimiento", "Usuarios", "Detalles"};
    JComboBox<String> comboInicio = new JComboBox<>(paginas);
    comboInicio.setBounds(180, 60, 180, 25);
    config.add(comboInicio);

    JButton guardar = new JButton("Guardar ⚙️");
    guardar.setBounds(260, 120, 100, 30);
    config.add(guardar);

    guardar.addActionListener(e -> {
        String temaSeleccionado = (String) comboTema.getSelectedItem();

        try {
            switch (temaSeleccionado) {
                case "Claro":
                    UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                    break;
                case "Oscuro":
                    UIManager.setLookAndFeel("com.formdev.flatlaf.FlatDarkLaf");
                    break;
                case "Usar configuración del sistema":
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    break;
            }

            // Actualiza todos los componentes abiertos
            SwingUtilities.updateComponentTreeUI(this);
            this.pack(); // opcional: ajusta tamaño si cambia el estilo

            JOptionPane.showMessageDialog(config, "Tema aplicado: " + temaSeleccionado);
            config.dispose();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(config, "Error al aplicar el tema", "Error", JOptionPane.ERROR_MESSAGE);
        }
    });

    config.setVisible(true);
    }//GEN-LAST:event_ConfiguracionActionPerformed

    private void HistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HistorialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HistorialActionPerformed

    private void VistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VistaActionPerformed
//////////////////////ALISSON///////////////////////////////////////////

    }//GEN-LAST:event_VistaActionPerformed

    private void arranqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arranqueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_arranqueActionPerformed

    private void serviciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serviciosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_serviciosActionPerformed

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
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main().setVisible(true);
            }
        });
    }
//
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Configuracion;
    private javax.swing.JButton Eficiencia;
    private javax.swing.JButton GRAFIC;
    private javax.swing.JButton Historial;
    private javax.swing.JTextField No_procesos;
    private javax.swing.JButton Vista;
    private javax.swing.JButton arranque;
    private javax.swing.JButton detalles;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jIniciar_procesos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtabla_datos;
    private javax.swing.JButton jterminar_procesos;
    private javax.swing.JButton nuevatarea;
    private javax.swing.JButton servicios;
    private javax.swing.JButton usuario;
    // End of variables declaration//GEN-END:variables
}
