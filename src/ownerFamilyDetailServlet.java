
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

public class ownerFamilyDetailServlet extends HttpServlet {

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
	    String mname=request.getParameter("membername");
	    int mage=Integer.parseInt(request.getParameter("memberage"));
	    String memail=request.getParameter("memberemail");
            int mobile=Integer.parseInt(request.getParameter("membermobile"));
            int occupationid=Integer.parseInt(request.getParameter("occupationid"));
           
            try{
                 System.out.println("inside try");
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/housing","root","root");
        String sql="insert into family_member_details(member_name,member_age,member_email,member_mob,occupation_id)values(?,?,?,?,?)";
        PreparedStatement ps=con.prepareStatement(sql);
        
        ps.setString(1,mname);
        ps.setInt(2,mage);
        ps.setString(3,memail);
        ps.setInt(4,mobile);
        ps.setInt(5,occupationid);
	               
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
          
String mname=request.getParameter("membername");
 
          
try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/housing","root","root");  
              
PreparedStatement ps=con.prepareStatement("select * from family_member_details where member_name=?");  
 ps.setString(1,mname );
                
ResultSet rs=ps.executeQuery();  
 
        
             session.setAttribute("Result",rs);
            response.sendRedirect("searchOwnerFamily.jsp");
        
        

    }
catch (Exception e2) {e2.printStackTrace();}  

    
    
            }
        
        else if(action!=null && action.equalsIgnoreCase("update"))
        {
            
            System.out.println("inside submit");  
	    String mname=request.getParameter("membername");
	    int mage=Integer.parseInt(request.getParameter("memberage"));
	    String memail=request.getParameter("memberemail");
            int mobile=Integer.parseInt(request.getParameter("membermobile"));
            int occupationid=Integer.parseInt(request.getParameter("occupationid"));
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/housing","root","root");
        String sql="update family_member_details set member_name=?,member_age=?,member_email=?,member_mob=?,occupation_id=? where member_name=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1,mname);
        ps.setInt(2,mage);
        ps.setString(3,memail);
        ps.setInt(4,mobile);
        ps.setInt(5,occupationid);
        ps.setString(6,mname);
        int rs=ps.executeUpdate();
        if(rs>0)
        {
            response.sendRedirect("searchOwnerFamily.jsp");
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
            String mname=request.getParameter("membername");
            String sql="delete from family_member_details where member_name=?";
             PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,mname);
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
