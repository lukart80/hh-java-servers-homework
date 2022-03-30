import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/counter")
public class CounterServlet extends HttpServlet {
    int counter = 0;

    private void incrementCounter() {
        counter++;
    }

    private void subtractCounter(int value) {
        counter = counter - value;
    }

    private void clearCounter() {
        counter = 0;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();

        writer.println(counter);

        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        processPostRequest(req, response);

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        String subtractionNum = req.getHeader("Subtraction-Value");
        if (subtractionNum == null || !isInteger(subtractionNum)) {
            throw new IllegalArgumentException();
        }
        subtractCounter(Integer.parseInt(subtractionNum));
        PrintWriter writer = response.getWriter();
        writer.println(counter);
        writer.flush();

    }

    protected void processPostRequest(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        if (req.getServletPath().equals("/counter")) {
            incrementCounter();
            PrintWriter writer = response.getWriter();
            writer.println(counter);
            writer.flush();
            response.setStatus(200);
            return;
        }

        if (req.getServletPath().equals("/counter/clear")) {
            clearCounter();
            response.setStatus(200);
            return;
        }
        response.setStatus(404);
    }

    private boolean isInteger(String num) {
        try {
            Integer.parseInt(num);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
