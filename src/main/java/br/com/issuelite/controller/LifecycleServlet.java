package br.com.issuelite.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/lifecycle")
public class LifecycleServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("=====================================================");
        System.out.println(">>> LifecycleServlet: Método init() FOI CHAMADO!");
        System.out.println("=====================================================");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("-----------------------------------------------------");
        System.out.println(">>> LifecycleServlet: Método service() FOI CHAMADO!");
        super.service(req, resp); // <--- Isso aqui é o "porteiro" que decide se chama o doGet ou doPost
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(">>> LifecycleServlet: Método doGet() FOI CHAMADO!");

        resp.setContentType("text/html");
        resp.getWriter().println("<html><body>");
        resp.getWriter().println("<h1>Servlet de Ciclo de Vida (v0.2)</h1>");
        resp.getWriter().println("</body></html>");
    }

    @Override
    public void destroy() {
        System.out.println("=====================================================");
        System.out.println(">>> LifecycleServlet: Método destroy() FOI CHAMADO!");
        System.out.println("=====================================================");
    }
}