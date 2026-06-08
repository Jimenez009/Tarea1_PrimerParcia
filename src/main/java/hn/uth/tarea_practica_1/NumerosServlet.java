package hn.uth.tarea_practica_1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/NumerosServlet")
public class NumerosServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String operacion = request.getParameter("operacion");
        String numerosInput = request.getParameter("numeros");

        String nombreOperacion = "";
        String resultado = "";

        try {

            String[] partes = numerosInput.split(",");
            int[] arreglo = new int[partes.length];
            for (int i = 0; i < partes.length; i++) {
                arreglo[i] = Integer.parseInt(partes[i].trim());
            }

            if ("mayorMenor".equals(operacion)) {
                nombreOperacion = "Encontrar el mayor y menor de los números ingresados";
                if (arreglo.length < 3) {
                    resultado = "Error: Debe ingresar al menos 3 números.";
                } else {
                    int mayor = arreglo[0];
                    int menor = arreglo[0];

                    for (int i = 0; i < Math.min(arreglo.length, 3); i++) {
                        if (arreglo[i] > mayor) mayor = arreglo[i];
                        if (arreglo[i] < menor) menor = arreglo[i];
                    }
                    resultado = "Mayor (de los 3 primeros): " + mayor + " | Menor (de los 3 primeros): " + menor;
                }
            } else if ("repetido".equals(operacion)) {
                nombreOperacion = "Encontrar el valor que más se repite de 'n' cantidad de números";
                HashMap<Integer, Integer> mapa = new HashMap<>();
                for (int num : arreglo) {
                    mapa.put(num, mapa.getOrDefault(num, 0) + 1);
                }

                int maxRepeticiones = -1;
                int numeroMasRepetido = arreglo[0];
                for (Map.Entry<Integer, Integer> entrada : mapa.entrySet()) {
                    if (entrada.getValue() > maxRepeticiones) {
                        maxRepeticiones = entrada.getValue();
                        numeroMasRepetido = entrada.getKey();
                    }
                }
                resultado = "El número más repetido es: " + numeroMasRepetido + " (" + maxRepeticiones + " veces)";
            }
        } catch (Exception e) {
            resultado = "Error: Asegúrese de separar los números enteros únicamente por comas.";
        }

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html><html><head><title>Respuesta Servlet 2</title>");
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


            out.println("<p><strong>Operación Realizada:</strong> " + nombreOperacion + "</p>");

            out.println("<table>");
            out.println("<tr><th>Entrada (n números)</th><th>Respuesta</th></tr>");
            out.println("<tr><td>" + numerosInput + "</td><td>" + resultado + "</td></tr>");
            out.println("</table>");
            out.println("<br><a href='index.html'>Volver al Menú</a>");
            out.println("</body></html>");
        }
    }
}