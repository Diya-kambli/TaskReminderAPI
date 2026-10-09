package taskreminder;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/updateTask")
public class UpdateTaskServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String idText = request.getParameter("id");
        String taskName = request.getParameter("taskName");
        String description = request.getParameter("description");
        String date = request.getParameter("date");
        String time = request.getParameter("time");
        String priority = request.getParameter("priority");

        if (idText != null) {

            int id = Integer.parseInt(idText);

            Task task = new Task(
                    taskName,
                    description,
                    date,
                    time,
                    priority
            );

            task.setId(id);

            TaskDAO.updateTask(task);
        }

        response.sendRedirect("tasks");
    }
}