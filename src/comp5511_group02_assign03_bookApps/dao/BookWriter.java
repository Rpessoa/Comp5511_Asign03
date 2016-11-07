
package comp5511_group02_assign03_bookApps.dao;


/**
 *
 * @author aiken
 * 
 */
public interface BookWriter {
    void addBook(String isbn, String title, String author, String publisher, String address,double price);

    void updateBook(String isbn, String title, String author, String publisher, String address,double price);

    void deleteBook(String isbn);
}
