package ch.heigvd.res.labsmtp.impl.model.mail;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class permettant de definir une personne(nom, prenom, adresse Mail)
 *
 * @auteur cedric Lankeu , Olivier Djeulezeck
 */

public class Person {
    private String firstname;
    private String lastname;
    private final String addresse;

    public Person(String firstname, String lastname, String addresse) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.addresse = addresse;
    }

    /**
     * Constructeur
     */
    public Person(String addresse) {
        this.addresse = addresse;

        Pattern pattern = Pattern.compile("(.*)\\.(.*)@");
        Matcher matcher = pattern.matcher(addresse);
        boolean found = matcher.find();
        if (found) {
            this.firstname = matcher.group(1);
            firstname = firstname.substring(0, 1).toUpperCase() + firstname.substring(1);
            this.lastname = matcher.group(2);
            lastname = lastname.substring(0, 1).toUpperCase() + lastname.substring(1);
        }
    }

    public String getAddresse() {
        return addresse;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }


}
