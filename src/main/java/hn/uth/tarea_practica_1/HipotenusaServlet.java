package hn.uth.tarea_practica_1;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/HipotenusaServlet")
public class HipotenusaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String catetoAStr = request.getParameter("catetoA");
        String catetoBStr = request.getParameter("catetoB");
        String resultado = "";

        try {
            double a = Double.parseDouble(catetoAStr);
            double b = Double.parseDouble(catetoBStr);
            double hipotenusa = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
            resultado = String.format("%.4f", hipotenusa);
        } catch (NumberFormatException e) {
            resultado = "Error: Los valores de los catetos deben ser números válidos.";
        }

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html><html><head><title>Respuesta Servlet 3</title>");
            out.println("<style>table, th, td { border: 1px solid black; border-collapse: collapse; padding: 10px; } th { background-color: #f2f2f2; }</style></head><body>");

            out.println("<h2>Servlet Tarea 1: [INTEGRANTES ]</h2>");
            out.println("<h2> [Karol Andrea Maldonado Ramirez ]</h2>");
            out.println("<h2> [Stephanie Alejandra Chevez Almendares  ]</h2>");
            out.println("<h2> [Ronmel david sarmiento salmeron ]</h2>");
            out.println("<h2> [Allan Gerardo Nuñez Solis  ]</h2>");
            out.println("<h2> [Jose Alfredo Jimenez Vargas ]</h2>");
            out.println("<h2> [Jair Leonardo Breve ]</h2>");
            out.println("<h2>Cuentas : </h2>");
            out.println("<h2> [202220010211]</h2>");
            out.println("<h2> [202410060605]</h2>");
            out.println("<h2> [202210130132]</h2>");
            out.println("<h2> [202320130099]</h2>");
            out.println("<h2> [202310130219]</h2>");
            out.println("<h2> [202310130039]</h2>");
            out.println("<p><strong>Operación Realizada:</strong> Cálculo de la Hipotenusa (Teorema de Pitágoras)</p>");

            out.println("<table>");
            out.println("<tr><th>Cateto A</th><th>Cateto B</th><th>Hipotenusa Generada</th></tr>");
            out.println("<tr><td>" + catetoAStr + "</td><td>" + catetoBStr + "</td><td>" + resultado + "</td></tr>");
            out.println("</table>");
            out.println("<br><a href='index.html'>Volver al Menú</a>");
            out.println("</body></html>");
        }
    }
}