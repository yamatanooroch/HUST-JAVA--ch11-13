package homework.ch11_13.p1;

public class Main {
    public static void main(String[] args) {
        // 实例化任务对象
        Task task1 = new Task1();
        Task task2 = new Task2();
        Task task3 = new Task3();

        // 实例化任务服务对象
        TaskService taskService = new TaskServiceImpl();

        // 添加任务
        taskService.addTask(task1);
        taskService.addTask(task2);
        taskService.addTask(task3);

        // 执行任务
        taskService.exeuteTasks();
    }
}