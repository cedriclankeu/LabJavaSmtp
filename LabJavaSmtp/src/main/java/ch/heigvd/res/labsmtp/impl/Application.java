package ch.heigvd.res.labsmtp.impl;


import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import ch.heigvd.res.labsmtp.impl.config.ConfigManager;
import ch.heigvd.res.labsmtp.impl.model.mail.Message;
import ch.heigvd.res.labsmtp.impl.model.prank.Prank;
import ch.heigvd.res.labsmtp.impl.model.prank.PrankGenerator;
import ch.heigvd.res.labsmtp.impl.smtp.SmtpClient;


public class Application {

    private static final Logger LOG = Logger.getLogger(Application.class.getName());

    public static void main(String[] args) throws IOException {

        LOG.info("Labo SMTP");
        ConfigManager confMan = new ConfigManager();

        PrankGenerator generator = new PrankGenerator(confMan);



        List<Prank> pranks = generator.generatorPranks();

        SmtpClient client = new SmtpClient(confMan.getSmtpServerAdress(), confMan.getSmtpServerPort());

        for (Prank p : pranks) {
            for (Message msg : p.generateMailMessage()) {
                client.sendMessage(msg);
            }
        }

        client.disconnect();

    }

}
