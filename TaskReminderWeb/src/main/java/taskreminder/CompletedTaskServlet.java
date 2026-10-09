package taskreminder;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/completed")
public class CompletedTaskServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        List<Task> tasks = TaskDAO.getCompletedTasks();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Completed Tasks</title>");

        out.println("<style>");
        out.println("body {");
        out.println("font-family: Arial;");
        out.println("background-color: #ffe6f2;");
        out.println("padding: 30px;");
        out.println("}");

        out.println("h1 {");
        out.println("color: #d63384;");
        out.println("text-align: center;");
        out.println("}");

        out.println(".task {");
        out.println("background: white;");
        out.println("padding: 20px;");
        out.println("margin: 20px auto;");
        out.println("width: 500px;");
        out.println("border-radius: 15px;");
        out.println("}");

        out.println("</style>");
        out.println("</head>");

        out.println("<body>");

        out.println("<h1>Completed Tasks</h1>");

        if (tasks.isEmpty()) {

            out.println("<p style='text-align:center;'>No completed tasks.</p>");

        } else {

            for (Task task : tasks) {

                out.println("<div class='task'>");

                out.println("<h2>" + task.getTaskName() + "</h2>");

                out.println("<p><b>Description:</b> "
                        + task.getDescription() + "</p>");

                out.println("<p><b>Date:</b> "
                        + task.getDate() + "</p>");

                out.println("<p><b>Time:</b> "
                        + task.getTime() + "</p>");

                out.println("<p><b>Priority:</b> "
                        + task.getPriority() + "</p>");

                out.println("<p><b>Status:</b> "
                        + task.getStatus() + "</p>");

                out.println("</div>");
            }
        }

        out.println("<p style='text-align:center;'>");
        out.println("<a href='tasks'>Back to My Tasks</a>");
        out.println("</p>");

        out.println("</body>");
        out.println("</html>");
    }
}