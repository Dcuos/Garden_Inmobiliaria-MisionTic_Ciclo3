
package servlets;

import Controller.UsuarioController;
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
@WebServlet(name = "ServletUsuarioLogin", urlPatterns = {"/ServletUsuarioLogin"})
public class ServletUsuarioLogin extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    public ServletUsuarioLogin(){
        super();
    }
  
    

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UsuarioController username = new UsuarioController();
        
        String usuario = request.getParameter("usuario");
        String contraseña = request.getParameter("contraseña");
        String result = username.login(usuario, contraseña);
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(result);
        out.flush();
        out.close();

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
        doGet(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
   

}