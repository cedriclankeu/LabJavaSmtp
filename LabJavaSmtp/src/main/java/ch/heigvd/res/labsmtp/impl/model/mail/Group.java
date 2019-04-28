package ch.heigvd.res.labsmtp.impl.model.mail;


/**
 * Classe Group : permet de definir des groupes de personne a partir de victimes
 * Il separe les victimes en emetteur et le reste en victime cible.
 *
 * @auteur cedric Lankeu , Olivier Djelezeck
 */
public class Group {

    private final List<Person> member = new ArrayList<>();
    public void addMember(Person person){
        member.add(person);
    }

    public List<Person>getMember(){
        return new ArrayList<>(member);
    }

}
