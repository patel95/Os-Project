
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dell
 */
public class MainForm extends javax.swing.JFrame {

    String algo;
    DefaultTableModel dtm;
    int arrival,burst,priority;
    int c=1;
    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        ProcessTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        arrivaltime = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        bursttime = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        prioritytf = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        AlgoComboBox = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ProcessTable.setModel(new DefaultTableModel(new Object [][] {},new String [] {"Process ID","Arrival Time","CPU Burst", "Priority"}));
        jScrollPane1.setViewportView(ProcessTable);

        jLabel1.setText("Arrival Time");

        arrivaltime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arrivaltimeActionPerformed(evt);
            }
        });

        jLabel2.setText("Burst Time");

        jLabel3.setText("Priority");

        jButton1.setText("Add Job/Process");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Select the algorithm");

        AlgoComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "FCFS", "SJF", "Priority", "SRTF", "Round Robin" }));
        AlgoComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlgoComboBoxActionPerformed(evt);
            }
        });

        jButton2.setText("Display Gantt Chart");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Clear All");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(172, 172, 172)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(125, 125, 125)
                        .addComponent(AlgoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(110, 110, 110)
                            .addComponent(prioritytf, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(110, 110, 110)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(arrivaltime, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                                .addComponent(bursttime)))))
                .addContainerGap(262, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(jButton1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(213, 213, 213))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(arrivaltime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(bursttime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(prioritytf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(AlgoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jButton2)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        
         dtm=(DefaultTableModel)ProcessTable.getModel();
        if(arrivaltime.getText().equals("") || bursttime.getText().equals("") || prioritytf.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please enter all the fields.");
        }
        else
        {
            arrival=Integer.parseInt(this.arrivaltime.getText());
        burst=Integer.parseInt(this.bursttime.getText());
        priority=Integer.parseInt(this.prioritytf.getText());
            dtm.addRow(new Object[]{c, arrival, burst, priority});
            c++;
        }
        this.arrivaltime.setText("");
        this.bursttime.setText("");
        this.prioritytf.setText("");
    
    }//GEN-LAST:event_jButton1ActionPerformed

    private void AlgoComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlgoComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AlgoComboBoxActionPerformed

    private void arrivaltimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arrivaltimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_arrivaltimeActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int processArray[]=new int[dtm.getRowCount()];
        int arrivalArray[]=new int[dtm.getRowCount()];
        int burstArray[]=new int[dtm.getRowCount()];
        int priorityArray[]=new int[dtm.getRowCount()];
        
        int i;
        for(i=0;i<dtm.getRowCount();i++)
        {
            processArray[i]=(int)dtm.getValueAt(i, 0);
            arrivalArray[i]=(int)dtm.getValueAt(i, 1);
            burstArray[i]=(int)dtm.getValueAt(i, 2);
            priorityArray[i]=(int)dtm.getValueAt(i, 3);
        }
        algo=(String) this.AlgoComboBox.getSelectedItem();
        
        JOptionPane.showMessageDialog(this,"The priorities will be considered only in case of Priority Scheduling.");
        
        
        
        
        
        
        if(algo.equals("FCFS"))
        {
            
            FCFS obj=new FCFS(processArray, arrivalArray, burstArray, priorityArray);
            obj.calculate();
        }
        else if(algo.equals("SJF"))
        {
            SJF obj=new SJF(processArray, arrivalArray, burstArray, priorityArray);
            obj.calculate();
        }
        else if(algo.equals("Priority"))
        {
            Priority obj=new Priority(processArray, arrivalArray, burstArray, priorityArray);
            obj.calculate();
        }
        else if(algo.equals("SRTF"))
        {
            SRTF obj=new SRTF(processArray, arrivalArray, burstArray, priorityArray);
            obj.calculate();
            
        }
        else if(algo.equals("Round Robin"))
        {
            dtm=(DefaultTableModel)ProcessTable.getModel();
            String tq=JOptionPane.showInputDialog(this, "Enter time quantum:");
            RoundRobin obj=new RoundRobin(processArray, arrivalArray, burstArray, priorityArray, Integer.parseInt(tq));
            obj.calculate();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int rowCount = dtm.getRowCount();
for (int i = rowCount - 1; i >= 0; i--) {
    dtm.removeRow(i);
}
c=1;
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox AlgoComboBox;
    private javax.swing.JTable ProcessTable;
    private javax.swing.JTextField arrivaltime;
    private javax.swing.JTextField bursttime;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField prioritytf;
    // End of variables declaration//GEN-END:variables
}
