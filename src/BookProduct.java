public class BookProduct extends Product{
    private String author, publisher;

    public BookProduct(int productID, String name, float price, String author, String publisher) {
        super(productID, name, price);
        setAuthor(author);
        setPublisher(publisher);
    }

    public String author() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String publisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    @Override
    public String toString() {
        return super.toString() +
                "\nAuthor: " + author() +
                "\nPublisher: " + publisher() + "\n";
    }
}