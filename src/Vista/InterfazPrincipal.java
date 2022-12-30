/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import static Controlador.ControladorBusquedas.shellSort;
import static Controlador.ControladorBusquedas.shellSortD;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Victor
 */
public class InterfazPrincipal extends javax.swing.JFrame {
    
    
    int n = 20000;
    String[] array = new String[n];
    
    

    /**
     * Creates new form InterfazPrincipal
     */
    public InterfazPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public static void quickSort(String[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    public static int partition(String[] array, int low, int high) {
        String pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j].compareTo(pivot) < 0) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, high);
        return i + 1;
    }

    public static void swap(String[] array, int i, int j) {
        String temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    
    public static void quickSortD(String[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partitionD(array, low, high);
            quickSortD(array, low, pivotIndex - 1);
            quickSortD(array, pivotIndex + 1, high);
        }
    }

    public static int partitionD(String[] array, int low, int high) {
        String pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j].compareTo(pivot) > 0) {
                i++;
                swapD(array, i, j);
            }
        }

        swapD(array, i + 1, high);
        return i + 1;
    }

    public static void swapD(String[] array, int i, int j) {
        String temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnOrdenQuick = new javax.swing.JButton();
        btnOrdenarShell = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnCrearDatosAleatorios = new javax.swing.JButton();
        cbxOrdenacion = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSinOrdenar = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblOrdenadaShell = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblOrdenadaQuick = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LISTA DE 20000");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LISTA CON 20000 DATOS ALEATORIOS");

        btnOrdenQuick.setText("ORDENACION QUICK SORT");
        btnOrdenQuick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenQuickActionPerformed(evt);
            }
        });

        btnOrdenarShell.setText("ORDENACION SHELL");
        btnOrdenarShell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenarShellActionPerformed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("CREAR LOS 20000 DATOS ALEATORIOS");

        btnCrearDatosAleatorios.setText("CREAR DATOS");
        btnCrearDatosAleatorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearDatosAleatoriosActionPerformed(evt);
            }
        });

        cbxOrdenacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ascendente", "Desendente" }));
        cbxOrdenacion.setSelectedItem(null);

        tblSinOrdenar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblSinOrdenar);

        tblOrdenadaShell.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane5.setViewportView(tblOrdenadaShell);

        tblOrdenadaQuick.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane6.setViewportView(tblOrdenadaQuick);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("SELECCIONAR EL ORDENAMIENTO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnOrdenQuick)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnOrdenarShell))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCrearDatosAleatorios, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxOrdenacion, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(btnCrearDatosAleatorios)
                    .addComponent(cbxOrdenacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
                    .addComponent(jScrollPane5)
                    .addComponent(jScrollPane6))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOrdenQuick)
                    .addComponent(btnOrdenarShell))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearDatosAleatoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearDatosAleatoriosActionPerformed
        // TODO add your handling code here:
        
        Random rand = new Random();
        
        for (int i = 0; i < n; i++) {
            int len = rand.nextInt(10) + 1;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < len; j++) {
                char c = (char) (rand.nextInt(26) + 'a');
                sb.append(c);
            }
            array[i] = sb.toString();
        }

        for (String s : array) {
            
            System.out.println(s);
            
        }
        String[] columnNames = {"Datos sin ordenar"};
        Object[][] data = new Object[array.length][1];
        
        for (int i = 0; i < array.length; i++) {
            data[i][0] = array[i];
        }

        DefaultTableModel modelo = new DefaultTableModel(data, columnNames);
        tblSinOrdenar.setModel(modelo);

    }//GEN-LAST:event_btnCrearDatosAleatoriosActionPerformed

    private void btnOrdenarShellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenarShellActionPerformed
        // TODO add your handling code here:
        if (cbxOrdenacion.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "El metodo de ordenacion no esta seleccionado porfavor revise el combobox", "FALTA ORDEN", JOptionPane.WARNING_MESSAGE);
        }else if(tblSinOrdenar.getRowCount() <= 0){
            JOptionPane.showMessageDialog(null, "La tabla esta vacia, porfavor genere los datos aleatorios", "TABLA VACIA", JOptionPane.WARNING_MESSAGE);
        } 
        else {
            String opcion = (String) cbxOrdenacion.getSelectedItem().toString();

            if (opcion.equals("Ascendente")) {
                shellSort(array);
            }

            if (opcion.equals("Desendente")) {
                shellSortD(array);
            }

            for (String s : array) {
//            System.out.println(s);
            }

            String[] columnNames = {"Datos ordenados por shell"};
            Object[][] data = new Object[array.length][1];

            for (int i = 0; i < array.length; i++) {
                data[i][0] = array[i];
            }

            DefaultTableModel modelo = new DefaultTableModel(data, columnNames);
            tblOrdenadaShell.setModel(modelo);
        }
        
    }//GEN-LAST:event_btnOrdenarShellActionPerformed

    private void btnOrdenQuickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenQuickActionPerformed
        // TODO add your handling code here:
        
        if (cbxOrdenacion.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "El metodo de ordenacion no esta seleccionado porfavor revise el combobox", "FALTA ORDEN", JOptionPane.WARNING_MESSAGE);
        }else if(tblSinOrdenar.getRowCount() <= 0){
            JOptionPane.showMessageDialog(null, "La tabla esta vacia, porfavor genere los datos aleatorios", "TABLA VACIA", JOptionPane.WARNING_MESSAGE);
        }else{
            String opcion = (String) cbxOrdenacion.getSelectedItem().toString();

        if (opcion.equals("Ascendente")) {
            quickSort(array, 0, array.length - 1);
        }

        if (opcion.equals("Desendente")) {
            quickSortD(array, 0, array.length - 1);
        }
//        

//        quickSort(array, 0, array.length - 1);
//        System.out.println(Arrays.toString(array));
        String[] columnNames = {"Datos ordenados por quicksort"};
        Object[][] data = new Object[array.length][1];

        for (int i = 0; i < array.length; i++) {
            data[i][0] = array[i];
        }

        DefaultTableModel modelo = new DefaultTableModel(data, columnNames);
        tblOrdenadaQuick.setModel(modelo);
        }

    }//GEN-LAST:event_btnOrdenQuickActionPerformed

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
            java.util.logging.Logger.getLogger(InterfazPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearDatosAleatorios;
    private javax.swing.JButton btnOrdenQuick;
    private javax.swing.JButton btnOrdenarShell;
    public static javax.swing.JComboBox<String> cbxOrdenacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable tblOrdenadaQuick;
    private javax.swing.JTable tblOrdenadaShell;
    private javax.swing.JTable tblSinOrdenar;
    // End of variables declaration//GEN-END:variables
}
