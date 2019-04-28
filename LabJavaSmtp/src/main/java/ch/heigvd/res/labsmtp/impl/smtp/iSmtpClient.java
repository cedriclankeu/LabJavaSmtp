package ch.heigvd.res.labsmtp.impl.smtp;


import ch.heigvd.res.labsmtp.impl.model.mail.Message;

import java.io.IOException;

public interface iSmtpClient {
    public void sendMessage(Message message) throws IOException;
}
