public class EmailSending implements EmailSendingStrategy {

    @Override
    public void send(String title, String email) {
        System.out.println("Sending book '" + title + "' to email: " + email);
    }

    @Override
    public boolean isEmailSendable() {
        return true;
    }
}
