
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class searchServlet extends HttpServlet {

      @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
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

        
    }

    
   
