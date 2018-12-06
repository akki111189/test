
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/NewServlet"})
public class NewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         HttpSession session=request.getSession();
        String action=request.getParameter("action");
        if(action!=null && action.equalsIgnoreCase("Submit"))
        {
            String branchname=request.getParameter("branchname");
            String date=request.getParameter("date");
            String applicantid=(String)session.getAttribute("applicant_id");  
           try
            {
               Class.forName("com.mysql.jdbc.Driver");
                    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pallavi","root","root");
                    String sql="select branch_name,date,applicant_id from booking where branch_name='"+branchname+"' and date='"+date+"' and applicant_id='"+applicantid+"'";
                     PreparedStatement ps=con.prepareStatement(sql);
                      ResultSet rs=ps.executeQuery(sql);
  if(!rs.next())
{
String sql3="insert into booking(branch_name,date,applicant_id) values(?,?,?)";
                         PreparedStatement ps3=con.prepareStatement(sql3);
        
                  ps3.setString(1,branchname);
                  ps3.setString(2,date);
                  ps3.setString(3,applicantid);
                  int rs3=ps3.executeUpdate();
 if(rs3>0)
{

                         
                    String sql1="select opening,booked from appointmentdetails where branch_name='"+branchname+"' and date='"+date+"'";
                PreparedStatement ps1=con.prepareStatement(sql1);
                  ResultSet rs1=ps1.executeQuery(sql1);
                     if(rs1.next())
			{
                            
                          int open=0,booked=0;
                            	open=rs1.getInt(1);
                                booked=rs1.getInt(2);
                                System.out.println("open = "+open+" booked = "+booked);
                                if(booked<open)
                                {
                                    booked++;
                                    System.out.println("open = "+open+" booked = "+booked);
                                    String sql2="update appointmentdetails set opening="+open+",booked="+booked+" where branch_name='"+branchname+"' and date='"+date+"'";
                                 PreparedStatement ps2=con.prepareStatement(sql2);
                                  System.out.println(sql2);
                                System.out.println("open = "+open+" booked = "+booked);
                                 int rs2=ps2.executeUpdate();
                                 if(rs2>0)
                                 {
                                 response.sendRedirect("success.html");
                                 }
                                }
                        }
}
}else
{
 response.sendRedirect("error.jsp");
}
        
    }
         catch(Exception e)
                      {
                             System.out.println(e);
                       }   

}
    }
}
