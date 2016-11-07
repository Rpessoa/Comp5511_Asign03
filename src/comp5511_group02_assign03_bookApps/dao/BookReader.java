/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comp5511_group02_assign03_bookApps.dao;

import comp5511_group02_assign03_bookApps.lib.Book;

/**
 *
 * @author aiken
 */
public interface BookReader {
    
    Book fetchIsbn(String isbn);

    int getTotalBookAmount();
    
    public String listBooks(); 
}
