package org.nicolasperussi.service;

import org.nicolasperussi.dao.TaskDAO;
import org.nicolasperussi.domain.Task;

public class TaskService {
    private TaskDAO taskDAO;

    public TaskService() {
        this.taskDAO = getTaskDAO();
    }

    private TaskDAO getTaskDAO() {
        if (taskDAO == null) {
            taskDAO = new TaskDAO();
        }

        return taskDAO;
    }

    public void createTask(Task task) {
        taskDAO.save(task);
    }

    public Task findById(final int id) {
        return taskDAO.findById(id);
    }
}
