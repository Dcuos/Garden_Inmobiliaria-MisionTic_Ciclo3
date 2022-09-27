
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
@WebServlet(name = "ServletInmuebleListado", urlPatterns = {"/ServletInmuebleListado"})
public class ServletInmuebleListado extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public ServletInmuebleListado(){
        super();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        muebleController inmuebless = new muebleController();
        
        boolean ordenar = Boolean.parseBoolean(request.getParameter("ordenar"));
        String orden = request.getParameter("orden");
        String mueblesStr = inmuebless.listar(ordenar, orden);

        
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
