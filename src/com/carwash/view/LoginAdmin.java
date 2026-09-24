package com.carwash.view;

import com.carwash.repository.ManipulationFile;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginAdmin {
    private JPanel main;
    private JPanel center;
    private JPanel buttom;
    private JTextField fieldName;
    private JPasswordField passwordField;
    private JButton submitButton;
    private JButton backButton;
    private JLabel validatorFillData;
    private JCheckBox showPassword;

    public LoginAdmin() {
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validatorFillData.setText("");

                String name = fieldName.getText();
                String password = String.valueOf(passwordField.getPassword());

                if (name.isEmpty() || password.isEmpty()) {
                    validatorFillData.setText("Preencha todos os campos.");
                } else {
                    String informationInvoicing = ManipulationFile.readAndLoginFile(name, password);

                    if  (informationInvoicing != null) {
                        redirectToMessageAdminInvoicing(informationInvoicing);
                    }

                    validatorFillData.setText("Nome ou Senha inválidos.");
                    fieldName.setText("");
                    passwordField.setText("");
                    fieldName.requestFocus();
                }

            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                redirectToMainCarWash();
            }
        });

        showPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (showPassword.isSelected()) {
                    passwordField.setEchoChar((char) 0);
                } else {
                    passwordField.setEchoChar('•');
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
