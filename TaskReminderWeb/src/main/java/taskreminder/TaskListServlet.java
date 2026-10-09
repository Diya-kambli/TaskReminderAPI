package taskreminder;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/tasks")
public class TaskListServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        List<Task> tasks = TaskDAO.getAllTasks();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");

        out.println("<meta charset='UTF-8'>");

        out.println("<title>My Tasks - Task Reminder</title>");

        out.println("<style>");

        out.println("body {");
        out.println("margin: 0;");
        out.println("font-family: Arial, sans-serif;");
        out.println("background-color: #f7f1f5;");
        out.println("color: #333;");
        out.println("}");

        out.println(".header {");
        out.println("background-color: #e8b4c8;");
        out.println("padding: 25px;");
        out.println("text-align: center;");
        out.println("}");

        out.println(".header h1 {");
        out.println("margin: 0;");
        out.println("color: white;");
        out.println("font-size: 32px;");
        out.println("}");

        out.println(".navbar {");
        out.println("background-color: white;");
        out.println("padding: 15px;");
        out.println("text-align: center;");
        out.println("box-shadow: 0 2px 5px #ccc;");
        out.println("}");

        out.println(".navbar a {");
        out.println("text-decoration: none;");
        out.println("color: #b04a72;");
        out.println("margin: 0 15px;");
        out.println("font-weight: bold;");
        out.println("}");

        out.println(".container {");
        out.println("width: 80%;");
        out.println("margin: 30px auto;");
        out.println("}");

        out.println(".container h2 {");
        out.println("color: #b04a72;");
        out.println("}");

        out.println(".task-card {");
        out.println("background-color: white;");
        out.println("padding: 20px;");
        out.println("margin-top: 20px;");
        out.println("border-radius: 12px;");
        out.println("box-shadow: 0 3px 10px #ccc;");
        out.println("}");

        out.println(".task-card h3 {");
        out.println("color: #b04a72;");
        out.println("}");

        out.println(".button {");
        out.println("border: none;");
        out.println("padding: 10px 15px;");
        out.println("margin: 5px;");
        out.println("border-radius: 6px;");
        out.println("cursor: pointer;");
        out.println("background-color: #d889a7;");
        out.println("color: white;");
        out.println("}");

        out.println(".add-button {");
        out.println("display: block;");
        out.println("margin: 25px auto;");
        out.println("background-color: #b04a72;");
        out.println("color: white;");
        out.println("border: none;");
        out.println("padding: 12px 20px;");
        out.println("border-radius: 8px;");
        out.println("cursor: pointer;");
        out.println("font-size: 16px;");
        out.println("}");

        out.println("</style>");

        out.println("</head>");

        out.println("<body>");

        // Header
        out.println("<div class='header'>");
        out.println("<h1>TASK REMINDER</h1>");
        out.println("</div>");

        // Navigation
        out.println("<div class='navbar'>");

        out.println("<a href='index.html'>Home</a>");
        out.println("<a href='tasks'>My Tasks</a>");

        // Correct Add Task link
        out.println("<a href='" + request.getContextPath()
                + "/addtask.html'>Add Task</a>");

        out.println("<a href='completed'>Completed</a>");

        out.println("</div>");

        // Main container
        out.println("<div class='container'>");

        out.println("<h2>My Tasks</h2>");

        if (tasks.isEmpty()) {

            out.println("<div class='task-card'>");
            out.println("<p>No tasks available.</p>");
            out.println("</div>");

        } else {

            for (int i = 0; i < tasks.size(); i++) {

                Task task = tasks.get(i);

                out.println("<div class='task-card'>");

                out.println("<h3>"
                        + task.getTaskName()
                        + "</h3>");

                out.println("<p>📅 "
                        + task.getDate()
                        + "</p>");

                out.println("<p>⏰ "
                        + task.getTime()
                        + "</p>");

                out.println("<p>Priority: "
                        + task.getPriority()
                        + "</p>");

                out.println("<p>Status: "
                        + task.getStatus()
                        + "</p>");

                out.println("<a href='editTask?id="
                        + task.getId()
                        + "'><button class='button'>Edit</button></a>");

                out.println("<a href='deleteTask?id="
                        + task.getId()
                        + "'><button class='button'>Delete</button></a>");

                out.println("<a href='completeTask?id="
                        + task.getId()
                        + "'><button class='button'>Complete</button></a>");

                out.println("</div>");
            }
        }

        // Correct Add New Task link
        out.println("<a href='" + request.getContextPath()
                + "/addtask.html'>");

        out.println("<button class='add-button'>");
        out.println("+ Add New Task");
        out.println("</button>");

        out.println("</a>");

        out.println("</div>");

        out.println("</body>");
        out.println("</html>");
    }
}