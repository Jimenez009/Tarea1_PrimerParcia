package hn.uth.tarea_practica_1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/BinariosServlet")
public class BinariosServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String operacion = request.getParameter("operacion");
        String numeroStr = request.getParameter("numero").trim();

        String nombreOperacion = "";
        String resultado = "";

        try {
            if ("binToDec".equals(operacion)) {
                nombreOperacion = "Cálculo de número binario a decimal";
                int decimal = Integer.parseInt(numeroStr, 2);
                resultado = String.valueOf(decimal);
            } else if ("decToBin".equals(operacion)) {
                nombreOperacion = "Cálculo de número decimal a binario";
                int decimal = Integer.parseInt(numeroStr);
                resultado = Integer.toBinaryString(decimal);
            }
        } catch (NumberFormatException e) {
            resultado = "Error: Formato de número inválido para la conversión.";
        }

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html><html><head><title>Respuesta Servlet 1</title>");
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

            out.println("<p><strong>Operación Realizada:</strong> " + nombreOperacion + "</p>");

            out.println("<table>");
            out.println("<tr><th>Entrada</th><th>Respuesta</th></tr>");
            out.println("<tr><td>" + numeroStr + "</td><td>" + resultado + "</td></tr>");
            out.println("</table>");
            out.println("<br><a href='index.html'>Volver al Menú</a>");
            out.println("</body></html>");
        }
    }
}