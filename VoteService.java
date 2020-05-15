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
public class VoteService {
    
    public void addVote(String vote)
    {
        vote=vote.toLowerCase();
        
        try {
            new DAO().insertVote(vote);
        } catch (VoteException ex) {
            Logger.getLogger(VoteService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
