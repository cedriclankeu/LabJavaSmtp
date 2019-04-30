package ch.heigvd.res.labsmtp.impl.model.prank;


import ch.heigvd.res.labsmtp.impl.config.ConfigManager;
import ch.heigvd.res.labsmtp.impl.model.mail.Group;
import ch.heigvd.res.labsmtp.impl.model.mail.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;


/**
 * dans cette classe on definit le nombre de victime par groupe. dans chaque groupe on dans chaque groupe
 * on devais y avoir 1 expediteur et au moins deux destinataires
 * @auteur cedric Lankeu , Olivier Djelezeck
 */


public class PrankGenerator {

    private ConfigManager confManager;
    private static final Logger LOG = Logger.getLogger(PrankGenerator.class.getName());

    public PrankGenerator(ConfigManager confManager) {
        this.confManager = confManager;
    }


    /**
     * cette methode permet d'attribué à des groupes constitués des blagues
     */

    public List<Prank> generatorPranks() {

        List<Prank> pranks = new ArrayList<Prank>();
        List<Group> groups = generateGroups(confManager.getVictim(), confManager.getNumberofGroups());

        int numberOfGroupe = confManager.getNumberofGroups();
        int numberOfVictims = confManager.getVictim().size();

        if (numberOfVictims / numberOfGroupe < 3) {
            numberOfGroupe = numberOfVictims / 3;
            LOG.warning("there are not enough victims to generate the desired number of groups. We can only " +
                    "generate a max of" + numberOfGroupe + "groupe to have at least 3 victims per group");
        }

        List<String> messages = confManager.getMessage();
        for (int i = 0; i < groups.size(); ++i) {
            pranks.add(new Prank(groups.get(i).getFrom(),
                    groups.get(i).getTo(), messages.get(i % messages.size())));
        }
        return pranks;
    }


    /**
     *
     * @generateGroupe  cette methode permet de générer les groupes
     * @param listVictims: il s'agit d'une liste de personne qui pourront recevoir des messages
     * @param nbGroups: le nombre de groupe que l'utilisateur s'est fixé
     */

    private List<Group> generateGroups(List<Person> listVictims, int nbGroups) {

        List<Person> victims = listVictims;

        Collections.shuffle(victims);

        ArrayList<Person>[] victimGroup = new ArrayList[nbGroups];

        for (int i = 0; i < victimGroup.length; i++) {
            victimGroup[i] = new ArrayList<Person>();
        }

        for (int j = 0; j < victims.size(); j++) {
            victimGroup[j % nbGroups].add(victims.get(j));
        }

        ArrayList<Group> groups = new ArrayList<Group>();
        for (int i = 0; i < nbGroups; i++) {
            groups.add(new Group(victimGroup[i]));
        }

        return groups;
    }
}
