public class TaskManagement {

    private Task head;

    // Add Task
    public void addTask(int taskId, String taskName, String status) {

        Task newTask = new Task(taskId, taskName, status);

        if (head == null) {
            head = newTask;
        } else {

            Task temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newTask;
        }

        System.out.println("Task added successfully.");
    }

    // Search Task
    public Task searchTask(int taskId) {

        Task temp = head;

        while (temp != null) {

            if (temp.taskId == taskId) {
                return temp;
            }

            temp = temp.next;
        }

        return null;
    }

    // Traverse Tasks
    public void displayTasks() {

        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        Task temp = head;

        System.out.println("\nTask List:");

        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    // Delete Task
    public void deleteTask(int taskId) {

        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        if (head.taskId == taskId) {
            head = head.next;
            System.out.println("Task deleted successfully.");
            return;
        }

        Task temp = head;

        while (temp.next != null && temp.next.taskId != taskId) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Task not found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Task deleted successfully.");
        }
    }

    public static void main(String[] args) {

        TaskManagement tm = new TaskManagement();

        tm.addTask(101, "Design UI", "Pending");
        tm.addTask(102, "Develop Backend", "In Progress");
        tm.addTask(103, "Testing", "Pending");

        tm.displayTasks();

        System.out.println("\nSearching Task ID 102:");

        Task task = tm.searchTask(102);

        if (task != null) {
            System.out.println(task);
        } else {
            System.out.println("Task not found.");
        }

        tm.deleteTask(102);

        tm.displayTasks();
    }
}