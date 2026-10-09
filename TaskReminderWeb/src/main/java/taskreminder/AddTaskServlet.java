package taskreminder;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addTask")
public class AddTaskServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String taskName = request.getParameter("taskName");
        String description = request.getParameter("description");
        String date = request.getParameter("date");
        String time = request.getParameter("time");
        String priority = request.getParameter("priority");
        Task task = new Task(
        		taskName,
        	    description,
        	    date,
        	    time,
        	    priority
        	);

        TaskDAO.addTask(task);

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Task Added</title>");
        out.println("</head>");

        out.println("<body>");

        out.println("<h1>Task Added Successfully!</h1>");

        out.println("<h2>Task Details</h2>");

        out.println("<p>Task Name: " + taskName + "</p>");
        out.println("<p>Description: " + description + "</p>");
        out.println("<p>Date: " + date + "</p>");
        out.println("<p>Time: " + time + "</p>");
        out.println("<p>Priority: " + priority + "</p>");

        out.println("<br>");
        out.println("<a href='dashboard.html'>Back to Dashboard</a>");

        out.println("</body>");
        out.println("</html>");
    }
}