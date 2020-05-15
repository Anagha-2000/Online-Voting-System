/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myproject;

import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Anagha Patil
 */
public class RegisterService {
    
    public boolean addVoter(String fname,String lname,String gender,String pno,String email,String password)
    {
        fname=fname.toLowerCase();
        lname=lname.toLowerCase();
       
        pno=pno.toLowerCase();
        email=email.toLowerCase();
        
        //password=password.toLowerCase();
        
        
        try{
            new DAO().insertVoter(fname, lname, gender,pno, email, password);
            return true;
        }
        catch (VoteException ex) {
            //Logger.getLogger(VoteService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
     public boolean validateAdmin(String username, String password) {
        try {
            username = username.toLowerCase();
            new DAO().selectAdmin(username, password);
            return true;
        } catch (VoteException ex) {
                    return false;

        }
    }
     
    public boolean validateVoter(String username, String password) {
        try {
            username = username.toLowerCase();
            new DAO().selectUser(username, password);
            return true;
        } catch (VoteException ex) {
                    return false;

        }
    }
}
