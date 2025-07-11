public class NoEmailSending implements EmailSendingStrategy {

    @Override
    public void send(String title, String email) {
        System.out.println("No email sending available for book: " + title + " to email: " + email);
    }

    @Override
    public boolean isEmailSendable() {
        return false;
    }
}
