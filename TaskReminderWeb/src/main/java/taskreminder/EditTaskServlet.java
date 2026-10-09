package taskreminder;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/editTask")
public class EditTaskServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        String idText = request.getParameter("id");

        if (idText == null) {
            response.sendRedirect("tasks");
            return;
        }

        int id = Integer.parseInt(idText);

        List<Task> tasks = TaskDAO.getAllTasks();

        Task task = null;

        for (Task t : tasks) {
            if (t.getId() == id) {
                task = t;
                break;
            }
        }

        if (task == null) {
            response.sendRedirect("tasks");
            return;
        }

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Edit Task</title>");

        out.println("<style>");

        out.println("body {");
        out.println("font-family: Arial;");
        out.println("background-color: #ffe6f2;");
        out.println("text-align: center;");
        out.println("}");

        out.println(".box {");
        out.println("background-color: white;");
        out.println("width: 400px;");
        out.println("margin: 50px auto;");
        out.println("padding: 30px;");
        out.println("border-radius: 15px;");
        out.println("}");

        out.println("input, select {");
        out.println("width: 90%;");
        out.println("padding: 10px;");
        out.println("margin: 8px;");
        out.println("}");

        out.println("button {");
        out.println("background-color: #ff69b4;");
        out.println("color: white;");
        out.println("border: none;");
        out.println("padding: 10px 20px;");
        out.println("border-radius: 8px;");
        out.println("cursor: pointer;");
        out.println("}");

        out.println("</style>");
        out.println("</head>");

        out.println("<body>");

        out.println("<div class='box'>");

        out.println("<h2>Edit Task</h2>");

        out.println("<form action='updateTask' method='post'>");

        out.println("<input type='hidden' name='id' value='" + task.getId() + "'>");

        out.println("<input type='text' name='taskName' value='"
                + task.getTaskName()
                + "' placeholder='Task Name' required>");

        out.println("<input type='text' name='description' value='"
                + task.getDescription()
                + "' placeholder='Description' required>");

        out.println("<input type='date' name='date' value='"
                + task.getDate() + "' required>");

        out.println("<input type='time' name='time' value='"
                + task.getTime() + "' required>");

        out.println("<select name='priority'>");

        out.println("<option value='High'>High</option>");
        out.println("<option value='Medium'>Medium</option>");
        out.println("<option value='Low'>Low</option>");

        out.println("</select>");

        out.println("<br>");

        out.println("<button type='submit'>Update Task</button>");

        out.println("</form>");

        out.println("</div>");

        out.println("</body>");
        out.println("</html>");
    }
}