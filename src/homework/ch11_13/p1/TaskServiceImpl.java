package homework.ch11_13.p1;

import java.util.ArrayList;
import java.util.List;

/**
 * 任务服务接口实现类
 */
class TaskServiceImpl implements TaskService {

    private List<Task> tasks = new ArrayList<>();

    @Override
    public void exeuteTasks() {
        for (Task task : tasks) {
            task.execute();
        }
    }

    @Override
    public void addTask(Task t) {
        tasks.add(t);
    }
}