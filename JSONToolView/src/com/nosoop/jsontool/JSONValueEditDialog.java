/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nosoop.jsontool;

import bundled.jsontool.org.json.JSONArray;
import bundled.jsontool.org.json.JSONException;
import com.nosoop.inputdialog.ModalInputDialog;

/**
 *
 * @author nosoop < nosoop at users.noreply.github.com >
 */
public class JSONValueEditDialog extends ModalInputDialog<JSONValueEditDialog.JSONValueDialogResponse> {
    static enum ValueTypes {
        BOOLEAN, DOUBLE, INT, LONG, STRING, ARRAY, NULL;

        @Override
        public String toString() {
            return this.name();
        }

        public static ValueTypes getValueType(Object object) {
            if (object == null) {
                return NULL;
            }
            
            switch (object.getClass().getSimpleName()) {
                case "Integer":
                    return INT;
                case "Boolean":
                    return BOOLEAN;
                case "Double":
                    return DOUBLE;
                case "JSONArray":
                    return ARRAY;
            }
            return STRING;
        }
    }
    
    static enum ReturnValue {
        SAVE, CANCEL;
    }

    public static class JSONValueDialogResponse {
        String key;
        Object value;
        ReturnValue dialogResponse;
    }

    String key;
    Object value;
    ReturnValue dialogResponse;

    /**
     * Creates new form JSONValueEditDialog
     */
    public JSONValueEditDialog(java.awt.Frame parent, String key, Object value) {
        super(parent);

        this.key = key;
        this.value = value;
        this.dialogResponse = ReturnValue.CANCEL;

        initComponents();

        editTypeDropdown.setSelectedItem(ValueTypes.getValueType(value));
        
        this.getRootPane().setDefaultButton(editSaveButton);

        this.setVisible(true);
    }

    @Override
    public JSONValueEditDialog.JSONValueDialogResponse getReturnValue() {
        JSONValueDialogResponse response = new JSONValueDialogResponse();
        response.key = key;
        response.value = value;
        response.dialogResponse = dialogResponse;

        return response;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        editNameLabel = new javax.swing.JLabel();
        editNameField = new javax.swing.JTextField();
        editTypeLabel = new javax.swing.JLabel();
        editTypeDropdown = new javax.swing.JComboBox();
        editValueLabel = new javax.swing.JLabel();
        editCancelButton = new javax.swing.JButton();
        editSaveButton = new javax.swing.JButton();
        editValueField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editing key " + key);

        editNameLabel.setText("Key:");

        editNameField.setText(this.key);

        editTypeLabel.setText("Type:");

        editTypeDropdown.setModel(new javax.swing.DefaultComboBoxModel(ValueTypes.values()));
        editTypeDropdown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editTypeDropdownActionPerformed(evt);
            }
        });

        editValueLabel.setText("Value:");

        editCancelButton.setText("Cancel");
        editCancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editCancelButtonActionPerformed(evt);
            }
        });

        editSaveButton.setText("Save");
        editSaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editSaveButtonActionPerformed(evt);
            }
        });

        editValueField.setText(this.value != null ? this.value.toString() : "");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(editNameField)
                    .addComponent(editTypeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(editTypeDropdown, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(editValueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 244, Short.MAX_VALUE)
                        .addComponent(editSaveButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(editCancelButton))
                    .addComponent(editValueField))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(editNameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(editTypeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editTypeDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(editValueLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editValueField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editCancelButton)
                    .addComponent(editSaveButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editCancelButtonActionPerformed
        // Return current key/value pair.
        this.setVisible(false);
    }//GEN-LAST:event_editCancelButtonActionPerformed

    private void editSaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editSaveButtonActionPerformed
        key = editNameField.getText();
        String stringValue = editValueField.getText();

        // Convert value to expected type.
        // TODO Show if a value can't be parsed as the type when typing.
        switch ((ValueTypes) editTypeDropdown.getSelectedItem()) {
            case BOOLEAN:
                value = Boolean.parseBoolean(stringValue);
                break;
            case INT:
                value = Integer.parseInt(stringValue);
                break;
            case LONG:
                value = Long.parseLong(stringValue);
                break;
            case DOUBLE:
                value = Double.parseDouble(stringValue);
                break;
            case ARRAY:
                try {
                    value = new JSONArray(stringValue);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                break;
            case NULL:
                value = null;
                break;
            case STRING:
                value = stringValue;
                break;
            default:
                throw new AssertionError("Value not one of the known typess.");
        }
        
        this.dialogResponse = ReturnValue.SAVE;

        this.setVisible(false);
    }//GEN-LAST:event_editSaveButtonActionPerformed

    private void editTypeDropdownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editTypeDropdownActionPerformed
        // Disable field on null.
        if (editTypeDropdown.getSelectedItem() == ValueTypes.NULL) {
            editValueField.setEnabled(false);
        } else {
            editValueField.setEnabled(true);
        }
    }//GEN-LAST:event_editTypeDropdownActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton editCancelButton;
    private javax.swing.JTextField editNameField;
    private javax.swing.JLabel editNameLabel;
    private javax.swing.JButton editSaveButton;
    private javax.swing.JComboBox editTypeDropdown;
    private javax.swing.JLabel editTypeLabel;
    private javax.swing.JTextField editValueField;
    private javax.swing.JLabel editValueLabel;
    // End of variables declaration//GEN-END:variables
}