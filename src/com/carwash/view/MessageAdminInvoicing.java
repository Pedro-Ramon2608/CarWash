package com.carwash.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MessageAdminInvoicing {
    private JPanel main;
    private JPanel top;
    private JPanel center;
    private JLabel faturamento;
    private JButton voltarParaOInicioButton;

    public MessageAdminInvoicing() {
        voltarParaOInicioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainCarWash lavaRapido = new MainCarWash();
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(main);
                frame.setContentPane(lavaRapido.getMain());
                frame.revalidate();
                frame.repaint();
            }
        });
    }

    public void pegarFaturamento(String dadosFaturamento) {
        faturamento.setText("R$ " + dadosFaturamento);
    }

    public JPanel getMain() {
        return main;
    }
}
