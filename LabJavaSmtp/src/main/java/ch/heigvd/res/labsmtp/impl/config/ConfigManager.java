package ch.heigvd.res.labsmtp.impl.config;

import ch.heigvd.res.labsmtp.impl.model.mail.Person;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


/**
 * Cette classe charge les parametres(adress, port) necessaire pour fonctionnement du client, les adresses emails
 * personnes ciblées, nombre de groupe
 *
 * @auteur cedric Lankeu , Olivier Djelezeck
 */
public class ConfigManager implements IConfigManager {

    private String smtpServerAdress;
    private int smtpServerPort;
    private final List<Person> victim;      //personnes ciblées
    private final List<String> message;     // message indesirable qui sera envoyé
    private int numberofGroups;
    private List<Person> witnesstoCC;

    /**
     * Constructeur
     *
     * @param
     */
    public ConfigManager() throws IOException {

        victim = loadAdressFromFile("./config/victims.utf8");
        message = loadMessagesFromFile("./config/messages.utf8");
        loadProperties("./config/config.properties");
    }

    /**
     * Charge les parametres contenu dans le fichier properties du dossier config
     *
     * @param fileName fichier properties du dossier config
     */
    private void loadProperties(String fileName) {

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(fileName);
            Properties properties = new Properties();
            properties.load(fis);

            this.smtpServerAdress = properties.getProperty("smtpServerAdress");
            this.smtpServerPort = Integer.parseInt(properties.getProperty("smtpServerPort"));
            this.numberofGroups = Integer.parseInt(properties.getProperty("numberOfGroups"));

            this.witnesstoCC = new ArrayList<>();
            String witnesses = properties.getProperty("witnessestoCC");
            String[] witnessesAdresses = witnesses.split(",");
            for (String address : witnessesAdresses) {
                this.witnesstoCC.add(new Person(address));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }

    }


    /**
     * Cette methode recupere toute les adresses et les stock dans la variable result
     *
     * @param fileName nom du fichier qui contient ces adresses
     */
    private List<Person> loadAdressFromFile(String fileName) {

        List<Person> result = new ArrayList<Person>();
        FileInputStream fis = null;
        try {

            fis = new FileInputStream(fileName);

            BufferedReader reader = new BufferedReader(new InputStreamReader(fis, "UTF-8"));

            String victimRead;
            while ((victimRead = reader.readLine()) != null) {
                result.add(new Person(victimRead));
            }

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return result;
    }

    /**
     * Charge les message que contient le fichier message.utf8
     *
     * @param fileName le nom du fichier qui contien le message
     */
    private List<String> loadMessagesFromFile(String fileName) throws IOException {

        List<String> result;
        try (FileInputStream fis = new FileInputStream(fileName)) {

            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");

            try (BufferedReader reader = new BufferedReader(isr)) {

                result = new ArrayList<>();

                String line = reader.readLine();

                // Pour chaque ligne lu,
                while (line != null) {

                    StringBuilder body = new StringBuilder();

                    // On recupere le message borné par le separateur "=="
                    while ((line != null) && (!line.equals("=="))) {
                        body.append(line);
                        body.append("\r\n");
                        line = reader.readLine();
                    }

                    result.add(body.toString());
                    line = reader.readLine();
                }

            }
        }
        return result;
    }

    public List<Person> getVictim() {
        return victim;
    }

    public List<String> getMessage() {
        return message;
    }

    public int getNumberofGroups() {
        return numberofGroups;
    }

    public List<Person> getWitnesstoCC() {
        return witnesstoCC;
    }

    public String getSmtpServerAdress() {
        return smtpServerAdress;
    }

    public int getSmtpServerPort() {
        return smtpServerPort;
    }
}
