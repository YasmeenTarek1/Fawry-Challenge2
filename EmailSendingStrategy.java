public interface EmailSendingStrategy {
    void send(String title, String email);
    boolean isEmailSendable();
}
