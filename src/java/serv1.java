/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.aissms.sfir.MainGui.code.MainFrame;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.accessibility.AccessibleRole;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Owner
 */
@WebServlet(urlPatterns = {"/serv1"})
public class serv1 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String id=request.getParameter("userid");
        String nam =request.getParameter("username");
        String passw =request.getParameter("password");
        connect();
        //to create statement.
        Statement stmt =null;
        try {
            stmt=con.createStatement();
            ResultSet rs= stmt.executeQuery("select * from userdb where id='"+id+"'");
             System.out.println("dfd"); 
            
          if(rs.next())
          {  
           if(nam.equals(rs.getString(2))&& passw.equals(rs.getString(3)))
           {
            
               MainFrame mf=new MainFrame();
            mf.setVisible(true);
            response.sendRedirect("welcome.jsp");
          
               
           }       
            else
           {
            response.sendRedirect("index.html");
           }
          }
          else if(!rs.next())
          {   
            response.sendRedirect("create-account.html");
            
          }
        } catch (SQLException ex) {
            Logger.getLogger(serv1.class.getName()).log(Level.SEVERE, null, ex);
        }
        //-------
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet serv1</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet serv1 at " + request.getContextPath() + "</h1>");
            out.println(id);
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
  
     Connection con;
     void connect() 
     {
    try {
             Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
        } catch (Exception ex) {
            Logger.getLogger(serv1.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
      
}
