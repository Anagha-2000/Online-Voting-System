/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myproject;

/**
 *
 * @author Anagha Patil
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
public class DAO {
    

/**
 *
 * @author neebal
 */


    private Connection con;

    public DAO() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/voting_system", "root", "B/602aakar");
            System.out.println("connected");

        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("loaded");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertVoter(String fname,String lname,String gender,String pno,String email,String password) throws VoteException {
        try {
            String query = "INSERT INTO registeration(first_name, last_name, gender, phone_no, email, password) VALUES(?,?,?,?,?,?)";
            PreparedStatement ps1 = con.prepareStatement(query);
            ps1.setString(1, fname);
            ps1.setString(2, lname);
            ps1.setString(3, gender);
            ps1.setString(4, pno);
            ps1.setString(5, email);
            ps1.setString(6, password);
            
            
            ps1.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new VoteException();
        } finally {
            try {

                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void selectUser(String email,String password) throws VoteException {
        try {
            String query = "SELECT * FROM registeration WHERE email=? AND password=?";
            PreparedStatement ps1 = con.prepareStatement(query);
            ps1.setString(1, email);
            ps1.setString(2, password);
            
            
            ResultSet rs = ps1.executeQuery();
            if(!rs.next()) {
                throw new VoteException();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new VoteException();
        } finally {
            try {

                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
     public void selectAdmin(String email,String password) throws VoteException {
        try {
            String query = "SELECT * FROM admin WHERE username=? AND password=?";
            PreparedStatement ps1 = con.prepareStatement(query);
            ps1.setString(1, email);
            ps1.setString(2, password);
            
            
            ResultSet rs = ps1.executeQuery();
            if(!rs.next()) {
                throw new VoteException();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new VoteException();
        } finally {
            try {

                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
     public void insertVote(String vote) throws VoteException {
        
          try {
            String query = "INSERT INTO votes(partyid) VALUES(?)";
            PreparedStatement ps1 = con.prepareStatement(query);
            
            //String query1 = "SELECT * FROM registeration WHERE id=?";
            //PreparedStatement ps2 = con.prepareStatement(query1);
            
            ps1.setString(1,vote);
            //ps1.setString(2,query1);
            
            ps1.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new VoteException();
        } finally {
            try {

                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

     
     public void resultCalc()
     {
         try{
             String query = "SELECT * MAX (partyname), no_of_votes(*) FROM votes WHERE partyname=? AND no_of_votes=?";
              PreparedStatement ps1 = con.prepareStatement(query);
              ps1.executeUpdate();
         }
         catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            //throw new VoteException();
        } finally {
            try {

                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
          
     }

     
        
     }
   
    


