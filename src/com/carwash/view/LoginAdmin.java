package com.carwash.view;

import com.carwash.repository.ManipulationFile;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginAdmin {
    private JPanel main;
    private JPanel center;
    private JPanel buttom;
    private JTextField textNome;
    private JPasswordField tetxSenha;
    private JButton enviarButton;
    private JButton voltarButton;
    private JLabel dadosPreenchidos;
    private JCheckBox showPassword;

    public LoginAdmin() {
        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dadosPreenchidos.setText("");

                String nome = textNome.getText();
                String senha = tetxSenha.getText();

                if (nome.isEmpty() || senha.isEmpty()) {
                    dadosPreenchidos.setText("Preencha todos os campos.");
                } else {
                    String informationInvoicing = ManipulationFile.readAndLoginFile(nome, senha);

                    if  (informationInvoicing != null) {
                        redirectToMessageAdminInvoicing(informationInvoicing);
                    }

                    dadosPreenchidos.setText("Nome ou Senha inválidos.");
                    textNome.setText("");
                    tetxSenha.setText("");
                    textNome.requestFocus();
                }

            }
        });

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                redirectToMainCarWash();
            }
        });

        showPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (showPassword.isSelected()) {
                    tetxSenha.setEchoChar((char) 0);
                } else {
                    tetxSenha.setEchoChar('•');
                }
            }
        });
    }


    public void redirectToMainCarWash() {
        MainCarWash carWash = new MainCarWash();
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(main);
        frame.setContentPane(carWash.getMain());
        frame.revalidate();
        frame.repaint();
    }


    public void redirectToMessageAdminInvoicing(String informationInvoicing) {
        MessageAdminInvoicing messageAdminInvoicing = new MessageAdminInvoicing();

        messageAdminInvoicing.pegarFaturamento(informationInvoicing);

        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(main);
        frame.setContentPane(messageAdminInvoicing.getMain());
        frame.revalidate();
        frame.repaint();
    }


    public JPanel getMain() {
        return main;
    }
}
