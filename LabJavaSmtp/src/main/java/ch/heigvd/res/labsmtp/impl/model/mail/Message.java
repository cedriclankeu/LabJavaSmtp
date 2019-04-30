package ch.heigvd.res.labsmtp.impl.model.mail;


/**
 * Classe Message : permet de definir un message au format qui sera vu par les victimes
 *
 * @auteur cedric Lankeu , Olivier Djelezeck
 */
public class Message {
    private Person from;
    private Person to;
    private String body;

    /**
     * Cette methode permet de definir un meme template pour tout message envoyé
     *
     * @param message message tiré au hazard et qui etait contenu dans le fichier "messages.utf8"
     *
     */
    private String messageTemplate(String message) {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("From: ");
        strBuilder.append(from.getAddresse() + "\r\n" + "Content-Type: text/plain; charset=\"UTF-8\"" + "\r\n");
        strBuilder.append("To: ");
        strBuilder.append(to.getAddresse() + "\r\n");

        strBuilder.append(message);
        return strBuilder.toString();
    }

    /**
     * Constructeur
     *
     * @param from    : l'emetteur
     * @param to      : les victimes
     * @param message le message a envoyer au victimes
     */
    public Message(Person from, Person to, String message) {
        this.from = from;
        this.to = to;
        body = messageTemplate(message);
    }

    public String getBody() {
        return body;
    }


    public Person getTo() {
        return to;
    }

    public Person getFrom() {
        return from;
    }

}
