/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.clickcounter;

/**
 *
 * @author Administrator
 */
public class ClickGame extends javax.swing.JFrame {

    /**
     * Creates new form ClickGame
     */
    int count = 0;
    boolean isTimeUp = false;
    int currentScore = 0;

    public ClickGame() {
        initComponents();

        Thread thread = new Thread(() -> {
            for (int i = 15; i >= 0; i--) {
                String a = String.valueOf(i);
                labelTime.setText("Time : " + a);
                try {
                    Thread.sleep(1000); // 1000 milisaniye (1 saniye) beklet
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (i == 0 ) {
                    isTimeUp = true;
                }
            }
        });

        thread.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelNameOfGame = new javax.swing.JLabel();
        labelDescirption = new javax.swing.JLabel();
        buttonClick = new javax.swing.JButton();
        labelTime = new javax.swing.JLabel();
        labelClickCount = new javax.swing.JLabel();
        labelBest = new javax.swing.JLabel();
        buttonRestart = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelNameOfGame.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        labelNameOfGame.setText("Click Counter Game");

        labelDescirption.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelDescirption.setText("Welcome !");

        buttonClick.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        buttonClick.setText("CLICK");
        buttonClick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClickActionPerformed(evt);
            }
        });

        labelTime.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelTime.setText("Time : 15");
        labelTime.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelTimeMouseClicked(evt);
            }
        });

        labelClickCount.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelClickCount.setText("Click Count : 0");

        labelBest.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        labelBest.setText("BEST : 0");

        buttonRestart.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        buttonRestart.setText("Restart");
        buttonRestart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRestartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelNameOfGame)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                                .addComponent(labelBest))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelDescirption)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelClickCount)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonRestart)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonClick)
                        .addGap(148, 148, 148))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelTime)
                .addGap(177, 177, 177))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelNameOfGame)
                    .addComponent(labelBest))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelDescirption)
                        .addGap(9, 9, 9)
                        .addComponent(labelTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonClick)
                        .addGap(54, 54, 54)
                        .addComponent(labelClickCount))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonRestart)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonClickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClickActionPerformed
        // TODO add your handling code here:

        if (!isTimeUp) {
            count++;
            currentScore = count;
            String b = String.valueOf(count);
            labelClickCount.setText("Click Count : " + b);
            
            int highScore = HighScore.getHighScore();

            if (currentScore > highScore) {
                highScore = currentScore;
                HighScore.saveHighScore(highScore);

                String best = String.valueOf(highScore);
                
                
                labelBest.setText("BEST : " + best);
            }
        }
    }//GEN-LAST:event_buttonClickActionPerformed

    private void labelTimeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelTimeMouseClicked
        // TODO add your handling code here:


    }//GEN-LAST:event_labelTimeMouseClicked

    private void buttonRestartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRestartActionPerformed
        // TODO add your handling code here:
        count = 0;
        isTimeUp = false;
        
        Thread thread = new Thread(() -> {
            for (int i = 15; i >= 0; i--) {
                String a = String.valueOf(i);
                labelTime.setText("Time : " + a);
                try {
                    Thread.sleep(1000); // 1000 milisaniye (1 saniye) beklet
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } 
                if (i == 0) {
                    isTimeUp = true;
                }
            }
        });
        thread.start();
    }//GEN-LAST:event_buttonRestartActionPerformed

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
            java.util.logging.Logger.getLogger(ClickGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClickGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClickGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClickGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClickGame().setVisible(true);
            }
        });
        /* Create and display the form */

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonClick;
    private javax.swing.JButton buttonRestart;
    private javax.swing.JLabel labelBest;
    private javax.swing.JLabel labelClickCount;
    private javax.swing.JLabel labelDescirption;
    private javax.swing.JLabel labelNameOfGame;
    private javax.swing.JLabel labelTime;
    // End of variables declaration//GEN-END:variables
}