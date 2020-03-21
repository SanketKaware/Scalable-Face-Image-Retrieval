/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static org.apache.coyote.http11.Constants.a;
import sun.security.util.BigInt;

/**
 *
 * @author Owner
 */
@WebServlet(urlPatterns = {"/serv2"})
public class serv2 extends HttpServlet {

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
        
        String nam =request.getParameter("username");
        String passw =request.getParameter("password");
        String conpassw =request.getParameter("confirmpassword");
        String  mobno =request.getParameter("mobileno");
        String mail =request.getParameter("email");
        connect();
        //to create statement.
        Statement stmt1 =null;
        try {
            stmt1=con1.createStatement();
            int i = stmt1.executeUpdate("insert into userdb (username,password,mobileno,email) values ('"+nam+"','"+passw+"','"+mobno+"','"+mail+"')");
              
      response.sendRedirect("welcome.jsp");

        
        } catch (SQLException ex) {
            Logger.getLogger(serv2.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("inserted !!");
        ///
        try (PrintWriter out = response.getWriter()) {
          
            out.println("<!DOCTYPE html>");
            
            
        
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

    Connection con1;
     void connect()
     {
         
        try {
              
            con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
        } catch (SQLException ex) {
            Logger.getLogger(serv2.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
}
