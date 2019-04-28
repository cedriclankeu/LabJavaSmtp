package ch.heigvd.res.labsmtp.impl.config;

import ch.heigvd.res.labsmtp.impl.model.mail.Person;


import java.util.List;

/**
 * Implemente les methodes permettant de traiter les fichier contenu dans le dossier config .
 */
public interface IConfigManager {
    public List<String> getMessage();

    public int getNumberofGroups();

    public List<Person> getVictim();

    public List<Person> getWitnesstoCC();
}
