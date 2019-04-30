

package ch.heigvd.res.labsmtp.impl.model.prank;


import ch.heigvd.res.labsmtp.impl.model.mail.Message;
import ch.heigvd.res.labsmtp.impl.model.mail.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe génère des mail. dans le mail on retrouve:
 * un expéditeur, les recepteurs et le message qui est envoyé
 *
 * @auteur cedric Lankeu , Olivier Djelezeck
 */

public class Prank {
    private Person sender;
    private String message;
    private List<Person> receivers = new ArrayList<Person>();

    /**
     * @contrcteur Prank: dans ce constructeur on definit l'expéditeur, les recepteur et message
     *
     * @parametre: sender, receivers, message
     * */


    public Prank(Person sender, List<Person> receivers, String message) {
        this.message = message;
        this.sender = sender;
        this.receivers.addAll(receivers);
    }



    /**
     * @generateMaiMessage cette methode permet d'attribuer à chaque recepteur un mail
     */


    public List<Message> generateMailMessage() {
        ArrayList<Message> mails = new ArrayList<Message>();
        for (Person receiver : receivers) {
            mails.add(new Message(sender, receiver, message));
        }
        return mails;
    }
}
