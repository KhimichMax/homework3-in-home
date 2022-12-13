package Manager;

import TodoList.Epic;
import TodoList.Subtask;
import TodoList.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class Manager {

    private static int count;

    private HashMap<Integer, Task> collectMainTask = new HashMap<>();
    private HashMap<Integer, ArrayList<Subtask>> collectEpic = new HashMap<>();

    // Возвращает все задачи
    public HashMap<Integer, Task> getAllTask() {
        return collectMainTask;
    }

    // Возвращает все epics
    public HashMap<Integer, ArrayList<Subtask>> getAllEpic() {
        return collectEpic;
    }

    // Возвращает все подзадачи из своего epic
    public ArrayList<Subtask> getAllSubtaskOfEpic(Epic epic) {
        return epic.getSubtasksList();
    }

    // Возвращает подзадачу по индетификатору
    public Subtask getSubtaskOfEpic(Epic epic, int id) {
        return epic.getSubTask(id);
    }

    // Удаляет задачу по индетификатору
    public boolean removeIndexTask(Integer id) {
        if (collectMainTask.remove(id) == null) {
            return false;
        }else {
            return true;
        }
    }

    public boolean removeIndexEpic(Integer id) {
        if (collectEpic.remove(id) == null) {
            return false;
        }else {
            return true;
        }
    }

    // Удаляет подзадачу по индетификатору !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    public Boolean removeIndexSubtask(Epic epic, Integer id) {
        ArrayList<Subtask> subtasksList = epic.getSubtasksList();
        Boolean bool = null;
        for (Subtask subtask  : subtasksList) {
            if (subtask.getId() == id) {
                subtasksList.remove(subtask);
                return bool = true;
            }else {
                return bool = false;
            }
        }
        return bool;
    }

    // Удаляет все типы задач
    public boolean removeAllTask() {
        if (collectMainTask.isEmpty()) {
            return true;
        }else {
            collectMainTask.clear();
            return false;
        }
    }

    // Удаляет все задачи
    public void removeTasks() {
        Iterator<Map.Entry<Integer, Task>> iterator = collectMainTask.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<Integer, Task> entry = iterator.next();
            collectMainTask.remove(entry.getKey(), entry.getValue());
        }
    }

    // Удаляет все epic
    public void removeEpics() {
        Iterator<Map.Entry<Integer, ArrayList<Subtask>>> iterator = collectEpic.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<Integer, ArrayList<Subtask>> entry = iterator.next();
            collectEpic.remove(entry.getKey(), entry.getValue());
        }
    }

    // Удаляет подзадачи
    public void removeSubtask(Epic epic) {
       epic.getSubtasksList().clear();
    }

    // Удаляет все подзадачи !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    public void removeAllSubtask() {
        Iterator<Map.Entry<Integer, ArrayList<Subtask>>> iterator = collectEpic.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<Integer, ArrayList<Subtask>> entry = iterator.next();
            entry.getValue().clear();
        }
    }

    // Получить задачу по индетификатору
    public Task getTask(Integer id) {
        return collectMainTask.get(id);
    }

    public HashMap<Integer, ArrayList<Subtask>> getEpic(Integer id) {
        HashMap<Integer, ArrayList<Subtask>> backEpic = new HashMap<>();

        for (Map.Entry<Integer, ArrayList<Subtask>> entry : collectEpic.entrySet()) {
            if (entry.getKey() == id) {
                backEpic.put(entry.getKey(), entry.getValue());
            }
        }
        if (backEpic.isEmpty()) {
            return null;
        }else {
            return backEpic;
        }
    }

    // Получить подзадачу по индетификатору
    public Subtask getSubtask(Epic epic, Integer id) {

        ArrayList<Subtask> subtasksList = epic.getSubtasksList();
        Integer pos = -1;
        for (Subtask sub : subtasksList) {
            if (sub.getId() == id) {
                pos++;
            }
        }
        if (pos > -1) {
            return subtasksList.get(pos);
        }else {
            return null;
        }
    }

    // Добавить задачу в коллекцию
    public void addMainTask(Task task) {
        task.setId(count);
        count++;
        collectMainTask.put(task.getId(), task);
    }

    public void addEpic(Epic epic, ArrayList<Subtask> subtask) {
        epic.setId(count);
        count++;
        collectEpic.put(epic.getId(), subtask);
    }

    // Добавить подзадачу в массив
    public void addSubtask(Epic epic, Subtask subtask) {
        subtask.setId(count);
        count++;
        epic.setSubtasksList(subtask);
    }

    // Обновить задачу
    public void updateTask(Task task) {
        collectMainTask.put(task.getId(), task);
    }

    public void updateEpic(Epic epic, ArrayList<Subtask> subtasks) {
        collectEpic.put(epic.getId(), subtasks);
    }

    // Обновить подзадачу
    public void updateSubtask(Epic epic, Subtask subtask) {
        ArrayList<Subtask> subtasksList = epic.getSubtasksList();
        Integer id = subtask.getId();
        Integer pos = 0;
        for (Subtask sub : subtasksList) {
            if (sub.getId() == id) {
                subtasksList.add(pos, subtask);
            }
            pos++;
        }
    }

    // Проверка статуса epic
    public void checkStatus(Epic epic) {
        int mapLength = 0;
        int doneTask = 0;
        ArrayList<Subtask> subtasks = epic.getSubtasksList();

        mapLength =  subtasks.size();

        for (Subtask subT : subtasks) {
            if(subT.getStatus() == Status.DONE) {
                doneTask++;
            }
        }

        if (doneTask == mapLength) {
            epic.setStatus(Status.DONE);
        } else {
            epic.setStatus(Status.IN_PROGRESS);
        }
    }

    // Переключатель статуса подзадач
    public void setDoneSubtask(Subtask subtask) {
        subtask.setStatus(Status.DONE);
        checkStatus(subtask.getEpic());
    }

}
