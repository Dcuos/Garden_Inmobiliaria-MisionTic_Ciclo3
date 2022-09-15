/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
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
@WebServlet(name = "ServletUsuarioRegister", urlPatterns = {"/ServletUsuarioRegister"})
public class ServletUsuarioRegister extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public ServletUsuarioRegister() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UsuarioController username = new UsuarioController();

        String usuario = request.getParameter("usuario");
        String contraseña = request.getParameter("contraseña");
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String telefono = request.getParameter("telefono");
        String direccion_cliente = request.getParameter("direccion_cliente");
        boolean premium = Boolean.parseBoolean(request.getParameter("premium"));
        double saldo = Double.parseDouble(request.getParameter("saldo"));

        String result = username.register(usuario, contraseña, nombres, apellidos, telefono, direccion_cliente, premium, saldo);
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(result);
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
