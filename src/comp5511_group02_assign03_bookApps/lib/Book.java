
package comp5511_group02_assign03_bookApps.lib;


/**
 *
 * @author aiken
 */
public class Book implements Comparable<Book>{
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private String address;
    private Double price;
    
    public Book(String isbn, String title, String author, String publisher, String address,double price) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.address = address;
        this.price = price;
    }
    
    /**
     * Constructor for Binary Search to add or delete book
     * @param isbn 
     */
    public Book(String isbn) {
        this.isbn = isbn;
    }

    
    public Book(Book book) {
        this.isbn = book.getIsbn();
        this.title = book.getTitle();
        this.author = book.getAuthor();
        this.publisher = book.getPublisher();
        this.address = book.getAddress();
        this.price = book.getPrice();
    }    
    
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    
    /**
     * Two book are equal if they have the same isbn
     * @param isbnCode
     * @return 
     */
    public boolean equals(Book isbnCode) {
        if (isbnCode == null) {
            return false;
        }
        return isbnCode.getIsbn().equals(getIsbn());
    }
    
    //Returning records of the Book and displaying on console
    public String toString() {
        StringBuilder book_sb = new StringBuilder();
        book_sb.append("Book ISBN: ");
        book_sb.append(getIsbn());
        book_sb.append(", Title: ");
        book_sb.append(getTitle());
        book_sb.append(", Author: ");
        book_sb.append(getAuthor());
        book_sb.append(", Publisher: ");
        book_sb.append(getPublisher());
        book_sb.append(", Publisher Address: ");
        book_sb.append(getAddress());
        book_sb.append(", Price: ");
        book_sb.append(getPrice());
        return book_sb.toString();
    }
    /**
     * this method is used in sort and binary search
     * @param isbnCode
     * @return 
     */
    @Override
    public int compareTo(Book isbnCode) {
        return this.getIsbn().compareTo(isbnCode.getIsbn());
    }
}
