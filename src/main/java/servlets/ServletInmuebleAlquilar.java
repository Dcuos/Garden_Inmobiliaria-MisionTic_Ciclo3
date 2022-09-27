/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import Controller.muebleController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dicdh
 */
@WebServlet(name = "ServletInmuebleAlquilar", urlPatterns = {"/ServletInmuebleAlquilar"})
public class ServletInmuebleAlquilar extends HttpServlet {

   private static final long serialVersionUID = 1L;
    public ServletInmuebleAlquilar(){
        super();
    }
   

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      muebleController inmuebless = new muebleController();
      
      int id_inmueble = Integer.parseInt(request.getParameter("id_inmueble"));
      String usuario =request.getParameter("usuario");
      
      String mueblesStr = inmuebless.alquilar(id_inmueble, usuario);
      
      response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println(mueblesStr);
        out.flush();
        out.close();
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    
}
