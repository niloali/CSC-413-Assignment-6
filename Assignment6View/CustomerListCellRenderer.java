//Nilofar Ali
//CSC 413 Spring 2024
//Assignment 6
package Assignment6View;

import Assignment6Model.BankCustomer;

import javax.swing.*;
import java.awt.*;

// Custom cell renderer to display only the full name
class CustomerListCellRenderer extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        if (value instanceof BankCustomer) {
            BankCustomer customer = (BankCustomer) value;
            value = customer.getName();
        }
        return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
    }
}