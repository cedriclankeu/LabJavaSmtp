package ch.heigvd.res.labsmtp.impl.model.mail;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe Group : permet de definir des groupes de personne a partir de victimes
 * Il separe les victimes en emetteur et le reste en victime cible.
 *
 * @auteur cedric Lankeu , Olivier Djelezeck
 */
public class Group {

    private final List<Person> to;
    private Person from;

    /**
     * Constructeur
     * apres construction du groupe on reccupère la premiere personne
     * de la liste comme expéditeur des message et le reste comme des recepteurs
     *
     * @param victimes : liste de tous les personnée ciblée
     */
    public Group(List<Person> victimes) {
        to = new ArrayList<>();

        this.from = victimes.get(0); // on charge l'expediteur par la première personne de la liste

        victimes.remove(0); //on charge les recepeteurs des messages par le reste de personne de la liste
        this.to.addAll(victimes);
    }

    public List<Person> getTo() {
        return new ArrayList<>(to);
    }

    public Person getFrom() {
        return from;
    }
}
