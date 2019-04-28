package ch.heigvd.res.labsmtp.impl.model.mail;


/**
 * Classe Message : permet de definir un message au format qui sera vu par les victimes
 *
 * @auteur cedric Lankeu , Olivier Djelezeck
 */
public class Message {

    private String from;
    private String subject;
    private String body;
    private String[] to = new String[0];
    private  String[] cc = new String[0];
    private String[]bcc = new String[0];

    public void setFrom(String from){
        this.from=from;
    }

    public String getFrom(){
        return from;
    }

    public void setSubject(String subject){
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setBody(String body){
        this.body = body;
    }
    public String getBody(){
        return body;
    }

    public void setTo(String[] to){
        this.to = to;
    }
    public String[] getTo(){
        return to;
    }
    public void setBcc(String[] bcc){
        this.bcc = bcc;
    }
    public String[] getBcc(){
        return bcc;
    }
    public void setCc(String[] cc){
        this.cc = cc;
    }
    public String[] getCc(){
        return cc;
    }


}
