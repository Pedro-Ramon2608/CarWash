package com.carwash.controller;

import com.carwash.repository.ManipulationFile;


public class CarWashController {

    /**
     * Verifies if all input fields are filled.
     *
     * @param name client name
     * @param model car model
     * @param licensePlate car license plate
     * @return true if all fields contain data, false otherwise
     */
    public static boolean processCarWash(String name, String model, String licensePlate) {

        if (name.trim().isEmpty() && model.trim().isEmpty() && licensePlate.trim().isEmpty()) {
            return false;
        }

        return true;
    }

    /**
     * Determines the wash price based on the selected index; then calls checkAndCreateFile passing the
     * file path and calculated value.
     *
     * @param index the selected index from the combo box
     */
    public static void saveWash(int index) {
        double valueWash;
        /*
         * 0 -> Simple Wash    R$ 30.00
         * 1 -> Full Wash      R$ 90.00
         * 2 -> Dry Wash       R$ 65.00
         * 3 -> Detailing      R$ 245.00
         */
        switch (index) {
            case 0 -> valueWash = 30.0;

            case 1 -> valueWash = 90.0;

            case 2 -> valueWash = 65.0;

            case 3 -> valueWash = 245.0;

            default -> valueWash = 0.0;
        } // End of the switch

        ManipulationFile.checkAndCreateAdminFile(valueWash);

    } // End of saveWash()
}
