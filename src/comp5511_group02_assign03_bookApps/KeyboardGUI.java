
package comp5511_group02_assign03_bookApps;




import comp5511_group02_assign03_bookApps.dao.BookArrayListData;
import comp5511_group02_assign03_bookApps.dao.BookDao;
import comp5511_group02_assign03_bookApps.lib.Book;
import java.util.Scanner;

public class KeyboardGUI {
     BookDao bookDao = new BookArrayListData();
     
    public void GUI(){
        Scanner Type = new Scanner(System.in);
        System.out.println("Please type first letter of your desired function ");
        System.out.println("'a' for adding, 'd' for deleting, 'u' for update, 's' for searching");
        String Function = Type.nextLine();
        //while (Function.equals("a"))
               
        if(Function.equals("a")){
        System.out.println("Okay let's add a record! ");
        System.out.println("What would you like to add?");
        System.out.println("Please Type ISBN");
        String ISBN = Type.nextLine();
        System.out.println("Please Type the Title");
        String TITLE = Type.nextLine();
        System.out.println("Please Type the Author name");
        String AUTHOR = Type.nextLine();
        System.out.println("Please Type the Publisher name");
        String PUBLISHER = Type.nextLine();
        System.out.println("Please Type the Address");
        String ADDRESS = Type.nextLine();
        System.out.println("Please Type the Price");
        String PRICE = Type.nextLine();
        bookDao.addBook(ISBN, TITLE,AUTHOR,PUBLISHER,ADDRESS, PRICE);
        System.out.println(bookDao.listBooks());
        }
        else if(Function.equals("d")){
        System.out.println("Okay let's delete a record! ");
        System.out.println("What would you like to delete?");
        System.out.println("Please Type ISBN");
        String ISBN = Type.nextLine();
        //What if the value is not in the book?
        //could run a search first
        bookDao.deleteBook(ISBN);
        System.out.println(bookDao.listBooks());
        }
       
        else if(Function.equals("u")){
        System.out.println("Okay let's update a record! ");
        System.out.println("Which record would you like to update?");
        System.out.println("Please Type ISBN of the record you want to change");
        String ISBN = Type.nextLine();
        System.out.println("Please Type the updated Title");
        String TITLE = Type.nextLine();
        System.out.println("Please Type the updated Author name");
        String AUTHOR = Type.nextLine();
        System.out.println("Please Type the updated Publisher name");
        String PUBLISHER = Type.nextLine();
        System.out.println("Please Type the updated Address");
        String ADDRESS = Type.nextLine();
        System.out.println("Please Type the updated Price");
        String PRICE = Type.nextLine();
        bookDao.updateBook(ISBN, TITLE,AUTHOR,PUBLISHER,ADDRESS, PRICE);
        System.out.println(bookDao.listBooks());
        }
         
        else if(Function.equals("s")){
        System.out.println("Okay let's search for a record! ");
        System.out.println("Which record would you like to search for?");
        System.out.println("Please Type ISBN of the record you want to look for");
        String ISBN = Type.nextLine();
        System.out.println("Now please choose the category you would like for: " + ISBN);
        System.out.println("For ISBN type is, for Title type ti, for Author type au, for Publisher type pu, for Address type ad, for Price type pr");
        
        String Category = Type.nextLine();
       
        if(Category.equals("is")){
         Book book = bookDao.fetchIsbn(ISBN);
        System.out.println(book.getIsbn());
            
        }
        else if(Category.equals("ti")){
         Book book = bookDao.fetchIsbn(ISBN);
         System.out.println(book.getTitle());
            
        }
        else  if(Category.equals("au")){
            Book book = bookDao.fetchIsbn(ISBN);
            System.out.println(book.getAuthor());
        }
        else if(Category.equals("pu")){
         Book book = bookDao.fetchIsbn(ISBN);
        System.out.println(book.getPublisher());
        }
        else if(Category.equals("ad")){
            Book book = bookDao.fetchIsbn(ISBN);
            System.out.println(book.getAddress());
        }
        else if(Category.equals("pr")){
           Book book = bookDao.fetchIsbn(ISBN);
            System.out.println(book.getPrice());
        }
        System.out.println(bookDao.listBooks());
        }
         
        else
        { System.out.println("You have not entered a valid letter!");
          System.out.println("Program Terminated");}
          
         }
}
