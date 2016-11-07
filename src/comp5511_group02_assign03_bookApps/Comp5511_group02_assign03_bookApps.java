
package comp5511_group02_assign03_bookApps;

import comp5511_group02_assign03_bookApps.dao.BookDao;
import comp5511_group02_assign03_bookApps.dao.BookArrayListData;
import comp5511_group02_assign03_bookApps.lib.Book;

/**
 *
 * @author aiken
 */
public class Comp5511_group02_assign03_bookApps {
    
    BookDao bookDao = new BookArrayListData();
    
     private void displayBookInfo() {
        testBookArrayListData();
    }
    
     private void testBookArrayListData() {
        // Testing add function and displaying all the records for checking
        bookDao.addBook("isbn1123", "title->Test1","author-t01","publisher-01","address-01", 123);
        System.out.println("Add book isbn1123 and show book list:");
        System.out.println(bookDao.listBooks());
        
        // Testing delete function and displaying all the records for checking
        bookDao.deleteBook("isbn1123");
        System.out.println("Delete book isbn1123 and show book list:");
        System.out.println(bookDao.listBooks());
        
        // Testing add function and displaying all the records for checking
        System.out.println("Add book isbn2123 and show book list:");
        bookDao.addBook("isbn2123", "title->test2","author-t02","publisher-02","address-02", 223);
        System.out.println(bookDao.listBooks());
        
        // Testing update function and displaying all the records for checking
        bookDao.updateBook("isbn2123", "title->test241","author-t41","publisher-41","address-41", 241);
        System.out.println("Update book isbn2123 and show book list:");
        System.out.println(bookDao.listBooks());
        
        // Testing search record function and displaying the search result for checking
        Book book = bookDao.fetchIsbn("isbn2123");
        System.out.println("fetch the price of the book : isbn2123:");
        System.out.println(book.getPrice());

        System.out.println("Display the SORTED book list:");
        bookDao.sortCatalog();

        System.out.println(bookDao.listBooks());
    }
     
    public static void main(String[] args) {
        Comp5511_group02_assign03_bookApps showBookApp = new Comp5511_group02_assign03_bookApps();
        showBookApp.displayBookInfo();
    }
    
}
