package com.carwash.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MessageAdminInvoicing {
    private JPanel main;
    private JPanel top;
    private JPanel center;
    private JLabel invoicing;
    private JButton backToStartButton;

    public MessageAdminInvoicing() {
        backToStartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                redirectToMainCarWash();
            }
        });
    }


    /**
     * Navigates the current window to the MainCarWash view.
     */
    public void redirectToMainCarWash() {
        MainCarWash carWash = new MainCarWash();
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(main);
        frame.setContentPane(carWash.getMain());
        frame.revalidate();
        frame.repaint();
    }


    public void pegarFaturamento(String dadosFaturamento) {
        invoicing.setText("R$ " + dadosFaturamento);
    }

    public JPanel getMain() {
        return main;
    }
}
