package taskreminder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class TaskDAO {

    // Add Task
    public static void addTask(Task task) {

        String sql = "INSERT INTO tasks "
                + "(taskName, description, date, time, priority, status) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            statement.setString(1, task.getTaskName());
            statement.setString(2, task.getDescription());
            statement.setString(3, task.getDate());
            statement.setString(4, task.getTime());
            statement.setString(5, task.getPriority());
            statement.setString(6, task.getStatus());

            statement.executeUpdate();

            System.out.println("Task saved to MySQL!");

            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // Get All Tasks
    public static List<Task> getAllTasks() {

        List<Task> tasks = new ArrayList<>();

        String sql = "SELECT * FROM tasks";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            java.sql.ResultSet result =
                    statement.executeQuery();

            while (result.next()) {

                Task task = new Task(
                        result.getString("taskName"),
                        result.getString("description"),
                        result.getString("date"),
                        result.getString("time"),
                        result.getString("priority")
                );

                task.setId(result.getInt("id"));
                task.setStatus(result.getString("status"));

                tasks.add(task);
            }

            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return tasks;
    }


    // Delete Task
    public static void deleteTask(int id) {

        String sql = "DELETE FROM tasks WHERE id = ?";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            statement.setInt(1, id);

            statement.executeUpdate();

            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // Complete Task
    public static void completeTask(int id) {

        String sql = "UPDATE tasks SET status = 'Completed' WHERE id = ?";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            statement.setInt(1, id);

            statement.executeUpdate();

            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // Get Completed Tasks
    public static List<Task> getCompletedTasks() {

        List<Task> tasks = new ArrayList<>();

        String sql = "SELECT * FROM tasks WHERE status = 'Completed'";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            java.sql.ResultSet result =
                    statement.executeQuery();

            while (result.next()) {

                Task task = new Task(
                        result.getString("taskName"),
                        result.getString("description"),
                        result.getString("date"),
                        result.getString("time"),
                        result.getString("priority")
                );

                task.setId(result.getInt("id"));
                task.setStatus(result.getString("status"));

                tasks.add(task);
            }

            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return tasks;
    }


    // Update Task
    public static void updateTask(Task task) {

        String sql = "UPDATE tasks SET "
                + "taskName = ?, "
                + "description = ?, "
                + "date = ?, "
                + "time = ?, "
                + "priority = ? "
                + "WHERE id = ?";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            statement.setString(1, task.getTaskName());
            statement.setString(2, task.getDescription());
            statement.setString(3, task.getDate());
            statement.setString(4, task.getTime());
            statement.setString(5, task.getPriority());
            statement.setInt(6, task.getId());

            statement.executeUpdate();

            System.out.println("Task updated in MySQL!");

            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}