/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author tuan
 */
public class InitElementArray extends javax.swing.JInternalFrame {

    /**
     * Creates new form InitElementArray

     */
    public InitElementArray(JButton button,JLabel label) {
        jbutton=button;
        jlabel=label;
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

        jValue = new javax.swing.JLabel();
        ValueField = new javax.swing.JTextField();
        bOK = new javax.swing.JButton();

        setClosable(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jValue.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jValue.setText("Value:");

        ValueField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ValueField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        ValueField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ValueFieldKeyPressed(evt);
            }
        });

        bOK.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        bOK.setText("OK");
        bOK.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                bOKFocusGained(evt);
            }
        });
        bOK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bOKMouseEntered(evt);
            }
        });
        bOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bOKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jValue)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ValueField)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bOK, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 45, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jValue, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ValueField, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bOK)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bOKActionPerformed
        
        try{
                int value;
                value = Integer.parseInt(ValueField.getText());
                if(value<100&&value>=0)
                {
                    jbutton.setText(Integer.toString(value));
                    jlabel.setText(Integer.toString(value));
                    dispose();
                } else
                {
                    ErrorNumberArray errorNumberArr = new ErrorNumberArray("Bạn phải nhập từ 0-99");
                    errorNumberArr.setVisible(false);
                    errorNumberArr.setLocation(300,50);
                    this.getParent().add(errorNumberArr,1);
                    errorNumberArr.setVisible(true);
                    errorNumberArr.moveToFront();
                }
                
        }catch (NumberFormatException e)
        {
           
            ErrorNumberArray errorNumberArr = new ErrorNumberArray("Bạn phải nhập một số");
            errorNumberArr.setVisible(false);
            errorNumberArr.setLocation(200,50);
            this.getParent().add(errorNumberArr,1);
            errorNumberArr.setVisible(true);
            errorNumberArr.moveToFront();
            
        }      
        
    }//GEN-LAST:event_bOKActionPerformed

    private void bOKMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bOKMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_bOKMouseEntered

    private void bOKFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bOKFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_bOKFocusGained

    private void ValueFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ValueFieldKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
            bOK.doClick();
    }//GEN-LAST:event_ValueFieldKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ValueField;
    private javax.swing.JButton bOK;
    private javax.swing.JLabel jValue;
    // End of variables declaration//GEN-END:variables
    private JButton jbutton; 
    private JLabel jlabel;
}
