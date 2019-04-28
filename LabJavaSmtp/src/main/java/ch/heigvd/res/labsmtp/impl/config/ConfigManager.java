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
     */
    public ConfigManager() throws IOException {


    }

    /**
     * Charge les parametres contenu dans le fichier properties du dossier config
     *
     * @param fileName fichier properties du dossier config
     */
    private void loadProperties(String fileName) {

    }


    /**
     * Cette methode recupere toute les adresses et les stock
     *
     * @param fileName nom du fichier qui contient ces adresses
     */
    private List<Person> loadAdressFromFile(String fileName) {

    }

    /**
     * Charge les message que contient le fichier message.utf8
     *
     * @param fileName le nom du fichier qui contien le message
     */
    private List<String> loadMessagesFromFile(String fileName) throws IOException {

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
