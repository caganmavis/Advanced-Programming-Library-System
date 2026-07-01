// AcademicBook.java
public class AcademicBook extends Book {
    private String subject;

    public AcademicBook(String isbn, String title, String author, String subject) {
        super(isbn, title, author);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    @Override
    public String toString() {
        return super.toString() + " [Subject: " + subject + "]";
    }
}