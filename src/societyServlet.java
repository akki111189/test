/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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

/**
 *
 * @author Pinnacle Infotech 7
 */
public class societyServlet extends HttpServlet {
       
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
            String societyname=request.getParameter("societyname");
            String societyaddress=request.getParameter("societyaddress");
            String regno=request.getParameter("regno");
            String nobuilding=request.getParameter("nobuilding");
            String societyarea=request.getParameter("societyarea");
            int amenitiesid=Integer.parseInt(request.getParameter("ammenitiesid"));
            int countryid=Integer.parseInt(request.getParameter("countryid"));
            int stateid=Integer.parseInt(request.getParameter("stateid"));
            int cityid=Integer.parseInt(request.getParameter("cityid"));
           
            try{
                 System.out.println("inside try");
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/housing","root","root");
        String sql="insert into society(society_name,society_add,registration_no,no_of_building,society_area,amenities_id,country_id,state_id,city_id)values(?,?,?,?,?,?,?,?,?) ";
        PreparedStatement ps=con.prepareStatement(sql);
        
        ps.setString(1,societyname);
        ps.setString(2,societyaddress);
        ps.setString(3,regno);
        ps.setString(4,nobuilding);
        ps.setString(5,societyarea);
        ps.setInt(6,amenitiesid);
        ps.setInt(7,countryid);
        ps.setInt(8,stateid);
        ps.setInt(9,cityid);
                
        int rs=ps.executeUpdate();
         if(rs>0)
			{
                    response.sendRedirect("success.html");			}
        }
        catch(Exception e)
        {
        System.out.println(e);
        }
        }
            
        else if(action!=null && action.equalsIgnoreCase("search"))
            {
               HttpSession session=request.getSession();
          
String societyname=request.getParameter("societyname");  
 
          
try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/housing","root","root");  
              
PreparedStatement ps=con.prepareStatement("select * from society where society_name=?");  
 ps.setString(1,societyname );
                
ResultSet rs=ps.executeQuery();  
 
        
             session.setAttribute("Result",rs);
            response.sendRedirect("searchSociety.jsp");
        
        

    }
catch (Exception e2) {e2.printStackTrace();}  

    
    
            }
        
        else if(action!=null && action.equalsIgnoreCase("update"))
        {
            
            String societyname=request.getParameter("societyname");
            String societyaddress=request.getParameter("societyaddress");
            String regno=request.getParameter("regno");
            String nobuilding=request.getParameter("nobuilding");
            String societyarea=request.getParameter("societyarea");
            int amenitiesid=Integer.parseInt(request.getParameter("ammenitiesid"));
            int countryid=Integer.parseInt(request.getParameter("countryid"));
            int stateid=Integer.parseInt(request.getParameter("stateid"));
            int cityid=Integer.parseInt(request.getParameter("cityid"));
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/housing","root","root");
        String sql="update society set society_name=?,society_add=?,registration_no=?,no_of_building=?,society_area=?,amenities_id=?,country_id=?,state_id=?,city_id=? where society_name=?";
        PreparedStatement ps=con.prepareStatement(sql);
        
        ps.setString(1,societyname);
        ps.setString(2,societyaddress);
        ps.setString(3,regno);
        ps.setString(4,nobuilding);
        ps.setString(5,societyarea);
        ps.setInt(6,amenitiesid);
        ps.setInt(7,countryid);
        ps.setInt(8,stateid);
        ps.setInt(9,cityid);
        ps.setString(10,societyname);    
        int rs=ps.executeUpdate();
        if(rs>0)
        {
            response.sendRedirect("searchSociety.jsp");
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
            String societyname=request.getParameter("societyname");
            String sql="delete from society where society_name=?";
             PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,societyname);
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

      
        
    
   


