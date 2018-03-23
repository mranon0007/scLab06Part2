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
        
        //Make Connection
        try{
            //trying to connect
            System.out.println(connString);
            conn = DriverManager.getConnection(connString,user,pass);
            System.out.println("Connected to Db.");
        } 
        //Error in Connection
        catch(SQLException e) {
            System.err.println(e);
        }
        
        //Run program forever
        while(true) {
            try {
                //Ask for User Choice
                System.out.println("\nChoose option:\n1.Print All\n2.Search\n3.Delete");
                System.out.println("---------");
                String in = input.nextLine();
                int choice = Integer.parseInt(in);
                
                if(choice < 1 || choice > 3) {
                    throw new Exception("Choose a correct option");
                }
                
                //Keep trying to work on user's choice.
                while(true) {
                    try{
                        //take action based on user choice.
                        int id;
                        switch(choice) {
                            case 1:
                                printAllStudents();
                                break;
                            case 2:
                                System.out.println("Enter RegNo:");;
                                id = Integer.parseInt(input.nextLine());
                                searchRecord(id);
                                break;
                            case 3:
                                System.out.println("Enter RegNo:");
                                id = Integer.parseInt(input.nextLine());
                                deleteRecord(id);
                                break;
                        }

                        break;
                    } 
                    //Database Error
                    catch(SQLException e) {
                        System.out.println("e1");
                        System.err.println(e);
                    }
                    //Unexcepted Input
                    catch(Exception e) {
                        System.out.println("Incorrect Value Entered!");
                        System.err.println(e);
                    } 
                } //End while
            }  //End Try
            catch(Exception e) {
                System.err.println(e);
            }
        } //End while
        
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
        st.executeUpdate(query);

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
