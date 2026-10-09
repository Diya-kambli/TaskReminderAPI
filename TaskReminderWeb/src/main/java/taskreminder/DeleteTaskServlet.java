package taskreminder;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteTask")
public class DeleteTaskServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        String idText = request.getParameter("id");

        if (idText != null) {

            int id = Integer.parseInt(idText);

            TaskDAO.deleteTask(id);
        }

        response.sendRedirect("tasks");
    }
}