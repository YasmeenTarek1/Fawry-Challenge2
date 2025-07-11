public class MailService {
    public void sendByEmail(Book book, String email) {
        if(!book.sendingStrategy.isEmailSendable()) {
            System.out.println("This book type cannot be sent by email");
            return;
        }

        book.sendingStrategy.send(book.getTitle(), email);
    }
}
