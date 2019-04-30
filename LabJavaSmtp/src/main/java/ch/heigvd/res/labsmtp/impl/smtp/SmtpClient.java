package ch.heigvd.res.labsmtp.impl.smtp;


import ch.heigvd.res.labsmtp.impl.model.mail.Message;

import java.io.*;
import java.net.Socket;
import java.util.logging.Logger;

public class SmtpClient implements iSmtpClient {

    private static final Logger LOG = Logger.getLogger(SmtpClient.class.getName());
    private Socket socket = null;
    private PrintWriter writer;
    private BufferedReader reader;
    private String line;

    public SmtpClient(String smtpServerAdresse, int smtpServerPort) {

        try {
            socket = new Socket(smtpServerAdresse, smtpServerPort);
            writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF8"), true);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF8"));

            writer.printf("EHLO localhost");
            line = reader.readLine();
            LOG.info(line);
            if (!line.startsWith("250-")) {
                throw new IOException("SMTP error: " + line);
            }
            while (line.startsWith("250-")) {
                line = reader.readLine();
                LOG.info(line);
            }

        } catch (Exception e) {

        }
    }

    public void sendMessage(Message message) throws IOException {


        writer.write("MAIL FROM: " + message.getFrom() + "\r\n");
        writer.flush();
        reader.readLine();

        writer.write("RCPT TO: " + message.getTo().getAddresse() + "\r\n");
        writer.flush();
        reader.readLine();

        writer.write("DATA" + "\r\n");
        writer.flush();
        reader.readLine();

        writer.write(message.getBody() + "\r\n");
        writer.write("\r\n");
        writer.flush();

        writer.write(".");
        writer.write("\r\n");
        writer.flush();

        reader.readLine();
    }

    public void disconnect() {

        writer.write("QUIT\r\n");
        writer.flush();
        writer.close();
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (socket != null) {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
