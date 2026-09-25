package com.carwash.repository;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class ManipulationFile {
    private static final String DIR = System.getProperty("user.home") + File.separator + "carwash";
    private static final String FILE_PATH = DIR + File.separator + "ganhosGeraisADM.txt";

    public static void createFile() {
        try {
            java.io.File arquivo = new java.io.File(FILE_PATH);

            // Criar os diretórios/pastas caso não existam
            if (arquivo.getParentFile() != null) arquivo.getParentFile().mkdir();

            // Tenta criar o arquivo
            if (arquivo.createNewFile()) {
                System.out.println("Arquivo criado com sucesso!");

                try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo))) {
                    writer.write("Pedro;pedro1234\n0.0\n");
                }
            }

        } catch (IOException e) {
            System.out.println("Erro de permissão ou input/output: " + e.getMessage());
        }
    }


    public static void updateFile(Double valor) {
        String nomeESenha;
        String valorTotal = "";

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {

            nomeESenha = reader.readLine();
            valorTotal = reader.readLine();

        } catch (IOException e) {
            System.out.println("Erro");
        }

        double somaValores = Double.parseDouble(valorTotal) + valor;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))){

            writer.write("Pedro;pedro1234\n" +
                    somaValores + "\n");

        } catch (IOException e) {
            System.out.println("Erro ao gravar o arquivo.");
        }

    }


    public static String readAndLoginFile(String nome, String senha) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {

            // nome;senha
            String admin = reader.readLine();
            String[] dados = admin.split(";");

            if (nome.equals(dados[0]) && senha.equals(dados[1])) {
                // Next line contain the invoicing
                return reader.readLine();
            }

        } catch (IOException erro) {
            System.out.println("Erro");
        }

        return null;
    }


    /**
     * Verifies if the file exists; if it does not exist, creates a new .txt file
     * containing the default username, password, and an initial balance of zero.
     *
     * @param valueWash the wash amount to update if the file exist, or written to the file
     */
    public static void checkAndCreateAdminFile(double valueWash) {
        if (Files.exists(Path.of(FILE_PATH))) {
            ManipulationFile.updateFile(valueWash);

        } else {
            ManipulationFile.createFile();

            ManipulationFile.updateFile(valueWash);
        }
    } // End of checkAndCreateAdminFile()
}