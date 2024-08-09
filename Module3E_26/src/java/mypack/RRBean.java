/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.ejb.Stateful;

/**
 *
 * @author Admin
 */
@Stateful
public class RRBean {
    public RRBean(){}
    public String roombooking(String cn, String cm , String rt){
    String message="";
    try
    {
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
    String query = "select * from roombook where room_type=? and status_room = 'not booked'";
    PreparedStatement pst = con.prepareStatement(query);
    pst.setString(1, rt);
    ResultSet rs = pst.executeQuery();
    if(rs.next()){
    String rno = rs.getString(1);
    PreparedStatement psmt1 = con.prepareStatement("update roombook set customer =? where room_id=?");
    psmt1.setString(1,cn);
      psmt1.setString(2,rno);
      psmt1.executeUpdate();
      
      psmt1 = con.prepareStatement("update roombook set mobile=? where room_id=?");
      psmt1.setString(1,cm);
      psmt1.setString(2,rno);
      psmt1.executeUpdate();
       
      psmt1 = con.prepareStatement("update roombook set status_room=? where room_id=?");
      psmt1.setString(1,"booked");
      psmt1.setString(2,rno);
      psmt1.executeUpdate();
      
      message = "Room " + rno + " booked and charges = " + rs.getString(3);
    }
    else{
    message = "Room " + rt + " currently not available ";
    }
    }
    catch(Exception e){
        message=""+e;
    }
   return message;
    }
}

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

