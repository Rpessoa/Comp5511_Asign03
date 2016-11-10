
package comp5511_group02_assign03_bookApps.dao;

import static comp5511_group02_assign03_bookApps.dao.BookConstants.MAX_LENGTH_FOR_BOOK_ISBN;
import static comp5511_group02_assign03_bookApps.dao.BookConstants.MAX_LENGTH_FOR_BOOK_TITLE;
import comp5511_group02_assign03_bookApps.lib.Book;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author aiken
 */
public class BookArrayListData implements BookDao{
    
    private ArrayList<Book> bookCatalog = new ArrayList<Book>();

    /**
     * Initializing the Book catalog
     */
    public BookArrayListData() {
        try {
            String path = "/Users/John/NetBeansProjects/Comp5511_Asign03/";
            // create recordInput for inputing records
            File inputFile = new File(path + "ISBN.txt");
            // A connection stream connects to the text file
            FileReader fileReader = new FileReader(inputFile);
            // A file pointer always points to the text file
            BufferedReader filePointer = new BufferedReader(fileReader);
            String recordInput = null;
            // "dataArray" is an ArrayList data structure for storing records of the input text file
            List<String> dataArray = new ArrayList<String>();
            while ((recordInput = filePointer.readLine()) != null) {
                dataArray.add(recordInput);
            }
            
            // Specify how many rows are there in the text file records
            int arrayListSize = dataArray.size();

            // Specify how many fields(columns) and what fields are there in the text file records
            String fieldsData = dataArray.get(0);
            String[] recordFields = fieldsData.split(";");
            int recordFieldsNum = 0;
            for (String itemData : recordFields) {
                System.out.println("Fields of record are: " + itemData + " ");
                recordFieldsNum++;
            }

            // Creating a string array for all of the text file records
            String[][] bookInfoArray = new String[arrayListSize][recordFieldsNum];
            for (int i = 0; i < arrayListSize; i++) {
                String rowData = dataArray.get(i);
                String[] dataMarker = rowData.split(";");
                int indexCounter = 0;
                for (String itemData : dataMarker) {
                    bookInfoArray[i][indexCounter] = itemData;
                    indexCounter++;
                }
            }
            // Adding book records of the input file into bookCatalog ArrayList
            for (int i = 1; i < arrayListSize; i++) {
                addBook(bookInfoArray[i][0], bookInfoArray[i][1],bookInfoArray[i][2],bookInfoArray[i][3],bookInfoArray[i][4],bookInfoArray[i][5]);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
       

    }

    /**
     * Find the Book and return a copy of that
     * if invalid returns null
     * @param isbn
     * @return 
     */
    @Override
    public Book fetchIsbn(String isbn) {
        Book book = getBook(isbn);
        if (book != null){
            return new Book(book);
        }
        return null;
    }

    /**
     * returns the size of the bookCatalog
     * @return 
     */
    @Override
    public int getTotalBookAmount() {
        return bookCatalog.size();
    }

    /**
     * Adding Book with given arguments to the catalog ArrayList
     * @param isbn
     * @param title
     * @param author
     * @param publisher
     * @param address
     * @param price 
     */
    @Override
    public void addBook(String isbn, String title, String author, String publisher, String address,String price) {
        Book book = new Book(isbn, title,author,publisher,address, price);
        if (validate(book)) {
            bookCatalog.add(book);
            sortCatalog();
        }
    }

    /**
     * Update a book of the given isbn if there are new updated records
     * 
     * @param isbn
     * @param title
     * @param author
     * @param publisher
     * @param address
     * @param price 
     */
    @Override
    public void updateBook(String isbn, String title, String author, String publisher, String address,String price) {
        //ToAsk: Why I didn't use fetchProduct Method
        Book book = getBook(isbn);
        if (book != null) {
        book.setTitle(title);
        book.setAuthor(author);
        book.setPublisher(publisher);
        book.setAddress(address);
        book.setPrice(price);
        }

    }

    /**
     * Deletes a product with the given code if exists
     * @param isbn 
     */
    @Override
    public void deleteBook(String isbn) {
        Book book = getBook(isbn);
        if (book!= null)
            deleteBook(book);
    }

    /**
     * A String representation setting of the bookCatalog
     * @return 
     */
    @Override
    public String listBooks() {
        StringBuilder book_sb = new StringBuilder();
        String prefix = "";
        for (Book book : bookCatalog) {
            book_sb.append(prefix);
            book_sb.append(book.toString());
            prefix = "\r\n";
        }
        return book_sb.toString();

    }

    /**
     * Sorting the bookCatalog
     */
    @Override
    public void sortCatalog() {
        Collections.sort(bookCatalog);
    }

    /**
     * Deletes a book (used internally)
     * @param book 
     */
    private void deleteBook(Book book) {
        bookCatalog.remove(book);
    }

    /**
     * Validates a book before adding
     * @param book
     * @return 
     */
    private boolean validate(Book book) {
        if (book.getTitle().length() > MAX_LENGTH_FOR_BOOK_TITLE
                || book.getIsbn().length() > MAX_LENGTH_FOR_BOOK_ISBN
               // || book.getPrice() < 0
                ) {
            return false;
        }
        if (bookCatalog.contains(book)) {
            return false;
        }
        return true;
    }

    /**
     * Search for a book using binary search
     * @param isbn
     * @return 
     */
    private Book getBook(String isbn)  {
        int index = Collections.binarySearch(bookCatalog, new Book(isbn));
        if (index >  0)
            return bookCatalog.get(index);
        else
           return null;
    }

}
