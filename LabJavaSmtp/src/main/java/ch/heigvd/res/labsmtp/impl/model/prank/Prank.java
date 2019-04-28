package ch.heigvd.res.labsmtp.impl.model.prank;


import ch.heigvd.res.labsmtp.impl.model.mail.Message;
import ch.heigvd.res.labsmtp.impl.model.mail.Person;

import java.util.ArrayList;
import java.util.List;


public class Prank {
    private Person sender;
    private String message;
    private List<Person> receivers = new ArrayList<Person>();


    public Prank(Person sender, List<Person> receivers, String message) {
        this.message = message;
        this.sender = sender;
        this.receivers.addAll(receivers);
    }


    public List<Message> generateMailMessage() {
        ArrayList<Message> mails = new ArrayList<Message>();
        for (Person receiver : receivers) {
            mails.add(new Message(sender, receiver, message));
        }
        return mails;
    }
}
