package com.carwash.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserMessage {
    private JPanel main;
    private JPanel center;
    private JPanel buttom;
    private JButton backButton;
    private JLabel name;
    private JLabel modelCar;
    private JLabel licensePlate;
    private JLabel typeOfWash;

    public UserMessage() {
        backButton.addActionListener(new ActionListener() {
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

    public void setInformation(String information) {
        // name;modelCar;licensePlate;typeOfWash
        String[] data = information.split(";");

        name.setText(data[0]);
        modelCar.setText(data[1]);
        licensePlate.setText(data[2]);
        typeOfWash.setText(data[3]);
    }

    public JPanel getMain() {
        return main;
    }
}
