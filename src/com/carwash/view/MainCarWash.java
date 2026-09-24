package com.carwash.view;

/**
 * Initializes the graphical interface and loads the startup settings.
 *
 * @author Pedro Ramon <pedrorfariasljesus@gmail.com>
 * @version 1.0.0
 * @since 09/09/2026
 */

import com.carwash.controller.CarWashController;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainCarWash {
    private JPanel main;
    private JPanel top;
    private JPanel center;
    private JPanel buttom;
    private JTextField carOwnersName;
    private JTextField carModel;
    private JTextField licensePlate;
    private JButton submitButton;
    private JComboBox chooseWash;
    private JLabel validatedData;
    private JButton loginAdminButton;

    public MainCarWash() {
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Reset message field
                validatedData.setText("");

                String name = carOwnersName.getText();
                String model = carModel.getText();
                String plate = licensePlate.getText();

                /*
                 * 0 -> Simple Wash
                 * 1 -> Full Wash
                 * 2 -> Dry Wash
                 * 3 -> Detailing
                 */
                int indexWash = chooseWash.getSelectedIndex();

                // Flag to verify if the fields are filled
                boolean areFieldsCompleted = CarWashController.processCarWash(name, model, plate);

                String typeWash = chooseWash.getItemAt(indexWash).toString();

                if (!areFieldsCompleted) {
                    validatedData.setText("Preencha todos os campos.");
                } else {
                    // Submit data for the saveWash
                    CarWashController.saveWash(indexWash);

                    String information = name + ";" + model + ";" + plate + ";" + typeWash;

                    redirectToUserMessage(information);
                }

                // Resets input fields
                carOwnersName.setText("");
                carModel.setText("");
                licensePlate.setText("");
            }
        });

        loginAdminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { redirectToLoginAdmin(); }
        });
    } // End of MainCarWash()


    // Run application
    public static void start(String[] args) {
        JFrame frame = new JFrame("Lava Rápido");
        frame.setContentPane(new MainCarWash().main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    } // End of initializes start()


    /**
     * Navigates the current window to the user message view and display the provided details.
     *
     * @param information text containing car owner's name, car model, license plate, and wash type.
     */
    public void redirectToUserMessage(String information) {
        UserMessage mensagemUsuario = new UserMessage();

        mensagemUsuario.setInformation(information);

        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(main);
        frame.setContentPane(mensagemUsuario.getMain());
        frame.revalidate();
        frame.repaint();
    } // End of redirectToUserMessage()


    /**
     * Navigates the current window to the admin login view.
     */
    public void redirectToLoginAdmin() {
        LoginAdmin admin = new LoginAdmin();

        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(main);
        frame.setContentPane(admin.getMain());
        frame.revalidate();
        frame.repaint();
    } // End of redirectToAdmin()

    public JPanel getMain() {
        return main;
    }
} // End of the MainCarWash class
