/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sclab06part2;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Yousuf Khan
 */
public class SCLab06Part2 {

    //Db credentials
    public static String user = "root";
    public static String pass = "1234";
    public static String connString = "jdbc:mysql://localhost:3307/university";
        
    //Db objects
    public static Connection conn = null;
    public static Statement st = null;
    public static ResultSet rs = null;
    public static String query;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner input = new Scanner(System.in);
        
       
    }
    
    public static void printAllStudents() throws SQLException {
        
        //Creating query
        st = conn.createStatement();
        query = "Select * from Students";
        rs = st.executeQuery(query);

        //Printing Results.
        System.out.println("\n\n******Printing Students");
        while(rs.next()) {
            String name = rs.getString("Name");
            String class_ = rs.getString("Class");
            String regno = rs.getString("RegNo");
            String contact = rs.getString("Contact");
            String section = rs.getString("Section");
            String address = rs.getString("Address");

            System.out.println(
                    "RegNo: " + regno + " " +
                    "Name: " + name + " " +
                    "Class: " + class_ + " " +
                    "Section: " + section + " " +
                    "Contact: " + contact + " " +
                    "Address: " + address
            );
        }
        System.out.println("************\n");
        
    }
    
    public static void deleteRecord(int id) throws SQLException {
        
        //Creating query
        st = conn.createStatement();
        query = "DELETE FROM `university`.`students` WHERE `RegNo`='"+id+"';";
        rs = st.executeQuery(query);

        //Printing Results.
        System.out.println("\nDeleted Record.");
        
    }
    
    public static void searchRecord(int id) throws SQLException {
        
        //Creating query
        st = conn.createStatement();
        query = "Select * from Students where `RegNo`='"+id+"';";
        rs = st.executeQuery(query);

        //Printing Results.
        System.out.println("\n\n******Printing Student");
        while(rs.next()) {
            String name = rs.getString("Name");
            String class_ = rs.getString("Class");
            String regno = rs.getString("RegNo");
            String contact = rs.getString("Contact");
            String section = rs.getString("Section");
            String address = rs.getString("Address");

            System.out.println(
                    "RegNo: " + regno + " " +
                    "Name: " + name + " " +
                    "Class: " + class_ + " " +
                    "Section: " + section + " " +
                    "Contact: " + contact + " " +
                    "Address: " + address
            );
        }
        System.out.println("************\n");
        
    }
}
