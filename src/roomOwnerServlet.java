
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class roomOwnerServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("before action");
       String action=request.getParameter("action");
       System.out.println(action);
        if(action!=null && action.equalsIgnoreCase("Submit"))
        {
          System.out.println("inside submit");  
	    int roomno=Integer.parseInt(request.getParameter("roomno")); 
            String roomtyp=request.getParameter("roomtype");
            String roomarea=request.getParameter("roomarea");
            String regno=request.getParameter("regno");
            String propertytaxno=request.getParameter("propertytaxno");
            String ownername=request.getParameter("ownername");
	    int age=Integer.parseInt(request.getParameter("age"));
	    String gender=request.getParameter("gender");
            String email=request.getParameter("email");
            int mobileno=Integer.parseInt(request.getParameter("mobile"));
            String certino=request.getParameter("certino");
            int nofamilymember=Integer.parseInt(request.getParameter("nofamilymember"));
            String parkingtyp=request.getParameter("parkingtyp");
            int occupationid=Integer.parseInt(request.getParameter("occupationid"));
            int paymentid=Integer.parseInt(request.getParameter("paymentid"));
            int societyid=Integer.parseInt(request.getParameter("societyid"));
            int buildingid=Integer.parseInt(request.getParameter("buildingid"));
           
            try{
                 System.out.println("inside try");
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/housing","root","root");
        String sql="insert into room_owner(room_no,room_type,room_area,reg_no,property_tax_no,owner_name,owner_age,owner_sex,owner_email,owner_mob,owner_certi_no,no_of_family_member,parking_typ,occupation_id,payment_id,society_id,building_id)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
        PreparedStatement ps=con.prepareStatement(sql);
        
        ps.setInt(1,roomno);
        ps.setString(2,roomtyp);
        ps.setString(3,roomarea);
        ps.setString(4,regno);
        ps.setString(5,propertytaxno);
        ps.setString(6,ownername);
        ps.setInt(7,age);
        ps.setString(8,gender);
        ps.setString(9,email);
        ps.setInt(10,mobileno);
        ps.setString(11,certino);
        ps.setInt(12,nofamilymember);
        ps.setString(13,parkingtyp);        
	ps.setInt(14,occupationid);
	ps.setInt(15,paymentid);
	ps.setInt(16,societyid);
	ps.setInt(17,buildingid);                
        int rs=ps.executeUpdate();
         if(rs>0)
			{
				response.sendRedirect("success.html");
			}
        }
        catch(Exception e)
        {
        System.out.println(e);
        }
        }
            
        else if(action!=null && action.equalsIgnoreCase("search"))
            {
               HttpSession session=request.getSession();
          
 String ownername=request.getParameter("ownername");
 
          
try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/housing","root","root");  
              
PreparedStatement ps=con.prepareStatement("select * from room_owner where owner_name=?");  
 ps.setString(1,ownername );
                
ResultSet rs=ps.executeQuery();  
 
        
             session.setAttribute("Result",rs);
            response.sendRedirect("searchOwner.jsp");
        
        

    }
catch (Exception e2) {e2.printStackTrace();}  

    
    
            }
        
        else if(action!=null && action.equalsIgnoreCase("update"))
        {
            
            System.out.println("inside submit");  
	    int roomno=Integer.parseInt(request.getParameter("roomno")); 
            String roomtyp=request.getParameter("roomtyp");
            String roomarea=request.getParameter("roomarea");
            String regno=request.getParameter("regno");
            String propertytaxno=request.getParameter("propertytaxno");
            String ownername=request.getParameter("ownername");
	    int age=Integer.parseInt(request.getParameter("age"));
	    String gender=request.getParameter("gender");
            String email=request.getParameter("email");
            int mobileno=Integer.parseInt(request.getParameter("mobileno"));
            String certino=request.getParameter("certino");
            int nofamilymember=Integer.parseInt(request.getParameter("nofamilymember"));
            String parkingtyp=request.getParameter("parkingtyp");
            int occupationid=Integer.parseInt(request.getParameter("occupationid"));
            int paymentid=Integer.parseInt(request.getParameter("paymentid"));
            int societyid=Integer.parseInt(request.getParameter("societyid"));
            int buildingid=Integer.parseInt(request.getParameter("buildingid"));
          
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/housing","root","root");
        String sql="update room_owner set room_no=?,room_type=?,room_area=?,reg_no=?,property_tax_no=?,owner_name=?,owner_age=?,owner_sex=?,owner_email=?,owner_mob=?,owner_certi_no=?,no_of_family_member=?,parking_typ=?,occupation_id=?,payment_id=?,society_id=?,building_id=? where owner_name=?";
        PreparedStatement ps=con.prepareStatement(sql);
        
       ps.setInt(1,roomno);
        ps.setString(2,roomtyp);
        ps.setString(3,roomarea);
        ps.setString(4,regno);
        ps.setString(5,propertytaxno);
        ps.setString(6,ownername);
        ps.setInt(7,age);
        ps.setString(8,gender);
        ps.setString(9,email);
        ps.setInt(10,mobileno);
        ps.setString(11,certino);
        ps.setInt(12,nofamilymember);
        ps.setString(13,parkingtyp);        
	ps.setInt(14,occupationid);
	ps.setInt(15,paymentid);
	ps.setInt(16,societyid);
	ps.setInt(17,buildingid);  
        ps.setString(18,ownername);  
        int rs=ps.executeUpdate();
        if(rs>0)
        {
            response.sendRedirect("searchOwner.jsp");
        }
            }
        catch(Exception e)
                {
                System.out.print(e);
                }
                
            }
        else if(action!=null && action.equalsIgnoreCase("delete"))
        {
            try{
                Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/housing","root","root");
            String ownername=request.getParameter("ownername");
            String sql="delete from room_Owner where owner_name=?";
             PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,ownername);
             int rs=ps.executeUpdate();
             if(rs>0)
        {
        response.sendRedirect("success.html");
        }
         }catch(Exception e){System.out.print(e);
            }
            

        }
           }

       
    }

    

