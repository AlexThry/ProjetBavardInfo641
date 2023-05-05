package fr.proj;

public class Message {
    private String sender;
    private String subject;
    private String content;
    private String theme;

    public Message(String sender, String subject, String content,String theme) {
        this.sender = sender;
        this.subject = subject;
        this.content = content;
        this.theme = theme;
    }

    @Override
    public String toString() {
        return "Message{" +
                "sender='" + sender + '\'' +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public String getSender() {
        return sender;
    }

    public String getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }

    public String getTheme() {
        return theme;
    }
}
