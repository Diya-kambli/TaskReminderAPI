package taskreminder;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/completeTask")
public class CompleteTaskServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String idText = request.getParameter("id");

        if (idText != null) {

            int id = Integer.parseInt(idText);

            TaskDAO.completeTask(id);
        }

        response.sendRedirect("tasks");
    }
}