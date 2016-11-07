
package comp5511_group02_assign03_bookApps.dao;

/**
 *
 * @author aiken
 */
public interface BookDao extends BookConstants, BookReader, BookWriter {
    public void sortCatalog();
}
