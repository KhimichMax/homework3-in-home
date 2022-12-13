package TodoList;

import Manager.Status;

import java.util.ArrayList;

public class Epic extends Task {

    private ArrayList<Subtask> subtasksList = new ArrayList<Subtask>();

    public Epic(String name, Status status) {
        super(name, status);
    }

    public ArrayList<Subtask> getSubtasksList() {
        return subtasksList;
    }

    public Subtask getSubTask(int id) {
        return subtasksList.get(id);
    }

    public void setSubtasksList(Subtask subtask) {
        this.subtasksList.add(subtask);
    }
}
