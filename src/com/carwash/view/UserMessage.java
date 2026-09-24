package com.carwash.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserMessage {
    private JPanel main;
    private JPanel center;
    private JButton voltarButton;
    private JLabel nome;
    private JLabel modelo;
    private JLabel placa;
    private JLabel tipoLavagem;
    private JPanel buttom;

    public UserMessage() {
        voltarButton.addActionListener(new ActionListener() {
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

    public void setInformation(String informacoes) {
        // nome;modelo;placa;lavagem
        String[] dados = informacoes.split(";");

        nome.setText(dados[0]);
        modelo.setText(dados[1]);
        placa.setText(dados[2]);
        tipoLavagem.setText(dados[3]);
    }

    public JPanel getMain() {
        return main;
    }
}
